package Entities;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserGraph{
private ArrayList<User> users;
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
           this.createEdge(user, otherUser);
           user.addNeighbor(otherUser);
           otherUser.addNeighbor(user);
           //more theoretical User methods
    }
    }
    public void deleteUser(User user){
        //TO DO
    }

    public void createEdge(User user1, User user2){
        //Precondition: No edge exists between user1 and user2
        //              user1 in users, user2 in users
        UserEdge newEdge = new UserEdge(user1, user2);
        this.userEdges.add(newEdge);
    }
    public void deleteEdge(User user){
        //TO DO
    }
}
