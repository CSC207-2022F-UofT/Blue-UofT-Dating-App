package FrameworksDrivers.UIElements;

import javax.swing.*;
import java.awt.*;

/**
 * UI element textArea class, holds JTextArea object
 */
public class textArea {
    public JTextArea TextArea;

    /**
     * Create new JTextArea object with given parameters.
     * @param jpanel panel to which the text area is added
     * @param textAreaText initial text of the text area
     * @param x x coordinate of the text area
     * @param y y coordinate of the text area
     * @param width width of the text area
     * @param height height of the text area
     */
    public void createTextArea(JPanel jpanel, String textAreaText, int x, int y, int width, int height) {
        TextArea = new JTextArea(textAreaText);
        TextArea.setBounds(x,y,width,height);
        TextArea.setForeground(Color.BLACK);
        if (jpanel != null) {
            jpanel.add(TextArea);
        }
        TextArea.setText(textAreaText);
    }

    /** Getter function for JTextArea object
     * @return JTextArea object held within class
     */
    public JTextArea getTextArea() {
        return TextArea;
    }

    /** Set the textArea's text to the passed string
     * @param text text to which the textArea's text will be set to
     */
    public void setText(String text){
        TextArea.setText(text);
    }
}
