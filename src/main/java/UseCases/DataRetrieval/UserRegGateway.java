package UseCases.DataRetrieval;

import Entities.User;
import Entities.UserGraph;

public class UserRegGateway {
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
        return CurrentGraph.getGraph().getUserByString(newName) != null;
    }
}