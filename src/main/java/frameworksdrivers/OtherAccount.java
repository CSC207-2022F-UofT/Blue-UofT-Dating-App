package frameworksdrivers;

import frameworksdrivers.UIElements.Label;
import frameworksdrivers.UIElements.Button;
import InterfaceAdapters.OtherAccountPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The OtherAccount class generates another users profile to display
 * that is chosen by the user
 */
public class OtherAccount implements ActionListener, View {
    private JPanel masterPanel;
    private CardLayout layout;
    private JPanel panel;

    private Object[] paths;
    private Button backToMain;
    private Label bio;
    private Label name;
    private Label location;

    private ArrayList<Label> interstsLabels;
    private ArrayList<Label> attributesLabels;
    private ArrayList<Label> courseLabels;

    private Label interestTitle;
    private Label attributesTitle;
    private Label coursesTitle;

    private JPanel interstPanel;
    private JPanel attributesPanel;
    private JPanel coursesPanel;

    private String prevpage;
    /**
     * Initalizes OtherAccount page
     *
     * @parem masterPanel Panel that holds OtherAccount and other pages
     * @parem layout Manager that controls which panel is shown
     */
    public OtherAccount(JPanel masterPanel, CardLayout layout) {
        this.masterPanel = masterPanel;
        this.layout = layout;
        this.interstsLabels = new ArrayList<>();
        this.courseLabels = new ArrayList<>();
        this.attributesLabels = new ArrayList<>();

        //Add ur code for your panel below VVVVV
        this.panel = new JPanel();
        JPanel inner = new JPanel();
        inner.setPreferredSize(new Dimension(600, 600));
        inner.setLayout(new GridLayout(2, 1));

        //photo
        JPanel upper = new JPanel();
        upper.setBackground(Color.blue);

        //Person information
        JPanel lower = new JPanel();
        this.name = new Label();
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

        //intersts
        JPanel interestsHolder = new JPanel();
        interestsHolder.setBackground(Color.BLUE);
        this.interestTitle = new Label();
        interestTitle.createLabelCentered(5, 5, 5, 5, null, "Interests", Color.white);

        this.interstPanel = new JPanel();
        this.interstPanel.setLayout(new GridLayout(0, 3));

        for (int i = 0; i <= 10; i++) {
            Label label = new Label();
            label.createLabelCentered(40, 40, 40, 40, null, "", Color.blue);
            label.setSize(100, 50);
            this.interstsLabels.add(label);
            this.interstPanel.add(label.getLabel());
        }

        interestsHolder.add(interestTitle.getLabel());
        interestsHolder.add(this.interstPanel);


        //attributes
        JPanel attrHolder = new JPanel();
        attrHolder.setBackground(Color.BLUE);
        this.attributesTitle = new Label();
        attributesTitle.createLabelCentered(5, 5, 5, 5, null, "Attributes", Color.white);

        this.attributesPanel = new JPanel();
        this.attributesPanel.setLayout(new GridLayout(0, 1));

        for (int i = 0; i <= 17; i++) {
            Label label = new Label();
            label.createLabelCentered(40, 40, 40, 40, null, "", Color.blue);
            label.setSize(100, 50);
            this.attributesLabels.add(label);
            this.attributesPanel.add(label.getLabel());
        }

        attrHolder.add(attributesTitle.getLabel());
        attrHolder.add(this.attributesPanel);

        //courses
        JPanel coursesHolder = new JPanel();
        coursesHolder.setBackground(Color.BLUE);
        this.coursesTitle = new Label();
        coursesTitle.createLabelCentered(5, 5, 5, 5, null, "Courses   ", Color.white);

        this.coursesPanel = new JPanel();
        this.coursesPanel.setLayout(new GridLayout(0, 3));

        for (int i = 0; i <= 4; i++) {
            Label label = new Label();
            label.createLabelCentered(40, 40, 40, 40, null, "", Color.blue);
            label.setSize(100, 50);
            this.courseLabels.add(label);
            this.coursesPanel.add(label.getLabel());
        }

        coursesHolder.add(coursesTitle.getLabel());
        coursesHolder.add(this.coursesPanel);


        JPanel buttonAlign = new JPanel();
        buttonAlign.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonAlign.setPreferredSize(new Dimension(600, 35));
        this.backToMain = new Button();
        this.backToMain.createButton(buttonAlign, "Back", 30, 30, 30, 30);
        this.backToMain.getButton().addActionListener(this);


        this.panel.add(buttonAlign);
        this.panel.add(inner);
        inner.add(upper);
        inner.add(lower);
        this.panel.add(interestsHolder);
        this.panel.add(attrHolder);
        this.panel.add(coursesHolder);

        JScrollPane scroller = new JScrollPane(this.panel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));

        this.masterPanel.add(scroller, "otherAccount");

    }

    /**
     * Sends the possible locations OtherAccount may need to traverse to
     *
     * @parem paths References to pages that OtherAccount may switch to
     */
    public void sendPaths(Object[] paths) {
        //gets paths to other pages
        this.paths = paths;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.backToMain.getButton()){
            OtherAccountPresenter otherAccountPresenter = new OtherAccountPresenter(this.name.getLabel().getText());
            otherAccountPresenter.updatePage("mainpageView", this.paths[0]);
            this.layout.show(this.masterPanel, "mainpageView");
        }

    }

    /**
     * Gets and updates OtherAccount page with new user information when user switches to it
     *
     * @param info Object array that contains all the needed information to update OtherAccount
     */
    public void updatePage(Object[] info) {
        this.name.getLabel().setText((String) info[0]);
        this.location.getLabel().setText((String) info[1]);
        this.bio.getLabel().setText("<html>" + info[2] + "</html>");

        ArrayList<String> intersts = (ArrayList<String>) info[3];
        ArrayList<String> attributes = (ArrayList<String>) info[4];
        ArrayList<String> courses = (ArrayList<String>) info[5];

        this.interstPanel.setVisible(intersts.size() > 0);
        this.interestTitle.setVisibile(intersts.size() > 0);
        this.attributesPanel.setVisible(attributes.size() > 1);
        this.attributesTitle.setVisibile(attributes.size() > 1);
        this.coursesPanel.setVisible(courses.size() > 1);
        this.coursesTitle.setVisibile(courses.size() > 1);

        for (Label interstsLabel : interstsLabels) {
            this.interstPanel.remove(interstsLabel.getLabel());
        }
        interstsLabels = new ArrayList<Label>();
        for (String interst : intersts) {
            Label label = new Label();
            label.createLabelCentered(40, 40, 40, 40, null, interst, Color.blue);
            label.setSize(100, 50);
            interstsLabels.add(label);
            this.interstPanel.add(label.getLabel());
        }


        for (Label attributesLabel : attributesLabels) {
            this.attributesPanel.remove(attributesLabel.getLabel());
        }
        attributesLabels = new ArrayList<Label>();
        for (String attribute : attributes) {
            Label label = new Label();
            label.createLabelCentered(40, 40, 40, 40, null, "atr", Color.blue);
            label.setSize(300, 50);
            label.setText(attribute);
            attributesLabels.add(label);
            this.attributesPanel.add(label.getLabel());
        }

        for (Label courseLabel : courseLabels) {
            this.coursesPanel.remove(courseLabel.getLabel());
        }
        courseLabels = new ArrayList<Label>();
        for (String course : courses) {
            Label label = new Label();
            label.createLabelCentered(40, 40, 40, 40, null, "crs", Color.blue);
            label.setSize(100, 50);
            label.setText(course);
            courseLabels.add(label);
            this.coursesPanel.add(label.getLabel());
        }
        //updates panel VVVVV
        this.panel.revalidate();

    }
}
