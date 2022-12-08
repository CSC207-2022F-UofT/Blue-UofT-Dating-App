package UseCases;
import Entities.User;
import Entities.UserEdge;
import Entities.UserGraph;
import UseCases.DataRetrieval.CurrentGraph;
import UseCases.DataRetrieval.SaveGraph;

/**
 * LikeUseCase is a UseCase class responsible for editing the user edge between two users when one user likes the other.
 * LikeUseCase is also very closely connected to the MainPagePresenter in the InterfaceAdapters package.
 *
 * @author aryaman
 */
public class LikeUseCase {
    /**
     * Updates the user edge between currentUser and likedUser
     *
     * @param currentUser User that is logged in currently
     * @param likedUser User that is liked by the currentUser
     */
    public void updateEdge(User currentUser, User likedUser){
        // First get the current graph
        UserGraph editGraph = CurrentGraph.getGraph();
        // Get the edge between the currentUser and likedUser
        UserEdge userEdge = editGraph.getEdge(currentUser, likedUser);
        // Update the edge by using the likes method
        userEdge.likes(likedUser);
        // Save the graph to update it
        new SaveGraph(editGraph);
        //  If both users like each other call the MatchUseCase
        if(userEdge.getLikeBackwards() && userEdge.getLikesForward()){ new MatchUseCase(currentUser, likedUser); }
    }
}
