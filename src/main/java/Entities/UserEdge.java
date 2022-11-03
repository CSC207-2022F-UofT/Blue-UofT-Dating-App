package Entities;

public class UserEdge {
    private User[] users;
    private float weight;
    private boolean likeForwards;
    private boolean likeBackwards;
    public UserEdge(User user1, User user2) {
        this.users = new User[2];
        this.users[0] = user1;
        this.users[1] = user2;
        this.likeForwards = false;
        this.likeBackwards = false;
    }
    public boolean hasMatch(){
        // Returns whether a match exists between two users
        return this.likeForwards || this.likeBackwards;
    }
    public void likes(User likee){
        //In this case 'likes' is like a verb, the passed in user is 'liked' by the other user
        if(this.users[0].getUsername() == likee.getUsername()){
            //these are theoretical getter methods of User
            this.likeBackwards = true;
        }
        else{ this.likeForwards = true;}
    }
}
