package UseCases.UserLogUseCase;

import Entities.User;
import Entities.UserGraph;
import UseCases.dataretrieval.CurrentGraph;
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
        UserGraph realGraph = CurrentGraph.getGraph();
        UserGraph userGraph = new UserGraph();
        new SaveGraph(userGraph);
        UserRegRequestModel requestModel1 =
                new UserRegRequestModel("testU", "1234", "1234");
        UserRegInteractor interactor = new UserRegInteractor();
        interactor.create(requestModel1);
        UserLogResponseModel responseModel = new UserLogResponseModel();

        Assertions.assertEquals(new User("testU", "1234").getUsername().getData(),
                responseModel.response("testU").getUsername().getData());
        new SaveGraph(realGraph);
    }
}
