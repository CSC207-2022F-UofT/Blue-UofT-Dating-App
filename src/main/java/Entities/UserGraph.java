package Entities;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserGraph implements Serializable {
private ArrayList<User> users;
private static final long serialVersionUID = 1L;
private ArrayList<UserEdge> userEdges;
    public UserGraph(){
        this.users = new ArrayList<>();
        this.userEdges = new ArrayList<>();
    }
    public UserGraph(ArrayList<User> users) {
        this.users = users;
        this.userEdges = new ArrayList<>();
    }
    public UserGraph(ArrayList<User> users, ArrayList<UserEdge> userEdges){
        this.users = users;
        this.userEdges = userEdges;
    }
    public boolean userInGraph(User userCheck) {
        //checks if username
        for (User user : this.users) {
            if(user.getUsername() == userCheck.getUsername()){
                //theoretical getter methods of User
                return true;
            }
        }
        return false;
    }
    public void addUser(User user){
        //Preconditions: user not in users
        this.users.add(user);
        for (User otherUser : this.users) {
            if(otherUser.getUsername() != user.getUsername()){
                this.createEdge(user, otherUser);
                user.addNeighbor(otherUser);
                otherUser.addNeighbor(user);
            }

    }
    }
    public void deleteUser(User user){
        //This method likely won't be used that much, likely more common to just use the hidden method.
        for(UserEdge edge: this.userEdges){
            if(edge.getUsers()[0] == user){
                edge.getUsers()[1].removeNeighbor(user);
                this.userEdges.remove(edge);
            }
            else if(edge.getUsers()[1] == user){
                edge.getUsers()[0].removeNeighbor(user);
                this.userEdges.remove(edge);
            }
        }
        this.users.remove(user);
    }

    private UserEdge createEdge(User user1, User user2){
        //Precondition: No edge exists between user1 and user2
        //              user1 in users, user2 in users
        UserEdge newEdge = new UserEdge(user1, user2);
        this.userEdges.add(newEdge);
        return newEdge;
    }
    public UserEdge getEdge(User user1, User user2){
        for(UserEdge edge: this.userEdges){
            if(edge.isEdge(user1, user2)){ return edge;}
        }
        return createEdge(user1, user2);
    }
    public ArrayList<String> getUsernames(){
        ArrayList<String> users = new ArrayList<String>();
        for(User user: this.users){

            users.add(user.getUsername().getData());
        }
        return users;
    }
    // currently using username as refernce to get user, not sure if we will be sending
    // displayname or username to presenters yet.
    public User getUser(String userID){
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUsername().getData().equals(userID)) {
                return this.users.get(i);
            }
        }
        return null;
    }
}
