package InterfaceAdapters;

import Entities.User;
import Entities.UserDataClasses.PublicUserDataClasses.Bio;
import Entities.UserGraph;
import FrameworksDrivers.AccountView;
import FrameworksDrivers.MainPageView;
import FrameworksDrivers.OtherAccount;
import FrameworksDrivers.View;
import UseCases.DataRetrieval.CurrentGraph;
import UseCases.DataRetrieval.CurrentUserGateway;
import UseCases.DataRetrieval.SaveGraph;
import UseCases.UserEditInteractor;
import UseCases.UserEditRequestModel;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.HashMap;

public class UserEditPresenter {

    public void saveUserInfo(UserEditRequestModel data, Object pageObject){
        UserGraph editedGraph = CurrentGraph.getGraph();
        User user = new CurrentUserGateway().getCurrentUser();
        UserEditInteractor userEditInteractor = new UserEditInteractor(data, editedGraph, user);
        SaveGraph.saveGraph(editedGraph);
        this.updatePage("otherAccount", pageObject);
    }

    public void updatePage(String page, Object pageObject) {
        switch (page) {
            case "mainpageView":
                 MainPageView mainPageView = (MainPageView) pageObject;
                //Would call UseCase and Presenter interface here to get data from entities VVV
                //send it back up to ui, update the next page to be loaded VVV
                mainPageView.updatePage(null);
                break;
            case "otherAccount":
                OtherAccount otherAccount = (OtherAccount) pageObject;
                otherAccount.updatePage(null);
                break;
        }
    }

    public User getCurrentUser(){
        CurrentUserGateway currentUserGateway = new CurrentUserGateway();
        return currentUserGateway.getCurrentUser();
    }

}
