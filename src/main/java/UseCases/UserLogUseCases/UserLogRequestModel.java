package UseCases.UserLogUseCases;

public class UserLogRequestModel {

    private final String name;
    private final String pass;

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
     * getter method for password in the UserLogRequestModel
     * @return the password attribute as String
     */
    String getPassword() {

        return this.pass;
    }

}
