package InterfaceAdapters;
import Entities.User;
import FrameWorksDrivers.*;
import UseCases.ChatUseCases.ChatRenderUseCase;
import UseCases.DataRetrieval.CurrentUserGateway;
import UseCases.LikeUseCase;
import UseCases.LogOutCurrentUser;

import java.util.ArrayList;

public class MainPagePresenter {
    private static int neighboursIndex = 0;

    public void updatePage(User displayedUser, String page, Object pageObject) {
        CurrentUserGateway currentUserGateway = new CurrentUserGateway();
        User currentUser = currentUserGateway.getCurrentUser();
        ArrayList<User> lst = currentUser.getNeighbors();
        if(lst.size() <= neighboursIndex){neighboursIndex = 0;}
        User nextUser = lst.get(neighboursIndex);

        Object[] userData = new Object[1];

        switch (page) {
            case "mainpageView":
                View mainPage = (View) pageObject;
                userData[0] = nextUser;
                mainPage.updatePage(userData);
                neighboursIndex += 1;
                break;
            case "chatView":
                View chatView = (View) pageObject;
                ChatRenderUseCase chatRenderUseCase = new ChatRenderUseCase();
                chatView.updatePage(chatRenderUseCase.render(currentUser).getChatrooms().toArray());
                break;
            case "usereditView":
                View userEditView = (View) pageObject;
                Object[] info = new Object[1];
                info[0] = "Old";
                userEditView.updatePage(info);
                break;
            case "otherAccount":
                View otherAccount = (View) pageObject;
                System.out.println(displayedUser.getUsername().getData());
                OtherAccountPresenter otherAccountPresenter = new OtherAccountPresenter(displayedUser.getUsername().getData());
                otherAccountPresenter.updatePage("loginView", otherAccount);
                break;
        }
    }
    public void Like(User matchedUser){
        CurrentUserGateway currentUserGateway = new CurrentUserGateway();
        User currentUser = currentUserGateway.getCurrentUser();
        LikeUseCase updateLike = new LikeUseCase();
        updateLike.updateEdge(currentUser, matchedUser);

    }

    public void logOut(Object pageObject) {
        new LogOutCurrentUser();
        ChatViewPresenter chatViewPresenter = new ChatViewPresenter((View) pageObject);
        chatViewPresenter.updatePage("logOut", pageObject);
    }
}


