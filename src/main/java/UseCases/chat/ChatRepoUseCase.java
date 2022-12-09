package UseCases.chat;

import Entities.Chatroom;
import UseCases.dataretrieval.SaveChats;
import Entities.User;

import java.io.Serializable;
import java.util.*;

/**
 * ChatRepoUseCase is a Use Case class that is responsbile for keeping track
 * of all the Chatrooms that have been created. It does so by maintaining a
 * static Map that maps a set of users to their corresponding Chatrooom.
 *
 * @author Rudy
 * @since 1.0
 */
public class ChatRepoUseCase implements Serializable {
    //class for checking if a chatroom exists

    private static Map<Set<User>, Chatroom> currChatrooms = new HashMap<>();
    private Map<Set<User>, Chatroom> instanceChatrooms = new HashMap<>();
    //will get called from chat reg, assume that the chatroom is legit

    /**
     * Assuming that a new Chatroom has been successfully created in ChatRegUseCase,
     * this method is called to add the newly created Chatroom to the map of all existing
     * chatrooms. It does so by mapping the users attribute (a set) of a Chatroom object to
     * the Chatroom itself.
     *
     * @param chat The Chatroom object to be added to the Map.
     * @see ChatRegUseCase
     */
    public void addChatroom(Chatroom chat) {
        currChatrooms.put(chat.getUsers(), chat);
    }

    /**
     * Checks whether a Chatroom object exists.
     *
     * @param users A set of Users.
     * @return Boolean representing whether a Chatroom object exists or not.
     */
    public boolean checkForExistingChatroom(Set<User> users) {
        Set<String> userSet = new HashSet<>();
        for(User user: users){userSet.add(user.getUsername().getData());}
        for(Set<User> userChats: currChatrooms.keySet()){
            HashSet<String> userChatsUsernames = new HashSet<>();
            for(User user: userChats){userChatsUsernames.add(user.getUsername().getData());}
            if(userChatsUsernames.equals(userSet)){
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the Chatroom object corresponding to a set of Users in the static Map
     * assuming the Chatroom exists.
     * Before calling this method, the programmer must check if the Chatroom exists by
     * calling the appropriate function.
     *
     * @param users A set of Users.
     * @return Chatroom corresponding to the input Set of users in the static Map.
     */
    public Chatroom getChatroom(Set<User> users) {
        Set<String> userSet = new HashSet<>();
        for(User user: users){userSet.add(user.getUsername().getData());}
        for(Set<User> userChats: currChatrooms.keySet()){
            HashSet<String> userChatsUsernames = new HashSet<>();
            for(User user: userChats){userChatsUsernames.add(user.getUsername().getData());}
            if(userChatsUsernames.equals(userSet)){return currChatrooms.get(userChats);}
        }
        ChatRegUseCase chatRegUseCase = new ChatRegUseCase();
        ArrayList<User> newChatUsers = new ArrayList<>(users);
        chatRegUseCase.createChatroom(newChatUsers.get(0), newChatUsers.get(1));
        return getChatroom(users);
    }

    ///**
     //* Get all the chatrooms that currently exist.
     //*
     //* @return A Map mapping sets of Users to their Chatroom objects.
     //*/
    //public static Map<Set<User>, Chatroom> getAllChatrooms() {
    //    return currChatrooms;
    //}

    /**
     * Returns all the chatrooms that include the given user.
     *
     * @param user The user whose chatrooms are desired.
     * @return A Map mapping a set of Users to their Chatrooms.
     */
    public static Map<Set<User>, Chatroom> getUserChatrooms(User user){
        Map<Set<User>, Chatroom> userChatrooms = new HashMap<>();
        for(Set<User> users: currChatrooms.keySet()){
            for(User mapUser: users){
                if(Objects.equals(mapUser.getUsername().getData(), user.getUsername().getData())){
                    userChatrooms.put(users, currChatrooms.get(users));
                }
            }
        }
        return userChatrooms;
    }

    /**
     * Updates the instance chatrooms of a ChatRepoUseCase object from the current stored chatrooms.
     */
    public void savingChats(){
        this.instanceChatrooms = currChatrooms;
    }

    /**
     * Updates the current stored chatrooms from the instance chatrooms of a ChatRepoUseCase object.
     */
    public void readingChats(){
        currChatrooms = this.instanceChatrooms;
    }

    /**
     * Resets the current stored chatrooms.
     */
    public static void resetChats(){ currChatrooms = new HashMap<>();}

    /**
     * Deletes all the chatrooms containing a specified User.
     *
     * @param user The User whose chats need to be deleted.
     */
    public void deleteUserChats(String user){
        Set<Set<User>> cloneKeys = new HashSet<>(currChatrooms.keySet());
        for(Set<User> set: cloneKeys){
            HashSet<String> usernames = new HashSet<>();
            for(User chatUser: set){ usernames.add(chatUser.getUsername().getData());}
            if(usernames.contains(user)){ currChatrooms.remove(set);}
        }
        new SaveChats(this);
    }
}
