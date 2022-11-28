package UseCases;

import Entities.User;
import Entities.UserDataClasses.HideableUserDataClasses.Courses;
import Entities.UserDataClasses.HideableUserDataClasses.Interests;
import Entities.UserDataClasses.PrivateUserDataClasses.Preferences;
import Entities.UserDataClasses.UserDataDictionaries.InterestsDict;

public class CompatibilityFunction {

    public float getCompatibility(User user1, User user2){
        // Return 0 if two Users are incompatible (one user has an attribute
        // which is a dealbreaker for the other), or .5 + a small fraction for
        // every additional interest
        float weight = 0;

        Preferences user1Preferences = new Preferences();
        Preferences user2Preferences = new Preferences();
        user1Preferences.setData(user1.getPreferences().getData());
        user2Preferences.setData(user2.getPreferences().getData());

        for(int i = 0; i < user2Preferences.getData().size(); i++){
            for(int k = 0; k < user2Preferences.getData().get(i).size(); k++){
                if(user1.containsAttribute(i, user2Preferences.getData().get(i).get(k))){
                    return weight;
                }}
            for(int k = 0; k < user2Preferences.getData().get(i).size(); k++){
                if(user2.containsAttribute(i, user1Preferences.getData().get(i).get(k))){
                    return weight;
                }}
        }

        Interests user1Interests = new Interests();
        Interests user2Interests = new Interests();
        user1Interests.setData(user1.getInterests().getData());
        user2Interests.setData(user2.getInterests().getData());
        int numInterests = InterestsDict.interestMap.size();
        weight += .5;

        for(int i = 0; i < numInterests; i++){
            if(user2.containsInterest(i) & user1.containsInterest(i)){
                weight += .5 / numInterests;
            }
        }
        return weight;
    }
}