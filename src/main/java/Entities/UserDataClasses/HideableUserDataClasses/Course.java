package Entities.UserDataClasses.HideableUserDataClasses;

import Entities.UserDataClasses.CourseCode;
import Entities.UserDataClasses.HideableData;

import java.io.Serializable;

public class Course extends HideableData<CourseCode> implements Serializable {
    public CourseCode data;
    public boolean hidden;

    public Course(CourseCode courseCode){
        super(courseCode);
        this.data = courseCode;
        this.hidden = true;
    }
}
