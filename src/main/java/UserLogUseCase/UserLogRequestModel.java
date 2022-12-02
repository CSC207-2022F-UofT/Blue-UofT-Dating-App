package UserLogUseCase;

public class UserLogRequestModel {

    private String name;
    private String pass;

    /**
     * constructor for the UserLogRequestModel
     * @param name the username entered by the user
     * @param pass the password entered by the user
     */
    public UserLogRequestModel(String name, String pass){
        this.name = name;
        this.pass = pass;

    }

    /**
     * getter method for username in the UserLogRequestModel
     * @return username as String
     */
    String getName() {
        return this.name;
    }

    /**
     * setter method for username in the UserLogRequestModel
     * (build for testing purposes)
     * @param name username that will be assigned to the name attribute in the model
     */
    void setName(String name) {

        this.name = name;
    }

    /**
     * getter method for password in the UserLogRequestModel
     * @return the password attribute as String
     */
    String getPassword() {

        return this.pass;
    }

    /**
     * the setter method for the pass attribute in the model
     * (build for testing purposes)
     * @param pass the password that will be assigned to the pass attribute
     */
    void setPassword(String pass) {

        this.pass = pass;
    }
}
