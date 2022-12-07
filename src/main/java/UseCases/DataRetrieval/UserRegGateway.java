package UseCases.DataRetrieval;
import Entities.User;
import Entities.UserGraph;

/**
 * This class will access the most recent graph and compare to a user
 */
public class UserRegGateway {
    /**
     * This method will return true if the username exists otherwise,
     * false will indicate that the username is valid to use
     * @param newName the new username to check
     * @return whether a user with the newName exists
     * @see User
     * @see UserGraph
     * @see CurrentGraph
     */

    public boolean getUserExists(String newName) {
        return CurrentGraph.getGraph().getUserByString(newName) != null;
    }
}