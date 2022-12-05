package InterfaceAdapters;
import FrameworksDrivers.MainPageView;
import FrameworksDrivers.OtherAccount;
import FrameworksDrivers.View;
import UseCases.DataRetrieval.CurrentUserGateway;
import UseCases.DisplayUserModel;
import UseCases.OtherAccountCases;

/**
 * OtherAccountPresenter used to take inputs from FrameWorkDrivers, select
 * and handle use cases, and update OtherAccount with new information.
 */
public class OtherAccountPresenter {
    private final String user;

    /**
     * Initializes OtherAccountPresenter
     *
     * @parem user a username that OtherAccountPresenter must interact with
     */
    public OtherAccountPresenter(String user) {
        this.user = user;
    }

    /**
     * Gets selected user information and updates OtherAccount with user information.
     *
     * @parem pageObject reference to page being switched to
     */
    public void updatePage(String page, Object pageObject) {
        switch (page){
            case "mainpageView":
                View mainPageView = (View) pageObject;
                mainPageView.updatePage(null);
                break;
            case "otherView":
                View account = (View) pageObject;
                DisplayUserModel displayUserModel = new DisplayUserModel(this.user);
                Object[] updateInformation = displayUserModel.getModel();
                account.updatePage(updateInformation);
                break;
        }

    }
}
