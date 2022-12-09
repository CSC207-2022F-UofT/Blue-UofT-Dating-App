package InterfaceAdapters;

import Entities.User;
import FrameworksDrivers.ChatViewInterface;
import FrameworksDrivers.View;
import UseCases.chat.ChatRenderResponseModel;
import UseCases.chat.ChatRenderUseCase;
import UseCases.chat.ChatRepoUseCase;
import UseCases.chat.SendMessageUseCase;
import UseCases.dataretrieval.CurrentUserGateway;
import UseCases.dataretrieval.SaveChats;

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
                new SaveChats(new ChatRepoUseCase());
                View mainPageView = (View) pageObject;
                MainPagePresenter mainPagePresenter = new MainPagePresenter();
                mainPagePresenter.updatePage(null, "mainpageView", mainPageView);
                break;
            case "logOut":
                ChatViewInterface chatView = (ChatViewInterface) pageObject;
                chatView.logOut();

        }
    }
}
