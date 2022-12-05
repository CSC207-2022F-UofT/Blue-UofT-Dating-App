package UseCases;

import Entities.CurrentUser;
import Entities.User;
import Entities.UserGraph;
import UseCases.DataRetrieval.CurrentGraph;
import UseCases.DataRetrieval.CurrentUserGateway;

public class UpdateCompatabilities {
    public UpdateCompatabilities(UserGraph currentGraph){
        CurrentUser user = new CurrentUser();
        User currentUser = currentGraph.getUser(user.getUser());
        for(User otherUser: currentUser.getNeighbors()){
            CompatibilityFunction compatibilityFunction = new CompatibilityFunction();
            currentGraph.getEdge(currentUser, otherUser).setWeight(compatibilityFunction.getCompatibility(currentUser, otherUser));
        }
    }
}
