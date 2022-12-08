package FrameworksDrivers.UIElements;

import javax.swing.*;
import java.awt.*;

/**
 * UI element label class, holds a JLabel object.
 */
public class Label {
    JLabel label;
    /**
     * Returns class variable label
     * @return JLabel object, label, held within the class
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * Creates a label and (optionally) adds it to an existing Dialog Box.
     * @param jpanel panel to which the label will be added
     * @param labelText text to be displayed in the label
     * @param boundWidth width of the label
     * @param boundHeight height of the label
     * @param boundX x coordinate of the label
     * @param boundY y coordinate of the label
     */
    public void createLabel(int boundX, int boundY, int boundWidth, int boundHeight, JPanel jpanel, String labelText) {
        label = new JLabel(labelText);
        label.setBounds(boundX, boundY, boundWidth, boundHeight);
        if (jpanel != null) {
            jpanel.add(label);
        }
    }

    /**
     * Creates a centred label and optionally adds it to the jPanel.
     * @param jpanel panel to which the label will be added
     * @param labelText text to be displayed in the label
     * @param boundWidth width of the label
     * @param boundHeight height of the label
     * @param boundX x coordinate of the label
     * @param boundY y coordinate of the label
     * @param foregroundColor colour of the text
     */
    public void createLabelCentered(int boundX, int boundY, int boundWidth, int boundHeight, JPanel jpanel, String labelText, Color foregroundColor) {
        label = new JLabel(labelText, SwingConstants.CENTER);
        label.setBounds(boundX, boundY, boundWidth, boundHeight);
        label.setForeground(foregroundColor);
        if (jpanel != null) {
            jpanel.add(label);
        }
    }

    /**
     * Sets horizontal alignment to the given alignment passed in by String align
     * @param align string defining how to align the label
     */
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
    /**
     * Sets vertical alignment to the given alignment passed in by String align
     * @param align string defining how to align the label
     */
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

    /** Setter function
     * @param text sets label text to passed text
     */
    public void setText(String text) {
        this.label.setText(text);
    }

    /** Setter function for size
     * @param width given width
     * @param height given height
     */
    public void setSize(int width, int height) {
        this.label.setPreferredSize(new Dimension(width, height));
    }

    /** Setter function for font size.
     * @param size size of font desired
     */
    public void setFontSize(int size) {
        this.label.setFont(new Font("", Font.PLAIN, size));
    }

    /**
     * Setter function for visibility
     * @param bool whether the label should be visible
     */
    public void setVisible(boolean bool) {
        this.label.setVisible(bool);
    }
}
