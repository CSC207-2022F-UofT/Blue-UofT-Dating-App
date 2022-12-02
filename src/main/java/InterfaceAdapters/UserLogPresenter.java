package InterfaceAdapters;

import Entities.CurrentUser;
import Entities.User;
import Entities.UserGraph;
import FrameworksDrivers.LogInView;

import FrameworksDrivers.SignUpView;
import UseCases.DataRetrieval.CurrentGraph;
import UserLogUseCase.UserLogInteractor;
import UserLogUseCase.UserLogRequestModel;

public class UserLogPresenter {

    /**
     * determine weather the action will switch up the page
     * if remaining in logIn, determine whether the login attempt will be successful
     * or not and call update page in login view with the corresponding message
     *
     * @param name username entered by the user
     * @param pass password entered by the user
     * @param page page that will be directed to or make changes on
     *             either the "signUpView" or the "logInView"
     * @param pageObject a page object to carry the action
     */
    public void switchPage(String name, String pass, String page, Object pageObject ) {
        switch (page) {
            case "signUpView":
                SignUpView signView = (SignUpView) pageObject;
                Object[] info = {};
                signView.updatePage(info);
                break;

            case "logInView":
                if (name.equals("")){
                    break;
            }
                UserLogRequestModel logRequestModel = new UserLogRequestModel(name, pass);
                UserLogInteractor userLogInteractor = new UserLogInteractor();
                LogInView logView = (LogInView) pageObject;

                if ("userDoesNotExist".equals(userLogInteractor.log(logRequestModel))){
                    String[] message = {"userDoesn'tExist"};
                    logView.updatePage(message);
                }

                if("passwordIncorrect".equals(userLogInteractor.log(logRequestModel))){
                    String[] message = {"passwordIncorrect"};
                    logView.updatePage(message);
                }

                UserGraph graph = CurrentGraph.getGraph();
                User attemptUser = graph.getUserByString(name);
                CurrentUser currentUser = new CurrentUser();
                currentUser.setUser(attemptUser.getUsername());
                currentUser.logIn();
                User[] message = {attemptUser};
                logView.updatePage(message);
                break;
        }

    }

}