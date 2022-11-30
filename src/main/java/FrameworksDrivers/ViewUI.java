package FrameworksDrivers;

import Entities.Chatroom;
import Entities.Message;
import Entities.User;
import InterfaceAdapters.ChatViewPresenter;
import UseCases.ChatUseCases.ChatRenderUseCase;
import UseCases.ChatUseCases.ChatRepoUseCase;

import javax.swing.*;
import java.awt.*;

public class ViewUI {

    //creates initial frame
    private JFrame frame = new JFrame();
    //master panel
    private JPanel masterPanel = new JPanel();
    private CardLayout layout = new CardLayout();
    private View currView;
    public ViewUI() {
        //master panel
        this.masterPanel.setLayout(layout);
        this.masterPanel.setPreferredSize(new Dimension(600, 800));;

        //initial panel
        UserEditView userEditView = new UserEditView(this.masterPanel, this.layout, new User(null, null));
        AccountView accountView = new AccountView(this.masterPanel, this.layout);
        OtherAccount otherAccount =  new OtherAccount(this.masterPanel, this.layout);
        LogInView logInView = new LogInView(this.masterPanel, this.layout);
        ChatView chatView = new ChatView(this.masterPanel, this.layout);

        MainPageView mainPageView = new MainPageView(this.masterPanel, this.layout);
        SignUpView signUpView = new SignUpView(this.masterPanel, this.layout);

        currView = chatView;


        // Main Page

        Object[] mainPagePaths = {otherAccount};
        mainPageView.sendPaths(mainPagePaths);
        Object[] mainPagePaths = {};

        //Send the paths to other pages that your page will have
        //I.E login -> main
        Object[] otherAccountPaths = {};
        otherAccount.sendPaths(otherAccountPaths);
        Object[] userEditPaths = {accountView};
        userEditView.sendPaths(userEditPaths);
        Object[] LogInPath = {accountView,signUpView};
        logInView.sendPaths(LogInPath);
//        Object[] chatViewPaths = {MainPageView};

        JScrollPane scroller = new JScrollPane( this.masterPanel);
        this.layout.show(this.masterPanel, "chatView");
        this.frame.add(scroller);
        this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
        this.frame.setTitle("MainPage");
        this.frame.pack();
        this.frame.setVisible(true);
        this.frame.setResizable(true);


    }

    public static void main(String[] args) {
        User u1 = new User("clark", "12345");
        User u2 = new User("kevin", "54321");
        Chatroom test = new Chatroom(u1, u2);
        test.addMessage(new Message(u1, "hello kevin"));
        test.addMessage(new Message(u2, "hello clark"));

        u1 = new User("bob", "12345");
        u2 = new User("joe", "54321");
        Chatroom test2 = new Chatroom(u1, u2);
        test2.addMessage(new Message(u1, "hello joe"));
        test2.addMessage(new Message(u2, "hello bob"));

        ViewUI UI = new ViewUI();
        ChatRepoUseCase repo = new ChatRepoUseCase();
        repo.addChatroom(test);
        repo.addChatroom(test2);

        ChatViewPresenter presenter = new ChatViewPresenter(UI.currView);
        presenter.render();
    }
}
