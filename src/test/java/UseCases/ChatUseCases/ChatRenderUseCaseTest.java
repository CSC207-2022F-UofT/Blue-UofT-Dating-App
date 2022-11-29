package UseCases.ChatUseCases;

import Entities.Chatroom;
import Entities.Message;
import Entities.User;
import InterfaceAdapters.ChatViewPresenter;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.swing.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ChatRenderUseCaseTest {

//    private static ChatRepoUseCase repo;

//    @BeforeEach
//    public void init() {
//        User u1 = new User("clark", "12345");
//        User u2 = new User("kevin", "54321");
//        Chatroom test = new Chatroom(u1, u2);
//        test.addMessage(new Message(u1, "hello kevin"));
//        test.addMessage(new Message(u2, "hello clark"));
//
//        u1 = new User("bob", "12345");
//        u2 = new User("joe", "54321");
//        Chatroom test2 = new Chatroom(u1, u2);
//        test2.addMessage(new Message(u1, "hello joe"));
//        test2.addMessage(new Message(u2, "hello bob"));
//
//        repo = new ChatRepoUseCase();
//        repo.addChatroom(test);
//        repo.addChatroom(test2);
//    }

    @Test
    void testChatroom1Render() {

        User u1 = new User("clark", "12345");
        User u2 = new User("kevin", "54321");
        Chatroom test = new Chatroom(u1, u2);
        test.addMessage(new Message(u1, "hello kevin"));
        test.addMessage(new Message(u2, "hello clark"));

        u1 = new User("bob", "12345");
        u2 = new User("joe", "54321");
        Chatroom test2 = new Chatroom(u1, u2);
        test2.addMessage(new Message(u1, "hello joe"));
        test2.addMessage(new Message(u2, "hello bob"));

        ChatRepoUseCase repo = new ChatRepoUseCase();
        repo.addChatroom(test);
        repo.addChatroom(test2);

        ArrayList<ArrayList<ArrayList<String>>> expectedOutput = new ArrayList<>();
        ArrayList<ArrayList<String>> expectedChatrooms = new ArrayList<>();
        ArrayList<String> user1 = new ArrayList<>();
        user1.add("clark");
        expectedChatrooms.add(user1);
        ArrayList<String> user2 = new ArrayList<>();
        user2.add("kevin");
        expectedChatrooms.add(user2);

        ArrayList<String> message1 = new ArrayList<>();
        message1.add("clark");
        message1.add("hello kevin");
        expectedChatrooms.add(message1);

        ArrayList<String> message2 = new ArrayList<>();
        message2.add("kevin");
        message2.add("hello clark");
        expectedChatrooms.add(message2);

        expectedOutput.add(expectedChatrooms);

        ChatRenderUseCase renderUseCase = new ChatRenderUseCase();
        ChatRenderResponseModel actualResponseModel = renderUseCase.render();
        ArrayList<ArrayList<ArrayList<String>>> actualList = actualResponseModel.getChatrooms();

        String actualUsername = actualList.get(0).get(0).get(0);
        String expectedUsername1 = expectedOutput.get(0).get(0).get(0);
        String expectedUsername2 = expectedOutput.get(0).get(1).get(0);
        assertTrue(actualUsername.equals(expectedUsername1) ||
                actualUsername.equals(expectedUsername2));
    }
}