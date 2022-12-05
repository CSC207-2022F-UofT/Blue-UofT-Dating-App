package FrameworksDrivers;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Entities.User;
import FrameworksDrivers.UIElements.Button;
import FrameworksDrivers.UIElements.Label;
import FrameworksDrivers.UIElements.textField;
import InterfaceAdapters.MainPagePresenter;
import InterfaceAdapters.UserLogPresenter;

/**
 *  A UI class implements <i>ActionListener</i> and <i>View</i> to create the login page
 *  for the program. This contains the creation of all components using and is responsible
 *  to any valid action on the page.
 */
public class LogInView implements ActionListener, View {
    Button logInB, signUpB;

    JPanel masterPanel, newPanel;
    Label userLabel, passLabel;
    textField textFieldUser, textFieldPass;

    CardLayout layout;

    private Object[] paths;

    /**
     *
     * Create the new login page
     * @param masterPanel the masterPanel that contains the page
     * @param layout layout of the masterPanel
     */
    public LogInView(JPanel masterPanel, CardLayout layout){
        //create page to display created element
        this.masterPanel = masterPanel;
        this.layout = layout;

        this.newPanel = new JPanel();
        GridLayout newLayout = new GridLayout(3, 2);
        this.newPanel.setLayout(newLayout);


        //create components for username input
        //create label for username input
        userLabel = new Label();
        userLabel.createLabel(40 , 40, 40, 40, newPanel, "Username");

        //create text field for inputting username
        textFieldUser = new textField();
        textFieldUser.createTextField(newPanel, 40, 40, 40, 40);


        //create components for password input
        //create label for password input
        passLabel = new Label();
        passLabel.createLabel(40 , 40, 40, 40, newPanel, "Password");

        //create text field for inputting password
        textFieldPass = new textField();
        textFieldPass.createTextField(newPanel, 40, 40, 40, 40);

        //create buttons for actions

        logInB = new Button();
        logInB.createButton(newPanel, "Log In", 40, 40, 40, 40);
        logInB.getButton().addActionListener(this);
        signUpB = new Button();
        signUpB.createButton(newPanel, "Sign Up", 40, 40, 40, 40);
        signUpB.getButton().addActionListener(this);
        newPanel.setBackground(Color.lightGray);
        this.masterPanel.add(newPanel, "loginView");
    }

    /**
     * Used to establish the connection to other connecting pages
     * @param paths contains the paths to other pages
     */
    public void sendPaths(Object[] paths){
        // obtain path to other pages
        this.paths = paths;
    }


    /**
     * responsible for refreshing the screen, prompt given message, or switch the
     * screen
     * @param info if info contains some strings, dialog box with string message
     */
    @Override
    public void updatePage(Object[] info) {

        if (info[0].equals("userDoesNotExist") || info[0].equals("passwordIncorrect")) {
            JOptionPane.showMessageDialog(null, info[0]);
            this.textFieldPass.setText("");
            this.newPanel.revalidate();
            this.newPanel.repaint();
        }
        else if (info[0] instanceof User) {
            // change to main page
            // update current user to user
            // set log in to true
            MainPagePresenter mainPagePresenter = new MainPagePresenter();
            mainPagePresenter.updatePage((User)info[0], "mainpageView", this.paths[1]);
            this.layout.show(this.masterPanel, "mainpageView");

        }
        else if(info[0].equals("Reload")){
            this.textFieldPass.setText("");
            this.newPanel.revalidate();
            this.newPanel.repaint();
        }
    }

    /**
     * handles the action performed by the user on login page
     * detect the button being clicked and call the presenter to determine
     * what to react
     *
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        // define action performed when button clicked
        // create presenter


        if (evt.getSource() == this.logInB.getButton()) {
            // check info entered
            // pass to LogInUseCase
            String name = textFieldUser.getTextField().getText();
            String pass = textFieldPass.getTextField().getText();
            UserLogPresenter logPresenter = new UserLogPresenter();
            logPresenter.switchPage(name, pass, "logInView", this);

            // pop dialog user doesn't exist
        }
        else if (evt.getSource() == this.signUpB.getButton()){
            // case evt.getSource() == signUpB
            // update page to SignUpView
            UserLogPresenter logPresenter = new UserLogPresenter();
            logPresenter.switchPage(null,null, "signUpView", this.paths[0]);
            //logPresenter.updatePage("signUpView", this.paths[1], "", "");
            this.layout.show(this.masterPanel, "signUpView");
        }

    }
}
