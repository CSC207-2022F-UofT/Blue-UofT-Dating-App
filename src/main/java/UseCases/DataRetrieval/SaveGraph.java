package UseCases.DataRetrieval;

import Entities.User;
import Entities.UserGraph;
import UseCases.UserGraphReadWriter;

import java.io.IOException;

public class SaveGraph {

    private UserGraph userGraph;
    UserGraphReadWriter readWriter = new UserGraphReadWriter();

    public SaveGraph(UserGraph userGraph) {
        this.userGraph = userGraph;
        try {
            readWriter.saveToFile("userGraph.ser", this.userGraph);
        } catch (IOException e) {
            System.out.println("User list did not save.");
        }
    }

    /**
     * this method will update the graph of users with a new User
     *      * @see User
     *      * @see UserGraph
     * @throws RuntimeException throws runtime exception
     * @return                  whether a user with the newName exists
     * @see    User
     * @see    UserGraph
     */
}