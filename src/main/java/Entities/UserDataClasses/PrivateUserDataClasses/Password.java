package Entities.UserDataClasses.PrivateUserDataClasses;

import Entities.UserDataClasses.UserData;

public class Password extends UserData<String> {
    public String data;
    public Password(String password){
        super(password);
        this.data = password;
    }
}
