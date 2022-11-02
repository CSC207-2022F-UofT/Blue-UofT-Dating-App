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
}
