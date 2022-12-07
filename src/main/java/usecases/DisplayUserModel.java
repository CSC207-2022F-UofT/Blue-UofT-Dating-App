package usecases;

import Entities.User;
import Entities.UserDataClasses.UserDataDictionaries.AttributesDict;
import Entities.UserDataClasses.UserDataDictionaries.InterestsDict;
import Entities.UserGraph;

import java.util.ArrayList;
import java.util.Arrays;

public class DisplayUserModel {
    private String name = "";
    private String location = "";
    private String bio = "";
    private final ArrayList<String> interests = new ArrayList<>();
    private final ArrayList<String> attributes = new ArrayList<>();
    private final ArrayList<String> courses = new ArrayList<String>();
    public DisplayUserModel(String userString){
        UserGraphReadWriter reader = new UserGraphReadWriter();
        User user;
        try {
            UserGraph graph = reader.readFromFile("userGraph.ser");
            user = graph.getUserByString(userString);
        }
        catch (Exception e){
            user = new User("", "");
        }
        this.name = user.getUsername().getData();
        this.location = user.getLocation().getData();
        this.bio = user.getBio().getData();
        new AttributesDict();
        for(int i: AttributesDict.attributesMap.keySet()){
            String attribute = user.getAttributes().getTypeAt(i);
            if((boolean) user.getAttributes().getData().get(i).get(1)){
                String stringBuilder = attribute + ": " +
                        user.getAttributes().getValueAt(i, (Integer) user.getAttributes().getData().get(i).get(0));
                this.attributes.add(stringBuilder);
            }

        }
        for(int i: user.getInterests().getData().keySet()){
            new InterestsDict();
            this.interests.add(InterestsDict.interestMap.get(i));
        }
        String[] courseArray = user.getCourses().toString().replace(" ", "").split(",");
        this.courses.addAll(Arrays.asList(courseArray));
    }
    public Object[] getModel(){
        return new Object[]{this.name, this.location, this.bio, this.interests, this.attributes, this.courses};
    }
}
