package usecases.DataRetrieval;

import Entities.UserGraph;
import usecases.UserGraphReadWriter;

import java.io.IOException;

public class CurrentGraph {

    public static UserGraph getGraph() {
        UserGraphReadWriter readWriter = new UserGraphReadWriter();
        UserGraph readGraph = null;

        try {
            readGraph = (UserGraph) readWriter.readFromFile("userGraph.ser");
        } catch (
                IOException e) {
            System.out.println("User list did not read.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return readGraph;
    }

    public static void main(String[] args) {
        UserGraph user = getGraph();
        System.out.println(user.getUsernames());
    }
}