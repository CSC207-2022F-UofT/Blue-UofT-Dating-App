package UseCases.ChatUseCases;
import Entities.User;
import Entities.UserEdge;
import Entities.UserGraph;
import UseCases.DataRetrieval.CurrentGraph;
import UseCases.DataRetrieval.SaveGraph;
import UseCases.LikeUseCase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LikeUseCaseTest {
    private UserGraph createTestUserGraph(){
        // Create a new UserGraph called testGraph
        UserGraph userGraph = new UserGraph();
        new SaveGraph(userGraph);
        return CurrentGraph.getGraph();
    }

    @Test
    void testLikes(){
        UserGraph testUserGraph = createTestUserGraph();

        // expected action
        LikeUseCase likeUseCase = new LikeUseCase();
        User currentUser = new User("aryaman", "123");
        User likedUser = new User("rudy", "123");
        testUserGraph.addUser(currentUser);
        testUserGraph.addUser(likedUser);
        new SaveGraph(testUserGraph);
        likeUseCase.updateEdge(currentUser,likedUser);

        // testing if action is performed
        UserEdge edge = CurrentGraph.getGraph().getEdge(currentUser,likedUser);

        // asserting if true
        assertTrue(edge.getLikeBackwards());
    }
}
