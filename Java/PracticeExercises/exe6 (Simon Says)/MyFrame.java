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
    // Frame Dimensions
    private int width = 1000, height = 500;

    // red, blue, green, orange
    // boxes to be detected
    private JPanel p1Box1, p1Box2, p1Box3, p1Box4;
    private JPanel spBox;
    private JPanel p2Box1, p2Box2, p2Box3, p2Box4;

    // buttons to be detected
    private JButton p1Submit, p1Clear;
    private JButton p2Submit, p2Clear;

    // labels to be detected
    private JLabel roundLabel, sp, player1, player2;

    // by default, player 1's turn first
    private boolean p1guessing = true, p2guessing = false;

    // for selected color checking
    private Color p1Color, p2Color;

    private int roundCount = 1;
    private int p1score = 0, p2score = 0;

    public MyFrame() {
        EventHandler handler = new EventHandler();

        // MyFrame properties
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setResizable(true);

        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        getContentPane().setBackground(Color.lightGray); // proper background setting...

        // Divided frame into 2 main panels
        JPanel titlePanel = new JPanel(new BorderLayout()); 
        JPanel gamePanel = new JPanel(new GridLayout(1, 3, 10, 0));
        
        // Title
        JPanel titleTop = new JPanel(new FlowLayout());
        JPanel titleBot = new JPanel(new FlowLayout());

        JLabel titleLabel = new JLabel("Simon Says Game");
        titleLabel.setFont(new Font("Cambria Math", Font.BOLD, 25));
        titleTop.add(titleLabel);

        roundLabel = new JLabel("Round " + roundCount);
        roundLabel.setFont(new Font("Cambria Math", Font.BOLD, 20));
        titleBot.add(roundLabel);

        titlePanel.add(titleTop, BorderLayout.NORTH);
        titlePanel.add(titleBot, BorderLayout.SOUTH);

        // Divide game panel into three panels
        JPanel column1 = new JPanel(new BorderLayout());
        
        JPanel column2 = new JPanel(new BorderLayout());
        
        JPanel column3 = new JPanel(new BorderLayout());
        

        gamePanel.add(column1);
        gamePanel.add(column2);
        gamePanel.add(column3);

        // Contents of Column 1
        JPanel p1Label = new JPanel(new FlowLayout());
        player1 = new JLabel("Player 1 - " + p1score);
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
        p1Clear.addActionListener(handler);
        
        p1Button.add(p1Submit);
        p1Button.add(p1Clear);

        column1.add(p1Button, BorderLayout. SOUTH);

        // Contents of Column 2
        JPanel spLabel = new JPanel(new FlowLayout());
        sp = new JLabel("Player 1's turn");
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
        player2 = new JLabel("Player 2 - " + p2score);
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
        p2Clear.addActionListener(handler);
        
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
            if(roundCount % 2 != 0) {
                if(p1guessing) {
                    if(e.getSource() == p1Box1) {
                        spBox.setBackground(Color.RED);
                        p1Color = Color.RED;
                        
                    }
                    else if(e.getSource() == p1Box2) {
                        spBox.setBackground(Color.BLUE);
                        p1Color = Color.BLUE;
                        
                    }
                    else if(e.getSource() == p1Box3) {
                        spBox.setBackground(Color.GREEN);
                        p1Color = Color.GREEN;
                        
                    }
                    else if(e.getSource() == p1Box4) {
                        spBox.setBackground(Color.ORANGE);
                        p1Color = Color.ORANGE;
                    }
                }

                if(p2guessing) {
                    if(e.getSource() == p2Box1) {
                        spBox.setBackground(Color.RED);
                        p2Color = Color.RED;
                        
                    }
                    else if(e.getSource() == p2Box2) {
                        spBox.setBackground(Color.BLUE);
                        p2Color = Color.BLUE;
                        
                    }
                    else if(e.getSource() == p2Box3) {
                        spBox.setBackground(Color.GREEN);
                        p2Color = Color.GREEN;
                        
                    }
                    else if(e.getSource() == p2Box4) {
                        spBox.setBackground(Color.ORANGE);
                        p2Color = Color.ORANGE;
                        
                    }
                    
                }
                
            } else if(roundCount % 2 == 0){
                if(p1guessing) {
                    if(e.getSource() == p1Box1) {
                        spBox.setBackground(Color.RED);
                        p1Color = Color.RED;
                        
                    }
                    else if(e.getSource() == p1Box2) {
                        spBox.setBackground(Color.BLUE);
                        p1Color = Color.BLUE;
                        
                    }
                    else if(e.getSource() == p1Box3) {
                        spBox.setBackground(Color.GREEN);
                        p1Color = Color.GREEN;
                        
                    }
                    else if(e.getSource() == p1Box4) {
                        spBox.setBackground(Color.ORANGE); 
                        p1Color = Color.ORANGE;
                    }
                }
                
                if(p2guessing) {
                    if(e.getSource() == p2Box1) {
                        spBox.setBackground(Color.RED);
                        p2Color = Color.RED;
                        
                    }
                    else if(e.getSource() == p2Box2) {
                        spBox.setBackground(Color.BLUE);
                        p2Color = Color.BLUE;
                        
                    }
                    else if(e.getSource() == p2Box3) {
                        spBox.setBackground(Color.GREEN);
                        p2Color = Color.GREEN;
                        
                    }
                    else if(e.getSource() == p2Box4) {
                        spBox.setBackground(Color.ORANGE);
                        p2Color = Color.ORANGE;
                        
                    }
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
            if(roundCount % 2 != 0) {
                if(p1guessing) {
                    if(e.getSource() == p1Submit) {
                        if (p1Color == null) {
                            return;
                        }
                        spBox.setBackground(Color.WHITE);
                        
                        p1guessing = false;
                        p2guessing = true;

                        sp.setText("Player 2's turn");
                    }
                    else if(e.getSource() == p1Clear) {
                        spBox.setBackground(Color.WHITE);
                    }
                }

                if(p2guessing) {
                    if (e.getSource() == p2Submit) {
                        if (p2Color == null) {
                            return;
                        }
                        spBox.setBackground(Color.WHITE);

                        if(p1Color == p2Color) {
                            p2score += 1;
                            player2.setText("Player 2 - " + p2score);
                        }

                        roundCount++;
                        roundLabel.setText("Round " + roundCount);
                    }
                    else if(e.getSource() == p2Clear) {
                        spBox.setBackground(Color.WHITE);
                    }
                }
            }

            else if(roundCount % 2 == 0)  {
                if(p1guessing) {
                    if(e.getSource() == p1Submit) {
                        if (p1Color == null) {
                            return;
                        }
                        spBox.setBackground(Color.WHITE);

                        if(p1Color == p2Color) {
                            p1score += 1;
                            player1.setText("Player 1 - " + p1score);
                        }
                        
                        roundCount++;
                        roundLabel.setText("Round " + roundCount);
                    }
                    else if(e.getSource() == p1Clear) {
                        spBox.setBackground(Color.WHITE);
                    }
                }

                if(p2guessing) {
                    if (e.getSource() == p2Submit) {
                        if (p2Color == null) {
                            return;
                        }
                        spBox.setBackground(Color.WHITE);

                        p1guessing = true;
                        p2guessing = false;

                        sp.setText("Player 1's turn");
                    }
                    else if(e.getSource() == p2Clear) {
                        spBox.setBackground(Color.WHITE);
                    }
                }
            }
        }
    }
}