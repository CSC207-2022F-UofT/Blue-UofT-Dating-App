package Entities.UserDataClasses.PublicDataClasses;

import Entities.UserDataClasses.UserData;

public class Bio extends UserData<String> {
    public String data;

    public Bio(String bio){
        super(bio);
        this.data = bio;
    }
}
