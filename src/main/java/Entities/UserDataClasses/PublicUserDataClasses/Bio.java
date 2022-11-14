package Entities.UserDataClasses.PublicUserDataClasses;

import Entities.UserDataClasses.UserData;

public class Bio extends UserData<String> {
    public String data;

    public Bio(String bio){
        super(bio);
        this.data = bio;
    }
    public Bio(){
        super("Just your average UofT student.");
        this.data = "Just your average UofT student.";
    }
}
