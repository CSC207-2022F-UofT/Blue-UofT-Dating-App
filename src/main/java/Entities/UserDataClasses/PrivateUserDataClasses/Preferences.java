package Entities.UserDataClasses.PrivateUserDataClasses;

import Entities.UserDataClasses.UserData;

import java.util.ArrayList;
import java.util.HashMap;

public class Preferences extends UserData<ArrayList<ArrayList<Integer>>> {
    // this.data consists of an ArrayList of an ArrayList of integers, where
    // each sub-list represents the disallowed ("deal-breaker") qualities in
    // potential matches, where the index of the list corresponds to which
    // attribute is being restricted
    public ArrayList<ArrayList<Integer>> data;

    // Constructor
    public Preferences(){
        super(new ArrayList<ArrayList<Integer>>());
        this.data = super.data;
        for(int i = 0; i <= 13; i++){
            this.data.add(new ArrayList<Integer>());
        }
    }

    // Methods
    public void addPreferences(Integer preferenceKey, ArrayList<Integer> valueKeys){
        // Adds preferences in <valueKeys> (e.g. brown, blue, green) to attribute
        // category <preferenceKey> (e.g. eye color), as determined by AttributesDict
        // and AttributesValueDict
        this.data.get(preferenceKey).addAll(valueKeys);
    }

    public void removePreferences(Integer preferenceKey, ArrayList<Integer> valueKeys){
        // Removes preferences in <valueKeys> (e.g. brown, blue, green) from attribute
        // category <preferenceKey> (e.g. eye color), as determined by AttributesDict
        // and AttributesValueDict
        this.data.get(preferenceKey).removeAll(valueKeys);
    }
}
