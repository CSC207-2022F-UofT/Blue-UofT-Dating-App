package UseCases.UserLogUseCase;

import Entities.User;
import Entities.UserGraph;
import UseCases.DataRetrieval.SaveGraph;
import UseCases.DataRetrieval.UserLogGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;


public class UserLogGatewayTest {


    /**
     * Test that when given a correct username of an existing user, gateway can
     * return the correct password
     */
    @Test
    public void getPassTest() {
        // create a user for testing


        User testUser = new User("testU", "1234");
        ArrayList<User> users = new ArrayList<>();
        users.add(testUser);

        UserGraph graph = new UserGraph(users);
        new SaveGraph(graph);

        // check that the password returned through the gateway is correct
        UserLogGateway newGateway = new UserLogGateway();
        Assertions.assertEquals("1234", newGateway.getPass("testU"));

    }
}
