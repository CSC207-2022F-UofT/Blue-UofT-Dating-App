package Entities.UserDataClasses.PublicDataClasses;

import Entities.UserDataClasses.UserData;

public class DisplayName extends UserData<String> {
    public String data;

    public DisplayName(String name){
        super(name);
        this.data = name;
    }
}
