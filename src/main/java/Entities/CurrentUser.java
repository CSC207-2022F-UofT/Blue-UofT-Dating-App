package Entities;

import Entities.UserDataClasses.PrivateUserDataClasses.Username;
import Entities.UserDataClasses.UserData;

public class CurrentUser {
    private static UserData<String> currentUser;
    private static boolean loggedIn;
    public void setUser(UserData<String> username){currentUser = username;
    }
    public UserData<String> getUser(){return currentUser;}
    public void logOut() {
        loggedIn = false;
    }
    public void logIn(){
        loggedIn = true;
    }
}
