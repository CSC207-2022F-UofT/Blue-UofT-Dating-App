package FrameworksDrivers;

import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ChatView
 */
class ChatViewTest {

    /**
     * Hard codes the input parameter that the ChatView updatePage() methods uses
     */
    private Object[] createInput() {
        Object[] input = new Object[2];
        ArrayList<ArrayList<String>> expectedChatroom1 = new ArrayList<>();
        ArrayList<String> user1 = new ArrayList<>();
        user1.add("clark");
        expectedChatroom1.add(user1);
        ArrayList<String> user2 = new ArrayList<>();
        user2.add("kevin");
        expectedChatroom1.add(user2);

        ArrayList<String> message1 = new ArrayList<>();
        message1.add("clark");
        message1.add("hello kevin");
        expectedChatroom1.add(message1);

        ArrayList<String> message2 = new ArrayList<>();
        message2.add("kevin");
        message2.add("hello clark");
        expectedChatroom1.add(message2);

        input[0] = expectedChatroom1;

        ArrayList<ArrayList<String>> expectedChatroom2 = new ArrayList<>();
        user1 = new ArrayList<>();
        user1.add("bob");
        expectedChatroom2.add(user1);
        user2 = new ArrayList<>();
        user2.add("joe");
        expectedChatroom2.add(user2);

        message1 = new ArrayList<>();
        message1.add("bob");
        message1.add("hello joe");
        expectedChatroom2.add(message1);

        message2 = new ArrayList<>();
        message2.add("joe");
        message2.add("hello bob");
        expectedChatroom2.add(message2);

        input[1] = expectedChatroom2;

        return input;
    }

    /**
     * Checks if the number of chat buttons in ChatView is equal to the number of chatrooms created
     */
    @Test
    void testChatListPanel() {
        Object[] input = createInput();
        int expectedNumButtons = 2;

        ChatView chatView = new ChatView(new JPanel(), new CardLayout());
        chatView.updatePage(input);

        assertEquals(expectedNumButtons, chatView.chatButtons.size());
    }

    /**
     * Checks if the chatNumToUsers hashmap is what we expect in ChatView after page is updated
     */
    @Test
    void testChatNumToUsers() {
        Object[] input = createInput();
        Map<String, String[]> expectedMap = new HashMap<>();
        expectedMap.put("0", new String[] {"clark", "kevin"});
        expectedMap.put("1", new String[] {"bob", "joe"});

        ChatView chatView = new ChatView(new JPanel(), new CardLayout());
        chatView.updatePage(input);

        assertEquals(expectedMap.keySet(), chatView.chatNumToUsers.keySet());
    }
}