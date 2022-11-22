package Entities.UserDataClasses.HideableUserDataClasses;

import Entities.UserDataClasses.HideableData;

import java.io.Serializable;
import java.util.ArrayList;

public class Courses extends HideableData<ArrayList<Course>> implements Serializable {
    public ArrayList<Course> data;
    public boolean hidden;

    // Constructors
    public Courses(){
        super(new ArrayList<Course>());
        this.data = super.data;
    }

    public Courses(ArrayList<Course> courses){
        super(courses);
        this.data = courses;
        this.hidden = true;
    }

    public Courses(Course course){
        super(new ArrayList<Course>());
        super.data.add(course);
        this.data = super.data;
        this.hidden = true;
    }

    // Methods
    public void addCourse(Course course){
        this.data.add(course);
    }
    public void addCourses(ArrayList<Course> courses){
        this.data.addAll(courses);
    }
    public void removeCourse(Course course){
        this.data.remove(course);
    }
    public void removeCourses(ArrayList<Course> courses){
        this.data.removeAll(courses);
    }
    @Override
    public String toString(){
        StringBuilder returnString = new StringBuilder();
        for(Course course: this.data){
            returnString.append(course.getData().code);
            returnString.append(", ");
        }
        return returnString.toString();
    }
}