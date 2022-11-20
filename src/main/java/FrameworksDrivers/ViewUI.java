package FrameworksDrivers;

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

        OtherAccount otherAccount =  new OtherAccount(this.masterPanel, this.layout);
        UserEditView userEditView = new UserEditView(this.masterPanel, this.layout);

        //Send the paths to other pages that your page will have
        //I.E login -> main
        Object[] otherAccountPaths = {};
        otherAccount.sendPaths(otherAccountPaths);
        //Object[] userEditPaths = {accountView};
        //userEditView.sendPaths(userEditPaths);


        layout.show(this.masterPanel, "otherAccount");

        this.frame.add(masterPanel);
        this.frame.setDefaultCloseOperation(this.frame.EXIT_ON_CLOSE);
        this.frame.setTitle("MainPage");
        this.frame.setResizable(false);
        this.frame.pack();
        this.frame.setVisible(true);


    }

    public static void main(String[] args) {
        ViewUI UI = new ViewUI();
    }


}
