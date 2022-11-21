package InterfaceAdapters;
import FrameworksDrivers.LogInView;
import FrameworksDrivers.View;


public class UserRegPresenter implements View{
    // create fail and success views

    @Override
    public void updatePage(String view, Object page) {
        switch(page) {
            case "Username already exists.":
                LogInView failView = (LogInView) page;

                // call Interactor & Presenter
                // sending back to ui

                // don't have a the view message yet
                failView.updateFailView("");
                break;
        }
    }

    @Override
    public void updatePage(String logInView, LogInView page) {
        switch(page) {
            case "Passwords don't match.":
                LogInView failView = (LogInView) page;

                // call Interactor & Presenter
                // sending back to ui

                // don't have a  view message yet
                failView.updateFailView("");
                break;
        }
    }
    @Override
    public void updatePage(String view, Object page) {
        switch(page) {
            case "Passwords don't match.":
                LogInView successView = (LogInView) page;

                // call Interactor & Presenter
                // sending back to ui

                // don't have a view message yet
                successView.updateSucessView("");
                break;
        }
    }
}
