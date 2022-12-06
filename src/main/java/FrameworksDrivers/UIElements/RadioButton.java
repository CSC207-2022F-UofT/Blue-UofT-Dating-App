package FrameworksDrivers.UIElements;

import javax.swing.*;

/**
 * Ui element RadioButton class, holds a JRadioButton object
 */
public class RadioButton {
    JRadioButton radioButton;

    /** Getter function for the radioButton
     * @return the radiobutton object held in the class
     */
    public JRadioButton getRadioButton() {
        return radioButton;
    }

    /** Creates a new JRadioButton object.
     * @param jpanel panel to which the radio button will be added
     * @param radioButtonText text of the radiobutton
     * @param boundX x coordinate of the radio button
     * @param boundY y coordinate of radio button
     * @param boundWidth width of the radio button
     * @param boundHeight height of the radio button
     * @param checked whether the radio button is initialized as clicked or not
     */
    public void createRadioButton(JPanel jpanel, String radioButtonText, int boundX,
                               int boundY, int boundWidth, int boundHeight, boolean checked) {
        radioButton = new JRadioButton(radioButtonText, checked);
        radioButton.setBounds(boundX,boundY,boundWidth,boundHeight);
        jpanel.add(radioButton);
    }

    /** Setter function for whether the button is clicked
     * @param checked whether the button is clicked or not
     */
    public void setChecked(Boolean checked){
        radioButton.setSelected(checked);
    }
}

