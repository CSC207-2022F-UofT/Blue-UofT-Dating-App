package Entities;

import java.io.Serializable;

public class Message implements Serializable {

    //this is an individual message
    //need which user sent the message as well as what the message is

    //the user who sent the message
    private User user;

    //the contents of the message
    private String message;

    public Message(User user, String text) {
        this.user = user;
        this.message = text;
    }

    //no setters as messages are immutable

    //getters
    public User getMessageUser() {
        return this.user;
    }

    public String getMessageText() {
        return this.message;
    }

}
