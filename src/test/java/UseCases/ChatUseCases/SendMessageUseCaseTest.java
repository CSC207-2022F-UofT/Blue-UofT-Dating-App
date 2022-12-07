package UseCases.ChatUseCases;

import Entities.*;
import UseCases.DataRetrieval.SaveGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SendMessageUseCaseTest {

    @Test
    void testaddMessage() {

        ChatRepoUseCase.resetChats();

        //should successfully add a new message to testChatroom

        User u1 = new User("clark", "12345");
        User u2 = new User("kevin", "54321");

        Set<User> users = new HashSet<>();
        users.add(u1);
        users.add(u2);

        UserGraph ug = new UserGraph();
        ug.addUser(u1);
        ug.addUser(u2);

        SaveGraph sg = new SaveGraph(ug);

        //u1 is current user
        CurrentUser CU = new CurrentUser();
        CU.setUser(u1.getUsername());

        ChatRegUseCase chatReg = new ChatRegUseCase();
        chatReg.createChatroom(u1, u2);

        // u1 - clark sends the message
        String message = "hi kein how are you";

        // does not work currently as there's issues with usergraph i.e. usergraph does not contain the test users
        // created above. do we need to use users that already exist in user graph?

        SendMessageUseCase sendMessageUseCase = new SendMessageUseCase();
        sendMessageUseCase.addMessage(u1.getUsername().getData(), u2.getUsername().getData(), message); // null pointer exception

        boolean actual = false;

        ChatRepoUseCase chatRepoUseCase = new ChatRepoUseCase();
        Chatroom chatroom = chatRepoUseCase.getChatroom(users);
        List<Message> conv = chatroom.getConversation();

        for (Message msg : conv) {
            if (msg.getMessageText().equals(message) && msg.getMessageUser().getUsername().getData().equals(u1.getUsername().getData())) {
                actual = true;
                break;
            }
        }

        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }
}
