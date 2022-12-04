package FrameworksDrivers;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Entities.User;
import FrameworksDrivers.UIElements.Button;
import FrameworksDrivers.UIElements.textArea;
import FrameworksDrivers.UIElements.textField;
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
    private textArea bioTextField;
    User displayUser;
    Button homeButton;
    Button chatButton;
    Button myProfileButton;
    Button likeButton;
    Button dislikeButton;
    Button viewOtherAccount;
    Button logOut;
    textField nameTextField;

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

        // Add viewOtherAccount button to the top panel
        topPanel.add(viewOtherAccount.getButton());
        logOut = new Button();
        logOut.createButton(lowerPanel, "Log Out", 500,0,200,100);
        logOut.getButton().addActionListener(this);

        // Create Name Text Panel
        JPanel namePanel = new JPanel();

        // Create Text Field
        nameTextField = new textField();
        nameTextField.createTextField(namePanel,150,200,300,200);
        nameTextField.setText(" ");

        // Create Bio Text Field
        bioTextField = new textArea();
        bioTextField.createTextArea(namePanel, "",150, 200, 400, 500);
        bioTextField.getTextArea().setEnabled(false);
        bioTextField.getTextArea().setWrapStyleWord(true);

        // Add Text Fields to the namePanel
        namePanel.add(nameTextField.getTextField());
        namePanel.add(bioTextField.getTextArea());

        // Adding all panels to the masterPanel
        panel.add(lowerPanel);
        panel.add(middlePanel);
        panel.add(topPanel);
        panel.add(namePanel);
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
            this.nameTextField.setText(displayUser.getDisplayName().getData());
            this.bioTextField.setText(displayUser.getBio().getData());
            this.bioTextField.getTextArea().setForeground(Color.BLACK);
        }
    }

}
