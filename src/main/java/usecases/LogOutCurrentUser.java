package usecases;

import Entities.CurrentUser;

public class LogOutCurrentUser {
    public LogOutCurrentUser(){
        CurrentUser currentUser = new CurrentUser();
        currentUser.logOut();
        currentUser.setUser(null);
    }
}
