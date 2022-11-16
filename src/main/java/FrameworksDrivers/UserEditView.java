package FrameworksDrivers;

import Entities.User;
import FrameworksDrivers.UIElements.*;
import FrameworksDrivers.UIElements.Button;
import FrameworksDrivers.UIElements.Icon;
import FrameworksDrivers.UIElements.Label;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserEditView implements ActionListener {
    private JPanel masterPanel;
    private CardLayout layout;
    private JPanel panel;
    private Object[] paths;
    textArea textArea;
    textField textField;
    Label label;
    Button buttonSubmit;
    Button buttonBack;
    ArrayList<Icon> photos;

    public UserEditView(JPanel masterPanel, CardLayout layout) {
        this.masterPanel = masterPanel;
        this.layout = layout;
        this.panel = new JPanel();

        //Add ur code for your panel below VVVVV
        Color c = new Color(204, 255, 255);
        Color r = new Color(255,204,208);
        Color g = new Color(144, 238, 144);

        buttonSubmit = new Button();
        buttonSubmit.createButton(this.panel, "Submit Changes", 350, 700, 200, 30);
        buttonSubmit.getButton().addActionListener(this);
        buttonSubmit.getButton().setBackground(g);

        buttonBack = new Button();
        buttonBack.createButton(this.panel, "Back", 50, 700, 100, 30);
        buttonBack.getButton().addActionListener(this);
        buttonBack.getButton().setBackground(r);

        this.panel.setBackground(Color.blue);
        this.panel.add(buttonBack.getButton());
        this.panel.add(buttonSubmit.getButton());


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
            // go to other page
        }
    }
}
