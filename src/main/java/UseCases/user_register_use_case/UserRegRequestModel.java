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

    /**
     * This will set the username the user wants to use
     * @param name the name to set
     */
    void setName(String name) {

        this.name = name;
    }

    /**
     * This will get the password the new user wants to use
     * @return the password the user wants
     */
    public String getPassword() {

        return this.password;
    }

    /**
     * This will set the password the new user wants to use
     * @param password password that should be set
     */
    void setPassword(String password) {

        this.password = password;
    }

    /**
     * This will get the repeated input of the password the new user wants to use
     * @return the second time the user entered the password they want to use
     */
    public String getRepeatPassword() {

        return repeatPassword;
    }

    /**
     * This will set a value for the password the new user wants to use when they are asked to repeat their input
     * @param repeatPassword a repeated password
     */
    public void setRepeatPassword(String repeatPassword) {

        this.repeatPassword = repeatPassword;
    }
}