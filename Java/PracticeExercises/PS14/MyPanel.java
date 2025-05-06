import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyPanel extends JPanel {
    private int width = 800, height = 600;

    private JPanel entryPanel;
    private JLabel subTitle;

    private JLabel nameLabel;
    private JTextField nameField;

    private JLabel ageLabel;
    private JTextField ageField;

    private JLabel genderLabel;

    private JLabel crushLabel;
    private JTextField crushField;

    private JLabel favMovieLabel;
    private JTextField favMovieField;

    private JLabel favColorLabel;
    private JTextField favColorField;

    private JLabel favSubLabel;
    private JTextField favSubField;

    private EventHandler eh;
    private File sbFile;

    private FileReader fr;
    private BufferedReader br;
    private FileWriter fw;
    
    private JPanel genderCheckBoxPanel;
    private JCheckBox box1;
    private JCheckBox box2;
    private JCheckBox box3;

    private int totalEntries = 0;
    
    public MyPanel() {
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(new BorderLayout());

        eh = new EventHandler();
        sbFile = new File("Entry.txt");

        System.out.println(countEntries());

        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.PINK);
        titlePanel.setLayout(new BorderLayout());

        
        JLabel title = new JLabel("My Slambook", JLabel.CENTER);
        title.setFont(new Font("Cambria Math", Font.BOLD, 30));
        title.setForeground(Color.BLACK);
        titlePanel.add(title, BorderLayout.NORTH);

        subTitle = new JLabel("This slambook has " + totalEntries + " entries. Add yours now!", JLabel.CENTER);
        subTitle.setFont(new Font("Cambria Math", Font.BOLD, 20));
        subTitle.setForeground(Color.BLACK);
        titlePanel.add(subTitle, BorderLayout.SOUTH);
        
        entryPanel = new JPanel();
        entryPanel.setBackground(Color.GRAY);
        entryPanel.setLayout(new GridLayout(7, 2));

        nameLabel = createEntryLabels(nameLabel, "Name: ");
        nameField = createEntryField(nameField);

        ageLabel = createEntryLabels(ageLabel, "Age: ");
        ageField = createEntryField(ageField);

        genderLabel = createEntryLabels(genderLabel, "Gender: ");

        genderCheckBoxPanel = new JPanel();
        genderCheckBoxPanel.setLayout(new GridLayout(1, 3));
        genderCheckBoxPanel.setOpaque(false);
        
        box1 = createCheckBox(box1, "Male");
        box2 = createCheckBox(box2, "Female");
        box3 = createCheckBox(box3, "Rather Not Say");

        genderCheckBoxPanel.add(box1);
        genderCheckBoxPanel.add(box2);
        genderCheckBoxPanel.add(box3);

        entryPanel.add(genderCheckBoxPanel);

        crushLabel = createEntryLabels(crushLabel, "Crush: ");
        crushField = createEntryField(crushField);

        favMovieLabel = createEntryLabels(favMovieLabel, "Favorite Movie: ");
        favMovieField = createEntryField(favMovieField);

        favColorLabel  = createEntryLabels(favColorLabel, "Favorite Color: ");
        favColorField = createEntryField(favColorField);

        favSubLabel = createEntryLabels(favSubLabel, "Favorite Subject: ");
        favSubField = createEntryField(favSubField);

        JPanel botPanel = new JPanel();
        botPanel.setBackground(Color.PINK);

        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(200, 50));
        submitButton.addActionListener(eh);
        
        botPanel.add(submitButton);

        this.add(titlePanel, BorderLayout.NORTH);
        this.add(entryPanel, BorderLayout.CENTER);
        this.add(botPanel, BorderLayout.SOUTH);
    }

    public JLabel createEntryLabels(JLabel label, String text) {
        label = new JLabel(text, JLabel.RIGHT);
        label.setFont(new Font("Cambria Math", Font.PLAIN, 20));
        label.setForeground(Color.BLACK);
        entryPanel.add(label);
        return label;
    }

    public JTextField createEntryField(JTextField field) {
        field = new JTextField();
        entryPanel.add(field);
        return field;
    }

    public JCheckBox createCheckBox(JCheckBox cBox, String label) {
        cBox = new JCheckBox(label);
        genderCheckBoxPanel.add(cBox);
        return cBox;
    }

    public class EventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveEntry();
            totalEntries++;
            subTitle.setText("New entry added! New number of entries: " + totalEntries);
        }
    }

    public void saveEntry() {
        // try and catch statement
        try {
            if(sbFile.createNewFile()) {
                System.out.println("Successfully created file");
            }
            else {
                System.out.println("File already exists");
            }

            fw = new FileWriter(sbFile, true);
            
            fw.write("Name: " + nameField.getText() + "\n");
            fw.write("Age: " + ageField.getText() + "\n");
            
            if(box1.isSelected() && box2.isSelected() && box3.isSelected()) {
                fw.write("Gender: Error, multiple boxes selected\n");
            }
            else if(box1.isSelected()) {
                fw.write("Gender: Male");
            }
            else if(box2.isSelected()) {
                fw.write("Gender: Male");
            }
            else if (box3.isSelected()) {
                fw.write("Gender: Rather Not Says");
            }

            fw.write("Crush: " + crushField.getText() + "\n");
            fw.write("Favorite Movie: " + favMovieField.getText() + "\n");
            fw.write("Favorite Color: " + favColorField.getText() + "\n");
            fw.write("Favorite Subject: " + favSubField.getText() + "\n");
            fw.write("---\n");

            fw.flush();
            fw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public int countEntries() {
        try {
            if(sbFile.createNewFile()) {
                System.out.println("Successfully created file");
            }
            else {
                System.out.println("File already exists");
            }

            fr = new FileReader(sbFile);
            br = new BufferedReader(fr);
            
            String s;
            
            while((s = br.readLine()) != null) {
                if(s.equals("---")) {
                    totalEntries ++;
                }
            }   

            fr.close();
            br.close();

        } catch(IOException e) {
            e.printStackTrace();
        }

        return totalEntries;
    }
}

