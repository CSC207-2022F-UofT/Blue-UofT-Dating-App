package Entities.UserDataClasses.PrivateUserDataClasses;

public class PostalCode {
    public final String code;
    // Precondition: code is a valid canadian postal code in the form A1B2C3

    // TODO: 11/2/22: Raise and catch errors for invalid postal code formats
    public PostalCode(String code){
        assert code.length() == 6;
        assert code.substring(0, 0).matches("[a-zA-Z]+") &
                code.substring(2, 2).matches("[a-zA-Z]+") &
                code.substring(4, 4).matches("[a-zA-Z]+") &
                code.substring(1, 1).matches("[0-9]+") &
                code.substring(3, 3).matches("[0-9]+") &
                code.substring(5, 5).matches("[0-9]+");

        this.code = code.toUpperCase();
    }
}
