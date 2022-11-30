package InterfaceAdapters;


import Entities.User;
import FrameworksDrivers.View;
import UseCases.ChatUseCases.*;

import java.util.ArrayList;

public class ChatViewPresenter implements ChatViewPresenterInterface {
    private final View currView;

    public ChatViewPresenter(View currView) {
        this.currView = currView;
    }

    // updates chatView with array of Chatroom objects
    @Override
    public void render() {
        ChatRenderResponseModel responseModel =  new ChatRenderUseCase().render();
        currView.updatePage(responseModel.getChatrooms().toArray());
    }

    public void sendMessage(String[] users, String message) {
        SendMessageUseCase useCase = new SendMessageUseCase();
        String user1 = users[0];
        String user2 = users[1];
        useCase.addMessage(user1, user2, message);
    }
}
