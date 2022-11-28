package FrameworksDrivers;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import FrameworksDrivers.UIElements.Button;
import FrameworksDrivers.UIElements.Icon;
import InterfaceAdapters.MainPagePresenter;
import InterfaceAdapters.OtherAccountPresenter;

public class MainPageView implements ActionListener, View {
    private JPanel masterPanel;
    private Object[] paths;
    private CardLayout layout;

    Button homeButton;
    Button chatButton;
    Button myProfileButton;
    Button likeButton;
    Button dislikeButton;
    Button viewOtherAccount;



    public MainPageView(JPanel masterPanel, CardLayout layout, String iconFilePath){
        this.masterPanel = masterPanel;
        this.layout = layout;
        // Create Lower Panel
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout(1, 3));

        // Create HomeButton
        homeButton = new Button();
        homeButton.createButton(lowerPanel, "Home", 130,195,100,30);
        homeButton.getButton().addActionListener(this);

        // Create ChatButton
        chatButton = new Button();
        chatButton.createButton(lowerPanel, "Chats", 130,195,100,30);
        chatButton.getButton().addActionListener(this);

        // Create MyProfileButton
        myProfileButton = new Button();
        myProfileButton.createButton(lowerPanel, "My Profile", 130,195,100,30);
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
        likeButton.createButton(lowerPanel, "Like", 130,195,100,30);
        likeButton.getButton().addActionListener(this);

        // Create like button
        dislikeButton = new Button();
        dislikeButton.createButton(lowerPanel, "Dislike", 130,195,100,30);
        dislikeButton.getButton().addActionListener(this);

        // Add these buttons to the middle panel
        middlePanel.add(likeButton.getButton());
        middlePanel.add(dislikeButton.getButton());

        // Create Top Panel
        JPanel topPanel = new JPanel();

        // Create viewOtherAccount Button
        viewOtherAccount = new Button();
        viewOtherAccount.createButton(lowerPanel, "View Profile", 130,195,100,30);
        viewOtherAccount.getButton().addActionListener(this);

        // Add this button to the top panel
        topPanel.add(viewOtherAccount.getButton());

        // Create Icon Panel
        JPanel iconPanel = new JPanel();

        // Create Icon
        Icon image = new Icon();
        image.createIcon(iconFilePath);

        // Add icon to panel
        iconPanel.add(image.getIcon());

        // Adding all panels to the masterPanel
        this.masterPanel.add(lowerPanel);
        this.masterPanel.add(middlePanel);
        this.masterPanel.add(topPanel);
        this.masterPanel.add(iconPanel);

//        //Frame compiling
//        mainFrame.add(masterPanel, BorderLayout.CENTER);
//        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        mainFrame.setTitle("MainPage");
//        mainFrame.pack();
//        mainFrame.setVisible(true);
    }

    public void sendPaths(Object[] paths) {
        this.paths = paths;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //create presenter
        MainPagePresenter mainPagePresenter = new MainPagePresenter();

        layout = new CardLayout();

        // All button cases
        if (homeButton.getButton().isSelected()){
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
            OtherAccountPresenter otherAccountPresenter = new OtherAccountPresenter();

            otherAccountPresenter.updatePage();
        }
    }
    public void updateMainPageView(Object[] info) {
        this.dummyInfo += info;
        System.out.print(this.dummyInfo);
        if (this.panel.getComponents().length < 2){
            JLabel label = new JLabel(this.dummyInfo);
            this.panel.add(label);
        }
        else{
            JLabel label = (JLabel) this.panel.getComponents()[1];
            label.setText(this.dummyInfo);
        }

        //updates panel VVVVV
        this.panel.revalidate();
    }

    @Override
    public void updatePage(String view, Object page) {

    }
}
