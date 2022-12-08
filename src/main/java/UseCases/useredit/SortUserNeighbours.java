package UseCases.useredit;

import UseCases.dataretrieval.SaveGraph;
import Entities.User;
import Entities.UserGraph;

public class SortUserNeighbours{
    private final UserGraph userGraph;
    private final User currentUser;
    public SortUserNeighbours(String user, UserGraph userGraph){
        this.currentUser = userGraph.getUserByString(user);
        this.userGraph = userGraph;
        sortedNeighbours();
        new SaveGraph(userGraph);
    }
    public SortUserNeighbours(User user, UserGraph userGraph){
        this.currentUser = user;
        this.userGraph = userGraph;
        sortedNeighbours();
        new SaveGraph(userGraph);
    }
    private void sortedNeighbours(){
        for(int i = 0; i < this.currentUser.getNeighbors().size(); i++){
            int swapIndex = this.getMaxUser(i, this.currentUser.getNeighbors().size() - 1);
            User userI = this.currentUser.getNeighbors().get(i);
            User userSwap = this.currentUser.getNeighbors().get(swapIndex);

            this.currentUser.getNeighbors().set(i, userSwap);
            this.currentUser.getNeighbors().set(swapIndex, userI);
        }
    }
    private int getMaxUser(int b, int e){
        User maxUser = this.currentUser.getNeighbors().get(b);
        float maxWeight = this.userGraph.getEdge(this.currentUser, maxUser).getWeight();
        int maxUserIndex = b;
        for(int i = b + 1; i <= e; i++){
            User otherUser = this.currentUser.getNeighbors().get(i);
            float otherUserWeight = this.userGraph.getEdge(this.currentUser, otherUser).getWeight();
            if(otherUserWeight > maxWeight){
                maxWeight = otherUserWeight;
                maxUser = otherUser;
                maxUserIndex = i;
            }
        }
        return maxUserIndex;
    }
}
