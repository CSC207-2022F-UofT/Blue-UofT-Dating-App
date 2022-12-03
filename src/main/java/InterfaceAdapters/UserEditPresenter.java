package InterfaceAdapters;

import Entities.User;
import Entities.UserGraph;
import FrameworksDrivers.MainPageView;
import UseCases.*;
import UseCases.DataRetrieval.CurrentGraph;
import UseCases.DataRetrieval.CurrentUserGateway;
import UseCases.DataRetrieval.SaveGraph;

public class UserEditPresenter {

    public void saveUserInfo(UserEditModel data, Object pageObject){
        UserGraph editedGraph = CurrentGraph.getGraph();
        User user = new CurrentUserGateway().getCurrentUser();
        new UserEditInteractor(data, editedGraph, user);
        new UpdateCompatabilities(editedGraph);
        new UpdateGraph(editedGraph);
        new SaveGraph(editedGraph);
        this.updatePage("mainpageView", pageObject);
    }

    public void updatePage(String page, Object pageObject) {
        switch (page) {
            case "mainpageView":
                 MainPageView mainPageView = (MainPageView) pageObject;
                //Would call UseCase and Presenter interface here to get data from entities VVV
                //send it back up to ui, update the next page to be loaded VVV
                mainPageView.updatePage(null);
                break;
        }
    }

    public UserEditResponseModel getCurrentUser(){
        CurrentUserGateway currentUserGateway = new CurrentUserGateway();
        UserEditResponseModel userEditResponseModel = new UserEditResponseModel(currentUserGateway.getCurrentUser());
        return userEditResponseModel;
    }

}
