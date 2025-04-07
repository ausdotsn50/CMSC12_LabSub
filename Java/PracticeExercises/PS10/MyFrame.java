import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class MyFrame extends JFrame {
    public MyFrame() {
        int width = 300;
        int height = 450;

        // Frame properties
        setTitle("Calculator");
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // adding margin to top panel
        // outer top panel
        JPanel topWrapper = new JPanel();
        // topWrapper.setBackground(Color.RED);
        addPanelMargin(topWrapper, 10, 0);
    
        // inner top panel
        JPanel topPanel = new JPanel(new BorderLayout());
        
        // This is the textfield panel
        JPanel textPanel = new JPanel(new BorderLayout());
        JTextField textField = new JTextField();
        textPanel.add(textField, BorderLayout.CENTER); // stretches textfield
        
        // top panel contains text panel
        topPanel.add(textPanel, BorderLayout.NORTH);

        // This is the backspace and clear panel
        JPanel bcPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        JPanel backPanel = new JPanel(new BorderLayout());
        JPanel clearPanel = new JPanel(new BorderLayout());

        JButton backButton = new JButton("Backspace");
        JButton clearButton = new JButton("Clear");
        
        backPanel.add(backButton, BorderLayout.CENTER); // stretches button
        clearPanel.add(clearButton, BorderLayout.CENTER);

        bcPanel.add(backPanel);
        bcPanel.add(clearPanel);
        
        // top panel contains backspace and clear panel
        topPanel.add(bcPanel, BorderLayout.SOUTH);
    
        topWrapper.add(topPanel, BorderLayout.CENTER);

        JPanel buttonWrapper = new JPanel();
        // buttonWrapper.setBackground(Color.BLACK);
        addPanelMargin(buttonWrapper, 0, 0);

        JPanel buttonsPanel = new JPanel(new GridLayout(4, 4, 5, 5)); 

        String[] calcButtons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String button : calcButtons) {
            JButton btn = new JButton(button); // JButton for String array elements
            buttonsPanel.add(btn);
        }

        buttonWrapper.add(buttonsPanel, BorderLayout.CENTER);

        JPanel botWrapper = new JPanel();
        // botWrapper.setBackground(Color.PINK);
        addPanelMargin(botWrapper, 0, 0);

        JPanel labelPanel = new JPanel(new FlowLayout());

        JLabel label = new JLabel("CMSC 12 Practice Laboratory :)");
        labelPanel.add(label);
        botWrapper.add(labelPanel);
    
        // Add to frame
        add(topWrapper, BorderLayout.NORTH);
        add(buttonWrapper, BorderLayout.CENTER);
        add(botWrapper, BorderLayout.SOUTH);

        setVisible(true);
    }

    public JPanel addPanelMargin(JPanel wrapper, int top, int bot) {
        wrapper.setLayout(new BorderLayout());
        wrapper.setBorder(new EmptyBorder(top, 10, bot, 10));
        return wrapper;
    }
}
