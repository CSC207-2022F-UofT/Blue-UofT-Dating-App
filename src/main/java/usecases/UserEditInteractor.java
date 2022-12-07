package usecases;

import Entities.User;
import Entities.UserDataClasses.HideableUserDataClasses.Attributes;
import Entities.UserDataClasses.HideableUserDataClasses.Courses;
import Entities.UserDataClasses.PrivateUserDataClasses.Preferences;
import Entities.UserGraph;

public class UserEditInteractor {
    UserEditModel userInput;
    UserGraph currGraph;
    User user;
    public UserEditInteractor(UserEditModel userInput, UserGraph currGraph, User user){
        this.user = user;
        this.userInput = userInput;
        this.currGraph = currGraph;
        this.saveData();
    }

    private void saveData(){
        Attributes attributes = new Attributes();
        Preferences preferences = new Preferences();
        for(int i = 0; i <= 13; i++){
            attributes.addAttribute(i, this.userInput.attributeDict.get(i), this.userInput.hiddenDict.get(i));
            preferences.addPreferences(i, this.userInput.breakersDict.get(i));
        }
        currGraph.getUser(user.getUsername()).setDisplayName(this.userInput.name);
        currGraph.getUser(user.getUsername()).setBio(this.userInput.bio);
        currGraph.getUser(user.getUsername()).setCourses(new Courses(this.userInput.courses));
        currGraph.getUser(user.getUsername()).setInterests(this.userInput.interestsDict);
        currGraph.getUser(user.getUsername()).setAttributes(attributes);
        currGraph.getUser(user.getUsername()).setPreferences(preferences);
    }
}
