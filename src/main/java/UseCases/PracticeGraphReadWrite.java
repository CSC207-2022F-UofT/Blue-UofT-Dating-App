package UseCases;

import Entities.UserGraph;

import java.io.IOException;

public class PracticeGraphReadWrite {
    UserGraphReadWriter readWriter = new UserGraphReadWriter();
    public PracticeGraphReadWrite(UserGraph userGraph){
        try {
            readWriter.saveToFile("userGraph.ser", userGraph);
        } catch (IOException e) {
            System.out.println("User list did not save.");
        }
        try {
            UserGraph readGraph = (UserGraph) readWriter.readFromFile("userGraph.ser");
            for(String name: readGraph.getUsernames()){
                System.out.println(name);
            }
        } catch (IOException e) {
            System.out.println("User list did not save.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
