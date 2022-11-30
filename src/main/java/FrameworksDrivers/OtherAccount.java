package FrameworksDrivers;
import InterfaceAdapters.MainPagePresenter;
import InterfaceAdapters.OtherAccountPresenter;
import FrameworksDrivers.UIElements.Label;
import FrameworksDrivers.UIElements.Button;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OtherAccount implements ActionListener, View {
    private JPanel masterPanel;
    private CardLayout layout;
    private JPanel panel;

    private Object[] paths;
    private Label bio;
    private Label name;
    private Label location;
    private Label[] textBank;
    private String prevpage;
    public OtherAccount(JPanel masterPanel, CardLayout layout) {
        this.masterPanel = masterPanel;
        this.layout = layout;

        //Add ur code for your panel below VVVVV
        this.panel = new JPanel();
        JPanel inner = new JPanel();
        inner.setPreferredSize(new Dimension(600, 750));
        inner.setLayout(new GridLayout(2, 1));

        //photo
        JPanel upper = new JPanel();
        upper.setBackground(Color.blue);

        //Person information
        JPanel lower = new JPanel();
        this.name  = new Label();
        this.name.createLabelCentered(40, 40, 40, 40, null, "Name", Color.blue);
        this.location = new Label();
        this.location.createLabelCentered(40, 40, 40, 40, null, "location", Color.blue);
        JPanel topInfo = new JPanel();
        topInfo.setPreferredSize(new Dimension(600, 100));
        topInfo.setLayout(new GridLayout(1, 2));

        //name location
        topInfo.add(this.name.getLabel());
        topInfo.add(this.location.getLabel());
        lower.add(topInfo);

        //biograph
        JPanel botInfo = new JPanel();
        botInfo.setPreferredSize(new Dimension(400, 200));
        botInfo.setLayout(new BoxLayout(botInfo, BoxLayout.Y_AXIS));
        this.bio = new Label();
        this.bio.createLabel(100, 100, 100, 100, botInfo, "<html> hi </html>");
        this.bio.setHorizontalAlignment("left");
        this.bio.setVerticalAlignment("top");
        lower.add(botInfo);

        JPanel buttonAlign = new JPanel();
        buttonAlign.setPreferredSize(new Dimension(600, 20));
        buttonAlign.setLayout(new BoxLayout(buttonAlign, BoxLayout.X_AXIS));
        Button backToMain = new Button();
        backToMain.createButton(buttonAlign, "Back", 20, 20, 10, 10);
        backToMain.getButton().addActionListener(this);
        backToMain.setHorizontalAlignment("left");

        this.panel.add(buttonAlign);
        this.panel.add(inner);
        inner.add(upper);
        inner.add(lower);


        this.masterPanel.add(this.panel, "otherAccount");
    }


    public void sendPaths(Object[] paths) {
        //gets paths to other pages
        this.paths = paths;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (prevpage.equals("main")) {}

    }

    public void updatePage(Object[] info){
        this.name.getLabel().setText((String) info[0]);
        this.bio.getLabel().setText((String) info[1]);
        this.bio.getLabel().setText("<html>" + (String) info[2] + "</html>");

        //updates panel VVVVV
        this.panel.revalidate();
    }

}



//zzz