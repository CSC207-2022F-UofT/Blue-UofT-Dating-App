package UseCases.ChatUseCases;

import Entities.User;
import Entities.UserGraph;
import UseCases.dataretrieval.CurrentGraph;
import UseCases.PracticeGraphCreator;
import UseCases.useredit.SortUserNeighbours;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SortUserNeighboursTest {
    @Test
    void testSortUserNeighbours(){
        UserGraph userGraph = PracticeGraphCreator.createGraph();
        userGraph.addUser(new User("test1", "1"));
        userGraph.addUser(new User("test2", "1"));
        userGraph.getEdge(userGraph.getUserByString("Ewan"), userGraph.getUserByString("Jay")).setWeight((float) 0.13);
        userGraph.getEdge(userGraph.getUserByString("Ewan"), userGraph.getUserByString("test1")).setWeight((float) .75);
        userGraph.getEdge(userGraph.getUserByString("Ewan"), userGraph.getUserByString("test2")).setWeight((float) 0);
        new SortUserNeighbours(userGraph.getUserByString("Ewan"), userGraph);
        UserGraph currentGraph = CurrentGraph.getGraph();
        assertEquals(currentGraph.getUserByString("Ewan").getNeighbors().get(0).getUsername().getData(), userGraph.getUserByString("test1").getUsername().getData());
        assertEquals(currentGraph.getUserByString("Ewan").getNeighbors().size(), 3);
        assertEquals(currentGraph.getUserByString("Ewan").getNeighbors().get(2).getUsername().getData(), userGraph.getUserByString("test2").getUsername().getData());
    }
}
