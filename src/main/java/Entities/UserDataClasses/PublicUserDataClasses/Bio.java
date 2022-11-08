package Entities.UserDataClasses.PublicUserDataClasses;

import Entities.UserDataClasses.UserData;

import java.io.Serializable;

public class Bio extends UserData<String> implements Serializable {
    public String data;

    public Bio(String bio){
        super(bio);
        this.data = bio;
    }
}
