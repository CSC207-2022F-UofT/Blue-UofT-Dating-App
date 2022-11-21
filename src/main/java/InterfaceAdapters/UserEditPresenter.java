package InterfaceAdapters;

import Entities.User;
import Entities.UserDataClasses.PublicUserDataClasses.Bio;
import FrameworksDrivers.AccountView;
import FrameworksDrivers.OtherAccount;
import FrameworksDrivers.View;
import UseCases.DataRetrieval.CurrentUserGateway;

import java.util.ArrayList;

public class UserEditPresenter{

    public void saveUserInfo(){

    }

    public void updatePage(String page, Object pageObject) {
        switch (page) {
            case "accountView":
                 AccountView accountView = (AccountView) pageObject;

                //Would call UseCase and Presenter interface here to get data from entities VVV


                //send it back up to ui, update the next page to be loaded VVV
                //accountView.updateAccountView();

                break;
            case "testAccount":
                //TestAccount testAccount = (TestAccount) pageObject;
                //testAccount.updateTestAccount("");

        }
    }
    public User getCurrentUser(){
        CurrentUserGateway currentUserGateway = new CurrentUserGateway();
        return currentUserGateway.getCurrentUser();
    }

}
