package UseCases.UserLogUseCase;

import UseCases.userlog.UserLogRequestModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Test the UserLogRequestModel
 * Since the model only contains a constructor and two getter methodds,
 * test all functions at once
 */
public class UserLogRequestModelTest {
    @Test
    public void requestModelTest(){
        UserLogRequestModel model = new UserLogRequestModel("testU", "1234");
        String expectedUsername = "testU";
        String expectedPassword = "1234";

        Assertions.assertTrue(expectedUsername.equals(model.getName()) &&
                expectedPassword.equals(model.getPassword()));
    }


}
