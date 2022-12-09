package UseCases.ChatUseCases;

import Entities.Chatroom;
import Entities.Message;
import Entities.User;
import UseCases.chat.ChatRenderResponseModel;
import UseCases.chat.ChatRenderUseCase;
import UseCases.chat.ChatRepoUseCase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ChatRenderUseCase
 */
class ChatRenderUseCaseTest {

    /**
     * Hard codes the repo that stores the raw chatroom data
     */
    private void createRepo() {
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
    }

    /**
     * Checks that the ChatRenderUseCase returns the correct ResponseModel with current user "clark"
     */
    @Test
    void testChatroom1Render() {
        createRepo();

        //create expected output array
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
        User user = new User("clark", "123456");
        ChatRenderResponseModel actualResponseModel = renderUseCase.render(user);
        ArrayList<ArrayList<ArrayList<String>>> actualList = actualResponseModel.getChatrooms();

        String actualUsername = actualList.get(0).get(0).get(0);
        String expectedUsername1 = expectedOutput.get(0).get(0).get(0);
        String expectedUsername2 = expectedOutput.get(0).get(1).get(0);
        assertTrue(actualUsername.equals(expectedUsername1) ||
                actualUsername.equals(expectedUsername2));
    }

    /**
     * Checks that the ChatRenderUseCase returns the correct ResponseModel with current user "bob"
     */
    @Test
    void testChatroom2Render() {
        ArrayList<ArrayList<ArrayList<String>>> expectedOutput = new ArrayList<>();
        ArrayList<ArrayList<String>> expectedChatrooms = new ArrayList<>();
        ArrayList<String> user1 = new ArrayList<>();
        user1.add("bob");
        expectedChatrooms.add(user1);
        ArrayList<String> user2 = new ArrayList<>();
        user2.add("joe");
        expectedChatrooms.add(user2);

        ArrayList<String> message1 = new ArrayList<>();
        message1.add("bob");
        message1.add("hello joe");
        expectedChatrooms.add(message1);

        ArrayList<String> message2 = new ArrayList<>();
        message2.add("joe");
        message2.add("hello bob");
        expectedChatrooms.add(message2);

        expectedOutput.add(expectedChatrooms);

        ChatRenderUseCase renderUseCase = new ChatRenderUseCase();
        User user = new User("bob", "123456");
        ChatRenderResponseModel actualResponseModel = renderUseCase.render(user);
        ArrayList<ArrayList<ArrayList<String>>> actualList = actualResponseModel.getChatrooms();

        String actualUsername = actualList.get(0).get(0).get(0);
        String expectedUsername1 = expectedOutput.get(0).get(0).get(0);
        String expectedUsername2 = expectedOutput.get(0).get(1).get(0);
        assertTrue(actualUsername.equals(expectedUsername1) ||
                actualUsername.equals(expectedUsername2));
    }
}
