package UseCases.UserRegUseCase;
import UseCases.user_register_use_case.UserRegRequestModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegRequestModelTest {

    /**
     * This test will check that the name, password, and repeated password have been properly set when a request model
     * is created
     */
    @Test
    void testReqestModel1() {
        UserRegRequestModel requestModel = new UserRegRequestModel("Bob", "pw123", "pw123");

        String actualUsername = "Bob";
        String actualPassword = "ppw123";
        String actualRepeatPassword = "pw123";

        assertTrue(actualUsername.equals(requestModel.getName()) &&
                actualPassword.equals(requestModel.getPassword()) &&
                actualRepeatPassword.equals(requestModel.getRepeatPassword()));
    }

    /**
     * This test will check that if the name, password, and repeated password are set maually set, the
     * request model will reflect this
     */
    @Test
    void testReqestModel2() {

        String newName = "Jill";
        String newPassword = "12345";
        String newRepeatPassword = "54321";

        UserRegRequestModel requestModel = new UserRegRequestModel("Bob", "pw123", "pw123");
    }
}



