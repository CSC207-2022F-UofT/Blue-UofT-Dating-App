package UseCases;
import Entities.User;
import Entities.UserDataClasses.HideableUserDataClasses.Attributes;
import Entities.UserDataClasses.HideableUserDataClasses.Interests;
import Entities.UserDataClasses.UserData;
import Entities.UserGraph;
import Entities.UserDataClasses.HideableUserDataClasses.Course;
import Entities.UserDataClasses.HideableUserDataClasses.Courses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class OtherAccountCases {
    public String[] getUserInfo(String userid) {
        try {
            String[] userInfo = new String[6];
            UserGraphReadWriter reader = new UserGraphReadWriter();
            UserGraph graph = reader.readFromFile("userGraph.ser");
            User userclass = graph.getUserByString(userid);

            String displayName = userclass.getDisplayName().getData();
            String location = userclass.getLocation().getData();
            String bio = userclass.getBio().getData();

            userInfo[0] = displayName;
            userInfo[1] = location;
            userInfo[2] = bio;

            String courseString = "";
            Courses courses = userclass.getCourses();
            if (!courses.hidden) {
                ArrayList<Course> courseList = courses.data;
                for (int i = 0; i < courseList.size(); i++) {
                    Course course = courseList.get(i);
                    if (!course.hidden) {
                        if (courseString.equals("")) {
                            courseString += ", " + course.data;
                        }
                        else {
                            courseString += course.data;
                        }
                    }
                }
            }

            String interstsString = "";
            Interests intersts = userclass.getInterests();
            if (!intersts.hidden) {
                HashMap<Integer, Boolean> map = intersts.data;
                for (int i = 0; i <= 50; i++) {
                    if (!map.get(i)) {
                        if (interstsString.equals("")) {
                            interstsString += ", " + intersts.getInterestAt(i);
                        }
                        else {
                            interstsString +=  intersts.getInterestAt(i);
                        }
                    }
                }
            }

            Attributes attributes = userclass.getAttributes();
            String attributesString = "";
            if (!attributes.hidden) {
                HashMap<Integer, ArrayList<Object>> map = attributes.data;
                for (int i = 0; i <= 13; i++) {
                    ArrayList<Object> atr = map.get(i);
                    if (!(boolean) atr.get(1)) {
                        if (attributesString.equals("")) {
                            attributesString += attributes.getTypeAt(i) + ": " + attributes.getValueAt(i, (int) atr.get(0));
                        }
                        else {
                            attributesString += ", " + attributes.getTypeAt(i) + ": " + attributes.getValueAt(i, (int) atr.get(0));
                        }
                    }
                }
            }
            userInfo[3] = courseString;
            userInfo[4] = interstsString;
            userInfo[5] = attributesString;

            return userInfo;
        }
        catch(IOException e) {
            return null;
        }
        catch(ClassNotFoundException e) {
            return null;
        }
    }

}
