package UseCases.UserRegUseCase;

import Entities.User;
import Entities.UserGraph;
import UseCases.DataRetrieval.CurrentGraph;
import UseCases.DataRetrieval.SaveGraph;
import UseCases.user_register_use_case.UserRegInteractor;
import UseCases.user_register_use_case.UserRegRequestModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This test will check that the interactor is properly creating the returns
 * The UserRegInteractor  is called in the presenter, and if the test passes, then the request model aspect of 
 *  * UserRegInteractor is also tested
 */
public class UserRegInteractorTest {
    /**
     * Test for a User inputting passwords that do not match
     */
    @Test
    void testInteractor1() {
        UserGraph userGraph = new UserGraph();
        new SaveGraph(userGraph);
        UserRegRequestModel requestModel =
                new UserRegRequestModel("Bob", "pw123", "pw321");
        UserRegInteractor interactor = new UserRegInteractor();
        String expected = "passNoMatch";
        assertEquals(interactor.create(requestModel), expected);
    }

    /**
     * Test a User for a Username that is not unique
     */
    @Test
    void testInteractor2() {
        UserGraph userGraph = new UserGraph();
        new SaveGraph(userGraph);
        UserRegRequestModel requestModel1 =
                new UserRegRequestModel("Sally", "1234", "1234");
        UserRegInteractor interactor1 = new UserRegInteractor();
        interactor1.create(requestModel1);

        UserRegInteractor interactor2 = new UserRegInteractor();
        UserRegRequestModel requestModel2 =
                new UserRegRequestModel("Sally", "1234", "1234");
        String expected = "userExists";
        assertEquals(interactor2.create(requestModel2), expected);
    }

    /**
     * Test that a User is properly created if they are unique and submit correct passwords
     */
    @Test
    void testInteractor3() {
        UserGraph userGraph = new UserGraph();
        new SaveGraph(userGraph);
        UserRegRequestModel requestModel =
                new UserRegRequestModel("Jo", "1234", "1234");
        UserRegInteractor interactor = new UserRegInteractor();
        String actualString = interactor.create(requestModel);
        String expectedString = "Jo";

        assertEquals(actualString, expectedString);
    }
}
