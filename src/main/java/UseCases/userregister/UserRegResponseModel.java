package UseCases.userregister;

/**
 * This class contains the response model if a user inputs valid registration information
 */
public class UserRegResponseModel {

    /**
     * The username of the new user that has just been created
     */
    String login;

    /**
     * Contains the name of the new user who has been created
     * @param login the new user's login name
     */
    public UserRegResponseModel(String login) {
        this.login = login;
    }

    /**
     * Returns the login name of the new user
     * @return the login name
     */
    public String getLogin() {
        return login;
    }
}