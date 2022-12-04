package InterfaceAdapters;


import Entities.User;
import FrameworksDrivers.MainPageView;
import FrameworksDrivers.View;
import UseCases.ChatUseCases.*;
import UseCases.DataRetrieval.CurrentUserGateway;
import UseCases.DataRetrieval.SaveChats;
import UseCases.DataRetrieval.SaveGraph;

import java.util.ArrayList;

/**
 * Calls use case methods and updates ChatView with new information.
 */
public class ChatViewPresenter {
    private final View currView;

    /**
     * Initializes ChatViewPresenter
     *
     * @param currView the reference to the ChatView object
     */
    public ChatViewPresenter(View currView) {
        this.currView = currView;
    }

    /**
     * Updates chatView with array of Chatroom objects
     * Calls render method of ChatRenderUseCase and updates the Chat page with the response model
     */
    public void render() {
        CurrentUserGateway currentUserGateway = new CurrentUserGateway();
        User currentUser = currentUserGateway.getCurrentUser();
        ChatRenderResponseModel responseModel =  new ChatRenderUseCase().render(currentUser);
        currView.updatePage(responseModel.getChatrooms().toArray());
    }

    /**
     * Updates chatView with array of Chatroom objects
     * Calls render method of ChatRenderUseCase and updates the Chat page with the response model
     * @param users String array with two usernames corresponding to the sender and recipient of the text message
     * @param message the message that is sent between the users
     */
    public void sendMessage(String[] users, String message) {
        SendMessageUseCase useCase = new SendMessageUseCase();
        String user1 = users[0];
        String user2 = users[1];
        useCase.addMessage(user1, user2, message);
        new SaveChats(new ChatRepoUseCase());
    }

    /**
     * Updates the page that is specified by the inputs
     * @param page the string name of the page to be updated
     * @param pageObject the instance of the page to be updated
     */
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
