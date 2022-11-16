package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Chatroom implements Serializable {

    //object representing chat between two users

    //most important attribute
    private List<Message> conversation;

    //users in the chatroom
    private User[] users;

    //precondition: user1 and user2 have matched / like each other
    public Chatroom(User user1, User user2) {
        this.conversation = new ArrayList<Message>();
        this.users = new User[2];
        this.users[0] = user1;
        this.users[1] = user2;
    }

    //add message to conversation
    public void addMessage(Message text) {
        this.conversation.add(text);
    }

    //getters

    public User[] getUsers() {
        return this.users;
    }

    public List<Message> getConversation() {
        return this.conversation;
    }

    //could be used to get the most recent text to update view instead of re-rendering entire conversation with
    //every new text
    public Message getMostRecentText() {
        return this.conversation.get(this.conversation.size() - 1);
    }
}
