package InterfaceAdapters;
import FrameworksDrivers.MainPageView;
import FrameworksDrivers.OtherAccount;
import UseCases.OtherAccountCases;
import com.sun.tools.javac.Main;

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

                String[] updateInformation = updateCase.getUserInfo(this.user);
                account.updatePage(updateInformation);
            case "mainpageView":
                MainPageView mainPageView = (MainPageView) pageObject;
                mainPageView.updatePage(null);

        }

    }
}
