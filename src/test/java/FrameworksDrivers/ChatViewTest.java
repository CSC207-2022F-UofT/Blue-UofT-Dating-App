package FrameworksDrivers;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ChatViewTest {

    @Test
    void testChatListPanel() {
        ArrayList<ArrayList<ArrayList<String>>> expectedOutput = new ArrayList<>();
        ArrayList<ArrayList<String>> expectedChatrooms = new ArrayList<>();
        ArrayList<String> user1 = new ArrayList<>();
        user1.add("clark");
        expectedChatrooms.add(user1);
        ArrayList<String> user2 = new ArrayList<>();
        user2.add("kevin");
        expectedChatrooms.add(user2);

        //no need to add messages

        expectedOutput.add(expectedChatrooms);

        ChatView testView = new ChatView(new JPanel(), new CardLayout());
        Object[] info = expectedOutput.toArray();
        testView.updatePage(info);
        assertEquals(testView.chatButtons.size(), 1);
//        assertEquals(testView.chatButtons.get(0).getName(), "clarkkevin");
    }
}