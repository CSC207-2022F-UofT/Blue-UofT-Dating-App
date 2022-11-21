package InterfaceAdapters;


import Entities.User;
import FrameworksDrivers.View;
import UseCases.ChatUseCases.ChatRegRequestModel;
import UseCases.ChatUseCases.ChatRenderResponseModel;
import UseCases.ChatUseCases.ChatRenderUseCase;

import java.util.ArrayList;

public class ChatViewPresenter {

    private ChatRenderUseCase useCase;

    private View currView;

    public ChatViewPresenter(ChatRenderUseCase useCase) {
        this.useCase = useCase;
    }

    // updates chatView with array of Chatroom objects
    public void render() {
        ChatRenderResponseModel responseModel =  new ChatRenderUseCase().render();
        currView.updatePage(responseModel.getChatrooms().toArray());
    }
}
