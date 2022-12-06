package Entities;
import Entities.UserDataClasses.UserData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Weighted, fully connected and pseudo directional graph which is the main data structure of the project. The
 * nodes of the graph represent Users, and edges represent relationships between users, storing likes between users and
 * their compatibility. User graph (and all classes it holds) implements serializable, so it can be data persistent.
 * The only methods of this class are getters and setters.
 */
public class UserGraph implements Serializable {
private final ArrayList<User> users;
private final ArrayList<UserEdge> userEdges;

    /**
     * Different constructors for user graph
     */
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

    /** Adds passed user into graph. This also creates all edges
     * @param user User object
     */
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

    /**
     * Creates an edge between two users.
     * @param user1 User object
     * @param user2 other User object
     * @return UserEdge between user1 and user2
     */
    private UserEdge createEdge(User user1, User user2){
        //Precondition: No edge exists between user1 and user2
        //              user1 in users, user2 in users
        UserEdge newEdge = new UserEdge(user1, user2);
        this.userEdges.add(newEdge);
        return newEdge;
    }

    /** Returns UserEdge between two users
     * @param user1  User object
     * @param user2 other User object
     * @return UserEdge between two users
     */
    public UserEdge getEdge(User user1, User user2){
        for(UserEdge edge: this.userEdges){
            if(edge.isEdge(user1, user2)){ return edge;}
        }
        return createEdge(user1, user2);
    }

    /** Get the usernames of all users
     * @return ArrayList of usernames within UserGraph
     */
    public ArrayList<String> getUsernames(){
        ArrayList<String> users = new ArrayList<>();
        for(User user: this.users){

            users.add(user.getUsername().getData());
        }
        return users;
    }

    /** Gets the user from the graph with username, username.
     * Preconditions: user with username, username, in usergraph
     * @param username UserData username
     * @return User object with username, username.
     */
    public User getUser(UserData<String> username){
        for(User user: this.users){
            if(Objects.equals(user.getUsername().getData(), username.getData())){
                return user;
            }

        }
        return new User("null","null");
    }

    /** Gets the user from the graph with username, username.
     * Preconditions: user with username, username, in usergraph
     * @param username string username
     * @return User object with username, username.
     */
    public User getUserByString(String username) {
        for (User user : this.users) {
            if (username.equals(user.getUsername().getData())) {
                return user;
            }
        }
        return null;
    }

    /** Getter of users for UserGraph
     * @return users of UserGraph
     */
    public ArrayList<User> getUsers(){ return this.users;}

    /** Removes an edge from the list of edges.
     * @param userEdge UserEdge object
     */
    public void deleteEdge(UserEdge userEdge){
        for(int i = 0; i < this.userEdges.size(); i++){
            UserEdge userEdge1 = this.userEdges.get(i);
            if(Arrays.equals(userEdge.getUsers(), userEdge1.getUsers())){
                this.userEdges.remove(i);
                return;
            }
        }
    }

    /** Removes user from user list of the UserGraph
     * @param user User object
     */
    public void deleteUser(User user){
        for(int i = 0; i < this.users.size(); i++){
            if(this.users.get(i).getUsername().getData().equals(user.getUsername().getData())){
                this.users.remove(i);
                return;
            }
        }
    }
}
