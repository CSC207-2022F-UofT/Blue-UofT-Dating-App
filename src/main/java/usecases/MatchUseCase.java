package usecases;

import Entities.User;
import usecases.ChatUseCases.ChatRegUseCase;
import usecases.ChatUseCases.ChatRepoUseCase;
import usecases.DataRetrieval.SaveChats;

import javax.swing.*;


public class MatchUseCase {
    public MatchUseCase(User currentUser, User likedUser){
        ChatRegUseCase chatRegUseCase = new ChatRegUseCase();
        chatRegUseCase.createChatroom(currentUser, likedUser);
        new SaveChats(new ChatRepoUseCase());
        JOptionPane.showMessageDialog(null, "Its a match!");
    }
}
