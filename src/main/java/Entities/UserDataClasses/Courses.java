package Entities.UserDataClasses;

import java.util.ArrayList;

public class Courses extends HideableData<ArrayList<Course>>{
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
