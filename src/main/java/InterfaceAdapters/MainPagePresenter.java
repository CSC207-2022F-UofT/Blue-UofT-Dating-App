package InterfaceAdapters;
import Entities.User;
import FrameworksDrivers.ChatView;
import FrameworksDrivers.OtherAccount;
import FrameworksDrivers.UserEditView;
import UseCases.ChatUseCases.ChatRenderUseCase;
import UseCases.ChatUseCases.ChatRepoUseCase;
import UseCases.DataRetrieval.CurrentUserGateway;
import UseCases.DisplayUserModel;
import UseCases.LikeUseCase;
import FrameworksDrivers.MainPageView;

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
                neighboursIndex += 1;
                MainPageView mainPage = (MainPageView) pageObject;
                userData[0] = nextUser;
                mainPage.updatePage(userData);
                break;
            case "chatView":
                ChatView chatView = (ChatView) pageObject;
                ChatRenderUseCase chatRenderUseCase = new ChatRenderUseCase();
                chatView.updatePage(chatRenderUseCase.render(currentUser).getChatrooms().toArray());
                break;
            case "usereditView":
                UserEditView userEditView = (UserEditView) pageObject;
                Object[] info = new Object[1];
                info[0] = "Old";
                userEditView.updatePage(info);
                break;
            case "otherAccount":
                OtherAccount otherAccount = (OtherAccount) pageObject;
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
}


