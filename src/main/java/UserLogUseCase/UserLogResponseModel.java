package UserLogUseCase;

import Entities.CurrentUser;
import Entities.User;
import Entities.UserGraph;
import UseCases.DataRetrieval.CurrentGraph;

public class UserLogResponseModel {

    /**
     *
     * This method will be called from the presenter and interact
     * wit the entities to log in the user
     * @param name the name of the user that's trying to log in
     * @return the user that's trying to log in
     */
    public User response(String name) {
        UserGraph graph = CurrentGraph.getGraph();
        User attemptUser = graph.getUserByString(name);
        CurrentUser currentUser = new CurrentUser();
        currentUser.setUser(attemptUser.getUsername());
        currentUser.logIn();

        return attemptUser;

    }

}
