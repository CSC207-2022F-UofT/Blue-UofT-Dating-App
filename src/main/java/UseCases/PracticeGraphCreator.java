package UseCases;

import Entities.User;
import Entities.UserGraph;

public class PracticeGraphCreator {
    public static UserGraph createGraph(){
        UserGraph userGraph = new UserGraph();
        User user1 = new User("EwanBob76","EWiebob");
        User user2 = new User("TheBoyJay","moose321");
        userGraph.addUser(user1);
        userGraph.addUser(user2);
        return userGraph;

    }
}
