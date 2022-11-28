package InterfaceAdapters;

import Entities.User;
import Entities.UserDataClasses.PublicUserDataClasses.Bio;
import FrameworksDrivers.AccountView;
import FrameworksDrivers.MainPageView;
import FrameworksDrivers.OtherAccount;
import FrameworksDrivers.View;
import UseCases.DataRetrieval.CurrentUserGateway;

import java.util.ArrayList;
import java.util.HashMap;

public class UserEditPresenter {

    // This is a code smell (Long Parameter List) going to ask about it in tutorial.
    public void saveUserInfo(String name, String bio, String[] courses, HashMap<Integer, Boolean> interestsDict,
                             HashMap<Integer, Integer> attributeDict, HashMap<Integer, Integer> breakersDict,
                             HashMap<Integer, Boolean> hiddenDict){


    }


    public void updatePage(String page, Object pageObject) {
        switch (page) {
            case "mainpageView":
                 MainPageView mainPageView = (MainPageView) pageObject;

                //Would call UseCase and Presenter interface here to get data from entities VVV


                //send it back up to ui, update the next page to be loaded VVV
                mainPageView.updatePage(null);

                break;
        }
    }
    public User getCurrentUser(){
        CurrentUserGateway currentUserGateway = new CurrentUserGateway();
        return currentUserGateway.getCurrentUser();
    }

}
