package UseCases.ChatUseCases;
import Entities.User;
import Entities.UserEdge;
import Entities.UserGraph;
import UseCases.chat.ChatRepoUseCase;
import UseCases.dataretrieval.CurrentGraph;
import UseCases.dataretrieval.SaveGraph;
import UseCases.mainpage.MatchUseCase;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MatchUseCaseTest {
    private UserGraph createTestUserGraph() {
        // Create a new UserGraph called testGraph
        UserGraph userGraph = new UserGraph();
        new SaveGraph(userGraph);
        return CurrentGraph.getGraph();
    }

    @Test
    void testMatchCreateChatRoom(){
        UserGraph realGraph = CurrentGraph.getGraph();
        UserGraph testUserGraph = createTestUserGraph();

        // expected action
        User currentUser = new User("aryaman", "123");
        User likedUser = new User("rudy", "456");
        testUserGraph.addUser(currentUser);
        testUserGraph.addUser(likedUser);
        new SaveGraph(testUserGraph);
        UserEdge userEdge = testUserGraph.getEdge(currentUser, likedUser);
        userEdge.likes(currentUser);
        userEdge.likes(likedUser);
        new MatchUseCase(currentUser,likedUser);

        ChatRepoUseCase chatRepoUseCase = new ChatRepoUseCase();
        Set<User> users = new HashSet<>();
        users.add(currentUser);
        users.add(likedUser);
        assertTrue(chatRepoUseCase.checkForExistingChatroom(users));
        new SaveGraph(realGraph);
    }
}
