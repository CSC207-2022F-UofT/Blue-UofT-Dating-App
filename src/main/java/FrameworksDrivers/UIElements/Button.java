package FrameworksDrivers.UIElements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Button {
    JButton button;
    int index;

    /**
     * Returns class variable button
     * @return
     */
    public JButton getButton() {
        return button;
    }

    /**
     * Creates a JButton UI component with an image icon
     * @param jpanel
     * @param buttonText
     * @param boundX
     * @param boundY
     * @param boundWidth
     * @param boundHeight
     */
    public void createButton(JPanel jpanel, String buttonText, int boundX,
                                     int boundY, int boundWidth, int boundHeight) {
        button = new JButton(buttonText);
        jpanel.add(button);
        button.setBounds(boundX, boundY, boundWidth, boundHeight);
        button.setLocation(new Point(boundX, boundY));

    }
    public void createButton(JPanel jpanel, String buttonText, int boundX,
                             int boundY, int boundWidth, int boundHeight, int index) {
        button = new JButton(buttonText);
        jpanel.add(button);
        button.setBounds(boundX, boundY, boundWidth, boundHeight);
        button.setLocation(new Point(boundX, boundY));
        this.index = index;

    }
    public void setHorizontalAlignment(String align) {
        if (align.equals("left")) {
            this.button.setHorizontalAlignment(SwingConstants.LEFT);
        }
        else if (align.equals("center")) {
            this.button.setHorizontalAlignment(SwingConstants.CENTER);
        }
        else {
            this.button.setHorizontalAlignment(SwingConstants.RIGHT);
        }
    }


}

