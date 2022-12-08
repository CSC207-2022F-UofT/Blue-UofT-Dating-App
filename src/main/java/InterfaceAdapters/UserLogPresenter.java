package InterfaceAdapters;

import Entities.User;
import FrameworksDrivers.View;
import UseCases.userlog.UserLogInteractor;
import UseCases.userlog.UserLogRequestModel;
import UseCases.userlog.UserLogResponseModel;

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
                View signView = (View) pageObject;
                Object[] info = {null};
                signView.updatePage(info);
                break;

            case "logInView":
                if (name.equals("")){
                    break;
            }
                UserLogRequestModel logRequestModel = new UserLogRequestModel(name, pass);
                UserLogInteractor userLogInteractor = new UserLogInteractor();
                View logView = (View) pageObject;

                if ("userDoesNotExist".equals(userLogInteractor.log(logRequestModel))){
                    String[] message = {"userDoesNotExist"};
                    logView.updatePage(message);
                }

                else if("passwordIncorrect".equals(userLogInteractor.log(logRequestModel))){
                    String[] message = {"passwordIncorrect"};
                    logView.updatePage(message);
                }
                else {
                    UserLogResponseModel responseModel = new UserLogResponseModel();
                    User attemptUser = responseModel.response(name);
                    User[] message = {attemptUser};
                    logView.updatePage(message);
                    break;
                }
        }

    }

}
