package UseCases.UserRegUseCase;
import Entities.User;
import Entities.UserGraph;
import InterfaceAdapters.UserRegPresenter;
import UseCases.DataRetrieval.CurrentGraph;
import UseCases.DataRetrieval.UserRegGateway;
import UseCases.user_register_use_case.UserRegInputBoundary;
import UseCases.user_register_use_case.UserRegInteractor;
import UseCases.user_register_use_case.UserRegRequestModel;
import UseCases.user_register_use_case.UserRegResponseModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserRegInteractorTest {

    /**
     * Testing to ensure that registering a new user is done properly
     * 1) Create a UserRegInteractor
     * 2) Create input data from the user
     * 3) Call the input boundary
     * 4) Check that the output data the presenter receives is correct
     * 5) make sure that if the input user info is valid, a new user has been created
     */
    @Test
    void testUserRegInteractor1() {

        UserRegPresenter presenter = new UserRegPresenter();
        UserRegRequestModel requestModel = new UserRegRequestModel("Kim", "1234", "1234");
        UserRegGateway userRegGateway = new UserRegGateway();
        UserRegInteractor interactor = new UserRegInteractor();

        UserRegInputBoundary inputboundary = new UserRegInputBoundary() {
            @Override
            public String create(UserRegRequestModel requestModel) {
                return null;
            }
        };

        assertTrue(userRegGateway.getUserExists(requestModel.getName()));

        UserRegResponseModel expectedResponseModel = new UserRegResponseModel("Kim");
        UserGraph graph = CurrentGraph.getGraph();
        User expectedUser = new User(requestModel.getName(), requestModel.getPassword());

        assertEquals(interactor.create(requestModel), expectedResponseModel.getLogin());
        assertEquals(graph.getUserByString(requestModel.getName()), expectedUser);
    }
//
//    /**
//     * Testing to ensure that registering an error is message is properly created if the user info is invalid
//     * 1) Create a UserRegInteractor
//     * 2) Create input data from the user
//     * 3) Call the input boundary
//     * 4) Check that the output message the presenter receives is correct if the username already exists
//     * 5) Make sure that a new user is not created if the name already exists
//     */
//    UserRegPresenter presenter = new UserRegPresenter();
//    UserRegRequestModel requestModel = new UserRegRequestModel("Kim", "1234", "1234");
//    UserRegGateway userRegGateway = new UserRegGateway();
//    UserRegInteractor interactor = new UserRegInteractor();
//
//    UserRegInputBoundary inputboundary = new UserRegInputBoundary() {
//        @Override
//        public String create(UserRegRequestModel requestModel) {
//            return null;
//        }
//    };


}
