package FrameworksDrivers;
import InterfaceAdapters.TestPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestAccount implements ActionListener {

    private JPanel masterPanel;
    private CardLayout layout;
    private JPanel panel;
    private Object[] paths;

    private String dummyInfo = "coffee";
    public TestAccount(JPanel masterPanel, CardLayout layout) {
        this.masterPanel = masterPanel;
        this.layout = layout;

        //Add ur code for your panel below VVVVV
        this.panel = new JPanel();

        JButton button = new JButton("Dont do it");
        button.addActionListener(this);
        this.panel.setLayout(new GridLayout(3, 3));
        this.panel.setBackground(Color.blue);
        this.panel.add(button);
        JPanel anotherPAnel = new JPanel();
        this.panel.add(anotherPAnel);


        this.masterPanel.add(this.panel, "testAccount");
    }

    public void sendPaths(Object[] paths) {
        this.paths = paths;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        TestPresenter presenter = new TestPresenter();

        presenter.updatePage("otherAccount", this.paths[0]);

        //switches the panel
        this.layout.show(this.masterPanel, "otherAccount");

    }
    public void updateTestAccount(String info) {
        // update values and stuff etc
        this.dummyInfo += info;
        System.out.print(this.dummyInfo);
        if (this.panel.getComponents().length < 2){
            JLabel label = new JLabel(this.dummyInfo);
            this.panel.add(label);
        }
        else{
//            JLabel label = (JLabel) this.panel.getComponents()[1];
//            label.setText(this.dummyInfo);
        }

        //updates panel VVVVV
        this.panel.revalidate();
    }

}
