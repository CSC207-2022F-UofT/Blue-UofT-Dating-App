package FrameWorksDrivers.UIElements;

import javax.swing.*;

public class RadioButton {
    JRadioButton radioButton;

    public JRadioButton getRadioButton() {
        return radioButton;
    }
    public void createRadioButton(JPanel jpanel, String radioButtonText, int boundX,
                               int boundY, int boundWidth, int boundHeight, boolean checked) {
        radioButton = new JRadioButton(radioButtonText, checked);
        radioButton.setBounds(boundX,boundY,boundWidth,boundHeight);
        jpanel.add(radioButton);
    }
    public void setChecked(Boolean checked){
        radioButton.setSelected(checked);
    }
}

