package Entities.UserDataClasses.HideableUserDataClasses;

import Entities.UserDataClasses.HideableData;
import Entities.UserDataClasses.UserDataDictionaries.InterestsDict;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Interests extends HideableData<HashMap<Integer, Boolean>> implements Serializable {

    public HashMap<Integer, Boolean> data;
    public boolean hidden;

    // Constructors
    public Interests(){
        super(new HashMap<>(), false);
        this.data = super.data;
        this.hidden = false;
    }

    // Methods
    public void addInterest(Integer interestKey){
        this.data.put(interestKey, true);
    }
    public void addInterest(Integer interestKey, boolean hidden){
        this.data.put(interestKey, hidden);
    }
    public void addInterests(ArrayList<Integer> interestKeys) {
        for (Integer interestKey : interestKeys) {
            addInterest(interestKey, true);
        }
    }
    public void removeInterest(Integer interestKey){
        this.data.remove(interestKey);
    }
    public void removeInterests(ArrayList<Integer> interestKeys) {
        for (Integer interestKey : interestKeys) {
            removeInterest(interestKey);
        }
    }
    public void hideInterest(Integer interestKey){
        this.data.replace(interestKey, true);
    }
    public void showInterest(Integer interestKey){
        this.data.replace(interestKey, false);
    }
    public String getInterestAt(Integer interestKey){
        InterestsDict dict = new InterestsDict();
        return dict.interestAt(interestKey);
    }
}