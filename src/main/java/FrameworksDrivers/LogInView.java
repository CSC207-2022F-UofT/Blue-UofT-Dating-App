package FrameworksDrivers;


import javax.swing.JPanel;
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

    private Object[] paths;

    public LogInView(JPanel masterPanel){
        //create page to display created element
        this.masterPanel = masterPanel;

        this.newPanel = new JPanel();
        GridLayout layout = new GridLayout(3, 2);
        this.newPanel.setLayout(layout);


        //create components for username input
        //create label for username input
        userLabel = new Label();
        userLabel.createLabel(40 , 40, 40, 40, newPanel, "Username", Color.BLUE);

        //create text field for inputting username
        textFieldUser = new textField();
        textFieldUser.createTextField(newPanel, 40, 40, 40, 40);


        //create components for password input
        //create label for password input
        passLabel = new Label();
        passLabel.createLabel(40 , 40, 40, 40, newPanel, "Password", Color.BLUE);

        //create text field for inputting password
        textFieldPass = new textField();
        textFieldPass.createTextField(newPanel, 40, 40, 40, 40);

        //create buttons for actions

        logInB = new Button();
        logInB.createButton(newPanel, "Log In", 40, 40, 40, 40);
        logInB
        signUpB = new Button();
        signUpB.createButton(newPanel, "Sign Up", 40, 40, 40, 40);


        //create action listener on button click
//       logInB.addActionListener(this);
//        setTitle("Log In");

//        signUpB.addActionListener(this);
//        setTitle("Sign Up");

        newPanel.setBackground(Color.lightGray);
        this.masterPanel.add(newPanel, "");
    }

    public void sendPaths(Object[] paths){
        // obtain path to other pages
        this.paths = paths;
    }


    @Override
    public void updatePage(...) {
        ...

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // define action performed when button clicked
        // create presenter


        if (e.getSource() == logInB) {
            // check info entered
            // pass to LogInUseCase
            ...

        } else {
            // case e.getSource() == signUpB {
            // update page to SignUpView
            LoginPresenter presenter = new LoginPresenter();
            presenter.updatePage("signUpView", this.paths[2]);
        }

    }
}
