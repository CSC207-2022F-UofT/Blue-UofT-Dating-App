package FrameworksDrivers.UIElements;

import javax.swing.*;
import java.awt.*;

 /**
 * UI element button class which holds a JButton.
 */
public class Button {
    JButton button;

    /**
     * Returns class variable button
     * @return the JButton which this object holds
     */
    public JButton getButton() {
        return button;
    }

    /**
     * Creates a JButton UI component with an image icon
     * @param jPanel jPanel to which the new button is being added
     * @param buttonText button's text
     * @param boundX button's x location
     * @param boundY button's y location
     * @param boundWidth button's width
     * @param boundHeight button's height
     */
    public void createButton(JPanel jPanel, String buttonText, int boundX,
                                     int boundY, int boundWidth, int boundHeight) {
        button = new JButton(buttonText);
        jPanel.add(button);
        button.setBounds(boundX, boundY, boundWidth, boundHeight);
        button.setLocation(new Point(boundX, boundY));

    }
}

