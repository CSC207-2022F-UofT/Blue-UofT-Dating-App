package FrameworksDrivers.UIElements;

import javax.swing.*;
import java.awt.*;

public class Label {
    JLabel label;

    /**
     * Returns class variable label
     * @return
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * Creates a label and (optionally) adds it to an existing Dialog Box.
     * @param jpanel
     * @param labelText
     */
    public void createLabel(int boundX, int boundY, int boundWidth, int boundHeight, JPanel jpanel, String labelText) {
        label = new JLabel(labelText);
        label.setBounds(boundX, boundY, boundWidth, boundHeight);
        if (jpanel != null) {
            jpanel.add(label);
        }
    }
    public void setFontSize(int size){
        label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, size));
    }
}