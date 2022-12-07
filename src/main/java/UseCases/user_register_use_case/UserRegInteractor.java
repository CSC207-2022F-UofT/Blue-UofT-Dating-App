package UseCases.user_register_use_case;
import Entities.User;
import Entities.UserGraph;
import InterfaceAdapters.UserRegPresenter;
import UseCases.DataRetrieval.CurrentGraph;
import UseCases.DataRetrieval.SaveGraph;
import UseCases.DataRetrieval.UserRegGateway;

public class UserRegInteractor implements UserRegInputBoundary{
    /**
     * This class will connect whether a username is valid, and the passwords match to create a new User
     * @param userRegGateway a User or null
     * @param presenter      presenter for registering a new User
     * @return               the view corresponding to the validity of the User's registration info
     * @see                  UserRegGateway
     * @see                  UserRegPresenter
     */
    final UserRegGateway userRegGateway;

    public UserRegInteractor() {

        this.userRegGateway = new UserRegGateway();
    }
    @Override
    public String create(UserRegRequestModel requestModel) {
        if (!requestModel.getPassword().equals(requestModel.getRepeatPassword())) {
            return "passNoMatch";
        }
        else if (userRegGateway.getUserExists(requestModel.getName())) {
            return "userExists";
        }
        else{
            User user = new User(requestModel.getName(), requestModel.getPassword());
            UserGraph graph = CurrentGraph.getGraph();
            graph.addUser(user);
            new SaveGraph(graph);
            UserRegResponseModel responseModel = new UserRegResponseModel(user.getUsername().toString());
            return responseModel.getLogin();
        }
    }
}