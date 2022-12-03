package InterfaceAdapters;

import Entities.Chatroom;
import Entities.Message;
import Entities.User;
import UseCases.ChatUseCases.ChatRepoUseCase;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChatViewPresenterTest {
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
    @Test
    void testRender() {

    }
}