package FrameworksDrivers;
import InterfaceAdapters.OtherAccountPresenter;
import FrameworksDrivers.UIElements.Label;
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
    public OtherAccount(JPanel masterPanel, CardLayout layout) {
        this.masterPanel = masterPanel;
        this.layout = layout;

        //Add ur code for your panel below VVVVV
        this.panel = new JPanel();
        this.panel.setLayout(new GridLayout(2, 0));

        JPanel upper = new JPanel();
        upper.setBackground(Color.blue);

        JPanel lower = new JPanel();


        Label nameLabel = new Label();
        nameLabel.createLabelCentered(40, 40, 40, 40, null, "Name", Color.blue);
        Label locationLabel = new Label();
        locationLabel.createLabelCentered(40, 40, 40, 40, null, "location", Color.blue);
        JPanel topInfo = new JPanel();
        topInfo.setPreferredSize(new Dimension(600, 100));
        topInfo.setLayout(new GridLayout(1, 2));
        topInfo.setBackground(Color.red);
        topInfo.add(nameLabel.getLabel());
        topInfo.add(locationLabel.getLabel());
        lower.add(topInfo);

        JPanel botInfo = new JPanel();
        botInfo.setPreferredSize(new Dimension(450, 250));
        botInfo.setLayout(new GridLayout(0, 1));
        botInfo.setBackground(Color.yellow);
        Label biography = new Label();
        biography.createLabel(40, 40, 40, 40, botInfo, "bio", Color.blue);
        //biography.getLabel().setText("<html>"+ "IVEL OVBIRDS I ReALLY LOVE BIRSDS??? DPNT IU :OVE BRIDS BIDS BIRDS BNIRFDS FUCK DUCKS GOOSE GEESE BIRDS" +"</html>");
        lower.add(botInfo);


        this.panel.add(upper);
        this.panel.add(lower);

        //Button newButton = new Button();
        //newButton.createButton(this.panel, "shot", 50, 50, 50, 50);
        //newButton.getButton().addActionListener(this);
        this.masterPanel.add(this.panel, "otherAccount");
    }


    public void sendPaths(Object[] paths) {
        //gets paths to other pages
        this.paths = paths;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //create presenter

        OtherAccountPresenter presenter = new OtherAccountPresenter("dog");

        //this.paths[0] refers to te first path in the paths array, which is testAccount.
        presenter.updatePage("testAccount", this.paths[0]);

        //switches the panel
        this.layout.show(this.masterPanel, "testAccount");

    }

    public void updatePage(Object[] info){
        this.name.getLabel().setText((String) info[0]);
        this.bio.getLabel().setText((String) info[1]);
        this.bio.getLabel().setText((String) info[2]);

        //updates panel VVVVV
        this.panel.revalidate();
    }

}



//zzz