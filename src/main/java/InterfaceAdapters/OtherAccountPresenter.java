package InterfaceAdapters;
import FrameworksDrivers.OtherAccount;
import UseCases.OtherAccountCases;
public class OtherAccountPresenter{
    private String user;
    public OtherAccountPresenter(String user) {
        this.user = user;
    }
    public void updatePage(String page, Object pageObject) {
        switch (page) {
            case "loadAccount":
                OtherAccount account = (OtherAccount) pageObject;
                OtherAccountCases updateCase = new OtherAccountCases();

                //Not sure if mainpageview will send displayname or username, will chance once I know.
                //String[] updateInformation = updateCase.getUserInfo(this.user);
                //account.updatePage(updateInformation);
        }
    }
}
