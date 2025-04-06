// PS9 in CMSC 12: Fundamentals of Programming II

/*
PS description: 
    - Creating skeleton GUI for Slambook.java by exploring jawa.awt & javax.swing

Submitted by: 
    - Angela Denise Almazan
*/

// import javax.swing.BorderFactory;
// import javax.swing.ButtonGroup;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Slambook {
    public static JPanel entryPanel(JLayeredPane layeredPane, int y_coord) {
        JPanel panel = new JPanel();
        panel.setLayout(null);  // absolute positioning fix
        panel.setBounds(125, y_coord, 600, 45);
        panel.setOpaque(false);
        // panel.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        layeredPane.add(panel, Integer.valueOf(1));
        return panel;
    }

    public static void entryLabel(JPanel panel, String entryType) {
        JLabel label = new JLabel(entryType);
        label.setBounds(10, 7, 100, 30);
        // label.setBorder(BorderFactory.createLineBorder(Color.yellow));
        panel.add(label);
    }

    public static void entryField(JPanel panel) {
        JTextField field = new JTextField();
        field.setBounds(130, 8, 450, 30);
        // field.setBorder(BorderFactory.createLineBorder(Color.red));
        panel.add(field);
    }

    public static void genderCheckBox(JPanel panel, String boxType, int x_coord, int width) {
        JCheckBox genderCheckBox = new JCheckBox(boxType);
        genderCheckBox.setBounds(x_coord, 7, width, 30);
        genderCheckBox.setOpaque(false);
        panel.add(genderCheckBox);
    }

    public static void main(String[] args) {
        // reuse
        int frameWidth = 800, frameHeight = 600;
        int titleFontSize = 25;

        // macos no icon fix from stackoverflow thread
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            UIManager.put("swing.boldMetal", Boolean.FALSE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame.setDefaultLookAndFeelDecorated(true);

        // frame properties
        JFrame frame = new JFrame("Slambook");
        frame.setSize(frameWidth, frameHeight);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // adding icon
        ImageIcon icon = new ImageIcon("images/icon.png");
        frame.setIconImage(icon.getImage());

        /* 
            JLayeredPane adds depth to a JFC/Swing container, 
            allowing components to overlap each other when needed. 
            An Integer object specifies each component's depth in the container, 
            where higher-numbered components sit "on top" of other components.
        */

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(frameWidth, frameHeight));
        layeredPane.setLayout(null); // absolute positioning fix

        // adding background image
        ImageIcon backgroundImage = new ImageIcon("images/background.png");
        JLabel background = new JLabel(backgroundImage);
        background.setBounds(0, 0, frameWidth, frameHeight);
        layeredPane.add(background, Integer.valueOf(0)); // lowest layer

        // adding title label
        JLabel titleLabel = new JLabel("S L A M B O O K", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Cambria Math", Font.BOLD, titleFontSize));
        titleLabel.setForeground(Color.DARK_GRAY);
        titleLabel.setBounds(275, 10, 250, 50);
        // titleLabel.setBorder(BorderFactory.createLineBorder(Color.black));

        layeredPane.add(titleLabel, Integer.valueOf(1)); // adding title label to layered pane

        // This is the name panel
        JPanel namePanel = entryPanel(layeredPane, 80);
        entryLabel(namePanel, "Name: ");
        entryField(namePanel);

        // This is the age panel
        JPanel agePanel = entryPanel(layeredPane, 140);
        entryLabel(agePanel, "Age: ");
        entryField(agePanel);

        // This is the gender panel
        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(null);  // absolute positioning fix
        genderPanel.setBounds(125, 200, 600, 45);
        genderPanel.setOpaque(false);
        // genderPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        layeredPane.add(genderPanel, Integer.valueOf(1));

        entryLabel(genderPanel, "Gender: ");
        genderCheckBox(genderPanel, "Male", 130, 55);
        genderCheckBox(genderPanel, "Female", 210, 70);
        genderCheckBox(genderPanel, "Rather not say", 307, 120);
        
        // This is the crush panel
        JPanel crushPanel = entryPanel(layeredPane, 260);
        entryLabel(crushPanel, "Crush: ");
        entryField(crushPanel);

        /* 
        favorite Movie: " + person.get(i).getFavMovie());    
        System.out.println("Favorite Color: " + person.get(i).getFavColor());    
        System.out.println("Favorite Subject: " + person.get(i).getFavSub());
        System.out.println("Motto:
        */
        
        // This is the favorite movie panel
        JPanel favMoviePanel = entryPanel(layeredPane, 320);
        entryLabel(favMoviePanel, "Favorite Movie: ");
        entryField(favMoviePanel);

        // This is the favorite color panel
        JPanel favColorPanel = entryPanel(layeredPane, 380);
        entryLabel(favColorPanel, "Favorite Color: ");
        entryField(favColorPanel);

        // This is the favorite subject panel
        JPanel favSubject = entryPanel(layeredPane, 440);
        entryLabel(favSubject, "Favorite Subject: ");
        entryField(favSubject);

        JButton submitButton = new JButton("Submit Entry");
        submitButton.setLayout(null);  // absolute positioning fix
        submitButton.setBounds(335, 500, 120, 20);
        // genderPanel.setOpaque(false);
        layeredPane.add(submitButton, Integer.valueOf(1));

        frame.setContentPane(layeredPane);
        frame.setVisible(true);
    }
}
