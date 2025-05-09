import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements Runnable {
    private int width = 500;
    private int height = 500;
    
    private int initialSize = 35;
    private int sizeCap = 100;
    
    private ArrayList<Circle> circles = new ArrayList<>();
    
    EventHandler eventH = new EventHandler();
    Thread myThread;
    
    public MyPanel() {
        this.setPreferredSize(new Dimension(width, height));   
        this.addMouseListener(eventH);
        this.setFocusable(true);
    }
    
    public void startThread() {
        myThread = new Thread(this);
        myThread.start();
    }
    
    @Override
    public void run() {
        while (myThread != null) {
            update();
            repaint();
            try {
                Thread.sleep(16); 
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);        
    }
    
    // draws all circles
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        
        for (Circle c : circles) {
            g.fillOval(c.p.x, c.p.y, c.size, c.size);
        }
    }
    
    public void update() {
        for (Circle c : circles) {
            if (c.size < sizeCap) {
                c.size++;
            }
        }
    }    
    
    public void addCircle(int x, int y) {
        circles.add(new Circle(new Point(x, y), initialSize));
    }
    
    public class EventHandler extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY(); 
            addCircle(x, y);
        }
    }
    
    // inner class
    // make a separate object called circle
    class Circle {
        // attributes of
    	Point p;
        int size;
        Thread cThread;

        public Circle(Point p, int size) {
            this.p = p;
            this.size = size;
        }
    }
}
