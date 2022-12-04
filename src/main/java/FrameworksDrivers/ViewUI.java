package FrameworksDrivers;

import Entities.*;
import Entities.UserDataClasses.PrivateUserDataClasses.Username;
import InterfaceAdapters.ChatGateway;
import InterfaceAdapters.MainPagePresenter;
import UseCases.DataRetrieval.*;
import InterfaceAdapters.ChatViewPresenter;
import UseCases.ChatUseCases.ChatRenderUseCase;
import UseCases.ChatUseCases.ChatRepoUseCase;
import UseCases.LikeUseCase;
import UseCases.PracticeGraphCreator;

import javax.swing.*;
import java.awt.*;

public class ViewUI {

    public ViewUI() {
        //master panel
        CardLayout layout = new CardLayout();//master panel
        JPanel masterPanel = new JPanel();
        masterPanel.setLayout(layout);
        masterPanel.setPreferredSize(new Dimension(600, 800));;
        //initial panel
        UserEditView userEditView = new UserEditView(masterPanel, layout);
        OtherAccount otherAccount =  new OtherAccount(masterPanel, layout);
        LogInView logInView = new LogInView(masterPanel, layout);
        ChatView chatView = new ChatView(masterPanel, layout);
        MainPageView mainPageView = new MainPageView(masterPanel, layout);
        SignUpView signUpView = new SignUpView(masterPanel, layout);


        // Main Page



//        Send the paths to other pages that your page will have
//        I.E login -> main
        Object[] mainPagePaths = {otherAccount, chatView, userEditView, mainPageView, logInView};
        mainPageView.sendPaths(mainPagePaths);
        Object[] otherAccountPaths = {mainPageView};
        otherAccount.sendPaths(otherAccountPaths);
        Object[] userEditPaths = {mainPageView, chatView};
        userEditView.sendPaths(userEditPaths);
        Object[] logInPath = {signUpView, mainPageView};
        logInView.sendPaths(logInPath);
        Object[] chatViewPaths = {mainPageView};
        chatView.sendPaths(chatViewPaths);
        Object[] signUpPaths = {userEditView, logInView};
        signUpView.sendPaths(signUpPaths);


        JScrollPane scroller = new JScrollPane(masterPanel);
        layout.show(masterPanel, "loginView");
        //creates initial frame
        JFrame frame = new JFrame();
        frame.add(scroller);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setTitle("MainPage");
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(true);
    }


    public static void main(String[] args) {
        ViewUI UI = new ViewUI();
        new GetChats();
    }
}
