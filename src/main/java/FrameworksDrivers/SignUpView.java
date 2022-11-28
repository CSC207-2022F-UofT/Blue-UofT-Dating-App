package FrameworksDrivers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignUpView implements View, ActionListener {

    JPanel masterPanel;

    public SignUpView(JPanel masterPanel) {
        //create page to display created element
        this.masterPanel = masterPanel;
    }

    @Override
    public void updatePage(Object[] info) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
