package UseCases.ChatUseCases;

import Entities.Chatroom;
import Entities.User;

import java.util.HashSet;
import java.util.Set;

/**
 * ChatRegUseCase is a Use Case class that is responsible for creating new
 * chats once certain conditions are met. Specifically, instances of
 * ChatRegUseCase are created when two users match, i.e. like each other.
 *
 * @author Rudy
 * @since 1.0
 */
public class ChatRegUseCase {

    //creates a new chatroom

    /**
     * Creates a new Chatroom for the users given as parameters provided
     * the chatroom does not previously exist. If it exists previously,
     * it returns the pre-existing chatroom.
     *
     * @param user1 A User object representing one of the two users in the chatroom.
     * @param user2 A User object representing the other of the two users in the chatroom.
     * @return  Chatroom object representing the chat between two input users.
     */
    public Chatroom createChatroom(User user1, User user2) {
        //first check if corresponding chatroom exists

        ChatRepoUseCase chatRepo = new ChatRepoUseCase();

        Set<User> my_users = new HashSet<>();
        my_users.add(user1);
        my_users.add(user2);

        if (chatRepo.checkForExistingChatroom(my_users)) {
            return chatRepo.getChatroom(my_users);
        }

        //ChatroomFactory fac = new ChatroomFactory();
        Chatroom chatroom = new Chatroom(user1, user2);
        chatRepo.addChatroom(chatroom);

        return chatroom;
    }

}
