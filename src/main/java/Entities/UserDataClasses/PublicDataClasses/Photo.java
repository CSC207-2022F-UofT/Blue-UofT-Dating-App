package Entities.UserDataClasses.PublicDataClasses;

import Entities.UserDataClasses.FreeWritten;
import Entities.UserDataClasses.UserData;

public class Photo extends UserData<String> implements FreeWritten {
    public String data;
    // Precondition: filePath is a valid file path to a photo

    public Photo(String filePath){
        super(filePath);
        this.data = filePath;
    }
}
