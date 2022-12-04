package FrameworksDrivers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Entities.User;
import FrameworksDrivers.UIElements.Button;
import FrameworksDrivers.UIElements.Label;
import FrameworksDrivers.UIElements.textField;
import InterfaceAdapters.UserRegPresenter;


public class SignUpView implements View, ActionListener {
    Button logb;
    Button regB;

    JPanel masterPanel, newPanel;
    Label userLabel, passLabel1, passLabel2;
    textField textFieldUser, textFieldPass1, textFieldPass2;

    CardLayout layout;

    private Object[] paths;

    /**
     * Create the new sing up page
     * @param masterPanel the masterPanel that contains the page
     * @param layout layout of the masterPanel
     */
    public SignUpView(JPanel masterPanel, CardLayout layout) {
        //create page to display created element
        this.masterPanel = masterPanel;
        this.layout = layout;

        this.newPanel = new JPanel();
        GridLayout newLayout = new GridLayout(4, 2);
        this.newPanel.setLayout(newLayout);
        //create components for username input
        //create label for username input
        userLabel = new Label();
        userLabel.createLabel(40 , 40, 40, 40, newPanel, "Username");

        //create text field for inputting username
        textFieldUser = new textField();
        textFieldUser.createTextField(newPanel, 40, 40, 40, 40);


        //create components for the first password input
        //create label for password input
        passLabel1 = new Label();
        passLabel1.createLabel(40 , 40, 40, 40, newPanel, "Password");

        //create text field for inputting password
        textFieldPass1 = new textField();
        textFieldPass1.createTextField(newPanel, 40, 40, 40, 40);


        //create components for the second password input
        // create label for password input
        passLabel2 = new Label();
        passLabel2.createLabel(40, 40, 40, 40, newPanel, "Confirm Password");

        //create text field for the second password input
        textFieldPass2 = new textField();
        textFieldPass2.createTextField(newPanel, 40, 40, 40, 40);
        //create buttons for actions

        regB = new Button();
        regB.createButton(newPanel, "Register", 40, 40, 40, 40);
        regB.getButton().addActionListener(this);

        logb = new Button();
        logb.createButton(newPanel, "Already have an account?", 40, 40,40,40);
        logb.getButton().addActionListener(this);
        newPanel.setBackground(Color.lightGray);
        this.masterPanel.add(newPanel, "signUpView");
    }


    /**
     *  Used to establish the connection to other connecting pages
     * @param paths contains the paths to other pages
     */
    public void sendPaths(Object[] paths){
        // obtain path to other pages
        this.paths = paths;
    }

    /**
     * refresh the page and display dialog box for message(if any)
     * if login is successful, change the page to UserEdit View
     * @param info contains one of the two error messages or a user object
     *             used to identify what changes need to be make besides refreshing current page
     */

    @Override
    public void updatePage(Object[] info) {

        // refresh page
        this.newPanel.revalidate();
        this.newPanel.repaint();

        // if sign up is unsuccessful, show message
        if (info[0] == "passNoMatch" || info[0] == "userExists") {
            JOptionPane.showMessageDialog(null, info[0]);
        }

        if (info[0] instanceof User) {
            // UserEditView userEditPage = new UserEditView(this.masterPanel, this.layout, (User)info[0]);
            UserEditView userEditView = (UserEditView) this.paths[0];
            String[] newUser = new String[1];
            newUser[0] = "New";
            userEditView.updatePage(newUser);
            // change to user edit page
            this.layout.show(this.masterPanel, "userEditView");
        }
    }

    /**
     * handle users' button click action
     * obtain information entered by the user and pass to the presenter
     * @param evt the event to be processed
     */

    @Override
    public void actionPerformed(ActionEvent evt) {

        if (evt.getSource() == regB.getButton()) {

            String nameEntered = textFieldUser.getTextField().getText();
            String pass1 = textFieldPass1.getTextField().getText();
            String pass2 = textFieldPass2.getTextField().getText();

            UserRegPresenter regPresenter = new UserRegPresenter();
            regPresenter.switchPage(nameEntered, pass1, pass2, this);
        }
        else if(evt.getSource() == logb.getButton()){
            UserRegPresenter regPresenter = new UserRegPresenter();
            regPresenter.updatePage("loginView" ,this.paths[1]);
            this.layout.show(this.masterPanel, "loginView");
        }

    }
}
