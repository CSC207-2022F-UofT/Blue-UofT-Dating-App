package InterfaceAdapters;

import FrameworksDrivers.OtherAccount;
import FrameworksDrivers.TestAccount;

public class OtherAccountPresenter {
    public void updatePage(String page, Object pageObject) {
        switch (page) {
            case "testAccount":
                TestAccount testAccount = (TestAccount) pageObject;

                //Would call UseCase and Presenter interface here to get data from entities VVV
                String dummy = "dummy";

                //send it back up to ui, upadte the next page to be loaded VVV
                testAccount.updateTestAccount(dummy);
                break;
        }
    }
}
