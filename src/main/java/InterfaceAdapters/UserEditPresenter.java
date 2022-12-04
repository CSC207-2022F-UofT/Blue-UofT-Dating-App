package InterfaceAdapters;

import Entities.CurrentUser;
import Entities.User;
import Entities.UserGraph;
import FrameworksDrivers.MainPageView;
import FrameworksDrivers.View;
import UseCases.*;
import UseCases.ChatUseCases.ChatRepoUseCase;
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
        return new UserEditResponseModel(currentUserGateway.getCurrentUser());
    }
    public void deleteAccount(Object pageObject){
        new DeleteCurrentAccount();
        ChatRepoUseCase chatRepoUseCase = new ChatRepoUseCase();
        CurrentUser currentUser = new CurrentUser();
        chatRepoUseCase.deleteUserChats(currentUser.getUser().getData());
        ChatViewPresenter chatViewPresenter = new ChatViewPresenter((View) pageObject);
        chatViewPresenter.updatePage("logOut", pageObject);
    }

}
