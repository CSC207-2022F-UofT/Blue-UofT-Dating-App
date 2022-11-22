package Entities;
public class CurrentUser {
    private User currentUser;
    private boolean loggedIn;
    public CurrentUser(User user){
        this.currentUser = user;
        this.logIn();
    }
    public void setUser(User user){
        this.currentUser = user;
    }
    public User getUser(){
        return this.currentUser;
    }
    public void logOut() {
        this.loggedIn = false;
    }
    public void logIn(){
        this.loggedIn = true;
    }
}
