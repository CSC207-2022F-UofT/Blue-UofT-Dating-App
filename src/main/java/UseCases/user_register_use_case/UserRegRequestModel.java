package UseCases.user_register_use_case;

/**
 * This class will hold all the information the user has inputted to register a new account
 */
public class UserRegRequestModel {

    /**
     * The username the new user has inputted
     */
    private String name;

    /**
     * The password the new user has inputted
     */
    private String password;

    /**
     * The password the new user has inputted, a repeated time
     */
    private String repeatPassword;

    /**
     * This method contains getters and setters for the info the new user has inputted; Setters are used for testing
     */
    public UserRegRequestModel(String name, String password, String repeatPassword) {
        this.name = name;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    /**
     * This will get the username that the new user has inputted
     * @return the username the new user wants to use
     */
    public String getName() {

        return this.name;
    }

    public String getPassword() {

        return this.password;
    }

    /**
     * This will get the repeated input of the password the new user wants to use
     * @return the second time the user entered the password they want to use
     */
    public String getRepeatPassword() {

        return repeatPassword;
    }
}