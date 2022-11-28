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
        super(new HashMap<Integer, Boolean>(), false);
        this.data = super.data;
        for(int i = 0; i <= 49; i++){
            this.addInterest(i);
            this.unInterested(i);
        }
        this.hidden = false;
    }
    public Interests(boolean hidden){
        super(new HashMap<Integer, Boolean>(), hidden);
        this.data = super.data;
        this.hidden = hidden;
    }

    // Methods
    public void addInterest(Integer interestKey){
        this.data.put(interestKey, true);
    }
    public void addInterest(Integer interestKey, boolean hidden){
        this.data.put(interestKey, hidden);
    }
    public void addInterests(ArrayList<Integer> interestKeys) {
        for(int i = 0; i < interestKeys.size(); i++) {
            addInterest(interestKeys.get(i), true);
        }
    }
    public void removeInterest(Integer interestKey){
        this.data.remove(interestKey);
    }
    public void unInterested(Integer interestKey){this.data.put(interestKey, false);}
    public void removeInterests(ArrayList<Integer> interestKeys) {
        for(int i = 0; i < interestKeys.size(); i++) {
            removeInterest(interestKeys.get(i));
        }
    }
    public void hideInterest(Integer interestKey){
        this.data.replace(interestKey, true);
    }
    public void showInterest(Integer interestKey){
        this.data.replace(interestKey, false);
    }
    public void setInterestVisibility(Integer interestKey, boolean hidden){
        this.data.replace(interestKey, hidden);
    }
    public String getInterestAt(Integer interestKey){
        InterestsDict dict = new InterestsDict();
        return dict.interestAt(interestKey);
    }
}