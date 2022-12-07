package InterfaceAdapters;

import Entities.CurrentUser;
import Entities.User;
import Entities.UserDataClasses.PrivateUserDataClasses.Username;
import FrameWorksDrivers.SignUpView;
import FrameWorksDrivers.View;
import UseCases.DataRetrieval.CurrentUserGateway;
import UseCases.user_register_use_case.UserRegInteractor;
import UseCases.user_register_use_case.UserRegRequestModel;


public class UserRegPresenter {
    public void switchPage(String name, String password1, String password2, Object pageObject) {
        UserRegRequestModel requestModel = new UserRegRequestModel(name, password1, password2);
        UserRegInteractor userRegInteractor = new UserRegInteractor();
        String response = userRegInteractor.create(requestModel);
        if ("passNoMatch".equals(response)) {
            View signup = (View) pageObject;
            String[] message = new String[] {"passNoMatch"};
            signup.updatePage(message);
        }
        else if ("userExists".equals(response)) {
            View signup = (View) pageObject;
            String[] message = new String[] {"userExists"};
            signup.updatePage(message);
        }
        else{
            SignUpView signup = (SignUpView) pageObject;
            CurrentUser currentUser = new CurrentUser();
            currentUser.setUser(new Username(name));
            currentUser.logIn();
            CurrentUserGateway currentUserGateway= new CurrentUserGateway();
            User[] message = new User[] {currentUserGateway.getCurrentUser()};
            signup.updatePage(message);

        }

    }


    public void updatePage(String page, Object pageObject){
        switch (page) {
            case "loginView":
                View logInView = (View) pageObject;
                Object[] info = new Object[1];
                info[0] = "Reload";
                logInView.updatePage(info);
        }
    }
}