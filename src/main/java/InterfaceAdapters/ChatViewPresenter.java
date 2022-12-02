package InterfaceAdapters;


import Entities.User;
import FrameworksDrivers.View;
import UseCases.ChatUseCases.*;

import java.util.ArrayList;

public class ChatViewPresenter implements ChatViewPresenterInterface {
    private View currView;

    public ChatViewPresenter(View currView) {
        this.currView = currView;
    }

    // updates chatView with array of Chatroom objects
    @Override
    public void render() {
        ChatRenderResponseModel responseModel =  new ChatRenderUseCase().render();
        currView.updatePage(responseModel.getChatrooms().toArray());
    }

}
