package usecases;

import java.util.ArrayList;
import java.util.HashMap;

public class UserEditModel {
    String bio;
    String name;
    String[] courses;
    HashMap<Integer, Boolean> interestsDict;
    HashMap<Integer, Integer> attributeDict;
    ArrayList<ArrayList<Integer>> breakersDict;
    HashMap<Integer, Boolean> hiddenDict;
    public UserEditModel(String name, String bio, String[] courses, HashMap<Integer, Boolean> interestsDict,
                         HashMap<Integer, Integer> attributeDict, ArrayList<ArrayList<Integer>> breakersDict,
                         HashMap<Integer, Boolean> hiddenDict){
        this.bio = bio;
        this.name = name;
        this.attributeDict = attributeDict;
        this.interestsDict = interestsDict;
        this.breakersDict = breakersDict;
        this.courses = courses;
        this.hiddenDict = hiddenDict;

    }
}
