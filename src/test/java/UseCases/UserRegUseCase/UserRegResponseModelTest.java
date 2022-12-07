package UseCases.UserRegUseCase;
import UseCases.user_register_use_case.UserRegResponseModel;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This test will check that the response model is properly created
 * The UserRegResponseModel is called in the UserRegPresenter. If this tests passes, then this aspect of the presenter
 * is checked
 */
public class UserRegResponseModelTest {
    /**
     * Hard code of the response model
     */

    @Test
    public void testResponseModel() {
        UserRegResponseModel responseModel = new UserRegResponseModel("Ellen");
        String expectedLogin = "Ellen";

        assertEquals(expectedLogin, responseModel.getLogin());
    }
}
