package FrameworksDrivers;
import FrameworksDrivers.UIElements.Label;
import FrameworksDrivers.UIElements.textField;
import InterfaceAdapters.ChatViewPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 *  A UI class that implements <i>ActionListener</i> and <i>View</i> to create the Chat page
 *  for the program. This class contains all the necessary UI components and relevant methods to update the view.
 */
public class ChatView implements ActionListener, View, ChatViewInterface {

    private JPanel masterPanel;
    private CardLayout layout;
    private CardLayout chatLayout = new CardLayout();
    private JPanel chatContainer;
    private JPanel panel;
    private textField textBox;
    private JButton sendButton;
    private String[] currUsers;
    protected Map<String, String[]> chatNumToUsers = new HashMap<>();
    private Object[] paths;

    protected ArrayList<JButton> chatButtons = new ArrayList<>();
    private Map<JPanel, String> map = new HashMap<>();
    private JButton backButton;
    private JPanel chatListPanel;
    boolean hasCurrentUsers;

    /**
     * Creates the Chat page with the relevant JPanels, back button, send button, and text field.
     * @param masterPanel the masterPanel that contains the page
     * @param layout layout of the masterPanel
     */

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
        this.panel.add(chatContainer, "bob joe");

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

    /**
     * Handles button clicks on the Chat page
     * Determines which button clicked and performs the corresponding actions
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        System.out.println("clicked");
        if (source == backButton) {
            System.out.println("clicked");
            ChatViewPresenter presenter = new ChatViewPresenter(this);
            presenter.updatePage("mainpageView", this.paths[0]);
            this.layout.show(this.masterPanel, "mainpageView");
        }
        else if (source == sendButton) { // send button is clicked
            ChatViewPresenter presenter = new ChatViewPresenter(this);
            String message = textBox.getText();
            System.out.println(message);
            presenter.sendMessage(currUsers, message);
            String[] tempUsers = currUsers.clone();
            presenter.render();
//            currUsers = tempUsers;

        }
        else { // one of the chatButtons must've been clicked
            JButton currButton = (JButton) source;
            String buttonString = Character.toString(currButton.getText().charAt(0));

            //updates the currUsers of the currentChatroom
            currUsers = chatNumToUsers.get(buttonString);
            ChatViewPresenter presenter = new ChatViewPresenter(this);
            presenter.render();
            this.chatLayout.show(chatContainer, buttonString);
            System.out.println(buttonString);
            System.out.println(Arrays.toString(currUsers));
        }
    }

    /**
     * Updates page based on the chatroom data that is passed from ChatRenderUseCase
     * In particular, it adds the buttons and panels for each chatroom between the user and their matches
     * as well as updating the messages
     *
     * @param info the array representation of the chatroom data
     */
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

            if (index == 0 && !this.hasCurrentUsers){
                this.currUsers = new String[] {user1, user2};
                this.hasCurrentUsers = true;
            }
            if(Arrays.equals(currUsers, new String[] {user1, user2})){
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
                            currChatPanel, textMessage);
                    currChatPanel.revalidate();
                    currChatPanel.repaint();
                    this.panel.remove(this.chatContainer);
                    this.chatContainer = new JPanel();
                    this.chatContainer.setLayout(this.chatLayout);
                    this.chatContainer.setBackground(Color.YELLOW);
                    this.chatContainer.setBounds(0, 0, 400, 600);

                    this.panel.add(chatContainer, "bob joe");
                    this.chatContainer.add(currChatPanel, String.valueOf(index));
                    this.map.put(currChatPanel, String.valueOf(index));
                    this.chatContainer.revalidate();
                    this.chatContainer.repaint();
                }
            }

            //add key value pair mapping index of chat to the users in the chat
            this.chatNumToUsers.put(String.valueOf(index), new String[] {user1, user2});
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(index);
            stringBuilder.append(user1);
            stringBuilder.append(" ");
            stringBuilder.append(user2);

            JButton currChatButton = new JButton(stringBuilder.toString());
            currChatButton.addActionListener(this);
            if(this.chatButtons.size() > 0){
                int chatButtonsSize = this.chatButtons.size();
                int unequalButtons = 0;
                for(int i = 0; i < chatButtonsSize; i++){
                    JButton button = this.chatButtons.get(i);
                    String[] users = button.getText().split(" ");
                    users = this.chatNumToUsers.get(Character.toString(button.getText().charAt(0)));
                    HashSet<String> set1 = new HashSet<String>(Arrays.asList(users));
                    HashSet<String> set2 = new HashSet<String>(Arrays.asList(user1, user2));
                    if(!set1.equals(set2)){
                        unequalButtons += 1;
                    }
                    System.out.println(set2.equals(set1));
                }
                if(unequalButtons == chatButtonsSize){
                    this.chatButtons.add(currChatButton);
                    this.chatListPanel.add(currChatButton);
                }
            }
            else{
                this.chatButtons.add(currChatButton);
                this.chatListPanel.add(currChatButton);
            }
            index++;
            }

        this.textBox.setText("");
        this.panel.add(chatContainer);
        this.panel.revalidate();
        this.panel.repaint();
        this.chatLayout.show(chatContainer, "bob joe");
        selectCurrentUserButton();

        System.out.println(Arrays.toString(currUsers));

    }

    public void selectCurrentUserButton(){
        for(JButton button: this.chatButtons){
            String[] users = this.chatNumToUsers.get(Character.toString(button.getText().charAt(0)));
            if(Arrays.equals(this.currUsers, users)){
                button.setBackground(Color.lightGray);
            }
            else{
                button.setBackground(Color.white);
            }
        }
    }

    @Override
    public void logOut(){
        this.currUsers = null;
        this.hasCurrentUsers = false;
        this.panel.remove(this.chatListPanel);
        this.chatListPanel = new JPanel();
        this.chatListPanel.setBackground(Color.RED);
        this.chatListPanel.setBounds(400, 0, 200, 800);
        this.chatListPanel.setLayout(new GridLayout(0, 1));
        this.panel.add(chatListPanel);
        this.chatNumToUsers.clear();
        this.chatButtons.clear();
    }
}
