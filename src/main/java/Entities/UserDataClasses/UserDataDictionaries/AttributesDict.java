package Entities.UserDataClasses.UserDataDictionaries;

import java.util.HashMap;

public class AttributesDict {
    public static final HashMap<Integer, String> attributesMap =
            new HashMap<>();

    public AttributesDict(){
        attributesMap.put(0, "Gender");
        attributesMap.put(1, "Age");
        attributesMap.put(2, "Height");
        attributesMap.put(3, "Weight");
        attributesMap.put(4, "Hair Color");
        attributesMap.put(5, "Eye Color");
        attributesMap.put(6, "Sexual Orientation");
        attributesMap.put(7, "College");
        attributesMap.put(8, "Program");
        attributesMap.put(9, "Postal Code"); // Want to find a numerical way to track someone's location
        attributesMap.put(10, "Where are you from?"); // Want to find a better way to say this and represent it
        attributesMap.put(11, "Ethnicity");
        attributesMap.put(12, "Religion");
        attributesMap.put(13, "What are you looking for?");
    }
    public String attributeAt(int attributeKey){
        return attributesMap.get(attributeKey);
    }
}