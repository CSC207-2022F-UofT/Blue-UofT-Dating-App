package usecases;

import Entities.User;
import Entities.UserGraph;

public class UpdateGraph {
    public UpdateGraph(UserGraph userGraph){
        for(User user: userGraph.getUsers()){
            new SortUserNeighbours(user, userGraph);
        }
    }
}
