package FrameworksDrivers;
import FrameworksDrivers.UIElements.Button;
import FrameworksDrivers.UIElements.Label;
import FrameworksDrivers.UIElements.textField;
import InterfaceAdapters.ChatViewPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ChatView implements ActionListener, View {

    private JPanel masterPanel;
    private CardLayout layout;
    private CardLayout chatLayout = new CardLayout();
    private JPanel chatContainer;
    private JPanel panel;
    private textField textBox;
    private JButton sendButton;
    private String[] currUsers;
    private Map<String, String[]> chatNumToUsers = new HashMap<>();
    private Object[] paths;

    protected ArrayList<JButton> chatButtons = new ArrayList<>();
    private Map<JPanel, String> map = new HashMap<>();
    private JButton backButton;
    private JPanel chatListPanel;

    public ChatView(JPanel masterPanel, CardLayout layout) {
        //initialize overall jpanel
        this.masterPanel = masterPanel;
        this.layout = layout;
        this.panel = new JPanel();
        this.panel.setLayout(null);

        //intialize chat list panel right
        chatListPanel = new JPanel();
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
        chatContainer = new JPanel();
        chatContainer.setLayout(chatLayout);
        chatContainer.setBackground(Color.YELLOW);
        chatContainer.setBounds(0, 0, 400, 600);
        this.panel.add(chatContainer);

        this.chatLayout.show(chatContainer, "bob joe");

        textBox = new textField(); // No idea what the columns do
        textBox.createTextField(textBoxContainer, 25, 0, 250, 50);

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        backButton.setBounds(20, 100, 100, 50);
        textBoxContainer.add(backButton);

        sendButton = new JButton("Send");
        sendButton.addActionListener(this);
        sendButton.setBounds(300, 0, 75, 50);
        textBoxContainer.add(sendButton);

        this.masterPanel.add(this.panel, "chatView");
    }

    // yo what is object paths used for
    public void sendPaths(Object[] paths) {
        this.paths = paths;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        System.out.println("clicked");
        if (source == backButton) {
            System.out.println("clicked");
            this.layout.show(this.masterPanel, "otherAccount");
        }
        else if (source == sendButton) { // send button is clicked
            ChatViewPresenter presenter = new ChatViewPresenter(this);
            String message = textBox.getText();
            System.out.println(message);
            presenter.sendMessage(currUsers, message);
        }
        else { // one of the chatButtons must've been clicked
            JButton currButton = (JButton) source;
            String buttonString = currButton.getText();

            //updates the currUsers of the currentChatroom
            currUsers = chatNumToUsers.get(buttonString);

            this.chatLayout.show(chatContainer, buttonString);
            System.out.println(buttonString);
            System.out.println(Arrays.toString(currUsers));
        }
    }

    @Override
    public void updatePage(Object[] info) {

        //might want to separate
        int index = 0;
        for (Object chatroomObject : info) {
            //new chatroom
            ArrayList<ArrayList<String>> chatroomList = (ArrayList<ArrayList<String>>) chatroomObject;

            //create corresponding chatroom button and add to chatListPanel on right of screen
            String user1 = chatroomList.get(0).get(0);
            String user2 = chatroomList.get(1).get(0);
            if (index == 0) currUsers = new String[] {user1, user2};

            //add key value pair mapping index of chat to the users in the chat
            chatNumToUsers.put(String.valueOf(index), new String[] {user1, user2});

            JButton currChatButton = new JButton(String.valueOf(index));
            currChatButton.addActionListener(this);
            chatButtons.add(currChatButton);
            chatListPanel.add(currChatButton);

            //create corresponding chat panel that will appear on the left-hand side when corresponding
            //chat button is pressed.
            JPanel currChatPanel = new JPanel();
            currChatPanel.setLayout(new GridLayout(0, 1));
            currChatPanel.setBackground(Color.CYAN);

            //iterate through the messages of the current chatroom
            for (int i = 2; i < chatroomList.size(); i++) {
                ArrayList<String> currMessageList = chatroomList.get(i);
                //example textMessage: clark: hello kevin
                String textMessage = currMessageList.get(0) + ": " + currMessageList.get(1);
                Label currLabel = new Label();

                // bounds don't matter because of grid layout for panel
                currLabel.createLabel(0, 0, 50, 50,
                        currChatPanel, textMessage + index);
            }

            chatContainer.add(currChatPanel, String.valueOf(index));
            map.put(currChatPanel, String.valueOf(index));

            index++;
        }

        System.out.println(Arrays.toString(currUsers));
    }
}
