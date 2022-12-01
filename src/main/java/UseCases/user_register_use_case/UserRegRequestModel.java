package UseCases.user_register_use_case;

public class UserRegRequestModel {
    /**
     * this class will hold all the info the user inputted to register a new account
     * @param name           the username the User wants to use
     * @param password       the password the User wants to use
     * @param repeatPassword a repetition of the password the User wants to use
     */
    private String name;
    private String password;
    private String repeatPassword;

    /**
     * this method contains getters and setters for the info the new User inputted
     * @return the name the User wants to use
     * @return the password the User wants to use
     * @return the repeated password the User wants to use
     *
     */
    public UserRegRequestModel(String name, String password, String repeatPassword) {
        this.name = name;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    String getName() {

        return this.name;
    }

    void setName(String name) {

        this.name = name;
    }

    String getPassword() {

        return password;
    }

    void setPassword(String password) {

        this.password = password;
    }

    public String getRepeatPassword() {

        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {

        this.repeatPassword = repeatPassword;
    }
}