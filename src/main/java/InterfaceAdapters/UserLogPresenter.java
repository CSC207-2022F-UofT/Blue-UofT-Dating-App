package InterfaceAdapters;

//import FrameworksDrivers.LogInView;

import FrameworksDrivers.LogInView;
import UseCases.UserLogUseCase.UserRegInteractor;
import UseCases.user_register_use_case.UserRegRequestModel;

public class UserLogPresenter {


    public void switchPage(String name, String pass, String page, Object pageObject ) {
        switch (page) {
            case "signUpView":
                LogInView login = (LogInView) pageObject;

                login.updatePage(new Object[0]);
                break;

            case "logInView":
                UserLogRequestModel logRequestModel = new UserLogRequestModel(name, password);
                UserLogInteractor userLogInteractor = new UserLogInteractor();
        }

    }

}
