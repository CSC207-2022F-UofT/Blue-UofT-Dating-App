package Entities;

public class UserEdge {
    private User[] users;
    private float weight;
    public UserEdge(User user1, User user2){
        this.users = new User[2];
        this.users[0] = user1;
        this.users[1] = user2;
    }
}
