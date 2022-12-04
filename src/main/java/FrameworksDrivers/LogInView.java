package FrameworksDrivers;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import FrameworksDrivers.UIElements.Button;
import FrameworksDrivers.UIElements.Label;
import FrameworksDrivers.UIElements.textField;
import InterfaceAdapters.LoginPresenter;


public class LogInView implements ActionListener, View {
    Button logInB, signUpB;

    JPanel masterPanel, newPanel;
    Label userLabel, passLabel;
    textField textFieldUser, textFieldPass;

    CardLayout layout;

    private Object[] paths;

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
        signUpB = new Button();
        signUpB.createButton(newPanel, "Sign Up", 40, 40, 40, 40);


        newPanel.setBackground(Color.lightGray);
        this.masterPanel.add(newPanel, "");
    }

    public void sendPaths(Object[] paths){
        // obtain path to other pages
        this.paths = paths;
    }


    @Override
    public void updatePage(Object[] info) {
        //LoginPresenter logPresenter = new LoginPresenter();
        //...
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        // define action performed when button clicked
        // create presenter


        if (evt.getSource() == logInB.getButton()) {
            // check info entered
            // pass to LogInUseCase

            try {
                //String exist  = new UserRegGateway().... ;
                //...
                LoginPresenter logPresenter = new LoginPresenter();
                logPresenter.updatePage("accountView", this.paths[1]);
                this.layout.show(this.masterPanel, "accountView");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            // pop dialog user doesn't exist
        } else if (evt.getSource() == signUpB.getButton()){
            // case evt.getSource() == signUpB
            // update page to SignUpView
            LoginPresenter logPresenter = new LoginPresenter();
            logPresenter.updatePage("signUpView", this.paths[2]);
            this.layout.show(this.masterPanel, "signUpView");

        }

    }
}
