package FrameworksDrivers.UIElements;
import javax.swing.*;

/**
 * UI element, Checkbox class which holds a JCheckBox object.
 */
public class CheckBox {
    JCheckBox checkBox;

    /**
     * Getter function for the JCheckBox
     * @return JCheckBox checkBox held within object
     */
    public JCheckBox getCheckBox() {
        return checkBox;
    }

    /**
     * @param jpanel panel the checkbox will  be added to
     * @param checkBoxText text of checkbox
     * @param boundX x coordinate of checkbox on panel
     * @param boundY y coordinate of checkbox on panel
     * @param boundWidth checkboxes width
     * @param boundHeight checkboxes height
     * @param checked whether the checkbox should be checked upon initialization
     */
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
