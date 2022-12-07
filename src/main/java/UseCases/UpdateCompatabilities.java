package UseCases;

import Entities.User;
import Entities.UserGraph;
import UseCases.DataRetrieval.CurrentUserGateway;

public class UpdateCompatabilities {
    public UpdateCompatabilities(UserGraph currentGraph){
        CurrentUserGateway currentUserGateway = new CurrentUserGateway();
        User currentUser = currentUserGateway.getCurrentUser();
        for(User otherUser: currentUser.getNeighbors()){
            CompatibilityFunction compatibilityFunction = new CompatibilityFunction();
            currentGraph.getEdge(currentUser, otherUser).setWeight(compatibilityFunction.getCompatibility(currentUser, otherUser));
        }
    }
}
