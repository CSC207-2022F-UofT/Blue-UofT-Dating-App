package Entities.UserDataClasses;

public class Course extends UserData<String> {
    public CourseCode data;
    public boolean hidden;

    public Course(CourseCode courseCode){
        super(courseCode.toString());
        this.data = courseCode;
        this.hidden = true;
    }
    public Course(CourseCode courseCode, boolean hidden){
        super(courseCode.toString());
        this.data = courseCode;
        this.hidden = hidden;
    }

    public void hide(){
        this.hidden = true;
    }
    public void show(){
        this.hidden = false;
    }
    public void setHidden(boolean hidden){
        this.hidden = hidden;
    }
}
