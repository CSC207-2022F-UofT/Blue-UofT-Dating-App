package UseCases.UserRegUseCase;
import UseCases.userregister.UserRegRequestModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This test will check that the name, password, and repeated password have been properly set when a request model
 * is created
 * The UserRegRequestModel is called in the presenter, and if the test passes, then the request model aspect of
 * UserRegPresenter is also tested
 */
public class UserRegRequestModelTest {
    /**
     * Hard codes the requests
     */
    @Test
    void testReqestModel1() {
        UserRegRequestModel requestModel =
                new UserRegRequestModel("Bob", "pw123", "pw123");

        String expectedUsername = "Bob";
        String expectedPassword = "pw123";
        String expectedRepeatPassword = "pw123";

        assertTrue(expectedUsername.equals(requestModel.getName()) &&
                expectedPassword.equals(requestModel.getPassword()) &&
                expectedRepeatPassword.equals(requestModel.getRepeatPassword()));
    }
}
