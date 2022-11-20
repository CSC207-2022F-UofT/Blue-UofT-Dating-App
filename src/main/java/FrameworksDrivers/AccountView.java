package FrameworksDrivers;

import Entities.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountView implements ActionListener {
    private JPanel masterPanel;
    private CardLayout layout;
    private JPanel panel;
    private Object[] paths;
    public AccountView(JPanel masterPanel, CardLayout layout){
        this.masterPanel = masterPanel;
        this.layout = layout;
        this.panel = new JPanel();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void updateAccountView(User user){

    }
}
