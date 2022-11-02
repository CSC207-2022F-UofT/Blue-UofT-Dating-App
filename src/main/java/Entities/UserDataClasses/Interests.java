package Entities.UserDataClasses;

import java.util.HashMap;

public class Interests extends HideableData<HashMap<Integer, Boolean>> {

    public HashMap<Integer, Boolean> data;
    public boolean hidden;
//    public void populateInterests(){
//        for(int i = 0; i <= InterestsDict.interestMap.size(); i++)
//        this.data.put(, true);
//    }
    public Interests(){
        super(new HashMap<Integer, Boolean>(), false);
        this.data = super.data;
        this.hidden = false;
    }
    public Interests(boolean hidden){
        super(new HashMap<Integer, Boolean>(), hidden);
        this.data = super.data;
        this.hidden = hidden;
    }

    public void selectInterest(Integer interestKey){
        this.data.put(interestKey, true);
    }
    public void selectInterest(Integer interestKey, boolean hidden){
        this.data.put(interestKey, hidden);
    }

    public void removeInterest(Integer interestKey){
        this.data.remove(interestKey);
    }

    public void hideInterest(Integer interestKey){
        this.data.replace(interestKey, true);
    }

    public void showInterest(Integer interestKey){
        this.data.replace(interestKey, false);
    }
    public void setVisibility(Integer interestKey, boolean hidden){
        this.data.replace(interestKey, hidden);
    }
}
