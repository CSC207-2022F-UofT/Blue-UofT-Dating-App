package usecases.ChatUseCases;

import Entities.*;
import usecases.DataRetrieval.CurrentGraph;

import java.util.HashSet;
import java.util.Set;

/**
 * SendMessageUseCase is a Use Case class that is responsible for
 * sending messages in chats. It is typically instantiated when a
 * User sends a message to another Use in their Chatroom.
 *
 * @author Rudy
 * @since 1.0
 */
public class SendMessageUseCase {

    // arguments:
    // the current chatroom (chat)
    // the user who sent the message (user)
    // the message sent (message)

    /**
     * Adds a Message object into the List within the provided
     * Chatroom to keep track of the conversation. This function
     * should only be called from within a chatroom.
     *
     * @param user1  Username of user who may have sent the message.
     * @param user2 Username of uer who may have sent the message.
     * @param message   The content of the message sent.
     */
    // the string message, username string
    public void addMessage(String user1, String user2, String message) {
        //get current user
        CurrentUser user = new CurrentUser(); //string containing username of current user

        //load graph and get curr_user from graph
        UserGraph user_graph = CurrentGraph.getGraph();
        User curr_user = user_graph.getUser(user.getUser());

        Set<User> users = new HashSet<>();
        users.add(user_graph.getUserByString(user1));
        users.add(user_graph.getUserByString(user2));

//        //user 1 is current user
//        if (user1.equals(curr_user.getUsername().data)){
//            Message new_message = new Message,
//        }

        //create message - assumes its always current user sending message, which is how it should be.
        Message new_message = new Message(curr_user, message);

        ChatRepoUseCase cruc = new ChatRepoUseCase();

        Chatroom chat = cruc.getChatroom(users);
        chat.addMessage(new_message);
    }

}
