package UseCases;

import Entities.User;
import Entities.UserGraph;
import UseCases.DataRetrieval.SaveGraph;

import java.util.ArrayList;

public class SortUserNeighbours{
    private final UserGraph userGraph;
    private final User currentUser;
    public SortUserNeighbours(String user, UserGraph userGraph){
        this.currentUser = userGraph.getUserByString(user);
        this.userGraph = userGraph;
        this.currentUser.setNeighbors(sortedNeighbours());
        new SaveGraph(userGraph);
    }
    public SortUserNeighbours(User user, UserGraph userGraph){
        this.currentUser = user;
        this.userGraph = userGraph;
        this.currentUser.setNeighbors(sortedNeighbours());
        new SaveGraph(userGraph);
    }
    private ArrayList<User> sortedNeighbours(){
        ArrayList<User> sortedList = new ArrayList<>();

        for(int i = 0; i <= this.currentUser.getNeighbors().size(); i++){
            sortedList.add(this.getMaxUser(i, this.currentUser.getNeighbors().size()));
        }
        return sortedList;
    }
    private User getMaxUser(int b, int e){
        User maxUser = this.currentUser.getNeighbors().get(b);
        float maxWeight = this.userGraph.getEdge(this.currentUser, maxUser).getWeight();
        for(int i = b + 1; i < e; i++){
            User otherUser = this.currentUser.getNeighbors().get(i);
            float otherUserWeight = this.userGraph.getEdge(this.currentUser, otherUser).getWeight();
            if(otherUserWeight > maxWeight){
                maxWeight = otherUserWeight;
                maxUser = otherUser;
            }
        }
        return maxUser;
    }
}
