package Entities.UserDataClasses.HideableUserDataClasses;

import Entities.UserDataClasses.HideableData;
import Entities.UserDataClasses.UserDataDictionaries.AttributeValueDict;
import Entities.UserDataClasses.UserDataDictionaries.AttributesDict;
import Entities.UserDataClasses.UserDataDictionaries.InterestsDict;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Attributes extends HideableData<HashMap<Integer, ArrayList<Object>>> implements Serializable {
    // this.data consists of an integer key (which corresponds to the type of attribute) and
    // an ArrayList value, which consists of an integer at index 0 (which corresponds to the value of
    // the specified attribute) and a boolean at index 1 which determines whether the attribute is hidden
    public HashMap<Integer, ArrayList<Object>> data;
    public boolean hidden;

    // Constructors
    public Attributes(){
        super(new HashMap<Integer, ArrayList<Object>>(), false);
        this.data = super.data;
        this.hidden = false;
    }
    public Attributes(boolean hidden){
        super(new HashMap<Integer, ArrayList<Object>>(), hidden);
        this.data = super.data;
        this.hidden = hidden;
    }

    // Methods
    public void addAttribute(Integer attributeKey, Integer valueKey){
        // sets the attribute with key attributeKey (in AttributesDict) to the
        // value with valueKey (in AttributeValuesDict)
        this.data.put(attributeKey, new ArrayList<Object>());
        this.data.get(attributeKey).add(valueKey);
        this.data.get(attributeKey).add(true);
    }
    public void addAttribute(Integer attributeKey, Integer valueKey, boolean hidden){

        this.data.put(attributeKey, new ArrayList<Object>());
        this.data.get(attributeKey).add(valueKey);
        this.data.get(attributeKey).add(hidden);
    }
    public void addAttributes(ArrayList<ArrayList<Integer>> attributeValuePairs){
        // Precondition: Each sublist must be exactly of length 2, and the first
        // number in each sublist should not be repeated
        for(int i = 0; i < attributeValuePairs.size(); i++){
            this.addAttribute(attributeValuePairs.get(i).get(0),
                    attributeValuePairs.get(i).get(1));
        }
    }
    public void removeAttribute(Integer attributeKey){
        this.data.remove(attributeKey);
    }
    public void removeAttributes(ArrayList<Integer> attributeKeys){
        // Precondition: Each integer in attributeKeys should be unique
        for(int i = 0; i < attributeKeys.size(); i++){
            this.removeAttribute(attributeKeys.get(i));
        }
    }
    public void changeAttribute(Integer attributeKey, Integer newValueKey){
        // Precondition: Attribute with attributeKey has already been set to
        // a value
        this.data.get(attributeKey).clear();
        this.data.get(attributeKey).add(newValueKey);
        this.data.get(attributeKey).add(true);
    }
    public void hideAttribute(Integer attributeKey){
        this.data.get(attributeKey).set(1, true);
    }
    public void showAttribute(Integer attributeKey){
        this.data.get(attributeKey).set(1, false);
    }
    public void setAttributeVisibility(Integer attributeKey, boolean hidden){
        this.data.get(attributeKey).set(1, hidden);
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
