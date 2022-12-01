package InterfaceAdapters;

import Entities.CurrentUser;
import Entities.User;
import Entities.UserGraph;
import FrameworksDrivers.SignUpView;
import FrameworksDrivers.View;
import UseCases.DataRetrieval.CurrentGraph;
import UseCases.user_register_use_case.UserRegInteractor;
import UseCases.user_register_use_case.UserRegRequestModel;


public class UserRegPresenter {
    public void switchPage(String name, String password1, String password2, Object pageObject) {
        UserRegRequestModel requestModel = new UserRegRequestModel(name, password1, password2);
        UserRegInteractor userRegInteractor = new UserRegInteractor();

        if ("passNoMath".equals(userRegInteractor.create(requestModel))) {
            SignUpView signup = (SignUpView) pageObject;
            String[] message = new String[] {"passNoMatch"};
            signup.updatePage(message);
        }

        if ("userExists".equals(userRegInteractor.create(requestModel))) {
            SignUpView signup = (SignUpView) pageObject;
            String[] message = new String[] {"userExists"};
            signup.updatePage(message);
        }
        SignUpView signup = (SignUpView) pageObject;
        UserGraph editedGraph = CurrentGraph.getGraph();
        User newUser = editedGraph.getUserByString(userRegInteractor.create(requestModel));
        CurrentUser currentUser = new CurrentUser();
        currentUser.setUser(newUser.getUsername());
        currentUser.logIn();
        User[] message = new User[] {newUser};
        signup.updatePage(message);

    }
}