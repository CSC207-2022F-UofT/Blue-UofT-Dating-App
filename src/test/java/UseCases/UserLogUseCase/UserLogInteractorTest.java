package UseCases.UserLogUseCase;

import Entities.User;
import Entities.UserGraph;
import UseCases.UserLogUseCases.UserLogInteractor;
import UseCases.UserLogUseCases.UserLogRequestModel;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class UserLogInteractorTest {
    // the original class contans a constructor and a function log


    // Test the log function in UserLogInteractor case by case
    // Construct a graph with a user for testing
    public void setUp(){
        User testU = new User("testU", "1234");
        ArrayList<User> users = new ArrayList<>();
        users.add(testU);

        UserGraph testGraph = new UserGraph(users);
    }


    @Test
    public void logNotExistsTest(){
        // in this test, check that the interactor can return the correct message in the case
        // where a user entered a username that doesn't exist

        //create a request model containing a wrong username
        UserLogRequestModel requestModel = new UserLogRequestModel("test", "1234");

        //check log returns the right message
        Assertions.assertEquals("userDoesNotExist", new UserLogInteractor().log(requestModel));

    }

    @Test
    public void logIncorrectPassword(){
        // in this test, check that the interactor can return the correct message in the case
        // where a user entered the username of an existed user but with an incorrect password

        // create a request model containing a correct username and incorrect password
        UserLogRequestModel requestModel = new UserLogRequestModel("testU", "1111");

        // check log returns the right message
        Assertions.assertEquals("passwordIncorrect", new UserLogInteractor().log(requestModel));
    }

    @Test
    public void logSuccessful() {
        // in this test, check that the interactor can return the correct message in the case
        // where a user entered the username of an existed user with a matching password

        //create a request model containing the correct username and password
        UserLogRequestModel requestModel = new UserLogRequestModel("testU", "1234");

        // check log returns the right message
    }
}
