package Entities.UserDataClasses.PublicUserDataClasses;

import Entities.UserDataClasses.UserData;

public class Location extends UserData<String> {
    public String data;
    // Idea: the user write whatever they want as their location, ideally
    // helping other users get the idea of where they live. Then, if users
    // match more often with users they know are near them, the algorithm can
    // find some sort of connection between postal codes

    public Location(String location){
        super(location);
        this.data = location;
    }
}
