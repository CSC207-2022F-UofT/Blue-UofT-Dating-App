package Entities.UserDataClasses.PublicUserDataClasses;

import Entities.UserDataClasses.UserData;

import java.io.Serializable;

public class DisplayName extends UserData<String> implements Serializable {
    public String data;

    public DisplayName(String name){
        super(name);
        this.data = name;
    }
}
