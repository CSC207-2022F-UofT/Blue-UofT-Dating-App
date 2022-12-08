package UseCases.userregister;
import UseCases.dataretrieval.CurrentGraph;
import UseCases.dataretrieval.SaveGraph;
import UseCases.dataretrieval.UserRegGateway;
import Entities.User;
import Entities.UserGraph;

/**
 * This class will connect whether a username is valid, and the passwords match to create a new User
 * @see UserRegInputBoundary
 * @see UserRegGateway
 */
public class UserRegInteractor implements UserRegInputBoundary{
    final UserRegGateway userRegGateway;

    /**
     * Checking if the inputted username already exists in the most recent UserGraph
     */
    public UserRegInteractor() {

        this.userRegGateway = new UserRegGateway();
    }

    /**
     * This will check if the new username is valid, and if the two passwords match.
     * @param requestModel the inputted info that the user inputted
     * @see User
     * @see UserGraph
     * @see CurrentGraph
     * @see UserRegResponseModel
     * @return error messages if the passwords don't match or name exists, login name if a valid new user
     *
     */
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
            UserRegResponseModel responseModel = new UserRegResponseModel(user.getUsername().getData());
            return responseModel.getLogin();
        }
    }
}