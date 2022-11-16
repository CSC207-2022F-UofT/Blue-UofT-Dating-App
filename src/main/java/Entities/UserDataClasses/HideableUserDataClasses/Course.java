package Entities.UserDataClasses.HideableUserDataClasses;

import Entities.UserDataClasses.CourseCode;
import Entities.UserDataClasses.HideableData;

import java.io.Serializable;

public class Course extends HideableData<CourseCode> implements Serializable {
    public CourseCode data;
    public boolean hidden;

    // Constructors
    public Course(CourseCode courseCode){
        super(courseCode);
        this.data = courseCode;
        this.hidden = true;
    }
    public Course(CourseCode courseCode, boolean hidden){
        super(courseCode);
        this.data = courseCode;
        this.hidden = hidden;
    }
}
