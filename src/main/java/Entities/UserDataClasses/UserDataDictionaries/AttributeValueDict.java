package Entities.UserDataClasses.UserDataDictionaries;

import java.util.ArrayList;
import java.util.HashMap;

public class AttributeValueDict {
    public static final HashMap<Integer, HashMap<Integer, String>> valuesMap =
            new HashMap<Integer, HashMap<Integer, String>>();

    public AttributeValueDict(){

        // Gender
        valuesMap.put(0, new HashMap<Integer, String>());
        valuesMap.get(0).put(0, "Male");
        valuesMap.get(0).put(1, "Female");
        valuesMap.get(0).put(2, "Other");

        // Age
        valuesMap.put(1, new HashMap<Integer, String>());
        valuesMap.get(1).put(0, "18");
        valuesMap.get(1).put(1, "19");
        valuesMap.get(1).put(2, "20");
        valuesMap.get(1).put(3, "21");
        valuesMap.get(1).put(4, "22");
        valuesMap.get(1).put(5, "23");
        valuesMap.get(1).put(6, "24");
        valuesMap.get(1).put(7, "25");
        valuesMap.get(1).put(8, "26");
        valuesMap.get(1).put(9, "27");
        valuesMap.get(1).put(10, "28");
        valuesMap.get(1).put(11, "29");
        valuesMap.get(1).put(12, "30+");

        // Height
        valuesMap.put(2, new HashMap<Integer, String>());
        valuesMap.get(2).put(0, "Under 4'10\"");
        valuesMap.get(2).put(1, "4'10\"-5'0\"");
        valuesMap.get(2).put(2, "5'1\"-5'3\"");
        valuesMap.get(2).put(3, "5'4\"-5'6\"");
        valuesMap.get(2).put(4, "5'7\"-5'9\"");
        valuesMap.get(2).put(5, "5'10\"-6'0\"");
        valuesMap.get(2).put(6, "6'1\"-6'3\"");
        valuesMap.get(2).put(7, "Over 6'4\"");

        // Weight (questionable choice of attribute, we can take it out if we want)
        valuesMap.put(3, new HashMap<Integer, String>());
        valuesMap.get(3).put(0, "Under 100 lbs");
        valuesMap.get(3).put(1, "100-120 lbs");
        valuesMap.get(3).put(2, "120-140 lbs");
        valuesMap.get(3).put(3, "140-160 lbs");
        valuesMap.get(3).put(4, "160-180 lbs");
        valuesMap.get(3).put(5, "180-200 lbs");
        valuesMap.get(3).put(6, "200-250 lbs");
        valuesMap.get(3).put(7, "Over 250 lbs");

        // Hair Color
        valuesMap.put(4, new HashMap<Integer, String>());
        valuesMap.get(4).put(0, "Light Brown");
        valuesMap.get(4).put(1, "Blonde");
        valuesMap.get(4).put(2, "Black");
        valuesMap.get(4).put(3, "Dark Brown");
        valuesMap.get(4).put(4, "Dirty Blonde");
        valuesMap.get(4).put(5, "Ginger");
        valuesMap.get(4).put(6, "Orange");
        valuesMap.get(4).put(7, "Green");
        valuesMap.get(4).put(8, "Red");
        valuesMap.get(4).put(9, "Blue");
        valuesMap.get(4).put(10, "Purple");
        valuesMap.get(4).put(11, "Pink");
        valuesMap.get(4).put(12, "Other or Multiple");

        // Eye Color
        valuesMap.put(5, new HashMap<Integer, String>());
        valuesMap.get(5).put(0, "Brown");
        valuesMap.get(5).put(1, "Green");
        valuesMap.get(5).put(2, "Blue");
        valuesMap.get(5).put(3, "Hazel");
        valuesMap.get(5).put(4, "Black");
        valuesMap.get(5).put(5, "Other");

        // Sexual Orientation
        valuesMap.put(6, new HashMap<Integer, String>());
        valuesMap.get(6).put(0, "Straight");
        valuesMap.get(6).put(1, "Gay");
        valuesMap.get(6).put(2, "Lesbian");
        valuesMap.get(6).put(3, "Bisexual");
        valuesMap.get(6).put(4, "Pansexual");
        valuesMap.get(6).put(5, "Other");

        // College
        valuesMap.put(7, new HashMap<Integer, String>());
        valuesMap.get(7).put(0, "Trinity College");
        valuesMap.get(7).put(1, "Victoria College");
        valuesMap.get(7).put(2, "New College");
        valuesMap.get(7).put(3, "University College");
        valuesMap.get(7).put(4, "Woodsworth College");
        valuesMap.get(7).put(5, "Innis College");
        valuesMap.get(7).put(6, "St. Michael's College");
        valuesMap.get(7).put(7, "None");

        // Program (Couldn't find a good, short list of programs, can add more later)
        valuesMap.put(8, new HashMap<Integer, String>());
        valuesMap.get(8).put(0, "Math and Physical Sciences");
        valuesMap.get(8).put(1, "Computer Science");
        valuesMap.get(8).put(2, "Life Sciences");
        valuesMap.get(8).put(3, "Rotman Commerce");
        valuesMap.get(8).put(4, "Music");
        valuesMap.get(8).put(5, "Engineering");
        valuesMap.get(8).put(6, "Humanities");

        // Postal Code
        valuesMap.put(9, new HashMap<Integer, String>()); // Want to find a numerical way to track someone's location

        // Where are you from?
        valuesMap.put(10, new HashMap<Integer, String>()); // Want to find a better way to say this and represent it

        // Ethnicity (I used the Hinge ethnicity list)
        valuesMap.put(11, new HashMap<Integer, String>());
        valuesMap.get(11).put(0, "White/Caucasian");
        valuesMap.get(11).put(1, "South Asian");
        valuesMap.get(11).put(2, "East Asian");
        valuesMap.get(11).put(3, "Black/African Descent");
        valuesMap.get(11).put(4, "Pacific Islander");
        valuesMap.get(11).put(5, "Middle Eastern");
        valuesMap.get(11).put(6, "American Indian");
        valuesMap.get(11).put(7, "Hispanic/Latino");
        valuesMap.get(11).put(8, "Mixed/Other");

        // Religion (also used hinge religion list)
        valuesMap.put(12, new HashMap<Integer, String>());
        valuesMap.get(12).put(0, "Christian");
        valuesMap.get(12).put(1, "Catholic");
        valuesMap.get(12).put(2, "Muslim");
        valuesMap.get(12).put(3, "Hindu");
        valuesMap.get(12).put(4, "Jewish");
        valuesMap.get(12).put(5, "Agnostic");
        valuesMap.get(12).put(6, "Atheist");
        valuesMap.get(12).put(7, "Other");

        // What are you looking for?
        valuesMap.put(11, new HashMap<Integer, String>());
        valuesMap.get(11).put(0, "Life Partner");
        valuesMap.get(11).put(1, "Serious Dating");
        valuesMap.get(11).put(2, "Casual Dating");
        valuesMap.get(11).put(3, "Hookup");
        valuesMap.get(11).put(4, "Friend");
        valuesMap.get(11).put(5, "Study Partner");
        valuesMap.get(11).put(6, "Other");
    }
}
