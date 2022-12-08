package UseCases.useredit;
import Entities.CurrentUser;
import UseCases.dataretrieval.CurrentGraph;
import UseCases.dataretrieval.SaveGraph;
import Entities.User;
import Entities.UserGraph;

/**
 * Deletes the User from the current graph. This removes the user from all its neighbours' neighbours lists, as well
 * as all the edges in the graph containing that user.
 */
public class DeleteCurrentAccount {
    public DeleteCurrentAccount(){
         UserGraph currentGraph = CurrentGraph.getGraph();
         CurrentUser currentUser = new CurrentUser();
         User user = currentGraph.getUserByString(currentUser.getUser().getData());
         for(User otherUser: user.getNeighbors()){
             otherUser.removeNeighbor(user);
             currentGraph.deleteEdge(currentGraph.getEdge(user, otherUser));
         }
         currentGraph.deleteUser(user);
         new SaveGraph(currentGraph);
    }
}
