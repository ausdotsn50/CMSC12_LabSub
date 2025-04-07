import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MyFrame extends JFrame {
    // red, blue, green, orange
    private JPanel p1Box1, p1Box2, p1Box3, p1Box4;
    private JPanel spBox;
    private JPanel p2Box1, p2Box2, p2Box3, p2Box4;

    private JButton p1Submit, p1Clear;
    private JButton p2Submit, p2Clear;

    // by default, player 1's turn first
    private boolean player1 = true, player2 = false;

    // for selected color checking
    private Color p1Color, p2Color;

    private int score = 0;

    public MyFrame() {
        EventHandler handler = new EventHandler();
        int width = 1000, height = 500;

        // MyFrame properties
        setSize(width, height);
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
        
        JPanel column2 = new JPanel(new BorderLayout());
        
        JPanel column3 = new JPanel(new BorderLayout());
        

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

        // Player 1 boxes
        p1Box1 = new JPanel();
        p1Box1.setBackground(Color.RED);

        p1Box2 = new JPanel();
        p1Box2.setBackground(Color.BLUE);

        p1Box3 = new JPanel();
        p1Box3.setBackground(Color.GREEN);

        p1Box4 = new JPanel();
        p1Box4.setBackground(Color.ORANGE);

        p1Box.add(p1Box1);
        p1Box.add(p1Box2);
        p1Box.add(p1Box3);
        p1Box.add(p1Box4);

        column1.add(p1Box, BorderLayout. CENTER);

        // Event handlers
        p1Box1.addMouseListener(handler);
        p1Box2.addMouseListener(handler);
        p1Box3.addMouseListener(handler);
        p1Box4.addMouseListener(handler);
        
        JPanel p1Button = new JPanel(new FlowLayout());
        
        // P1 submit and clear
        p1Submit = new JButton("Submit");
        p1Submit.addActionListener(handler); // action listener for submit
        p1Clear = new JButton("Clear");
        
        p1Button.add(p1Submit);
        p1Button.add(p1Clear);

        column1.add(p1Button, BorderLayout. SOUTH);

        // Contents of Column 2
        JPanel spLabel = new JPanel(new FlowLayout());
        JLabel sp = new JLabel("Show Panel");
        sp.setFont(new Font("Cambria Math", Font.BOLD, 12));
        spLabel.add(sp);
        column2.add(spLabel, BorderLayout. NORTH);

        spBox = new JPanel(new FlowLayout());
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

        p2Box1 = new JPanel();
        p2Box1.setBackground(Color.RED);

        p2Box2 = new JPanel();
        p2Box2.setBackground(Color.BLUE);

        p2Box3 = new JPanel();
        p2Box3.setBackground(Color.GREEN);

        p2Box4 = new JPanel();
        p2Box4.setBackground(Color.ORANGE);

        p2Box.add(p2Box1);
        p2Box.add(p2Box2);
        p2Box.add(p2Box3);
        p2Box.add(p2Box4);

        column3.add(p2Box, BorderLayout. CENTER);

        p2Box1.addMouseListener(handler);
        p2Box2.addMouseListener(handler);
        p2Box3.addMouseListener(handler);
        p2Box4.addMouseListener(handler);
        
        JPanel p2Button = new JPanel(new FlowLayout());
    
        p2Submit = new JButton("Submit");
        p2Submit.addActionListener(handler); // action listener for submit
        p2Clear = new JButton("Clear");
        
        p2Button.add(p2Submit);
        p2Button.add(p2Clear);

        column3.add(p2Button, BorderLayout. SOUTH);

        add(titlePanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public class EventHandler implements ActionListener, MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            // red, blue, green, orange
            if(player1) {
                if(e.getSource() == p1Box1) {
                    spBox.setBackground(Color.RED);
                    System.out.println("Player 1 clicked red");
                    p1Color = Color.RED;
                    
                }
                else if(e.getSource() == p1Box2) {
                    spBox.setBackground(Color.BLUE);
                    System.out.println("Player 1 clicked blue");
                    p1Color = Color.BLUE;
                    
                }
                else if(e.getSource() == p1Box3) {
                    spBox.setBackground(Color.GREEN);
                    System.out.println("Player 1 clicked green");
                    p1Color = Color.GREEN;
                    
                }
                else if(e.getSource() == p1Box4) {
                    spBox.setBackground(Color.ORANGE);
                    System.out.println("Player 1 clicked orange");   
                    p1Color = Color.ORANGE;
                }
            }

            if(player2) {
                if(e.getSource() == p2Box1) {
                    spBox.setBackground(Color.RED);
                    System.out.println("Player 2 clicked red");
                    p2Color = Color.RED;
                    
                }
                else if(e.getSource() == p2Box2) {
                    spBox.setBackground(Color.BLUE);
                    System.out.println("Player 2 clicked blue");
                    p2Color = Color.BLUE;
                    
                }
                else if(e.getSource() == p2Box3) {
                    spBox.setBackground(Color.GREEN);
                    System.out.println("Player 2 clicked green");
                    p2Color = Color.GREEN;
                    
                }
                else if(e.getSource() == p2Box4) {
                    spBox.setBackground(Color.ORANGE);
                    System.out.println("Player 2 clicked orange");  
                    p2Color = Color.ORANGE;
                    
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == p1Submit) {
                // when submitting null, it does not proceed to line of code
                if (p1Color == null) {
                    System.out.println("Player 1 must choose a color first!");
                    return;
                }

                player1 = false;
                player2 = true;
                spBox.setBackground(Color.WHITE);
                System.out.println("Player 2's turn!");
            }

            if (e.getSource() == p2Submit) {
                if (p2Color == null) {
                    System.out.println("Player 2 must choose a color first!");
                    return;
                }

                player1 = true;
                player2 = false;
                spBox.setBackground(Color.WHITE);

                if (p1Color == p2Color) {
                    score += 1;
                    System.out.println("Round won! Updated Score: " + score);
                } else {
                    System.out.println("Round lost!");
                }

                // Resets for next round
                p1Color = null;
                p2Color = null;
            }
        }

    }

}