package UseCases;

import Entities.User;
import Entities.UserGraph;

public class EditEdgeWeightUseCase {
    public void setUserEdgeWeight(User user1, User user2){
        CompatibilityFunction weightCalc = new CompatibilityFunction();
        float weight = weightCalc.getCompatibility(user1, user2);
        UserGraph graph = new UserGraph();
        graph.getEdge(user1, user2).setWeight(weight);
    }
}