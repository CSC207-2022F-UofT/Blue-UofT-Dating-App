package Entities;

import Entities.UserDataClasses.HideableUserDataClasses.Attributes;
import Entities.UserDataClasses.HideableUserDataClasses.Course;
import Entities.UserDataClasses.HideableUserDataClasses.Courses;
import Entities.UserDataClasses.HideableUserDataClasses.Interests;
import Entities.UserDataClasses.PrivateUserDataClasses.Password;
import Entities.UserDataClasses.PrivateUserDataClasses.PostalCode;
import Entities.UserDataClasses.PrivateUserDataClasses.Preferences;
import Entities.UserDataClasses.PrivateUserDataClasses.Username;
import Entities.UserDataClasses.PublicUserDataClasses.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class User implements Serializable {

    private final Username username;
    private Password password;
    private DisplayName displayName;
    private Bio bio;
    private Location location;
    private PostalCode postalCode;
    private Photos photos;
    private Courses courses;
    private Interests interests;
    private Attributes attributes;
    private Preferences preferences;
    private ArrayList<User> neighbors;

    // Constructor
    public User(String username, String password) {
        // Always hidden from other Users
        this.username = new Username(username);
        this.password = new Password(password);
        this.preferences = new Preferences();
        this.postalCode = new PostalCode();

        // Always shown to other Users
        this.displayName = new DisplayName();
        this.bio = new Bio();
        this.location = new Location();
        this.photos = new Photos();

        // Hideable
        this.courses = new Courses();
        this.interests = new Interests();
        this.attributes = new Attributes();

        // Other
        this.neighbors = new ArrayList<User>();
    }

    // Getters
    public Username getUsername() {
        return username;
    }
    public Password getPassword() {
        return password;
    }
    public DisplayName getDisplayName() {
        return displayName;
    }

    public Bio getBio() {
        return bio;
    }

    public Location getLocation() {
        return location;
    }

    public PostalCode getPostalCode() {
        return this.postalCode;
    }

    public Photos getPhotos() {
        return photos;
    }

    public Courses getCourses() {
        return courses;
    }

    public Interests getInterests() {
        return interests;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public ArrayList<User> getNeighbors() {
        return neighbors;
    }

    // Setters
    public void setPassword(String newPassword) {
        this.password = new Password(newPassword);
    }

    public void setPassword(Password newPassword) {
        this.password = newPassword;
    }

    public void setDisplayName(String newDisplayName) {
        this.displayName = new DisplayName(newDisplayName);
    }

    public void setDisplayName(DisplayName newDisplayName) {
        this.displayName = newDisplayName;
    }

    public void setBio(String newBio) {
        this.bio = new Bio(newBio);
    }

    public void setBio(Bio newBio) {
        this.bio = newBio;
    }

    public void setLocation(String newLocation) {
        this.location = new Location(newLocation);
    }

    public void setLocation(Location newLocation) {
        this.location = newLocation;
    }

    public void setPostalCode(String newPostalCode) {
        // Precondition: newPostalCode is of the format a1b2c3
        this.postalCode = new PostalCode(newPostalCode);
    }

    public void setPostalCode(PostalCode newPostalCode) {
        this.postalCode = newPostalCode;
    }

    public void setPhotos(ArrayList<Photo> newPhotos) {
        this.photos = new Photos(newPhotos);
    }

    public void setPhotos(Photos newPhotos) {
        this.photos = newPhotos;
    }

    public void setCourses(ArrayList<Course> newCourses) {
        this.courses = new Courses(newCourses);
    }

    public void setCourses(Courses newCourses) {
        this.courses = newCourses;
    }

    public void setInterests(HashMap<Integer, Boolean> newInterests) {
        this.interests = new Interests();
        this.interests.setData(newInterests);
        this.interests.data = newInterests;
    }

    public void setInterests(Interests newInterests) {
        this.interests = newInterests;
    }

    public void setAttributes(HashMap<Integer, ArrayList<Object>> newAttributes) {
        this.attributes = new Attributes();
        this.attributes.setData(newAttributes);
    }

    public void setAttributes(Attributes newAttributes) {
        this.attributes = newAttributes;
    }

    public void setPreferences(ArrayList<ArrayList<Integer>> newPreferences) {
        this.preferences = new Preferences();
        this.preferences.setData(newPreferences);
    }

    public void setPreferences(Preferences newPreferences) {
        this.preferences = newPreferences;
    }


    // // UserEdit Methods

    // Photos
    public void addPhoto(Photo newPhoto) {
        this.photos.addPhoto(newPhoto);
    }

    public void addPhotos(ArrayList<Photo> newPhotos) {
        this.photos.addPhotos(newPhotos);
    }

    public void removePhoto(Photo oldPhoto) {
        this.photos.removePhoto(oldPhoto);
    }

    public void removePhotos(ArrayList<Photo> oldPhotos) {
        this.photos.removePhotos(oldPhotos);
    }

    public Photo getPhotoAt(int index) {
        return this.photos.getData().get(index);
    }

    // Courses
    public void addCourse(Course newCourse) {
        this.courses.addCourse(newCourse);
    }

    public void addCourses(ArrayList<Course> newCourses) {
        this.courses.addCourses(newCourses);
    }

    public void removeCourse(Course oldCourse) {
        this.courses.removeCourse(oldCourse);
    }

    public void removeCourses(ArrayList<Course> oldCourses) {
        this.courses.removeCourses(oldCourses);
    }

    public Course getCourseAt(int index) {
        return this.courses.getData().get(index);
    }

    // Interests
    public void addInterest(int newInterest) {
        this.interests.addInterest(newInterest);
    }

    public void addInterests(ArrayList<Integer> newInterests) {
        this.interests.addInterests(newInterests);
    }

    public void removeInterest(int oldInterest) {
        this.interests.removeInterest(oldInterest);
    }

    public void removeInterests(ArrayList<Integer> oldInterests) {
        this.interests.removeInterests(oldInterests);
    }

    public String getInterestAt(int interestKey) {
        return this.interests.getInterestAt(interestKey);
    }
    public boolean containsInterest(int interestKey){
        return this.interests.data.containsKey(interestKey);
    }

    // Attributes
    public void addAttribute(int attributeType, int attributeValue) {
        this.attributes.addAttribute(attributeType, attributeValue);
    }
    public void addAttributes(ArrayList<ArrayList<Integer>> newAttributes) {
        this.attributes.addAttributes(newAttributes);
    }
    public void removeAttribute(int attributeType, int attributeValue) {
        this.attributes.removeAttribute(attributeType);
    }
    public void removeAttributes(ArrayList<Integer> oldAttributes) {
        this.attributes.removeAttributes(oldAttributes);
    }
    public void changeAttribute(int attributeType, int newAttributeValue) {
        // Precondition: Only call this function if the attribute with key
        // attributeType has been set to a value before
        this.attributes.changeAttribute(attributeType, newAttributeValue);
    }
    public String getAttributeType(int attributeKey) {
        return this.attributes.getTypeAt(attributeKey);
    }
    public String getAttributeValue(int attributeType, int attributeValue){
        return this.attributes.getValueAt(attributeType, attributeValue);
    }
    public boolean containsAttribute(int attributeType, int attributeValue){
        if(this.attributes.getData().containsKey(attributeType)){
            return this.attributes.getData().get(attributeType).contains(attributeValue);
        }
        return false;
    }

    // Preferences
    public void addPreference(int attributeType, int attributeValue) {
        ArrayList<Integer> valueList = new ArrayList<Integer>();
        valueList.add(attributeValue);
        this.preferences.addPreferences(attributeType, valueList);
    }
    public void addPreferences(int attributeType, ArrayList<Integer> valueList) {
        this.preferences.addPreferences(attributeType, valueList);
    }
    public void removePreference(int attributeType, int attributeValue) {
        // Use when you want to remove one value in a preference but keep
        // the others
        ArrayList<Integer> valueList = new ArrayList<Integer>();
        valueList.add(attributeValue);
        this.preferences.removePreferences(attributeType, valueList);
    }
    public void removePreferences(int attributeType, ArrayList<Integer> valueList) {
        // Use when you want to remove some values in a preference but keep
        // the others
        this.preferences.removePreferences(attributeType, valueList);
    }
    public void removeEntirePreference(int attributeType) {
        // Use when you want to remove a preference type entirely
        this.preferences.removeEntirePreference(attributeType);
    }
    public String getPreferenceType(int attributeKey) {
        return this.preferences.getTypeAt(attributeKey);
    }
    public String getPreferenceValue(int attributeType, int attributeValue){
        return this.preferences.getValueAt(attributeType, attributeValue);
    }

    // Hide and Show Methods
    public void hideInterests(){
        Interests userInterests = (Interests) this.interests;
        userInterests.hide();
        assert this.interests == userInterests;
    }
    public void showInterests(){
        Interests userInterests = (Interests) this.interests;
        userInterests.show();
        assert this.interests == userInterests;
    }
    public void hideAttributes(){
        Attributes userAttributes = (Attributes) this.attributes;
        userAttributes.hide();
        assert this.attributes == userAttributes;
    }
    public void showAttributes(){
        Attributes userAttributes = (Attributes) this.attributes;
        userAttributes.show();
        assert this.attributes == userAttributes;
    }
    public void hideCourses(){
        Courses userCourses = (Courses) this.courses;
        userCourses.hide();
        assert this.courses == userCourses;
    }
    public void showCourses(){
        Courses userCourses = (Courses) this.courses;
        userCourses.show();
        assert this.courses == userCourses;
    }
    public void hideCourse(Course course){
        // precondition: course is already in this User's list of courses
        assert this.courses.data.contains(course);
        int index = this.courses.data.indexOf(course);
        this.courses.data.get(index).hide();
    }
    public void showCourse(Course course) {
        // precondition: course is already in this User's list of courses
        assert this.courses.data.contains(course);
        int index = this.courses.data.indexOf(course);
        this.courses.data.get(index).show();
    }


    // // UserGraph Methods
    public void addNeighbor(User otherUser){
        this.neighbors.add(otherUser);
    }
    public void removeNeighbor(User otherUser){
        this.neighbors.remove(otherUser);
    }
    public void removeAllNeighbors(){
        this.neighbors.clear();
    }
    public void setNeighbors(ArrayList<User> newNeighbours){ this.neighbors = newNeighbours;}
}