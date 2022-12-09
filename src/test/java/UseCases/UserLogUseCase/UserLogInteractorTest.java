package UseCases.UserLogUseCase;

import Entities.UserGraph;
import UseCases.dataretrieval.SaveGraph;
import UseCases.userlog.UserLogInteractor;
import UseCases.userlog.UserLogRequestModel;
import UseCases.userregister.UserRegInteractor;
import UseCases.userregister.UserRegRequestModel;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


/**
 *     Test the log function in UserLogInteractor case by case
 */
public class UserLogInteractorTest {

    /**
     * Test that the interactor can return the correct message if a given user name does
     * not having a corresponding user in the graph
     */
    @Test
    public void logNotExistsTest(){
        UserGraph userGraph = new UserGraph();
        new SaveGraph(userGraph);

        //create a request model containing a wrong username
        UserLogRequestModel requestModel = new UserLogRequestModel("test", "1234");

        //check log returns the right message
        Assertions.assertEquals("userDoesNotExist", new UserLogInteractor().log(requestModel));

    }

    /**
     * in this test, check that the interactor can return the correct message in the case
     * where a user entered the username of an existed user but with an incorrect password
     */
    @Test
    public void logIncorrectPasswordTest(){

        UserGraph userGraph = new UserGraph();
        new SaveGraph(userGraph);
        UserRegRequestModel requestModel1 =
                new UserRegRequestModel("testU", "1234", "1234");
        UserRegInteractor interactor = new UserRegInteractor();
        interactor.create(requestModel1);

        // create a request model containing a correct username and incorrect password
        UserLogRequestModel requestModel = new UserLogRequestModel("testU", "1111");

        // check log returns the right message
        Assertions.assertEquals("passwordIncorrect", new UserLogInteractor().log(requestModel));
    }

    /**
     * in this test, check that the interactor can return the correct message in the case
     * where a user entered the username of an existed user with a matching password
     */
    @Test
    public void logSuccessfulTest() {
        UserGraph userGraph = new UserGraph();
        new SaveGraph(userGraph);
        UserRegRequestModel requestModel1 =
                new UserRegRequestModel("testU", "1234", "1234");
        UserRegInteractor interactor = new UserRegInteractor();
        interactor.create(requestModel1);

        //create a request model containing the correct username and password
        UserLogRequestModel requestModel = new UserLogRequestModel("testU", "1234");
        // check log returns the right message
        Assertions.assertEquals("testU", new UserLogInteractor().log(requestModel));
    }
}
