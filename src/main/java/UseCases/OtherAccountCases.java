package UseCases;
import Entities.User;
import Entities.UserGraph;

public class OtherAccountCases {
    public String[] getUserInfo(String userid) {
        // Questions:
        // How do I access userGraph?
        // Do I create a new one each time and add all the data in?
        // is it created on program start and stored somewhere I can access?

        //currently making new userGraph just for psuedo code purposes
        UserGraphReadWriter reader = new UserGraphReadWriter();
        UserGraph graph = reader.readFromFile("dog.png");
        User userclass = graph.getUser(userid);
        String[] userInfo = {userclass.getDisplayName().getData(),
                userclass.getLocation().getData(),
                userclass.getBio().getData()};

        return userInfo;
    }
}
