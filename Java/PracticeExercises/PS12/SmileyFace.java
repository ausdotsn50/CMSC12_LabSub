// PS12 in CMSC 12: Fundamentals of Programming II

/*
PS description: 
    - Drawing a smiley face using Java's Graphics capabilities

Submitted by: 
    - Angela Denise Almazan
*/

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class SmileyFace extends JFrame {
    private int width = 500, height = 500;
    private SmileyPanel sPanel;

    public SmileyFace() {
        sPanel = new SmileyPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(width, height);
        setTitle("PS12: Smiley Face");  
        
        // getContentPane().setBackground(Color.YELLOW);

        add(sPanel);

        setVisible(true);
    }

    public class SmileyPanel extends JPanel {
        public SmileyPanel() {
            JLabel label = new JLabel("Hi Ma'am Bea!");
            add(label);
            setBackground(new Color(200, 200, 237)); 
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.WHITE);
            // face
            g.fillOval(100, 80, 300, 300);

            g.setColor(Color.BLACK);
            // eyes
            g.fillOval(180, 180, 30, 30);
            g.fillOval(300, 180, 30, 30);

            // nose
            g.drawLine(250, 225, 250, 260);

            // mouth
            g.fillArc(180, 200,150, 150, 0, -180);            
        }
    }

    public static void main(String[] args) {
        new SmileyFace();
    }
}
