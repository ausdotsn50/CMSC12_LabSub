import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class GraphicsExample extends JFrame {
    private MyPanel myPanel;

    public GraphicsExample() {
        EventHandler eh = new EventHandler();
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        myPanel = new MyPanel();
        add(myPanel); // uses BorderLayout, in Center
        myPanel.addMouseMotionListener(eh);

        setVisible(true);
    }

    // using only few methods
    // extend adapter class instead
    public class EventHandler extends MouseAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            // get points
            int x = e.getX();
            int y = e.getY(); 

            // pass to my panel
            myPanel.setX(x);
            myPanel.setY(y);

            // repaint for every x and y passed
            repaint();
        }
    }
}