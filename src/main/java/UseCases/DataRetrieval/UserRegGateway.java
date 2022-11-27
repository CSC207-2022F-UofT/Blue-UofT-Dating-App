package UseCases.DataRetrieval;

import Entities.User;
import Entities.UserGraph;
import UseCases.UserGraphReadWriter;

import java.io.IOException;

public class UserRegGateway {
    /** this class will read the most updated graph of users to determine whether the name already exists
     * @see User
     * @see UserGraph
     */
    UserGraphReadWriter readWriter = new UserGraphReadWriter();
    UserGraph readGraph;
    /**
     * this method will return true if the username exists
     * Otherwise, false will indicate that the username is valid to use
     * @param  newName          a username that a new user wants
     * @throws RuntimeException throws runtime exception
     * @return                  whether a user with the newName exists
     * @see    User
     * @see    UserGraph
     */
    public boolean getUserExists(String newName) {

        try {
            UserGraph readGraph = readWriter.readFromFile("userGraph.ser");
            for (String name: readGraph.getUsernames()){
                System.out.println(name);
            }
        } catch (IOException e) {
            System.out.println("User list did not save.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return readGraph.getUserByString(newName) != null;
    }
}