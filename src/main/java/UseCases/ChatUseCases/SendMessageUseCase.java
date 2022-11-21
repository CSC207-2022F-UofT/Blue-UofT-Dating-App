package UseCases.ChatUseCases;

import Entities.Chatroom;
import Entities.Message;
import Entities.MessageFactory;
import Entities.User;

public class SendMessageUseCase {

    // arguments:
    // the current chatroom (chat)
    // the user who sent the message (user)
    // the message sent (message)
    public void addMessage(Chatroom chat, User user, String message) {
        MessageFactory fac = new MessageFactory();
        Message new_message = fac.create(user, message);

        chat.addMessage(new_message);
    }

}
