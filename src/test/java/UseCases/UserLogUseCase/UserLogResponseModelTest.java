package UseCases.UserLogUseCase;

import Entities.User;
import Entities.UserGraph;
import UseCases.dataretrieval.SaveGraph;
import UseCases.userlog.UserLogResponseModel;
import UseCases.userregister.UserRegInteractor;
import UseCases.userregister.UserRegRequestModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test the UserLogRepsonseModel to see that the model will return the
 * desire user
 */
public class UserLogResponseModelTest {

    @Test
    public void userLogResponseModelTest(){
        UserGraph userGraph = new UserGraph();
        new SaveGraph(userGraph);
        UserRegRequestModel requestModel1 =
                new UserRegRequestModel("testU", "1234", "1234");
        UserRegInteractor interactor = new UserRegInteractor();
        interactor.create(requestModel1);
        UserLogResponseModel responseModel = new UserLogResponseModel();
        User responseUser = responseModel.response("testU");
        String responseUserName = responseUser.getUsername().data;
        String responsePass = responseUser.getPassword().data;
        String expectName = "testU";
        String expectPass = "1234";
        Assertions.assertTrue(expectName.equals(responseUserName) &&
                expectPass.equals(responsePass));
    }
}
