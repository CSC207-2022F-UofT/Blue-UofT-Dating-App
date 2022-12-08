package UseCases.useredit;

import Entities.User;
import Entities.UserGraph;

/**
 * Use case for sorting the neighbour lists of all users in the passed in usergraph.
 */
public class UpdateGraph {
    public UpdateGraph(UserGraph userGraph){
        for(User user: userGraph.getUsers()){
            new SortUserNeighbours(user, userGraph);
        }
    }
}
