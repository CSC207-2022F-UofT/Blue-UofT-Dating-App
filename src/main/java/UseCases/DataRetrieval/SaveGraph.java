package UseCases.DataRetrieval;

import Entities.UserGraph;
import UseCases.UserGraphReadWriter;

import java.io.IOException;

public class SaveGraph {
    static UserGraphReadWriter readWriter = new UserGraphReadWriter();
    public static void saveGraph(UserGraph userGraph){
        try {
            readWriter.saveToFile("userGraph.ser", userGraph);
        } catch (IOException e) {
            System.out.println("User list did not save.");
        }


    }
}
