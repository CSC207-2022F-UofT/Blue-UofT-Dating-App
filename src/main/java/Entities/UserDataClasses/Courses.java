package Entities.UserDataClasses;

import Entities.UserDataClasses.PublicDataClasses.Photo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Courses extends UserData<ArrayList<Course>>{
    public ArrayList<Course> data;
    public boolean hidden;

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
