import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
    private PaintSimulator ps; // panel
    private EventHandler eh; // event handler

    public MyFrame() {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Paint Component Simulator");
        
        ps = new PaintSimulator();
        eh = new EventHandler();

        add(ps); // uses BorderLayout, in Center
        ps.addMouseMotionListener(eh);

        setVisible(true);
        ps.startMyThread();
    }

    // using only few methods
    // extend adapter class instead
    private class EventHandler extends MouseAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            // get points
            int x = e.getX();
            int y = e.getY(); 

            ps.addPoint(x, y);
            repaint();
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}