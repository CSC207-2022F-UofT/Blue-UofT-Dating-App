package FrameworksDrivers;

import Entities.User;
import Entities.UserDataClasses.UserDataDictionaries.InterestsDict;
import FrameworksDrivers.UIElements.*;
import FrameworksDrivers.UIElements.Button;
import FrameworksDrivers.UIElements.Icon;
import FrameworksDrivers.UIElements.Label;
import InterfaceAdapters.UserEditPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class UserEditView implements ActionListener {
    private JPanel masterPanel;
    private CardLayout layout;
    private JPanel panel;
    private Object[] paths;
    private User user;
    textField nameField;
    textArea bioField;

    Label labelTitle;
    Label nameLabel;
    Label preferencesLabel;
    Label passwordLabel;
    Label repasswordLabel;
    Label bioLabel;
    Label coursesLabel;
    Label interestsLabel;
    Button buttonSubmit;
    Button buttonBack;
    CheckBox[] interests;
    Label titleLabel;
    ArrayList<Icon> photos;

    public UserEditView(JPanel masterPanel, CardLayout layout, User user) {
        this.user = user;
        this.masterPanel = masterPanel;
        this.layout = layout;
        this.panel = new JPanel();
        //Add ur code for your panel below VVVVV
        Color c = new Color(204, 255, 255);
        Color r = new Color(255,204,208);
        Color g = new Color(144, 238, 144);
        this.panel.setBounds(0,0,800, 600);

        this.panel.setLayout(null);

        titleLabel = new Label();
        titleLabel.createLabel(250, 10, 300, 30 ,this.panel, "Update User Profile");
        titleLabel.setFontSize(30);

        nameLabel = new Label();
        nameLabel.createLabel(100, 50, 300, 30 ,this.panel, "Display Name");
        nameLabel.setFontSize(20);

        nameField = new textField();
        nameField.createTextField(this.panel, 20, 90, 300, 30);
        nameField.setText(this.user.getUsername().getData());

        bioLabel = new Label();
        bioLabel.createLabel(600, 50, 300, 30 ,this.panel, "Bio");
        bioLabel.setFontSize(20);

        bioField = new textArea();
        bioField.createTextArea(this.panel, this.user.getBio().getData(), 480, 90, 300, 100);
        bioField.setText(this.user.getUsername().getData());

        interestsLabel = new Label();
        interestsLabel.createLabel(20, 120, 300, 30, this.panel, "Interests");
        interestsLabel.setFontSize(20);
        InterestsDict update = new InterestsDict();
        interests = new CheckBox[50];
        for(int i = 0; i <= 25; i++){
              interests[i] = new CheckBox();
               interests[i].createCheckbox(this.panel, InterestsDict.interestMap.get(i), 20, 150 + 15*i,
                    150, 12, this.user.getInterests().getData().get(i));

        }
        for(int i = 26; i <= 49; i++){
            interests[i] = new CheckBox();
            interests[i].createCheckbox(this.panel, InterestsDict.interestMap.get(i), 170, 150 + 15*i - 390,
                    150, 12, this.user.getInterests().getData().get(i));

        }



        buttonSubmit = new Button();
        buttonSubmit.createButton(this.panel, "Submit Changes", 550, 550, 200, 30);
        buttonSubmit.getButton().addActionListener(this);
        buttonSubmit.getButton().setBackground(g);

        buttonBack = new Button();
        buttonBack.createButton(this.panel, "Back", 50, 550, 200, 30);
        buttonBack.getButton().addActionListener(this);
        buttonBack.getButton().setBackground(r);





        this.panel.setBackground(Color.lightGray);

        this.masterPanel.add(this.panel, "");
    }

    public void sendPaths(Object[] paths) {
        this.paths = paths;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSubmit.getButton()) {
            // change graph
        }
        else if(e.getSource() == buttonBack.getButton()){
            UserEditPresenter userEditPresenter = new UserEditPresenter();
            userEditPresenter.updatePage("testAccount", this.paths[1]);
            this.layout.show(this.masterPanel, "otherAccount");
        }
    }
    public void updateUserEditView(){
        UserEditPresenter userEditPresenter = new UserEditPresenter();
        this.user = userEditPresenter.getCurrentUser();
    }
}

