package UseCases;
import Entities.User;
import Entities.UserEdge;
import Entities.UserGraph;
import UseCases.DataRetrieval.CurrentGraph;
import UseCases.DataRetrieval.SaveGraph;

public class LikeUseCase {
    public void updateEdge(User currentUser, User likedUser){
        UserGraph editGraph = CurrentGraph.getGraph();
        UserEdge userEdge = editGraph.getEdge(currentUser, likedUser);
        userEdge.likes(likedUser);
        new SaveGraph(editGraph);
        if(userEdge.getLikeBackwards() && userEdge.getLikesForward()){ new MatchUseCase(currentUser, likedUser); }
    }
}
