package UseCases.DataRetrieval;

import Entities.UserGraph;
import UseCases.UserGraphReadWriter;

import java.io.IOException;

public class CurrentGraph {

    public static UserGraph getGraph() {
        UserGraphReadWriter readWriter = new UserGraphReadWriter();
        UserGraph readGraph = null;

        try {
            readGraph = (UserGraph) readWriter.readFromFile("userGraph.ser");
        } catch (
                IOException e) {
            System.out.println("User list did not save.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return readGraph;
    }
}