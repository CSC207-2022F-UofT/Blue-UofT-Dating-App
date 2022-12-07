package UseCases;
import Entities.CurrentUser;
import Entities.User;
import Entities.UserGraph;

/**
 * Updates the compatibilities between the current user and all of its neighbours.
 */
public class UpdateCompatibility {
    public UpdateCompatibility(UserGraph currentGraph){
        CurrentUser user = new CurrentUser();
        User currentUser = currentGraph.getUser(user.getUser());
        for(User otherUser: currentUser.getNeighbors()){
            CompatibilityFunction compatibilityFunction = new CompatibilityFunction();
            currentGraph.getEdge(currentUser, otherUser).setWeight(compatibilityFunction.getCompatibility(currentUser, otherUser));
        }
    }
}
