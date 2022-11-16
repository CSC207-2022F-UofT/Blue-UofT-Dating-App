package FrameworksDrivers;
import InterfaceAdapters.OtherAccountPresenter;
import InterfaceAdapters.TestPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OtherAccount implements ActionListener {

    private JPanel masterPanel;
    private CardLayout layout;
    private JPanel panel;

    private Object[] paths;
    private String dummyInfo = "snowing";
    public OtherAccount(JPanel masterPanel, CardLayout layout) {
        this.masterPanel = masterPanel;
        this.layout = layout;
        this.panel = new JPanel();

        //Add ur code for your panel below VVVVV
        this.panel.setLayout(new GridLayout(3, 3));
        JButton button = new JButton("cats");
        button.addActionListener(this);
        this.panel.add(button);

        this.masterPanel.add(this.panel, "otherAccount");
    }


    public void sendPaths(Object[] paths) {
        //gets paths to other pages
        this.paths = paths;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //create presenter
        OtherAccountPresenter presenter = new OtherAccountPresenter();

        //this.paths[0] refers to te first path in the paths array, which is testAccount.
        presenter.updatePage("testAccount", this.paths[0]);

        //switches the panel
        this.layout.show(this.masterPanel, "testAccount");

    }


    public void updateOtherAccount(String info) {
        this.dummyInfo += info;
        System.out.print(this.dummyInfo);
        if (this.panel.getComponents().length < 2){
            JLabel label = new JLabel(this.dummyInfo);
            this.panel.add(label);
        }
        else{
            JLabel label = (JLabel) this.panel.getComponents()[1];
            label.setText(this.dummyInfo);
        }

        //updates panel VVVVV
        this.panel.revalidate();
    }

}



//zzz