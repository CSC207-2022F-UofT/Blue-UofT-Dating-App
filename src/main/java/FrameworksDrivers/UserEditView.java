package FrameworksDrivers;

import FrameworksDrivers.UIElements.*;
import FrameworksDrivers.UIElements.Button;
import FrameworksDrivers.UIElements.Icon;
import FrameworksDrivers.UIElements.Label;
import InterfaceAdapters.UserEditController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
public class UserEditView implements ActionListener {
    DialogBox dialogBox;
    textArea textArea;
    textField textField;
    Label label;
    Button buttonSubmit;
    Button buttonBack;
    ArrayList<Icon> photos;

    public void createUserEditView() {
        dialogBox = new DialogBox();
        dialogBox.createDialogBox("Blue", 600, 800);
        dialogBox.getJframe().setVisible(true);
        dialogBox.getJframe().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialogBox.getJframe().setResizable(false);
        Color c = new Color(204, 255, 255);
        Color r = new Color(255,204,208);
        Color g = new Color(144, 238, 144);
        dialogBox.getJframe().getContentPane().setBackground(c);

        buttonSubmit = new Button();
        buttonSubmit.createButton(dialogBox.getJframe(), "Submit Changes", 350, 700, 200, 30);
        buttonSubmit.getButton().addActionListener(this);
        buttonSubmit.getButton().setBackground(g);

        buttonBack = new Button();
        buttonBack.createButton(dialogBox.getJframe(), "Back", 50, 700, 100, 30);
        buttonBack.getButton().addActionListener(this);
        buttonBack.getButton().setBackground(r);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSubmit.getButton()) {
            // change graph
        }
        else if(e.getSource() == buttonBack.getButton()){
            // go to other page
        }
    }
}
