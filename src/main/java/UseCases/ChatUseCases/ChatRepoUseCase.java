package UseCases.ChatUseCases;

import Entities.Chatroom;
import Entities.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ChatRepoUseCase implements Serializable {
    //class for checking if a chatroom exists

    private static final Map<Set<User>, Chatroom> currChatrooms = new HashMap<>();

    //will get called from chat reg, assume that the chatroom is legit
    public void addChatroom(Chatroom chat) {
        currChatrooms.put(chat.getUsers(), chat);
    }

    public boolean checkForExistingChatroom(Set<User> users) {
        return currChatrooms.containsKey(users);
    }

    public Chatroom getChatroom(Set<User> users) {
        return currChatrooms.get(users);
    }

    public Map<Set<User>, Chatroom> getAllChatrooms() {
        return currChatrooms;
    }

}
