package Entities.UserDataClasses.PrivateUserDataClasses;

import Entities.UserDataClasses.UserData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Preferences extends UserData<ArrayList<int[]>> implements Serializable {
    // this.data consists of an ArrayList of pairs of integers, where the first
    // integer in each pair corresponds to the type of attribute,
    public ArrayList<int[]> data;

    public Preferences(){
        super(new ArrayList<int[]>());
        this.data = super.data;
    }

    public void setPreferences(Integer attributeKey, Integer valueKey){
        // sets the attribute with key attributeKey (in AttributesDict) to the
        // value with valueKey (in AttributeValuesDict)
        int[] keyDict = new int[2];
        keyDict[0] = attributeKey;
        keyDict[1] = valueKey;
        this.data.add(keyDict);
    }

    public void removePreferences(Integer attributeKey){
        this.data.remove();
    }
}
