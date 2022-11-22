package FrameworksDrivers;

import Entities.User;

import javax.swing.*;
import java.awt.*;

public class ViewUI {

    //creates initial frame
    private JFrame frame = new JFrame();
    //master panel
    private JPanel masterPanel = new JPanel();
    private CardLayout layout = new CardLayout();
    public ViewUI() {
        //master panel
        this.masterPanel.setLayout(layout);
        this.masterPanel.setPreferredSize(new Dimension(600, 800));;

        //initial panel
        UserEditView userEditView = new UserEditView(this.masterPanel, this.layout, new User(null, null));
        AccountView accountView = new AccountView(this.masterPanel, this.layout);
        OtherAccount otherAccount =  new OtherAccount(this.masterPanel, this.layout);
        LogInView logInView = new LogInView(this.masterPanel);
        ChatView chatView = new ChatView(this.masterPanel, this.layout);
        SignUpView signUpView = new SignUpView(this.masterPanel);



        // Main Page
        Object[] mainPagePaths = {};
        //Send the paths to other pages that your page will have
        //I.E login -> main
        Object[] otherAccountPaths = {};
        otherAccount.sendPaths(otherAccountPaths);
        Object[] userEditPaths = {accountView};
        userEditView.sendPaths(userEditPaths);
        Object[] LogInPath = {accountView,signUpView};
        logInView.sendPaths(LogInPath);
        JScrollPane scroller = new JScrollPane( this.masterPanel );
        this.frame.add(scroller);
        this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
        this.frame.setTitle("MainPage");
        this.frame.pack();
        this.frame.setVisible(true);
        this.frame.setResizable(true);


    }

    public static void main(String[] args) {
        ViewUI UI = new ViewUI();
    }


}
