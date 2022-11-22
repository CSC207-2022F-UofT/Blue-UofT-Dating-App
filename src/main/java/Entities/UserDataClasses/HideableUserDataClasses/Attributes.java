package Entities.UserDataClasses.HideableUserDataClasses;

import Entities.UserDataClasses.HideableData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Attributes extends HideableData<HashMap<Integer, ArrayList<Object>>> implements Serializable {

    // this.data consists of an integer key (which corresponds to the type of attribute) and
    // an ArrayList value, which consists of an integer at index 0 (which corresponds to the value of
    // the specified attribute) and a boolean at index 1 which determines whether the attribute is hidden
    public HashMap<Integer, ArrayList<Object>> data;
    public boolean hidden;

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

    public void setAttribute(Integer attributeKey, Integer valueKey){
        // sets the attribute with key attributeKey (in AttributesDict) to the
        // value with valueKey (in AttributeValuesDict)
        this.data.put(attributeKey, new ArrayList<Object>());
        this.data.get(attributeKey).add(valueKey);
        this.data.get(attributeKey).add(true);
    }
    public void setAttribute(Integer attributeKey, Integer valueKey, boolean hidden){

        this.data.put(attributeKey, new ArrayList<Object>());
        this.data.get(attributeKey).add(valueKey);
        this.data.get(attributeKey).add(hidden);
    }

    public void removeAttribute(Integer attributeKey){
        this.data.remove(attributeKey);
    }

    public void hideAttribute(Integer attributeKey){
        this.data.get(attributeKey).set(1, true);
    }

    public void showAttribute(Integer attributeKey){
        this.data.get(attributeKey).set(1, false);
    }
    public void setVisibility(Integer attributeKey, boolean hidden){
        this.data.get(attributeKey).set(1, hidden);
    }
}
