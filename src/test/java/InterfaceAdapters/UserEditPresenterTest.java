package InterfaceAdapters;

import Entities.CurrentUser;
import UseCases.PracticeGraphCreator;
import Entities.User;
import Entities.UserDataClasses.CourseCode;
import Entities.UserDataClasses.HideableUserDataClasses.Course;
import Entities.UserDataClasses.HideableUserDataClasses.Interests;
import Entities.UserDataClasses.PrivateUserDataClasses.Username;
import Entities.UserDataClasses.UserDataDictionaries.AttributeValueDict;
import Entities.UserGraph;
import UseCases.dataretrieval.CurrentGraph;
import UseCases.dataretrieval.SaveGraph;
import UseCases.useredit.DeleteCurrentAccount;
import UseCases.useredit.UserEditInteractor;
import UseCases.useredit.UserEditModel;
import UseCases.useredit.UserEditResponseModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class UserEditPresenterTest {

    @Test
    void saveUserInfo() {
    }

    public User createUser(){
        User testUser = new User("Test", "1");
        ArrayList<Integer> interests = new ArrayList<>();
        interests.add(1);
        interests.add(3);
        Interests interests1 = new Interests();
        interests1.addInterests(interests);
        testUser.setInterests(interests1.getData());

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
        HashMap<Integer, ArrayList<Object>> attributes = new HashMap<>();
        ArrayList<Object> attribute1 = new ArrayList<>();
        attribute1.add(4);
        attribute1.add(true);
        attributes.put(1, attribute1);
    }
    @Test
    void saveUser(){
        UserGraph userGraph = PracticeGraphCreator.createGraph();
        String nameData = "test";
        String bioData = "i am a test";
        String coursesMetaData = "MAT123,CSC212";
        String[] coursesData = coursesMetaData.split(",");
        HashMap<Integer, Boolean> interestsDictData = new HashMap<>();
        for(int i = 0; i <= 49; i++){
            // every other interest is picked
            if(i % 2 == 0){
                interestsDictData.put(i, true);
            }
        }
        HashMap<Integer, Integer> attributeDictData = new HashMap<>();
        HashMap<Integer, Boolean> hiddenDictData = new HashMap<>();
        new AttributeValueDict();
        for(int i = 0; i <= 13; i++){
            int attributeIndex = 0;
            for(int j: AttributeValueDict.valuesMap.get(i).keySet()){
                attributeIndex = 5;
            }
            hiddenDictData.put(i, true);
            attributeDictData.put(i, attributeIndex);
        }
        ArrayList<ArrayList<Integer>> breakersDictData = new ArrayList<>();
        for(int i = 0; i <= 13; i++){
            breakersDictData.add(i, new ArrayList<>());
            for(int j: AttributeValueDict.valuesMap.get(i).keySet()){
                breakersDictData.get(i).add(j);
            }
        }
        // Send that data down to presenter so save it.
        UserEditPresenter userEditPresenter = new UserEditPresenter();
        UserEditModel data = new UserEditModel(nameData, bioData, coursesData, interestsDictData,
                attributeDictData, breakersDictData, hiddenDictData);
        User user = this.createUser();
        userGraph.addUser(user);
        new UserEditInteractor(data, userGraph, user);
        assertEquals( "test", userGraph.getUserByString("Test").getDisplayName().getData());
        assertEquals(5, userGraph.getUserByString("Test").getAttributes().getData().get(0).get(0));
        assertTrue(userGraph.getUserByString("Test").getInterests().getData().containsKey(2));
        assertFalse(userGraph.getUserByString("Test").getInterests().getData().containsKey(5));
    }
    @Test
    void deleteUser(){
        UserGraph currentGraph = CurrentGraph.getGraph();
        UserGraph userGraph = PracticeGraphCreator.createGraph();
        new SaveGraph(userGraph);
        CurrentUser currentUser = new CurrentUser();
        currentUser.setUser(new Username("Ewan"));
        new DeleteCurrentAccount();
        assertEquals(1, CurrentGraph.getGraph().getUsers().size());
        new SaveGraph(currentGraph);
    }
}