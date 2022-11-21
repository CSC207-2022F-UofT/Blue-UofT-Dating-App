package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Chatroom implements Serializable {

    //object representing chat between two users

    //most important attribute
    private List<Message> conversation;

    //users in the chatroom
    private Set<User> users;

    //precondition: user1 and user2 have matched / like each other
    public Chatroom(User user1, User user2) {
        this.conversation = new ArrayList<Message>();
        this.users = new HashSet<User>();
        this.users.add(user1);
        this.users.add(user2);
    }

    //add message to conversation
    public void addMessage(Message text) {
        this.conversation.add(text);
    }

    //getters

    public Set<User> getUsers() {
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

