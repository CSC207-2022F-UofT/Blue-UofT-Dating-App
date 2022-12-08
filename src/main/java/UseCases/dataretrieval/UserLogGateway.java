package UseCases.dataretrieval;

import Entities.User;
import Entities.UserGraph;

public class UserLogGateway{
    /**
     * this method will return the password under the user attempting to
     * log in as a String
     *
     * @param  name          a username that a new user wants
     * @throws RuntimeException throws runtime exception
     * @return                  whether a user with the newName exists
     * @see    User
     * @see    UserGraph
     */

    public String getPass(String name){
        User attemptUser = CurrentGraph.getGraph().getUserByString(name);
        return attemptUser.getPassword().data;
    }

}