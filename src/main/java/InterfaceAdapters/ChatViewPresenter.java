package InterfaceAdapters;


import Entities.User;
import FrameworksDrivers.ChatView;
import FrameworksDrivers.MainPageView;
import FrameworksDrivers.View;
import UseCases.ChatUseCases.*;
import UseCases.DataRetrieval.CurrentUserGateway;
import UseCases.DataRetrieval.SaveChats;
import UseCases.DataRetrieval.SaveGraph;
import com.sun.tools.javac.Main;

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
                new SaveChats(new ChatRepoUseCase());
                MainPageView mainPageView = (MainPageView) pageObject;
                MainPagePresenter mainPagePresenter = new MainPagePresenter();
                mainPagePresenter.updatePage(null, "mainpageView", mainPageView);
                break;
            case "logOut":
                ChatView chatView = (ChatView) pageObject;
                chatView.logOut();

        }
    }
}
