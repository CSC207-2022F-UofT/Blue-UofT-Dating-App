package UseCases.ChatUseCases;

import Entities.Chatroom;
import Entities.Message;
import Entities.MessageFactory;
import Entities.User;

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
     * Chatroom to keep track of the conversation.
     *
     * @param chat  Chatroom object where conversation is taking place.
     * @param user  User object representing the user that sent the message.
     * @param message   The content of the message sent.
     */
    public void addMessage(Chatroom chat, User user, String message) {
        MessageFactory fac = new MessageFactory();
        Message new_message = fac.create(user, message);

        chat.addMessage(new_message);
    }

}
