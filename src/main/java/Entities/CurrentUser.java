package Entities;
import Entities.UserDataClasses.UserData;

/**
 * This class holds the name of the current user which is logged in. This is what currentUer is.
 */
public class CurrentUser {
    private static UserData<String> currentUser;
    private static boolean loggedIn;

    /** Setter method of the currentUser
     * @param username username of the user which is logged in.
     */
    public void setUser(UserData<String> username){currentUser = username;
    }

    /** Getter method for currentUser/
     * @return currentUser
     */
    public UserData<String> getUser(){return currentUser;}

    /**
     * Set loggedIn to false.
     */
    public void logOut() {
        loggedIn = false;
    }

    /**
     * Sets loggedIn to true.
     */
    public void logIn(){
        loggedIn = true;
    }
}
