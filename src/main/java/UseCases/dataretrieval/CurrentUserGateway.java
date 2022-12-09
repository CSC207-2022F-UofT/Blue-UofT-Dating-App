package UseCases.dataretrieval;

import Entities.CurrentUser;
import Entities.User;
import Entities.UserDataClasses.UserData;
import Entities.UserGraph;

/**
 * Retrieves the user object with username CurrentUser.currUsername from CurrentGraph.
 */
public class CurrentUserGateway {
    UserData<String> username;
    UserGraph readGraph;

    /**
     * Retrieves the current user object.
     * @return current Uer object
     */
    public User getCurrentUser(){
        CurrentUser currentUser = new CurrentUser();
        username = currentUser.getUser();
        readGraph = CurrentGraph.getGraph();
        return readGraph.getUser(username);
    }
}
