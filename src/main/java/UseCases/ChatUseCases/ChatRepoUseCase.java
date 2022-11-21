package UseCases.ChatUseCases;

import Entities.Chatroom;
import Entities.User;

import java.util.HashMap;
import java.util.Set;

public class ChatRepoUseCase {
    //class for checking if a chatroom exists

    private static HashMap<Set<User>, Chatroom> currChatrooms = new HashMap<>();

    //will get called from chat reg, assume that the chatroom is legit
    public void addChatroom(Chatroom chat) {
        currChatrooms.put(chat.getUsers(), chat);
    }

    public boolean checkForExistingChatroom(Set<User> users) {
        return currChatrooms.containsKey(users);
    }

}
