package UseCases.mainpage;
import UseCases.chat.ChatRegUseCase;
import UseCases.chat.ChatRepoUseCase;
import UseCases.dataretrieval.SaveChats;
import Entities.User;

import javax.swing.*;

/**
 * MatchUseCase is a UseCase class responsible for creating a Chatroom for two users. MatchUseCase is also very closely
 * connected to the LikeUseCase.
 */
public class MatchUseCase {
    /**
     * Creates a new Chatroom for the currentUser and likedUser
     *
     * @param currentUser User that is logged in currently
     * @param likedUser User that is liked by the currentUser
     */
    public MatchUseCase(User currentUser, User likedUser){
        ChatRegUseCase chatRegUseCase = new ChatRegUseCase();
        chatRegUseCase.createChatroom(currentUser, likedUser);
        new SaveChats(new ChatRepoUseCase());
        JOptionPane.showMessageDialog(null, "Its a match!");
    }
}
