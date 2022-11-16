package Entities.UserDataClasses.PublicUserDataClasses;

import Entities.UserDataClasses.UserData;

import java.io.Serializable;

public class Photo extends UserData<String> implements Serializable {
    public String data;
    // Precondition: filePath is a valid file path to a photo

    public Photo(String filePath){
        super(filePath);
        this.data = filePath;
    }
}
