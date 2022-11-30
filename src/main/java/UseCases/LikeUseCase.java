package UseCases;
import Entities.User;
import Entities.UserEdge;

public class LikeUseCase {
    public void updateEdge(User currentUser, User likedUser){
        UserEdge userEdge = new UserEdge(currentUser, likedUser);
        userEdge.likes(likedUser);
    }
}
