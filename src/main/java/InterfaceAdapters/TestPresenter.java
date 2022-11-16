package InterfaceAdapters;
import FrameworksDrivers.OtherAccount;
import FrameworksDrivers.View;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class TestPresenter implements View{
    public void updatePage(String page, Object pageObject) {
        switch (page) {
            case "otherAccount":
                OtherAccount otherAccount = (OtherAccount) pageObject;

                //Would call UseCase and Presenter interface here to get data from entities VVV
                String dummy = "snowmannnnnnn";

                //send it back up to ui, upadte the next page to be loaded VVV
                otherAccount.updateOtherAccount(dummy);
                break;
        }
    }
}
