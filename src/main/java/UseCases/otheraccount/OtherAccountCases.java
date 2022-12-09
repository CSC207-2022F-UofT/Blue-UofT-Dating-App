package UseCases.otheraccount;

import UseCases.dataretrieval.UserGraphReadWriter;
import Entities.User;
import Entities.UserDataClasses.HideableUserDataClasses.Attributes;
import Entities.UserDataClasses.HideableUserDataClasses.Course;
import Entities.UserDataClasses.HideableUserDataClasses.Courses;
import Entities.UserDataClasses.HideableUserDataClasses.Interests;
import Entities.UserGraph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class OtherAccountCases {
    public Object[] getUserInfo(String userid) {
        try {
            Object[] userInfo = new Object[6];
            UserGraphReadWriter reader = new UserGraphReadWriter();
            UserGraph graph = reader.readFromFile("userGraph.ser");
            User userclass = graph.getUserByString(userid);

            String displayName = userclass.getDisplayName().getData();
            String location = userclass.getLocation().getData();
            String bio = userclass.getBio().getData();

            userInfo[0] = displayName;
            userInfo[1] = location;
            userInfo[2] = bio;

            ArrayList<String> courseString = new ArrayList<>();
            Courses courses = userclass.getCourses();
            if (!courses.hidden) {
                ArrayList<Course> courseList = courses.data;
                for (Course course : courseList) {
                    if (!course.hidden) {
                        courseString.add(course.data.code);
                    }
                }
            }
            ArrayList<String> interstsList = new ArrayList<>();
            Interests intersts = userclass.getInterests();
            if (!intersts.hidden) {
                HashMap<Integer, Boolean> map = intersts.data;
                for (int i = 0; i <= 50; i++) {
                    if (!map.get(i)) {
                        interstsList.add(intersts.getInterestAt(i));
                    }
                }
            }

            Attributes attributes = userclass.getAttributes();
            ArrayList<String> attributesList= new ArrayList<>();
            if (!attributes.hidden) {
                HashMap<Integer, ArrayList<Object>> map = attributes.data;
                for (int i = 0; i <= 13; i++) {
                    ArrayList<Object> atr = map.get(i);
                    if (!(boolean) atr.get(1)) {
                        attributesList.add(attributes.getTypeAt(i) + ": " + attributes.getValueAt(i, (int) atr.get(0)));
                    }
                }
            }

            userInfo[3] = interstsList;
            userInfo[4] = attributesList;
            userInfo[5] = courseString;

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
