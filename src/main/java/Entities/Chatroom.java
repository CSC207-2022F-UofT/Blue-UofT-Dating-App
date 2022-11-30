package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Chatroom is an entity class that represents a chat between two users.
 * A Chatroom object is instantiated when there is a match between two
 * users, i.e. when two users like each other.
 * There can every only exist one Chatroom between two users.
 * A Chatroom encapsultes the following information:
 * <ul>
 *     <li>A list of messages sent in the chatroom.</li>
 *     <li>The two users in the chatroom</li>
 * </ul>
 *
 * @author Rudy
 * @since 1.0
 */
public class Chatroom implements Serializable {

    //object representing chat between two users

    //most important attribute
    private List<Message> conversation;

    //users in the chatroom
    private Set<User> users;

    //precondition: user1 and user2 have matched / like each other

    /**
     * Constructor for Chatroom.
     * Creates a new ArrayList to store the conversation. Creates a HashSet to store the users,
     * and adds both users provided in the parameters to the HashSet.
     *
     * @param user1 A User object representing one of the two users in the chatroom.
     * @param user2 A User object representing the other of the two users in the chatroom.
     */
    public Chatroom(User user1, User user2) {
        this.conversation = new ArrayList<Message>();
        this.users = new HashSet<User>();
        this.users.add(user1);
        this.users.add(user2);
    }

    //add message to conversation

    /**
     * Add messages to a Chatroom object. A Message object is provided as an argument,
     * which is added to the list of messages stored in the Chatroom object.
     * Prior to calling this method, programmers should create a new Message object
     * that contains the message sent and the User who sent the message, and then pass
     * that object into this method as a parameter.
     *
     * @param text A Message object representing the text sent in the chat.
     */
    public void addMessage(Message text) {
        this.conversation.add(text);
    }

    //getters

    /**
     * Getter method for the Users in this Chatroom.
     *
     * @return A HashSet containing the two Users that make up the Chatroom.
     */
    public Set<User> getUsers() {
        return this.users;
    }

    /**
     * Getter method for the messages that have been exchanged in the Chatroom.
     *
     * @return An ArrayList containing Message objects that refer to messages exchanged between users.
     */
    public List<Message> getConversation() {
        return this.conversation;
    }

    //could be used to get the most recent text to update view instead of re-rendering entire conversation with
    //every new text
//    public Message getMostRecentText() {
//        return this.conversation.get(this.conversation.size() - 1);
//    }
}

