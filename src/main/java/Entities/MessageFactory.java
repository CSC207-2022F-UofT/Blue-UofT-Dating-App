package Entities;

public class MessageFactory {

    //creates Message object

    public Message create(User user, String message) {
        return new Message(user, message);
    }

}
