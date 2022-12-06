package FrameworksDrivers.UIElements;

import javax.swing.*;

/**
 * UI element textField class, holds a JTextField object
 */
public class textField {
    JTextField textField;

    /**
     * Returns class variable textField
     * @return JTextField object held within class
     */
    public JTextField getTextField() {
        return textField;
    }

    public String getText() {
        return textField.getText();
    }

    /**
     * Creates a JTextField as per specified criteria and adds it to the panel.
     * @param jpanel panel to which the textField will be added
     * @param boundX x coordinate of the textField
     * @param boundY y coordinate of the textField
     * @param boundWidth width of the textField
     * @param boundHeight height of the textFIeld
     */
    public void createTextField(JPanel jpanel, int boundX, int boundY, int boundWidth, int boundHeight) {
        textField = new JTextField();
        textField.setBounds(boundX,boundY,boundWidth,boundHeight);
        jpanel.add(textField);
    }

    /** Setter function for textField's text attribute.
     * @param text string to which the textField's text will be set to
     */
    public void setText(String text){
        textField.setText(text);
    }
}