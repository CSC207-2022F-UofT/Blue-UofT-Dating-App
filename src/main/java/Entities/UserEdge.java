package Entities;

import java.io.Serializable;
import java.util.Objects;

public class UserEdge implements Serializable {
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

    public void likes(User liked){
        //In this case 'likes' is like a verb, the passed in user is 'liked' by the other user.
        if(Objects.equals(this.users[0].getUsername().getData(), liked.getUsername().getData())){ this.likeBackwards = true;}
        else{ this.likeForwards = true;}
    }
    public void setWeight(float newWeight){ this.weight = newWeight;}
    public float getWeight(){ return this.weight;}
    public void hideInFeed(User hidden){
        //Same logic as likes method, the passed in user is wanting to be hidden by the other user.
        if(Objects.equals(this.users[0].getUsername().getData(), hidden.getUsername().getData())){ this.hiddenBackwards = true;}
        else{ this.hiddenForwards = true;}
    }
    public void unhideInFeed(User unhidden){
        if(Objects.equals(this.users[0].getUsername().getData(), unhidden.getUsername().getData())){ this.hiddenBackwards = false;}
        else{ this.hiddenForwards = false;}
    }
    public User[] getUsers(){
        return this.users;
    }
    public boolean isEdge(User user1, User user2){
        //god this is ugly, if anyone can think of a better way to retrieve an edge of two users from one's neighbour
        // list please implement.
        return (Objects.equals(this.users[0].getUsername().getData(), user1.getUsername().getData()) &&
                Objects.equals(this.users[1].getUsername().getData(), user2.getUsername().getData())) ||
                (Objects.equals(this.users[0].getUsername().getData(), user2.getUsername().getData()) &&
                        Objects.equals(this.users[1].getUsername().getData(), user1.getUsername().getData()));
    }
    public boolean getLikesForward(){
        return this.likeForwards;
    }

    public boolean getLikeBackwards() {
        return likeBackwards;
    }

}
