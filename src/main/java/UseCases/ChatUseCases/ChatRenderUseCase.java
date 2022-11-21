package UseCases.ChatUseCases;

import Entities.*;
import InterfaceAdapters.ChatViewPresenter;
import UseCases.UserGraphReadWriter;

import java.util.ArrayList;

public class ChatRenderUseCase {

    // assume that ChatRepo exist (static container)

    public ChatRenderResponseModel render() {

        ArrayList<Chatroom> chatrooms = new ArrayList<>();

        // make sure to pass the current user's username to the presenter
        // make sure to pass the current user's username to the presenter
        // make sure to pass the current user's username to the presenter

        // for user in this user neighbors
        // check match
        // if match
        // if match in csv for chatrooms
        // retrieve

        // dumb examples
        User u1 = new User("clark", "12345");
        User u2 = new User("kevin", "54321");
        Chatroom test = new Chatroom(u1, u2);
        test.addMessage(new Message(u1, "hello kevin"));
        test.addMessage(new Message(u2, "hello clark"));
        chatrooms.add(new Chatroom(u1, u2));

        ArrayList<Object> responseModel = new ArrayList<>();

        for (Chatroom chatroom: chatrooms) {
            ArrayList<Object> currList = new ArrayList<>();
            Object[] users = chatroom.getUsers().toArray();
            User user1 = (User) users[0];
            User user2 = (User) users[1];

            currList.add(user1.getUsername());
            currList.add(user2.getUsername());
            for (Message message : chatroom.getConversation()) {
                currList.add(new Object[]{message.getMessageUser().getUsername(), message.getMessageText()});
            }
            responseModel.add(currList);
        }
        // make sure to pass the current user's username to the presenter
        return new ChatRenderResponseModel(responseModel);
    }
}
