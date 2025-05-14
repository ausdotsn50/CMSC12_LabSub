import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
    public MyFrame() {
        final int WIDTH = 1000, HEIGHT = 500;

        // MyFrame properties
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setResizable(true);

        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(Color.lightGray); // proper background setting...

        // Divided frame into 2 main panels
        JPanel titlePanel = new JPanel(new FlowLayout()); 
        JPanel gamePanel = new JPanel(new GridLayout(1, 3, 10, 0));
        
        // Title
        JLabel titleLabel = new JLabel("Simon Says Game");
        titleLabel.setFont(new Font("Cambria Math", Font.BOLD, 25));
        titlePanel.add(titleLabel);

        // Divide game panel into three panels
        JPanel column1 = new JPanel(new BorderLayout());
        column1.setBackground(Color.YELLOW);
        JPanel column2 = new JPanel(new BorderLayout());
        column2.setBackground(Color.RED);
        JPanel column3 = new JPanel(new BorderLayout());
        column3.setBackground(Color.BLUE);

        gamePanel.add(column1);
        gamePanel.add(column2);
        gamePanel.add(column3);

        // Contents of Column 1
        JPanel p1Label = new JPanel(new FlowLayout());
        JLabel player1 = new JLabel("Player 1");
        player1.setFont(new Font("Cambria Math", Font.BOLD, 12));
        p1Label.add(player1);
        column1.add(p1Label, BorderLayout. NORTH);

        // code for boxes
        // Main box
        JPanel p1Box = new JPanel(new GridLayout(2, 2, 0, 0));

        JPanel p1Box1 = new JPanel();
        p1Box1.setBackground(Color.RED);
        JPanel p1Box2 = new JPanel();
        p1Box2.setBackground(Color.BLUE);
        JPanel p1Box3 = new JPanel();
        p1Box3.setBackground(Color.GREEN);
        JPanel p1Box4 = new JPanel();
        p1Box4.setBackground(Color.ORANGE);

        p1Box.add(p1Box1);
        p1Box.add(p1Box2);
        p1Box.add(p1Box3);
        p1Box.add(p1Box4);

        column1.add(p1Box, BorderLayout. CENTER);

        JPanel p1Button = new JPanel(new FlowLayout());
    
        JButton p1Submit = new JButton("Submit");
        JButton p1Clear = new JButton("Clear");
        
        p1Button.add(p1Submit);
        p1Button.add(p1Clear);

        column1.add(p1Button, BorderLayout. SOUTH);

        // Contents of Column 2
        JPanel spLabel = new JPanel(new FlowLayout());
        JLabel sp = new JLabel("Show Panel");
        sp.setFont(new Font("Cambria Math", Font.BOLD, 12));
        spLabel.add(sp);
        column2.add(spLabel, BorderLayout. NORTH);

        JPanel spBox = new JPanel(new FlowLayout());
        spBox.setBackground(Color.white);

        column2.add(spBox, BorderLayout. CENTER);

        JPanel spButton = new JPanel(new FlowLayout());
    
        JButton spPlay = new JButton("Play");
        spButton.add(spPlay);
        
        column2.add(spButton, BorderLayout. SOUTH);

        // Contents for Column 3
        JPanel p2Label = new JPanel(new FlowLayout());
        JLabel player2 = new JLabel("Player 2");
        player2.setFont(new Font("Cambria Math", Font.BOLD, 12));
        p2Label.add(player2);
        column3.add(p2Label, BorderLayout. NORTH);

        JPanel p2Box = new JPanel(new GridLayout(2, 2, 0, 0));

        JPanel p2Box1 = new JPanel();
        p2Box1.setBackground(Color.RED);
        JPanel p2Box2 = new JPanel();
        p2Box2.setBackground(Color.BLUE);
        JPanel p2Box3 = new JPanel();
        p2Box3.setBackground(Color.GREEN);
        JPanel p2Box4 = new JPanel();
        p2Box4.setBackground(Color.ORANGE);

        p2Box.add(p2Box1);
        p2Box.add(p2Box2);
        p2Box.add(p2Box3);
        p2Box.add(p2Box4);

        column3.add(p2Box, BorderLayout. CENTER);

        JPanel p2Button = new JPanel(new FlowLayout());
    
        JButton p2Submit = new JButton("Submit");
        JButton p2Clear = new JButton("Clear");
        
        p2Button.add(p2Submit);
        p2Button.add(p2Clear);

        column3.add(p2Button, BorderLayout. SOUTH);

        add(titlePanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);

        setVisible(true);
    }
}