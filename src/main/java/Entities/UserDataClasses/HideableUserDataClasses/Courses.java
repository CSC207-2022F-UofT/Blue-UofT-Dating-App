package Entities.UserDataClasses.HideableUserDataClasses;

import Entities.UserDataClasses.HideableData;
import Entities.UserDataClasses.HideableUserDataClasses.Course;

import java.io.Serializable;
import java.util.ArrayList;

public class Courses extends HideableData<ArrayList<Course>> implements Serializable {
    public ArrayList<Course> data;
    public boolean hidden;

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
}
