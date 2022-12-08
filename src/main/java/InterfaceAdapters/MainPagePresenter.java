package InterfaceAdapters;

import Entities.User;
import FrameworksDrivers.View;
import UseCases.ChatUseCases.ChatRenderUseCase;
import UseCases.DataRetrieval.CurrentUserGateway;
import UseCases.LikeUseCase;
import UseCases.LogOutCurrentUser;
import java.util.ArrayList;


/**
 * MainPagePresenter is an Interface Adapter or a Presenter class responsible for reading from serialized files that
 * correspond to the user data and updating main page accordingly. MainPagePresenter is also very closely connected
 * to the LikeUseCase in the UseCases package
 *
 * @author aryaman
 */
public class MainPagePresenter {
    private static int neighboursIndex = 0;

    /**
     * Gets selected user information and updates OtherAccount with user information.
     *
     * @param displayedUser User that is supposed to be displayed on the MainPage next
     * @param page reference to the page being switched to
     * @param pageObject pageObject to carry the action
     */
    public void updatePage(User displayedUser, String page, Object pageObject) {
        CurrentUserGateway currentUserGateway = new CurrentUserGateway();
        User currentUser = currentUserGateway.getCurrentUser();
        ArrayList<User> lst = currentUser.getNeighbors();
        if (lst.size() <= neighboursIndex){neighboursIndex = 0;}
        User nextUser = lst.get(neighboursIndex);

        Object[] userData = new Object[1];

        // Create different cases
        switch (page) {
            // Case1: mainpageView
            case "mainpageView":
                View mainPage = (View) pageObject;
                userData[0] = nextUser;
                mainPage.updatePage(userData);
                neighboursIndex += 1;
                break;
            // Case2: chatView
            case "chatView":
                View chatView = (View) pageObject;
                ChatRenderUseCase chatRenderUseCase = new ChatRenderUseCase();
                chatView.updatePage(chatRenderUseCase.render(currentUser).getChatrooms().toArray());
                break;
           // Case3: usereditView
            case "usereditView":
                View userEditView = (View) pageObject;
                Object[] info = new Object[1];
                info[0] = "Old";
                userEditView.updatePage(info);
                break;
            // Case4: otherAccount
            case "otherAccount":
                View otherAccount = (View) pageObject;
                OtherAccountPresenter otherAccountPresenter = new OtherAccountPresenter(displayedUser.getUsername().getData());
                otherAccountPresenter.updatePage("otherView", otherAccount);
                break;
        }
    }
    /**
     * The like method is used when a current user likes a matchedUser, and it calls the LikeUseCase to update the edge.
     *
     * @param matchedUser this is the matched user which was liked by current user
     */
    public void Like(User matchedUser){
        CurrentUserGateway currentUserGateway = new CurrentUserGateway();
        User currentUser = currentUserGateway.getCurrentUser();
        LikeUseCase updateLike = new LikeUseCase();
        updateLike.updateEdge(currentUser, matchedUser);

    }

    /**
     * The logOut method is used when a current user wants to log out and it calls the LogOutCurrentUser usecase.
     *
     * @param pageObject pageObject to carry the action
     */
    public void logOut(Object pageObject) {
        new LogOutCurrentUser();
        ChatViewPresenter chatViewPresenter = new ChatViewPresenter((View) pageObject);
        chatViewPresenter.updatePage("logOut", pageObject);
        neighboursIndex = 0;
    }
}


