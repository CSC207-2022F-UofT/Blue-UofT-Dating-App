package UseCases;

import Entities.CurrentUser;
import Entities.User;
import Entities.UserGraph;
import UseCases.DataRetrieval.CurrentGraph;
import UseCases.DataRetrieval.SaveGraph;

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
