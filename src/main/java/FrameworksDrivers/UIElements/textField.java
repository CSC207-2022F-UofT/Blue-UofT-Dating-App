package FrameworksDrivers.UIElements;

import javax.swing.*;

public class textField {
    JTextField textField;

    /**
     * Returns class variable textField
     * @return
     */
    public JTextField getTextField() {
        return textField;
    }

    /**
     * Creates a JTextField as per specified criteria and adds it to the dialogbox.
     * @param jpanel
     * @param boundX
     * @param boundY
     * @param boundWidth
     * @param boundHeight
     */
    public void createTextField(JPanel jpanel, int boundX, int boundY, int boundWidth, int boundHeight) {
        textField = new JTextField();
        textField.setBounds(boundX,boundY,boundWidth,boundHeight);
        jpanel.add(textField);
    }
    public void setText(String text){
        textField.setText(text);
    }
}