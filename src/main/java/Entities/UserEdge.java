package Entities;

import java.io.Serializable;
import java.util.Objects;

/**
 * UserEdge class representing the edge in a UserGraph. Stores users in a User array, and contains information about
 * their compatibility and relationship.
 */
public class UserEdge implements Serializable {
    private final User[] users;
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

    /** Sets the appropriate like boolean to true, depending on who was the "liked user.
     * @param liked This represents the user who was "liked"
     */
    public void likes(User liked){
        //In this case 'likes' is like a verb, the passed in user is 'liked' by the other user.
        if(Objects.equals(this.users[0].getUsername().getData(), liked.getUsername().getData())){ this.likeBackwards = true;}
        else{ this.likeForwards = true;}
    }

    /** Setter for the compatibility.
     * @param newWeight flaat of the new weight.
     */
    public void setWeight(float newWeight){ this.weight = newWeight;}
    public float getWeight(){ return this.weight;}
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
