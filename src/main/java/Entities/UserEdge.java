package Entities;

public class UserEdge {
    private User[] users;
    private float weight;
    private boolean hiddenForwards;
    private boolean hiddenBackwards;
    private boolean likeForwards;
    private boolean likeBackwards;
    public UserEdge(User user1, User user2) {
        this.users = new User[2];
        this.users[0] = user1;
        this.users[1] = user2;
        this.likeForwards = false;
        this.likeBackwards = false;
        this.hiddenForwards = false;
        this.hiddenBackwards = false;
    }
    public boolean hasMatch(){
        // Returns whether a match exists between two users
        return this.likeForwards || this.likeBackwards;
    }
    public void likes(User liked){
        //In this case 'likes' is like a verb, the passed in user is 'liked' by the other user.
        if(this.users[0].getUsername() == liked.getUsername()){ this.likeBackwards = true;}
        else{ this.likeForwards = true;}
    }
    public void hideInFeed(User hidden){
        //Same logic as likes method, the passed in user is wanting to be hidden by the other user.
        if(this.users[0].getUsername() == hidden.getUsername()){ this.hiddenBackwards = true;}
        else{ this.hiddenForwards = true;}
    }
    public void unhideInFeed(User unhidden){
        if(this.users[0].getUsername() == unhidden.getUsername()){ this.hiddenBackwards = false;}
        else{ this.hiddenForwards = false;}
    }
    public User[] getUsers(){
        return this.users;
    }
    public boolean isEdge(User user1, User user2){
        //god this is ugly, if anyone can think of a better way to retrieve an edge of two users from one's neighbour
        // list please implement.
        return (this.users[0].getUsername() == user1.getUsername() &&
                this.users[1].getUsername() == user2.getUsername()) ||
                (this.users[0].getUsername() == user2.getUsername() &&
                this.users[1].getUsername() == user1.getUsername());
    }
}
