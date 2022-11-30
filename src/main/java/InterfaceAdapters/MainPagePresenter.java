package InterfaceAdapters;
import Entities.User;
import UseCases.DataRetrieval.CurrentUserGateway;
import UseCases.LikeUseCase;
import FrameworksDrivers.MainPageView;

import java.util.ArrayList;

public class MainPagePresenter {
    private static int neighboursIndex = 0;

    public void updatePage(User matchedUser, String page, Object pageObject) {
        CurrentUserGateway currentUserGateway = new CurrentUserGateway();
        User currentUser = currentUserGateway.getCurrentUser();
        ArrayList<User> lst = currentUser.getNeighbors();
        User nextUser = lst.get(neighboursIndex);
        MainPageView mainPage = (MainPageView) pageObject;
        Object[] userData = new Object[1];

        switch (page) {
            case "Main Page":
                neighboursIndex += 1;

                userData[0] = nextUser;
                mainPage.updatePage(userData);

            case "Like":
                neighboursIndex += 1;

                LikeUseCase updateLike = new LikeUseCase();
                updateLike.updateEdge(currentUser, matchedUser);

                userData[0] = nextUser;
                mainPage.updatePage(userData);


            case "Dislike":
                neighboursIndex += 1;

                userData[0] = nextUser;
                mainPage.updatePage(userData);


        }
    }
}


