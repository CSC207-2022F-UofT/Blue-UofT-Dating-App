package FrameworksDrivers;
import org.junit.jupiter.api.Test;
import Entities.User;
import Entities.UserDataClasses.CourseCode;
import Entities.UserDataClasses.HideableUserDataClasses.Course;
import Entities.UserDataClasses.HideableUserDataClasses.Interests;
import UseCases.UserEditResponseModel;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class UserEditViewTest {
    public User createUser(){
        User testUser = new User("Test", "1");
        ArrayList<Integer> interests = new ArrayList<>();
        interests.add(1);
        interests.add(3);
        Interests interests1 = new Interests();
        interests1.addInterests(interests);
        testUser.setInterests(interests1);

        ArrayList<ArrayList<Integer>> attributes = new ArrayList<>();
        ArrayList<Integer> attribute1 = new ArrayList<>();
        attribute1.add(1);
        attribute1.add(4);
        attributes.add(attribute1);
        testUser.addAttributes(attributes);

        testUser.setDisplayName("testUser");
        testUser.setBio("I am a testUser");

        ArrayList<Course> courses = new ArrayList<>();
        Course course1 = new Course(new CourseCode("MAT123"));
        courses.add(course1);
        testUser.setCourses(courses);
        return testUser;
    }
    @Test
    void testUserEditResponseModel_CurrentUserGateway(){
        UserEditResponseModel userEditResponseModelActual = new UserEditResponseModel(createUser());
        assertEquals(userEditResponseModelActual.name, "testUser");
        assertEquals(userEditResponseModelActual.bio, "I am a testUser");
        assertEquals(userEditResponseModelActual.courses, "MAT123, ");
        HashMap<Integer, Boolean> interestHashMap = new HashMap<>();
        interestHashMap.put(1, true);
        interestHashMap.put(3, true);
        assertEquals(userEditResponseModelActual.interestsDict, interestHashMap);

    }

}
