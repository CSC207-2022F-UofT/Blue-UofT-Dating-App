package FrameworksDrivers;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Entities.User;
import FrameworksDrivers.UIElements.Button;
import FrameworksDrivers.UIElements.Label;
import InterfaceAdapters.MainPagePresenter;

/**
 *  MainPageView is a UI class which implements <i>ActionListener</i> and <i>View</i> to create the main page
 *  for the whole program. This contains the creation of all components such as buttons, textfields etc. that are to be
 *  displayed on the main page and are responsible for the actions different actions to be performed.
 *
 * @author aryaman
 */
public class MainPageView implements ActionListener, View {
    private JPanel masterPanel;
    private Object[] paths;
    private CardLayout layout;
    User displayUser;
    Button homeButton;
    Button chatButton;
    Button myProfileButton;
    Button likeButton;
    Button dislikeButton;
    Button viewOtherAccount;
    Button logOut;
    Label logo;
    Label tagLine;
    Label displayedName;
    Label bio;

    /**
     *
     * Create the main page
     * @param masterPanel the masterPanel that contains the page
     * @param layout layout of the masterPanel
     */
    public MainPageView(JPanel masterPanel, CardLayout layout){
        this.masterPanel = masterPanel;
        this.layout = layout;
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Create HomeButton
        homeButton = new Button();
        homeButton.createButton(panel, "Home", 0,600,200,200);
        homeButton.getButton().addActionListener(this);

        // Create ChatButton
        chatButton = new Button();
        chatButton.createButton(panel, "Chats", 200,600,200,200);
        chatButton.getButton().addActionListener(this);

        // Create MyProfileButton
        myProfileButton = new Button();
        myProfileButton.createButton(panel, "My Profile", 400,600,200,200);
        myProfileButton.getButton().addActionListener(this);

        // Create like button
        likeButton = new Button();
        likeButton.createButton(panel, "Like", 0,500,300,100);
        likeButton.getButton().addActionListener(this);

        // Create like button
        dislikeButton = new Button();
        dislikeButton.createButton(panel, "Dislike", 300,500,300,100);
        dislikeButton.getButton().addActionListener(this);

        // Create viewOtherAccount Button
        viewOtherAccount = new Button();
        viewOtherAccount.createButton(panel, "View Profile", 400,0,200,100);
        viewOtherAccount.getButton().addActionListener(this);

        // Create logOut Button
        logOut = new Button();
        logOut.createButton(panel, "Log Out", 0,0,200,100);
        logOut.getButton().addActionListener(this);

        // Create Logo Label
        logo = new Label();
        logo.createLabelCentered(250,0,100,100, panel, "Blue", Color.blue);
        logo.setFontSize(40);

        // Create TagLine Label
        tagLine = new Label();
        tagLine.createLabel(225,30,300,100,panel,"Grindin' through the pain");

        // Create DisplayedName Label
        displayedName = new Label();
        displayedName.createLabel(100,200,400,200,panel," ");
        displayedName.setFontSize(35);
        displayedName.setHorizontalAlignment("center");
        displayedName.setVerticalAlignment("center");

        // Create Bio Label
        bio = new Label();
        bio.createLabel(100,250,400,200,panel," ");
        bio.setFontSize(15);
        bio.setHorizontalAlignment("center");
        bio.setVerticalAlignment("center");

        // Adding panel to masterpanel
        this.masterPanel.add(panel, "mainpageView");
    }


    /**
     * sendPaths method is used to establish the connection to other connecting pages
     * @param paths contains the paths to other pages
     */
    public void sendPaths(Object[] paths) {
        this.paths = paths;
    }

    /**
     * actionPerformed handles the action performed by the user on the main page. actionPerformed detects the buttons
     * being clicked and calls the subsequent relevant presenters to determine how to react and where to send the user
     * or when to update the page on different times.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //create presenter
        MainPagePresenter mainPagePresenter = new MainPagePresenter();


        // All button cases
        if (e.getSource() == homeButton.getButton()){
            mainPagePresenter.updatePage(this.displayUser, "mainpageView",this.paths[3]);
            this.layout.show(this.masterPanel, "mainpageView");
        }
        if (e.getSource() == chatButton.getButton()){
            mainPagePresenter.updatePage(this.displayUser, "chatView", this.paths[1]);
            this.layout.show(this.masterPanel, "chatView");
        }
        if (e.getSource() == myProfileButton.getButton()){
            mainPagePresenter.updatePage(this.displayUser, "usereditView", this.paths[2]);
            this.layout.show(this.masterPanel, "userEditView");
        }
        if (e.getSource() == likeButton.getButton()){
            mainPagePresenter.Like(this.displayUser);
            mainPagePresenter.updatePage(this.displayUser, "mainpageView", this.paths[3]);
        }
        if (e.getSource() == dislikeButton.getButton()){
            mainPagePresenter.updatePage(this.displayUser, "mainpageView", this.paths[3]);
        }
        if (e.getSource() == viewOtherAccount.getButton()){
            mainPagePresenter.updatePage(this.displayUser, "otherAccount", this.paths[0]);
            this.layout.show(this.masterPanel, "otherAccount");
        }
        if(e.getSource() == logOut.getButton()){
            mainPagePresenter.logOut(this.paths[1]);
            this.layout.show(this.masterPanel, "loginView");
        }
    }
    /**
     * The updatePage method is responsible for refreshing and updating the screen with the new user displayed whenever
     * prompted to do so.
     * @param info info contains a User which is essentially the next user to be presented on the main page
     */
    public void updatePage(Object[] info) {
        //Just switch the user
        if(info == null){
            MainPagePresenter mainPagePresenter = new MainPagePresenter();
            mainPagePresenter.updatePage(null, "mainpageView", this);
        }
        else {
            this.displayUser = (User) info[0];
            this.displayedName.setText(displayUser.getDisplayName().getData());
            this.bio.setText(displayUser.getBio().getData());
        }
    }

}
