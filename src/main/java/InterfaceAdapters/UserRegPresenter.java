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
                failView.updateFailView("");
                break;
        }
    }

    @Override
    public void updatePage(String view, Object page) {
        switch(page) {
            case "Passwords don't match.":
                LogInView failView = (LogInView) page;

                // call Interactor & Presenter
                // sending back to ui
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
                successView.updateSucessView("");
                break;
        }
    }
}
