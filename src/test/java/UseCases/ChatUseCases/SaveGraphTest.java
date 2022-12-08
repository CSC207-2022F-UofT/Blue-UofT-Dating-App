package UseCases.ChatUseCases;
import Entities.UserGraph;
import UseCases.dataretrieval.CurrentGraph;
import UseCases.dataretrieval.SaveGraph;
import UseCases.PracticeGraphCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SaveGraphTest {
    @Test
   void SaveGraphTest1(){
        UserGraph currentGraph = CurrentGraph.getGraph();
        UserGraph userGraph = PracticeGraphCreator.createGraph();
        new SaveGraph(userGraph);
        UserGraph readGraph = CurrentGraph.getGraph();
        assertEquals(readGraph.getUsers().get(0).getUsername().getData(), userGraph.getUsers().get(0).getUsername().getData());
        new SaveGraph(currentGraph);
    }
    @Test
    void SaveGraphTest2(){
        UserGraph currentGraph = CurrentGraph.getGraph();
        UserGraph userGraph = new UserGraph();
        new SaveGraph(userGraph);
        UserGraph readGraph = CurrentGraph.getGraph();
        assertEquals(readGraph.getUsers().size(), 0);
        new SaveGraph(currentGraph);
    }
}
