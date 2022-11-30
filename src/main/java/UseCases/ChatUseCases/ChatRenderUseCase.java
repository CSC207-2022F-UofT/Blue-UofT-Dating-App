package UseCases.ChatUseCases;

import Entities.*;
import InterfaceAdapters.ChatViewPresenter;
import UseCases.UserGraphReadWriter;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class ChatRenderUseCase {

    // assume that ChatRepo exist (static container)

    public ChatRenderResponseModel render() {

        Map<Set<User>, Chatroom> map = ChatRepoUseCase.getAllChatrooms();

        ArrayList<ArrayList<ArrayList<String>>> responseModel = new ArrayList<>();

        for (Map.Entry<Set<User>, Chatroom> set : map.entrySet()) {

            ArrayList<ArrayList<String>> currChatroomList = new ArrayList<>();
            Chatroom chatroom= set.getValue();
            Object[] users = set.getKey().toArray();
            User user1 = (User) users[0];
            User user2 = (User) users[1];
            String username1 = user1.getUsername().getData();
            String username2 = user2.getUsername().getData();

            ArrayList<String> username1List = new ArrayList<>();
            ArrayList<String> username2List = new ArrayList<>();
            username1List.add(username1);
            username2List.add(username2);


            //added just now
            currChatroomList.add(username1List);
            currChatroomList.add(username2List);
            ArrayList<Message> convo = (ArrayList<Message>) chatroom.getConversation();

            for (Message m : convo) {
                ArrayList<String> messageList = new ArrayList<>();
                String messageUser = m.getMessageUser().getUsername().getData();
                String message = m.getMessageText();
                messageList.add(messageUser);
                messageList.add(message);
                currChatroomList.add(messageList);
            }
            responseModel.add(currChatroomList);
        }

        return new ChatRenderResponseModel(responseModel);
    }

    //        ArrayList<Chatroom> chatrooms = new ArrayList<>();
//
//        // dumb examples
//        User u1 = new User("clark", "12345");
//        User u2 = new User("kevin", "54321");
//        Chatroom test = new Chatroom(u1, u2);
//        test.addMessage(new Message(u1, "hello kevin"));
//        test.addMessage(new Message(u2, "hello clark"));
//        chatrooms.add(new Chatroom(u1, u2));
}
