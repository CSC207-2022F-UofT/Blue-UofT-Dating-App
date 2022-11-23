package FrameworksDrivers;
import FrameworksDrivers.UIElements.Button;
import FrameworksDrivers.UIElements.textField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChatView implements ActionListener, View {

    private JPanel masterPanel;
    private CardLayout layout;
    private JPanel panel;
    private textField textBox;
    private Object[] paths;

    private ArrayList<JButton> chatButtons = new ArrayList<>();
    private ArrayList<JPanel> chatPanels = new ArrayList<>();
    private JButton backButton;

    public ChatView(JPanel masterPanel, CardLayout layout) {
        //initialize overall jpanel
        this.masterPanel = masterPanel;
        this.layout = layout;
        this.panel = new JPanel();
        this.panel.setLayout(null);

        //intialize chat list panel right
        JPanel chatListPanel = new JPanel();
        chatListPanel.setBackground(Color.RED);
        chatListPanel.setBounds(400, 0, 200, 800);
        chatListPanel.setLayout(new GridLayout(0, 1));
        this.panel.add(chatListPanel);

        // text container
        JPanel textBoxContainer = new JPanel();
        textBoxContainer.setLayout(null);
        textBoxContainer.setBackground(Color.GREEN);
        textBoxContainer.setBounds(0, 600, 400, 200);
        this.panel.add(textBoxContainer);

        // innerchat container
        JPanel chatContainer = new JPanel();
        chatContainer.setLayout(new GridLayout(0, 1));
        chatContainer.setBackground(Color.YELLOW);
        chatContainer.setBounds(0, 0, 400, 600);
        this.panel.add(chatContainer);

        textBox = new textField(); // No idea what the columns do
        textBox.createTextField(textBoxContainer, 25, 0, 350, 100);

        JButton button1 = new JButton("Chat1");
        chatListPanel.add(button1);
        chatButtons.add(button1);

        JButton button2 = new JButton("Chat2");
        chatListPanel.add(button2);
        chatButtons.add(button2);

        backButton = new JButton("Back");
        chatListPanel.add(backButton);
        chatButtons.add(backButton);

        this.masterPanel.add(this.panel, "chatView");
    }

    // yo what is object paths used for
    public void sendPaths(Object[] paths) {
        this.paths = paths;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Depending on ehich
        // buttons.get(0) is button of the first chat
//        if (e.getSource() == backButton) {
//            //change view to th
//        }
//        for (int i = 0; i < chatButtons.size(); i++){
//            if (e.getSource() == chatButtons.get(i)) {
//                //change panel to the chat corresponding to the ith chat
//            }
//            return;

    }

    @Override
    public void updatePage(Object[] info) {
        for (Object chatroom : info) {
            Button b = new Button();
        }
    }
}
