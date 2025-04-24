import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import java.awt.Point;

public class MyPanel extends JPanel {
    private ArrayList<Point> points = new ArrayList<Point>();
    private int x, y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    // JComponent automaticaly calls paint component
    @Override
    public void paintComponent(Graphics g) {
        points.add(new Point(x, y)); // add
        if(x > 0 && y > 0) {
            g.setColor(Color.BLACK);

            for(Point i : points) {
                g.fillOval(i.x - 10, i.y - 10, 30, 30);
            }
        }
    }
}