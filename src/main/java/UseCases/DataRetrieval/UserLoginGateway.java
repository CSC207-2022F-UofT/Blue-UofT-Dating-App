package UseCases.DataRetrieval;

import Entities.User;
import Entities.UserGraph;
import UseCases.UserGraphReadWriter;

import java.io.IOException;

public class UserLoginGateway {
    /**
     * this class will read the most updated graph of users to determine whether the name already exists
     * @see User
     * @see UserGraph
     */
    UserGraphReadWriter readWriter = new UserGraphReadWriter();
    UserGraph readGraph;

    /** this method will return true if the username exists and the password matches
     * Otherwise, false will indicate that the username does not exist or the password is invalid
     * @param  loginName a username that user inputs
     * @param  loginPassword a password that the user inputs
     * @throws RuntimeException throws runtime exception
     * @return whether a user with the loginName with the loginPassword exists
     * @see    User
     * @see    UserGraph
     */

    public boolean getLoginExists(String loginName, String loginPassword) {
        try {
            UserGraph readGraph = readWriter.readFromFile("userGraph.ser");
            for (String name : readGraph.getUsernames()) {
                System.out.println(name);
            }
        } catch (IOException e) {
            System.out.println("User list did not save.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return readGraph.getUserByString(loginName) != null &
                readGraph.getUserByString(loginName).getPassword().toString().equals(loginPassword);
    }
}
