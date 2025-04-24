import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import java.awt.Point;

public class PaintSimulator extends JPanel implements Runnable {
    private Color brushColor = Color.BLUE; // initial color

    private ArrayList<Point> points = new ArrayList<Point>();   // stores color info
    private ArrayList<Color> colors = new ArrayList<Color>();   // stores coord info

    private Thread myThread;

    public void addPoint(int x, int y) {
        points.add(new Point(x, y)); // add
        colors.add(brushColor); // saved clr **associates point w/ color**
    }

    // JComponent automaticaly calls paint component
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < points.size(); i++) {
            Color c = colors.get(i);
            g.setColor(c); 
            Point p = points.get(i);
            g.fillOval(p.x - 10, p.y - 10, 30, 30);
        }
    }

    public void startMyThread() {
        myThread = new Thread(this);
        myThread.start();
    }

    @Override
    public void run() {
        while (myThread != null) {
            try {
                Thread.sleep(5000); // 5000 ms
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }

            if(brushColor == Color.BLUE) {
                brushColor = Color.RED;
            } 
            else {
                brushColor = Color.BLUE;
            }
        }
    }
}