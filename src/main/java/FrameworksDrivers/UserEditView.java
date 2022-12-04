package FrameworksDrivers;

import Entities.UserDataClasses.UserDataDictionaries.AttributeValueDict;
import Entities.UserDataClasses.UserDataDictionaries.AttributesDict;
import Entities.UserDataClasses.UserDataDictionaries.InterestsDict;
import FrameworksDrivers.UIElements.*;
import FrameworksDrivers.UIElements.Button;
import FrameworksDrivers.UIElements.Icon;
import FrameworksDrivers.UIElements.Label;
import InterfaceAdapters.UserEditPresenter;
import UseCases.UserEditModel;
import UseCases.UserEditResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class UserEditView implements ActionListener, View {
    private JPanel masterPanel;

    private boolean newUser = true;
    private CardLayout layout;
    private JPanel panel;
    private Object[] paths;
    textField nameField;
    textArea bioField;
    textArea courseField;
    Label labelTitle;
    Label nameLabel;
    Label preferencesLabel;
    Label passwordLabel;
    Label repasswordLabel;
    Label bioLabel;
    Label coursesLabel;
    Label interestsLabel;
    Label attributeLabel;
    Label[] attributesLabel;
    Label dealbreakerLabel;
    Label[] dealbreakerLabels;
    RadioButton[][] attributesRadioButtons;
    RadioButton[][] dealbreakerRadioButtons;
    CheckBox[] attributesHidden;
    Button buttonSubmit;
    Button buttonBack;
    Button deleteAccount;
    CheckBox[] interests;
    Label titleLabel;
    ArrayList<Icon> photos;

    public UserEditView(JPanel masterPanel, CardLayout layout){
        this.masterPanel = masterPanel;
        this.layout = layout;
        this.panel = new JPanel();
        //Add ur code for your panel below VVVVV
        Color c = new Color(204, 255, 255);
        Color r = new Color(255,204,208);
        Color g = new Color(144, 238, 144);
        this.panel.setBounds(0,0,800, 1600);
        this.panel.setPreferredSize(new Dimension(800,1600));

        this.panel.setLayout(null);
        titleLabel = new Label();
        titleLabel.createLabel(250, 10, 300, 30 ,this.panel, "Update User Profile");
        titleLabel.setFontSize(30);

        nameLabel = new Label();
        nameLabel.createLabel(100, 50, 300, 30 ,this.panel, "Display Name");
        nameLabel.setFontSize(20);

        nameField = new textField();
        nameField.createTextField(this.panel, 20, 90, 300, 30);

        bioLabel = new Label();
        bioLabel.createLabel(600, 50, 300, 30 ,this.panel, "Bio");
        bioLabel.setFontSize(20);

        bioField = new textArea();
        bioField.createTextArea(this.panel, "", 480, 90, 300, 100);

        interestsLabel = new Label();
        interestsLabel.createLabel(20, 120, 300, 30, this.panel, "Interests");
        interestsLabel.setFontSize(20);
        InterestsDict update = new InterestsDict();
        interests = new CheckBox[50];
        for(int i = 0; i <= 25; i++){
              interests[i] = new CheckBox();
              Boolean checked = false;
               interests[i].createCheckbox(this.panel, InterestsDict.interestMap.get(i), 20, 150 + 15*i,
                    150, 12, false);

        }
        for(int i = 26; i <= 49; i++){
            interests[i] = new CheckBox();
            interests[i].createCheckbox(this.panel, InterestsDict.interestMap.get(i), 170, 150 + 15*i - 390,
                    150, 12, false);

        }
        coursesLabel = new Label();
        coursesLabel.createLabel(400, 200, 500, 30 ,this.panel, "Courses (Valid UofT course codes only)");
        coursesLabel.setFontSize(20);

        courseField = new textArea();
        courseField.createTextArea(this.panel, "", 480, 230, 300, 70);


        attributeLabel = new Label();
        attributeLabel.createLabel(400, 310, 500, 30 ,this.panel, "Personal Details (please choose one)");
        attributeLabel.setFontSize(20);

        AttributesDict attributesDict = new AttributesDict();
        AttributeValueDict attributeValueDict = new AttributeValueDict();

        attributesLabel = new Label[14];
        attributesRadioButtons = new RadioButton[14][];
        attributesHidden = new CheckBox[14];
        int items = 0;
        for(int i = 0; i<=5; i++){
            attributesLabel[i] = new Label();
            attributesLabel[i].createLabel(400, 350 + 15*items, 300, 30, this.panel, attributesDict.attributeAt(i));
            attributesHidden[i] = new CheckBox();
            attributesHidden[i].createCheckbox(this.panel, "Hidden", 500,360+15*items,70,20,
                    false);
            items += 1;
            attributesRadioButtons[i] = new RadioButton[AttributeValueDict.valuesMap.get(i).keySet().size()];
            for(int j: AttributeValueDict.valuesMap.get(i).keySet()){
                attributesRadioButtons[i][j] = new RadioButton();
                attributesRadioButtons[i][j].createRadioButton(this.panel, attributeValueDict.valueAt(i, j), 400, 360 + 15*items,
                        150, 12, false);
                items+=1;
            }
        }
        items = 0;
        for(int i = 6; i<=13; i++){
            attributesLabel[i] = new Label();
            attributesLabel[i].createLabel(600, 350 + 15*items, 300, 30, this.panel, attributesDict.attributeAt(i));
            attributesHidden[i] = new CheckBox();
            attributesHidden[i].createCheckbox(this.panel, "Hidden", 700,360+15*items,70,10,
                    false);
            items += 1;
            attributesRadioButtons[i] = new RadioButton[AttributeValueDict.valuesMap.get(i).keySet().size()];
            for(int j: AttributeValueDict.valuesMap.get(i).keySet()){
                attributesRadioButtons[i][j] = new RadioButton();
                attributesRadioButtons[i][j].createRadioButton(this.panel, attributeValueDict.valueAt(i, j), 600, 360 + 15*items,
                        150, 12, false);
                items+=1;
            }
        }
        dealbreakerLabel = new Label();
        dealbreakerLabel.createLabel(100, 560, 500, 30 ,this.panel, "Deal-breakers");
        dealbreakerLabel.setFontSize(20);
        dealbreakerLabels = new Label[14];
        dealbreakerRadioButtons = new RadioButton[14][];
        int itemsd = 0;
        for(int i = 0; i<=5; i++){
            dealbreakerLabels[i] = new Label();
            dealbreakerLabels[i].createLabel(20, 580 + 15*itemsd, 300, 30, this.panel, attributesDict.attributeAt(i));
            itemsd += 1;
            dealbreakerRadioButtons[i] = new RadioButton[AttributeValueDict.valuesMap.get(i).keySet().size()];
            for(int j: AttributeValueDict.valuesMap.get(i).keySet()){
                dealbreakerRadioButtons[i][j] = new RadioButton();
                dealbreakerRadioButtons[i][j].createRadioButton(this.panel, attributeValueDict.valueAt(i, j), 20, 590 + 15*itemsd,
                        150, 12, false);
                itemsd+=1;
            }
        }
        itemsd = 0;
        for(int i = 6; i<=13; i++){
            dealbreakerLabels[i] = new Label();
            dealbreakerLabels[i].createLabel(220, 580 + 15 * itemsd, 300, 30, this.panel, attributesDict.attributeAt(i));
            itemsd += 1;
            dealbreakerRadioButtons[i] = new RadioButton[AttributeValueDict.valuesMap.get(i).keySet().size()];
            for(int j: AttributeValueDict.valuesMap.get(i).keySet()){
                dealbreakerRadioButtons[i][j] = new RadioButton();
                dealbreakerRadioButtons[i][j].createRadioButton(this.panel, attributeValueDict.valueAt(i, j), 220, 590 + 15*itemsd,
                        150, 12, false);
                itemsd+=1;
            }
        }
        buttonSubmit = new Button();
        buttonSubmit.createButton(this.panel, "Submit Changes", 550, 1500, 200, 30);
        buttonSubmit.getButton().addActionListener(this);
        buttonSubmit.getButton().setBackground(g);
        buttonBack = new Button();
        buttonBack.createButton(this.panel, "Back", 50, 1500, 200, 30);
        buttonBack.getButton().addActionListener(this);
        buttonBack.getButton().setBackground(r);
        deleteAccount = new Button();
        deleteAccount.createButton(this.panel, "Delete Account", 200, 1500, 200, 30);
        deleteAccount.getButton().addActionListener(this);
        deleteAccount.getButton().setBackground(Color.RED);
        JScrollPane scroller = new JScrollPane(this.panel);
        this.panel.setBackground(Color.lightGray);
        this.masterPanel.add(scroller, "userEditView");
    }
    public void sendPaths(Object[] paths) {
        this.paths = paths;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSubmit.getButton()) {
            String nameData = this.nameField.getTextField().getText();
            String bioData = this.bioField.getTextArea().getText();
            String coursesMetaData = this.courseField.getTextArea().getText().replace(" ","");
            String[] coursesData = coursesMetaData.split(",");
            HashMap<Integer, Boolean> interestsDictData = new HashMap<Integer, Boolean>();
            for(int i = 0; i <= 49; i++){
                CheckBox interest = this.interests[i];
                if(interest.getCheckBox().isSelected()){
                    interestsDictData.put(i, true);
                }
            }
            HashMap<Integer, Integer> attributeDictData = new HashMap<Integer,Integer>();
            HashMap<Integer, Boolean> hiddenDictData = new HashMap<Integer, Boolean>();
            for(int i = 0; i <= 13; i++){
                int attributeIndex = 0;
                for(int j: AttributeValueDict.valuesMap.get(i).keySet()){
                    if(this.attributesRadioButtons[i][j].getRadioButton().isSelected()){ attributeIndex = j;}
                }
                hiddenDictData.put(i, this.attributesHidden[i].getCheckBox().isSelected());
                attributeDictData.put(i, attributeIndex);
            }
            ArrayList<ArrayList<Integer>> breakersDictData = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i <= 13; i++){
                int breakerIndex = 0;
                breakersDictData.add(i, new ArrayList<Integer>());
                for(int j: AttributeValueDict.valuesMap.get(i).keySet()){
                    if(this.dealbreakerRadioButtons[i][j].getRadioButton().isSelected()){ breakersDictData.get(i).add(j);}
                }
            }
            UserEditPresenter userEditPresenter = new UserEditPresenter();
            UserEditModel data = new UserEditModel(nameData, bioData, coursesData, interestsDictData,
                    attributeDictData, breakersDictData, hiddenDictData);
            userEditPresenter.saveUserInfo(data, this.paths[0]);
            this.layout.show(this.masterPanel, "mainpageView");
            this.newUser = false;
        }
        else if(e.getSource() == buttonBack.getButton()){
            if(newUser){
                JOptionPane.showMessageDialog(null, "Please create a profile.");
            }
            else {
                UserEditPresenter userEditPresenter = new UserEditPresenter();
                userEditPresenter.updatePage("mainpageView", this.paths[0]);
                this.layout.show(this.masterPanel, "mainpageView");
            }
        }
        else if(e.getSource() == deleteAccount.getButton()){
            UserEditPresenter userEditPresenter = new UserEditPresenter();
            userEditPresenter.deleteAccount(this.paths[1]);
            this.layout.show(this.masterPanel, "loginView");
        }
    }
    @Override
    public void updatePage(Object[] info) {
        if(info[0].equals("New")){
            this.newUser = true;
        }
        UserEditPresenter userEditPresenter = new UserEditPresenter();
        UserEditResponseModel userEditResponseModel = userEditPresenter.getCurrentUser();
        this.nameField.setText(userEditResponseModel.name);
        this.bioField.setText(userEditResponseModel.bio);
        this.courseField.setText(userEditResponseModel.courses);
        for(int i = 0; i <= 49; i++){
            this.interests[i].setChecked(userEditResponseModel.interestsDict.containsKey(i));
        }
        for(int i = 0; i <= 13; i++){
            this.attributesHidden[i].setChecked((boolean) userEditResponseModel.attributeDict.get(i).get(1));
            for(int j: AttributeValueDict.valuesMap.get(i).keySet()){
                this.attributesRadioButtons[i][j].setChecked((int) userEditResponseModel.attributeDict.get(i).get(0) == j);
                this.dealbreakerRadioButtons[i][j].setChecked(userEditResponseModel.breakersDict.get(i).contains(j));
            }
        }
        this.panel.revalidate();
        this.panel.repaint();
    }
}

