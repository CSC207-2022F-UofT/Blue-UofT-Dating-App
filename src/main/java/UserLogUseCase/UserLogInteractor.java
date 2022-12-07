package UserLogUseCase;

import usecases.DataRetrieval.UserLogGateway;
import usecases.DataRetrieval.UserRegGateway;
import usecases.user_register_use_case.UserRegResponseModel;

public class UserLogInteractor implements UserLogInputBoundary{

    final UserRegGateway userGateway;
    final UserLogGateway userLogGateway;

    /**
     * constructor for the UserLogInteractor
     *
     */
    public UserLogInteractor() {
        this.userGateway = new UserRegGateway();
        this.userLogGateway = new UserLogGateway();
    }


    /**
     * check whether the entered information is valid for a successful log in
     * @param requestModel the request that contains the entered information
     * @return error message in string(if any)
     */
    @Override
    public String log(UserLogRequestModel requestModel) {
        if (!userGateway.getUserExists(requestModel.getName())){
            return "userDoesNotExist";
        }

        if (!requestModel.getPassword().equals(userLogGateway.getPass(requestModel.getName()))){
            return "passwordIncorrect";
        }

        UserRegResponseModel responseModel = new UserRegResponseModel(requestModel.getName());
        return responseModel.getLogin();
    }


}
