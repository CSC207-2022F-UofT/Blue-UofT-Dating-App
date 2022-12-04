package FrameworksDrivers.UIElements;
import javax.swing.*;
public class CheckBox {
    JCheckBox checkBox;

    public JCheckBox getCheckBox() {
        return checkBox;
    }
    public void createCheckbox(JPanel jpanel, String checkBoxText, int boundX,
                             int boundY, int boundWidth, int boundHeight, boolean checked) {
        checkBox = new JCheckBox(checkBoxText, checked);
        checkBox.setBounds(boundX,boundY,boundWidth,boundHeight);
        jpanel.add(checkBox);
    }
    public void setChecked(Boolean checked){
        checkBox.setSelected(checked);
    }
}
