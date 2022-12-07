package usecases;

import Entities.User;
import Entities.UserGraph;

public class PracticeGraphCreator {
    public static UserGraph createGraph(){
        UserGraph userGraph = new UserGraph();
        User user1 = new User("Ewan", "12345678");
        User user2 = new User("Jay","87654321");
        //THis is bad ik, just for practice
        userGraph.addUser(user1);
        userGraph.addUser(user2);
        return userGraph;

    }
}
