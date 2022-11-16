package Entities.UserDataClasses.HideableUserDataClasses;

import Entities.UserDataClasses.HideableData;

import java.io.Serializable;
import java.util.HashMap;

public class Interests extends HideableData<HashMap<Integer, Boolean>> implements Serializable {

    public HashMap<Integer, Boolean> data;
    public boolean hidden;

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
