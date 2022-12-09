package InterfaceAdapters;

import Entities.CurrentUser;
import Entities.UserGraph;
import FrameworksDrivers.ChatViewInterface;
import FrameworksDrivers.View;
import UseCases.chat.ChatRepoUseCase;
import UseCases.dataretrieval.CurrentGraph;
import UseCases.dataretrieval.CurrentUserGateway;
import UseCases.dataretrieval.SaveGraph;
import UseCases.useredit.*;

/**
 * Presenter for the UserEditView page. Because this project implements MVP, this class also serves the function
 * of being its controller as well (see methods like saveUserInfo and deleteAccount). It is also responsible for
 * updating the next viewPages (see updatePage).
 */
public class UserEditPresenter {

    /** Saves information in the passed UserEditModel to the current user. As well, this method calls use cases which
     * update the current UserGraoh to account for the profile change.
     * @param data information from UI elements being packaged
     * @param pageObject the View which the program will be going to next
     */
    public void saveUserInfo(UserEditModel data, Object pageObject){
        UserGraph editedGraph = CurrentGraph.getGraph();
        new UserEditInteractor(data, editedGraph, new CurrentUserGateway().getCurrentUser());
        new UpdateCompatibility(editedGraph);
        new UpdateGraph(editedGraph);
        new SaveGraph(editedGraph);
        this.updatePage("mainpageView", pageObject);
    }

    /** Calls the updatePage method of the view which is to be shown next
     * @param page which page is going to be shown
     * @param pageObject View object of the next page (in this case it is always mainpageView)
     */
    public void updatePage(String page, Object pageObject) {
        if ("mainpageView".equals(page)) {
            View mainPageView = (View) pageObject;
            //Would call UseCase and Presenter interface here to get data from entities VVV
            //send it back up to ui, update the next page to be loaded VVV
            mainPageView.updatePage(null);
        }
    }

    /** Retrieves necessary information from CurrentUser to display in the UserEditView
     * @return a UserEditResponseModel to return to the view
     */
    public UserEditResponseModel getCurrentUser(){
        CurrentUserGateway currentUserGateway = new CurrentUserGateway();
        return new UserEditResponseModel(currentUserGateway.getCurrentUser());
    }

    /**
     * Calls necessary delete user use cases.
     * @param pageObject view object to pass into the ChatViewPresenter
     */
    public void deleteAccount(Object pageObject){
        new DeleteCurrentAccount();
        ChatRepoUseCase chatRepoUseCase = new ChatRepoUseCase();
        CurrentUser currentUser = new CurrentUser();
        chatRepoUseCase.deleteUserChats(currentUser.getUser().getData());
        ChatViewPresenter chatViewPresenter = new ChatViewPresenter((ChatViewInterface) pageObject);
        chatViewPresenter.updatePage("logOut", pageObject);
    }

}
