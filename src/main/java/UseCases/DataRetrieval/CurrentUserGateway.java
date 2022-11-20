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
    UserGraphReadWriter readWriter = new UserGraphReadWriter();
    UserGraph readGraph;
    User user;
    public User getCurrentUser(){
        CurrentUser currentUser = new CurrentUser();
        username = currentUser.getUser();

        try {
            UserGraph readGraph = (UserGraph) readWriter.readFromFile("userGraph.ser");
            for(String name: readGraph.getUsernames()){
                System.out.println(name);
            }
        } catch (IOException e) {
            System.out.println("User list did not save.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return readGraph.getUser(username);
    }
}
