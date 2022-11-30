//package UseCases.user_register_use_case;
//import Entities.User;
//import Entities.UserDataClasses.UserFactory;
//import InterfaceAdapters.UserRegPresenter;
////this class normally will implement UserRegInputBoundary interface, it is currently underconstruction tho.
//public class UserRegInteractor {
////    final UserRegGateway userRegGateway;
////    final UserFactory userFactory;
////    final UserRegPresenter presenter;
////
////    public UserRegInteractor(UserRegGateway userRegGateway, UserFactory userFactory, UserRegPresenter presenter) {
////        this.userRegGateway = userRegGateway;
////        this.userFactory = userFactory;
////        this.presenter = presenter;
////    }
////
////    @Override
////    public UserRegResponseModel create(UserRegRequestModel requestModel) {
////        if (userRegGateway.existsByName(UserRegRequestModel.getName().toString())) {
////            return InterfaceAdapters.UserRegPresenter.prepareFailView("Username already exists.");
////        }
////        else if (!requestModel.getPassword().equals(requestModel.getRepeatPassword())) {
////            return InterfaceAdapters.UserRegPresenter.prepareFailView("Passwords don't match.");
////        }
////
////        User user = userFactory.createUser(requestModel.getName(), requestModel.getPassword());
////
////        UserRegDsRequestModel userDsModel = new UserRegDsRequestModel(requestModel.getName().toString(), requestModel.getPassword());
////        userRegGateway.save(userDsModel);
////
////        UserRegResponseModel accountResponseModel = new UserRegResponseModel(user.getUsername().toString());
////        return UserRegPresenter.prepareSuccessView(accountResponseModel);
////    }
//}