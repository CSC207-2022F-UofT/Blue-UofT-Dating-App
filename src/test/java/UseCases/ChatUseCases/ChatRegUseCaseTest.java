package UseCases.ChatUseCases;

import Entities.User;
import UseCases.chat.ChatRegUseCase;
import UseCases.chat.ChatRepoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class ChatRegUseCaseTest {

    @Test
    void createChatroomTest() {
        ChatRepoUseCase.resetChats();

        // create test users
        User u1 = new User("clark", "12345");
        User u2 = new User("kevin", "54321");

        Set<User> my_set = new HashSet<>();
        my_set.add(u1);
        my_set.add(u2);

        // create new chatroom
        ChatRegUseCase chatRegUseCase = new ChatRegUseCase();
        chatRegUseCase.createChatroom(u1, u2);

        // see if chatroom exists
        ChatRepoUseCase chatRepoUseCase = new ChatRepoUseCase();
        boolean actual = chatRepoUseCase.checkForExistingChatroom(my_set);

        // assert that the chatroom exists
        Assertions.assertTrue(actual);
    }
}
