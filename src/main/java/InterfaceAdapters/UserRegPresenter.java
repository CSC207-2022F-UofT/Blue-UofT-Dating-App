package InterfaceAdapters;

import Entities.CurrentUser;
import Entities.User;
import Entities.UserDataClasses.PrivateUserDataClasses.Username;
import Entities.UserGraph;
import FrameworksDrivers.SignUpView;
import FrameworksDrivers.View;
import UseCases.DataRetrieval.CurrentGraph;
import UseCases.DataRetrieval.CurrentUserGateway;
import UseCases.user_register_use_case.UserRegInteractor;
import UseCases.user_register_use_case.UserRegRequestModel;


public class UserRegPresenter {
    public void switchPage(String name, String password1, String password2, Object pageObject) {
        UserRegRequestModel requestModel = new UserRegRequestModel(name, password1, password2);
        UserRegInteractor userRegInteractor = new UserRegInteractor();
        String response = userRegInteractor.create(requestModel);
        if ("passNoMatch".equals(response)) {
            SignUpView signup = (SignUpView) pageObject;
            String[] message = new String[] {"passNoMatch"};
            signup.updatePage(message);
        }
        else if ("userExists".equals(response)) {
            SignUpView signup = (SignUpView) pageObject;
            String[] message = new String[] {"userExists"};
            signup.updatePage(message);
        }
        else{
            SignUpView signup = (SignUpView) pageObject;
            UserGraph editedGraph = CurrentGraph.getGraph();
            CurrentUser currentUser = new CurrentUser();
            currentUser.setUser(new Username(name));
            currentUser.logIn();
            CurrentUserGateway currentUserGateway= new CurrentUserGateway();
            User[] message = new User[] {currentUserGateway.getCurrentUser()};
            signup.updatePage(message);

        }

    }
}