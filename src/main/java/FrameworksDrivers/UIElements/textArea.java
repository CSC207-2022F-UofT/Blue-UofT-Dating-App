package FrameworksDrivers.UIElements;

import javax.swing.*;
import java.awt.*;

public class textArea {
    public JTextArea TextArea;

    public void createTextArea(JPanel jpanel, String textAreaText, int x, int y, int width, int height) {
        TextArea = new JTextArea(textAreaText);
        TextArea.setBounds(x,y,width,height);
        TextArea.setForeground(Color.BLACK);
        if (jpanel != null) {
            jpanel.add(TextArea);
        }
    }
    public void setText(String text){
        TextArea.setText(text);
    }
}