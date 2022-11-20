package Entities.UserDataClasses.PrivateUserDataClasses;

import Entities.UserDataClasses.UserData;
import Entities.UserDataClasses.UserDataDictionaries.AttributeValueDict;
import Entities.UserDataClasses.UserDataDictionaries.AttributesDict;

import java.util.ArrayList;

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
    public void removeEntirePreference(Integer preferenceKey){
        // Removes all preference values for the type referred to by preferenceKey
        // in AttributesDict
        this.data.get(preferenceKey).clear();
    }
    public void addPreferences(Integer preferenceKey, ArrayList<Integer> valueKeys){
        // Adds preferences in <valueKeys> (e.g. brown, blue, green) to attribute
        // category <preferenceKey> (e.g. eye color), as determined by AttributesDict
        // and AttributesValueDict. If a value in valueKeys is already present in
        // this.data, do not add it again.
        if(valueKeys.size() > 0) {
            for (int i = 0; i < valueKeys.size(); i++) {
                if (!(this.data.get(preferenceKey).contains(valueKeys.get(i)))){
                    this.data.get(preferenceKey).add(valueKeys.get(i));
                }}}
    }
    public void removePreferences(Integer preferenceKey, ArrayList<Integer> valueKeys){
        // Removes preferences in <valueKeys> (e.g. brown, blue, green) from attribute
        // category <preferenceKey> (e.g. eye color), as determined by AttributesDict
        // and AttributesValueDict
        this.data.get(preferenceKey).removeAll(valueKeys);
    }
    public String getTypeAt(int attributeKey){
        AttributesDict dict = new AttributesDict();
        return dict.attributeAt(attributeKey);
    }
    public String getValueAt(int attributeKey, int valueKey) {
        AttributeValueDict dict = new AttributeValueDict();
        return dict.valueAt(attributeKey, valueKey);
    }
}
