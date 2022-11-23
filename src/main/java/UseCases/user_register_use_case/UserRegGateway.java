package UseCases.user_register_use_case;

import Entities.CurrentUser;
import Entities.User;
import Entities.UserDataClasses.UserData;
import Entities.UserGraph;
import UseCases.UserGraphReadWriter;

import java.io.IOException;

public class UserRegGateway {
    UserGraphReadWriter readWriter = new UserGraphReadWriter();
    UserGraph readGraph;

    // the gateway will check if the username already exists
    public User getUserExists(String newName) {
        // should we refer to a general read graph function so there is not redunt code?
        try {
            UserGraph readGraph = (UserGraph) readWriter.readFromFile("userGraph.ser");
            for (String name: readGraph.getUsernames()){
                System.out.println(name);
            }
        } catch (IOException e) {
            System.out.println("User list did not save.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return readGraph.getUserByString(newName);
    }
}