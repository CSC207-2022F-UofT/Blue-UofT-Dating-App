package Entities;

import java.io.Serializable;

/**
 * Message is an entity class that forms the basis for all Chat-related functionality.
 * A Message object encapsulates the information needed to store and identify a
 * message. This includes the following information:
 * <ul>
 *     <li>The User who sent the message.</li>
 *     <li>The contents of the message.</li>
 * </ul>
 *
 * @author Rudy
 * @since 1.0
 */
public class Message implements Serializable {

    //this is an individual message
    //need which user sent the message as well as what the message is

    //the user who sent the message
    private User user;

    //the contents of the message
    private String message;

    /**
     * Constructor for Message.
     * Assigns the input arguments to their respective instance variables.
     *
     * @param user The user who sent this message. Must be a User object.
     * @param text The contents of the message.
     */
    public Message(User user, String text) {
        this.user = user;
        this.message = text;
    }

    //no setters as messages are immutable

    //getters

    /**
     * Returns a User object which represents the user that sent the message.
     *
     * @return The User object that send the message.
     */
    public User getMessageUser() {
        return this.user;
    }

    /**
     * Returns a String representing the contents of the message.
     *
     * @return A String representing the contents of the message.
     */
    public String getMessageText() {
        return this.message;
    }

}
