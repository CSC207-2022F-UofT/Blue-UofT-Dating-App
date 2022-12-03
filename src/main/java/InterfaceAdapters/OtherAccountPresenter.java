package InterfaceAdapters;
import FrameworksDrivers.MainPageView;
import FrameworksDrivers.OtherAccount;
import UseCases.DataRetrieval.CurrentUserGateway;
import UseCases.DisplayUserModel;
import UseCases.OtherAccountCases;

/**
 * OtherAccountPresenter used to take inputs from FrameWorkDrivers, select
 * and handle use cases, and update OtherAccount with new information.
 */
public class OtherAccountPresenter {
    private String user;

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
                MainPageView mainPageView = (MainPageView) pageObject;
                mainPageView.updatePage(null);
                break;
            case "loginView":
                OtherAccount account = (OtherAccount) pageObject;
                DisplayUserModel displayUserModel = new DisplayUserModel(this.user);
                Object[] updateInformation = displayUserModel.getModel();
                account.updatePage(updateInformation);
                break;
        }

    }
}
