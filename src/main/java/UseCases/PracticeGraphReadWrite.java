package UseCases;

import Entities.User;
import Entities.UserDataClasses.PrivateUserDataClasses.Preferences;
import java.io.*;
import Entities.UserGraph;

public class PracticeGraphReadWrite {
    private final UserGraph userGraph;
    UserGraphReadWriter readWriter = new UserGraphReadWriter();
    public PracticeGraphReadWrite(UserGraph userGraph){
        this.userGraph = userGraph;
//        try {
//            readWriter.saveToFile("userGraph.ser", userGraph);
//        } catch (IOException e) {
//            System.out.println("User list did not save.");
//        }
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
