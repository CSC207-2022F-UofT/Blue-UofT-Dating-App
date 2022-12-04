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
    public void createLabelCentered(int boundX, int boundY, int boundWidth, int boundHeight, JPanel jpanel, String labelText, Color foregroundColor) {
        label = new JLabel(labelText, SwingConstants.CENTER);
        label.setBounds(boundX, boundY, boundWidth, boundHeight);
        label.setForeground(foregroundColor);
        if (jpanel != null) {
            jpanel.add(label);
        }
    }
    public void setHorizontalAlignment(String align) {
        if (align.equals("left")) {
            this.label.setHorizontalAlignment(SwingConstants.LEFT);
        }
        else if (align.equals("center")) {
            this.label.setHorizontalAlignment(SwingConstants.CENTER);
        }
        else {
            this.label.setHorizontalAlignment(SwingConstants.RIGHT);
        }
    }

    public void setVerticalAlignment(String align) {
        if (align.equals("top")) {
            this.label.setVerticalAlignment(SwingConstants.TOP);
        }
        else if (align.equals("center")) {
            this.label.setVerticalAlignment(SwingConstants.CENTER);
        }
        else {
            this.label.setVerticalAlignment(SwingConstants.BOTTOM);
        }
    }

    public void setText(String text) {
        this.label.setText(text);
    }

    public void setSize(int width, int height) {
        this.label.setPreferredSize(new Dimension(width, height));
    }

    public void setFontSize(int size) {
        this.label.setFont(new Font("", Font.PLAIN, size));
    }
}