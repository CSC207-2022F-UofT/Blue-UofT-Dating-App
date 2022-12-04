package UseCases;

import Entities.Chatroom;
import Entities.User;
import UseCases.ChatUseCases.ChatRegUseCase;
import UseCases.ChatUseCases.ChatRepoUseCase;
import UseCases.DataRetrieval.SaveChats;

import javax.swing.*;


public class MatchUseCase {
    public MatchUseCase(User currentUser, User likedUser){
        ChatRegUseCase chatRegUseCase = new ChatRegUseCase();
        chatRegUseCase.createChatroom(currentUser, likedUser);
        new SaveChats(new ChatRepoUseCase());
        JOptionPane.showMessageDialog(null, "Its a match!");
    }
}
