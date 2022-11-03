package Entities.UserDataClasses.PrivateUserDataClasses;

import Entities.UserDataClasses.UserData;

public class Username extends UserData<String> {

    public String data;

    public Username(String username){
        super(username);
        this.data = username;
    }
}
