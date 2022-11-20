package UseCases;
import Entities.User;
import Entities.UserDataClasses.UserData;
import Entities.UserGraph;

public class OtherAccountCases {
    public String[] getUserInfo(String userid) {
        UserGraphReadWriter reader = new UserGraphReadWriter();
        UserGraph graph = reader.readFromFile("dog.png");
        User userclass = graph.getUserByString(userid);
        String[] userInfo = {userclass.getDisplayName().getData(),
                userclass.getLocation().getData(),
                userclass.getBio().getData()};
        return userInfo;
    }
}
