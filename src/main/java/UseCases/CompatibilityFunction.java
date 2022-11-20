package UseCases;

import Entities.User;
import Entities.UserDataClasses.PrivateUserDataClasses.Preferences;

public class CompatibilityFunction {

    public int getCompatibility(User user1, User user2){
        // Return 0 if two Users are incompatible (one user has an attribute
        // which is a dealbreaker for the other), or 1 if they are compatible
        int weight = 1;

        Preferences user1Preferences = new Preferences();
        Preferences user2Preferences = new Preferences();
        user1Preferences.setData(user1.getPreferences().getData());
        user2Preferences.setData(user2.getPreferences().getData());

        for(int i = 0; i < user2Preferences.getData().size(); i++){
            for(int k = 0; k < user2Preferences.getData().get(i).size(); k++){
                if(user1.containsAttribute(i, user2Preferences.getData().get(i).get(k))){
                    weight = 0;
                    return weight;
                }}
            for(int k = 0; k < user2Preferences.getData().get(i).size(); k++){
                if(user2.containsAttribute(i, user1Preferences.getData().get(i).get(k))){
                    weight = 0;
                    return weight;
                }}
        }
        return weight;
    }
}
