package Entities.UserDataClasses.PublicUserDataClasses;

import Entities.UserDataClasses.UserData;

public class Photo extends UserData<String> {
    public String data;
    // Precondition: filePath is a valid file path to a photo

    public Photo(String filePath){
        super(filePath);
        this.data = filePath;
    }
}
