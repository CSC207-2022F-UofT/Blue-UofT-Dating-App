package InterfaceAdapters;
import FrameworksDrivers.OtherAccount;
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
    public void updatePage(Object pageObject) {

        OtherAccount account = (OtherAccount) pageObject;
        OtherAccountCases updateCase = new OtherAccountCases();

        Object[] updateInformation = updateCase.getUserInfo(this.user);
        account.updatePage(updateInformation);
    }
}
