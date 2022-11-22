package UseCases.user_register_use_case;

public interface UserRegInputBoundary {
    UserRegResponseModel create(UserRegRequestModel requestModel);
}
