package Entities;

import Entities.UserDataClasses.HideableUserDataClasses.Attributes;
import Entities.UserDataClasses.HideableUserDataClasses.Course;
import Entities.UserDataClasses.HideableUserDataClasses.Courses;
import Entities.UserDataClasses.HideableUserDataClasses.Interests;
import Entities.UserDataClasses.PrivateUserDataClasses.Username;
import Entities.UserDataClasses.PublicUserDataClasses.DisplayName;
import Entities.UserDataClasses.PublicUserDataClasses.Location;
import Entities.UserDataClasses.PublicUserDataClasses.Photo;
import Entities.UserDataClasses.PublicUserDataClasses.Photos;
import Entities.UserDataClasses.UserData;

import java.util.ArrayList;
import java.util.HashMap;

public class User {

    private UserData<String> username;
//    private UserData<String> passwordHash; // Idk if this will be a string tbh
    private UserData<String> displayName;
    private UserData<String> bio;
    private UserData<String> location;
    private UserData<ArrayList<Photo>> photos;
    private UserData<ArrayList<Course>> courses;
    private UserData<HashMap<Integer, Boolean>> interests;
    private UserData<HashMap<Integer, ArrayList<Object>>> attributes;
//    private UserData<HashMap<Integer, ArrayList<Object>>> preferences;
    private ArrayList<User> neighbors;

    public User(String username, // password,
            String displayName, String location){
        this.username = new Username(username);
//        this.passwordHash =
        this.displayName = new DisplayName(displayName);
        this.location = new Location(location);
        this.photos = new Photos();
        this.courses = new Courses();
        this.interests = new Interests();
        this.attributes = new Attributes();
//        this.preferences =
        this.neighbors = new ArrayList<User>();
    }

    public UserData<String> getUsername() {
        return username;
    }
    public UserData<String> getDisplayName() {
        return displayName;
    }
    public UserData<String> getBio() {
        return bio;
    }
    public UserData<String> getLocation() {
        return location;
    }
    public UserData<ArrayList<Photo>> getPhotos() {
        return photos;
    }
    public UserData<ArrayList<Course>> getCourses() {
        return courses;
    }
    public UserData<HashMap<Integer, Boolean>> getInterests() {
        return interests;
    }
    public UserData<HashMap<Integer, ArrayList<Object>>> getAttributes() {
        return attributes;
    }
    public ArrayList<User> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(User otherUser){
        neighbors.add(otherUser);
    }
    public void removeNeighbor(User otherUser){
        neighbors.remove(otherUser);
    }
}
