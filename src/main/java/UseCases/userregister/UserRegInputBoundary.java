package UseCases.userregister;

public interface UserRegInputBoundary {
    /**
     * This interface will create the input boundary for what the User has submitted as their username as password
     * @param requestModel the info the user inputted
     */
    String create(UserRegRequestModel requestModel);
}