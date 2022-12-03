package UseCases;

import Entities.User;
import Entities.UserDataClasses.UserDataDictionaries.AttributesDict;
import Entities.UserDataClasses.UserDataDictionaries.InterestsDict;
import Entities.UserGraph;

import java.util.ArrayList;
import java.util.Arrays;

public class DisplayUserModel {
    private User user;
    private String name = "";
    private String location = "";
    private String bio = "";
    private ArrayList<String> interests = new ArrayList<>();
    private ArrayList<String> attributes = new ArrayList<>();
    private ArrayList<String> courses = new ArrayList<String>();
    public DisplayUserModel(String userString){
        UserGraphReadWriter reader = new UserGraphReadWriter();
        try {
            UserGraph graph = reader.readFromFile("userGraph.ser");
            this.user = graph.getUserByString(userString);
        }
        catch (Exception e){
            this.user = new User("", "");
        }
        this.courses.add("");
        this.interests.add("");
        this.name = this.user.getUsername().getData();
        this.location = this.user.getLocation().getData();
        this.bio = this.user.getBio().getData();
        new AttributesDict();
        for(int i: AttributesDict.attributesMap.keySet()){
            String attribute = this.user.getAttributes().getTypeAt(i);
            if((boolean) this.user.getAttributes().getData().get(i).get(1)){
                String stringBuilder = attribute + ": " +
                        this.user.getAttributes().getValueAt(i, (Integer) this.user.getAttributes().getData().get(i).get(0));
                this.attributes.add(stringBuilder);
            }

        }
        for(int i: this.user.getInterests().getData().keySet()){
            new InterestsDict();
            this.interests.add(InterestsDict.interestMap.get(i));
        }
        String[] courseArray = this.user.getCourses().toString().replace(" ", "").split(",");
        this.courses.addAll(Arrays.asList(courseArray));
    }
    public Object[] getModel(){
        return new Object[]{this.name, this.location, this.bio, this.interests, this.attributes, this.courses};
    }
}
