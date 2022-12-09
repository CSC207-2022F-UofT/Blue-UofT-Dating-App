package UseCases.ChatUseCases;

import Entities.Chatroom;
import Entities.User;
import UseCases.chat.ChatRegUseCase;
import UseCases.chat.ChatRepoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChatRepoUseCaseTest {

    @Test
    void addChatroomAndCheckForExistingChatroomTest() {
        ChatRepoUseCase.resetChats();

        // create test users
        User u1 = new User("clark", "12345");
        User u2 = new User("kevin", "54321");

        Set<User> my_set = new HashSet<>();
        my_set.add(u1);
        my_set.add(u2);

        Chatroom chatroom = new Chatroom(u1, u2);

        ChatRepoUseCase chatRepoUseCase = new ChatRepoUseCase();
        chatRepoUseCase.addChatroom(chatroom); //adding chatroom test

        boolean exists = chatRepoUseCase.checkForExistingChatroom(my_set); //check existing test

        Assertions.assertTrue(exists);
    }

    @Test
    void getChatroomTest() {
        ChatRepoUseCase.resetChats();

        // create test users
        User u1 = new User("clark", "12345");
        User u2 = new User("kevin", "54321");

        Set<User> my_set = new HashSet<>();
        my_set.add(u1);
        my_set.add(u2);

        ChatRegUseCase chatRegUseCase = new ChatRegUseCase();
        chatRegUseCase.createChatroom(u1, u2);

//        Chatroom chatroom = new Chatroom(u1, u2);
//
        ChatRepoUseCase chatRepoUseCase = new ChatRepoUseCase();
//        chatRepoUseCase.addChatroom(chatroom); //adding chatroom test

        Chatroom fetchedChatroom = chatRepoUseCase.getChatroom(my_set);

        Assertions.assertEquals(fetchedChatroom.getUsers(),my_set);
    }

    @Test
    void getUserChatroomsTest(){

        ChatRepoUseCase.resetChats();

        User u1 = new User("clark", "12345");
        User u2 = new User("kevin", "54321");
        User u3 = new User("bob", "54321");

        ChatRegUseCase chatRegUseCase = new ChatRegUseCase();
        chatRegUseCase.createChatroom(u1, u2);
        chatRegUseCase.createChatroom(u1, u3);

        Map<Set<User>, Chatroom> fetchedChatrooms = ChatRepoUseCase.getUserChatrooms(u1);

        boolean actual = true;

        for (Set<User> my_set: fetchedChatrooms.keySet()) {
            if (!(my_set.contains(u1))) {
                actual = false;
                break;
            }
        }

        Assertions.assertTrue(actual);
    }

}
