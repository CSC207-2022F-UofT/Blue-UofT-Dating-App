package InterfaceAdapters;


import Entities.User;
import FrameworksDrivers.MainPageView;
import FrameworksDrivers.View;
import UseCases.ChatUseCases.*;
import UseCases.DataRetrieval.CurrentUserGateway;
import UseCases.DataRetrieval.SaveChats;
import UseCases.DataRetrieval.SaveGraph;

import java.util.ArrayList;

public class ChatViewPresenter implements ChatViewPresenterInterface {
    private final View currView;

    public ChatViewPresenter(View currView) {
        this.currView = currView;
    }

    // updates chatView with array of Chatroom objects
    @Override
    public void render() {
        CurrentUserGateway currentUserGateway = new CurrentUserGateway();
        User currentUser = currentUserGateway.getCurrentUser();
        ChatRenderResponseModel responseModel =  new ChatRenderUseCase().render(currentUser);
        currView.updatePage(responseModel.getChatrooms().toArray());
    }

    public void sendMessage(String[] users, String message) {
        SendMessageUseCase useCase = new SendMessageUseCase();
        String user1 = users[0];
        String user2 = users[1];
        useCase.addMessage(user1, user2, message);
        new SaveChats(new ChatRepoUseCase());
    }
    public void updatePage(String page, Object pageObject) {
        switch (page) {
            case "mainpageView":
                MainPageView mainPageView = (MainPageView) pageObject;
                //Would call UseCase and Presenter interface here to get data from entities VVV
                //send it back up to ui, update the next page to be loaded VVV
                Object[] objects = new Object[1];
                CurrentUserGateway currentUserGateway = new CurrentUserGateway();
                objects[0] = currentUserGateway.getCurrentUser();
                mainPageView.updatePage(objects);
                break;
        }
    }
}
