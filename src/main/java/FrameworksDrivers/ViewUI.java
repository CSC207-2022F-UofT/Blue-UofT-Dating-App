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
        this.masterPanel.setPreferredSize(new Dimension(800, 600));;


        //initial panel
        UserEditView userEditView = new UserEditView(this.masterPanel, this.layout, new User(null, null));
        AccountView accountView = new AccountView(this.masterPanel, this.layout);

        TestAccount testAccount =  new TestAccount(this.masterPanel, this.layout);
        OtherAccount otherAccount =  new OtherAccount(this.masterPanel, this.layout);




        //Send the paths to other pages that your page will have
        //I.E login -> main
        Object[] testAccountPaths = {otherAccount};
        testAccount.sendPaths(testAccountPaths);
        Object[] otherAccountPaths = {testAccount};
        otherAccount.sendPaths(otherAccountPaths);
        Object[] userEditPaths = {accountView, testAccount};
        userEditView.sendPaths(userEditPaths);


        layout.show(this.masterPanel, "userEditView");
        this.frame.add(masterPanel);
        this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
        this.frame.setTitle("MainPage");
        this.frame.pack();
        this.frame.setVisible(true);

    }

    public static void main(String[] args) {
        ViewUI UI = new ViewUI();
    }


}
