package Entities.UserDataClasses.PublicDataClasses;

import Entities.UserDataClasses.FreeWritten;
import Entities.UserDataClasses.UserData;

public class Bio extends UserData<String> implements FreeWritten {
    public String data;

    public Bio(String bio){
        super(bio);
        this.data = bio;
    }
}
