package UseCases.ChatUseCases;

import Entities.Chatroom;
import Entities.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    private static final Map<Set<User>, Chatroom> currChatrooms = new HashMap<>();

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
        return currChatrooms.containsKey(users);
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
        return currChatrooms.get(users);
    }

    /**
     * Get all the chatrooms that currently exist.
     *
     * @return A Map mapping sets of Users to their Chatroom objects.
     */
    public static Map<Set<User>, Chatroom> getAllChatrooms() {
        return currChatrooms;
    }

}