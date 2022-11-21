package UseCases.ChatUseCases;

import Entities.Chatroom;
import Entities.ChatroomFactory;
import Entities.User;

import java.util.HashSet;
import java.util.Set;

public class ChatRegUseCase {

    //creates a new chatroom

    public Chatroom createChatroom(User user1, User user2) {
        //first check if corresponding chatroom exists

        ChatRepoUseCase chatRepo = new ChatRepoUseCase();

        Set<User> my_users = new HashSet<>();
        my_users.add(user1);
        my_users.add(user2);

        if (chatRepo.checkForExistingChatroom(my_users)) {
            return chatRepo.getChatroom(my_users);
        }

        ChatroomFactory fac = new ChatroomFactory();
        Chatroom chatroom = fac.create(user1, user2);
        chatRepo.addChatroom(chatroom);

        return chatroom;
    }

}
