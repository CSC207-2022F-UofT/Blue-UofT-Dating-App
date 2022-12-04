package FrameworksDrivers;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import FrameworksDrivers.UIElements.Button;
import FrameworksDrivers.UIElements.Label;
import FrameworksDrivers.UIElements.textField;


public class SignUpView implements View, ActionListener {
    Button regB;

    JPanel masterPanel, newPanel;
    Label userLabel, passLabel1, passLabel2;
    textField textFieldUser, textFieldPass1, textFieldPass2;

    CardLayout layout;

    private Object[] paths;

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



        newPanel.setBackground(Color.lightGray);
        this.masterPanel.add(newPanel, "");
    }

    public void sendPaths(Object[] paths){
        // obtain path to other pages
        this.paths = paths;
    }

    @Override
    public void updatePage(Object[] info) {
        //...
    }

    @Override
    public void actionPerformed(ActionEvent evt) {

        if (evt.getSource() == regB.getButton()) {

            try {
                //...;
            } catch (Exception e) {
                //...
            }
        }

    }
}
