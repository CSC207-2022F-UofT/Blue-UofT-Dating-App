package FrameworksDrivers.UIElements;

import javax.swing.*;
import java.util.Objects;

/**
 * UI element Icon class, stores an ImageIcon
 */
public class Icon {
    ImageIcon icon;

    /**
     * Returns class variable icon
     * @return ImageIcon object icon, held within class
     */
    public ImageIcon getIcon() {
        return icon;
    }

    /**
     * Creates an ImageIcon by reading image from the provided filepath
     * @param iconFilePath filepath leading to image
     */
    public void createIcon(String iconFilePath) {
        icon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource(iconFilePath)));
        icon.getImage();
    }
}