package Entities.UserDataClasses;

import java.io.Serializable;

public class CourseCode implements Serializable {

    public final String code;
    // Precondition: code is a valid UofT course code in the form AAA111 (no
    // compatibility for course codes with more than 3 numbers)

    // TODO: 11/2/22: Raise and catch errors for invalid course code formats
    public CourseCode(String code){
        assert code.length() == 6;
        assert code.substring(0, 2).matches("[a-zA-Z]+") &
                code.substring(3, 5).matches("[0-9]+");
        this.code = code.toUpperCase();
    }
    

}
