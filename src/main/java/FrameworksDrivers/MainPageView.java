package FrameworksDrivers;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Entities.User;
import FrameworksDrivers.UIElements.Button;
import FrameworksDrivers.UIElements.textField;
import InterfaceAdapters.MainPagePresenter;
import InterfaceAdapters.OtherAccountPresenter;

public class MainPageView implements ActionListener, View {
    private JPanel masterPanel;
    private Object[] paths;
    User displayUser;
    private CardLayout layout;

    Button homeButton;
    Button chatButton;
    Button myProfileButton;
    Button likeButton;
    Button dislikeButton;
    Button viewOtherAccount;
    textField nameTextField;

    public MainPageView(JPanel masterPanel, CardLayout layout){
        this.masterPanel = masterPanel;
        this.layout = layout;
        // Create Lower Panel
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout(1, 3));

        // Create HomeButton
        homeButton = new Button();
        homeButton.createButton(lowerPanel, "Home", 0,600,200,200);
        homeButton.getButton().addActionListener(this);

        // Create ChatButton
        chatButton = new Button();
        chatButton.createButton(lowerPanel, "Chats", 200,600,200,200);
        chatButton.getButton().addActionListener(this);

        // Create MyProfileButton
        myProfileButton = new Button();
        myProfileButton.createButton(lowerPanel, "My Profile", 400,600,200,200);
        myProfileButton.getButton().addActionListener(this);

        // Add these buttons to the lower panel
        lowerPanel.add(homeButton.getButton());
        lowerPanel.add(chatButton.getButton());
        lowerPanel.add(myProfileButton.getButton());

        // Create Middle Panel
        JPanel middlePanel = new JPanel();
        lowerPanel.setLayout(new GridLayout(1, 2));

        // Create like button
        likeButton = new Button();
        likeButton.createButton(lowerPanel, "Like", 0,500,300,100);
        likeButton.getButton().addActionListener(this);

        // Create like button
        dislikeButton = new Button();
        dislikeButton.createButton(lowerPanel, "Dislike", 300,500,300,100);
        dislikeButton.getButton().addActionListener(this);

        // Add these buttons to the middle panel
        middlePanel.add(likeButton.getButton());
        middlePanel.add(dislikeButton.getButton());

        // Create Top Panel
        JPanel topPanel = new JPanel();

        // Create viewOtherAccount Button
        viewOtherAccount = new Button();
        viewOtherAccount.createButton(lowerPanel, "View Profile", 400,0,200,100);
        viewOtherAccount.getButton().addActionListener(this);

        // Add this button to the top panel
        topPanel.add(viewOtherAccount.getButton());

        // Create Name Text Panel
        JPanel namePanel = new JPanel();

        // Create Text Field
        nameTextField = new textField();
        nameTextField.createTextField(namePanel,150,200,300,200);
        nameTextField.setText(" ");

        // Add Text Field to the Panel
        namePanel.add(nameTextField.getTextField());


        // Adding all panels to the masterPanel
        this.masterPanel.add(lowerPanel);
        this.masterPanel.add(middlePanel);
        this.masterPanel.add(topPanel);
        this.masterPanel.add(namePanel);
    }

    public void sendPaths(Object[] paths) {
        this.paths = paths;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //create presenter
        layout = new CardLayout();

        // All button cases
        if (homeButton.getButton().isSelected()){
            MainPagePresenter mainPagePresenter = new MainPagePresenter();

            this.layout.show(this.masterPanel, "Main Page");
        }
        if (chatButton.getButton().isSelected()){
            this.layout.show(this.masterPanel, "Chat Page");
        }
        if (myProfileButton.getButton().isSelected()){
            this.layout.show(this.masterPanel, "My Profile Page");
        }
        if (likeButton.getButton().isSelected()){

        }
        if (dislikeButton.getButton().isSelected()){

        }
        if (viewOtherAccount.getButton().isSelected()){
            //OtherAccountPresenter otherAccountPresenter = new OtherAccountPresenter(String user);
            //otherAccountPresenter.updatePage("loadAccount", paths[0]);
            this.layout.show(this.masterPanel, "otherAccount");
        }
    }
    public void updatePage(Object[] info) {
        //Just switch the user
        this.displayUser = (User) info[0];
        this.nameTextField.setText(displayUser.getDisplayName().toString());
    }

}
