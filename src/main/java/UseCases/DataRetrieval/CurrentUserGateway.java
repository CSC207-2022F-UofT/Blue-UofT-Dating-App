package UseCases.DataRetrieval;

import Entities.CurrentUser;
import Entities.User;
import Entities.UserDataClasses.PrivateUserDataClasses.Username;
import Entities.UserDataClasses.UserData;
import Entities.UserGraph;
import UseCases.UserGraphReadWriter;

import java.io.IOException;

public class CurrentUserGateway {
    UserData<String> username;
    UserGraph readGraph;
    User user;
    public User getCurrentUser(){
        CurrentUser currentUser = new CurrentUser();
        username = currentUser.getUser();
        readGraph = CurrentGraph.getGraph();
        return readGraph.getUser(username);
    }
}
