
package UseCases.useredit;

import Entities.User;
import Entities.UserDataClasses.PrivateUserDataClasses.Preferences;
import Entities.UserDataClasses.UserDataDictionaries.InterestsDict;

public class CompatibilityFunction {

    /**
     * Return whether user1 has an attribute that is a dealbreaker for user2
     * @param user1 user to check for attributes
     * @param user2 user to check for preferences
     * @return whether they are incompatible
     */
    public boolean hasDealbreaker(User user1, User user2){
        Preferences user2Preferences = user2.getPreferences();

        for(int i = 0; i < user2Preferences.getData().size(); i++){
            for(int k = 0; k < user2Preferences.getData().get(i).size(); k++){
                if(user1.containsAttribute(i, user2Preferences.getData().get(i).get(k))){
                    return true;
                }}
        }
        return false;
    }

    /**
     * Return the compatibility weight between <user1> and <user2>. That is,
     * if one User has an attribute that is a dealbreaker for the other,
     * return 0. Otherwise, set the weight to 0.5. Then, for each interest
     * user1 and user2 have in common, add .5 / (number of possible interests).
     * This ensures the maximum compatibility weight is 1.
     * The function should return the same value regardless of the order of the
     * Users.
     * @param user1 First user
     * @param user2 Second user
     * @return compatibility weight
     */
    public float getCompatibility(User user1, User user2){
        // Return 0 if two Users are incompatible (one user has an attribute
        // which is a dealbreaker for the other), or .5 + a small fraction for
        // every additional interest
        float weight = 0;

        if(hasDealbreaker(user1, user2) || hasDealbreaker(user2, user1)){
            return weight;
        }

        new InterestsDict();
        int numInterests = InterestsDict.interestMap.size();
        weight += .5;

        for(int i = 0; i < numInterests; i++){
            if(user2.containsInterest(i) && user1.containsInterest(i)){
                weight += .5 / numInterests;
                System.out.println(true);
            }
        }
        return weight;
    }
}