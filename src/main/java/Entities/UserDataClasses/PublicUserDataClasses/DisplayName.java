package Entities.UserDataClasses.PublicUserDataClasses;

import Entities.UserDataClasses.UserData;

public class DisplayName extends UserData<String> {
    public String data;

    public DisplayName(String name){
        super(name);
        this.data = name;
    }
    public DisplayName(){
        super("Majed ElKhalifa");
        this.data = "Majed ElKhalifa";
    }
}
