import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable {
    private int screenSize = 500;
    
    private int defaultSize = 20;

    private ArrayList<Circle> circles = new ArrayList<Circle>();
    private EventHandler eventH;

    private Thread myThread;
    public Panel() {
        readData();
        // pass it to circles

        this.setPreferredSize(new Dimension(screenSize, screenSize));
        this.setFocusable(true);

        eventH = new EventHandler();
        this.addMouseListener(eventH);
    }

    // start the Thread
    public void startThread() {
        myThread = new Thread(this);
        myThread.start();
    }

    // implement the function run from Runnable -> the ThreadJob
    public void run() {
        while (myThread != null) {
            repaint();
            try {
                Thread.sleep(16); // roughly 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // paint your panel here
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        // draw the circles created here
        for (Circle c : circles) {
            g.fillOval(c.p.x, c.p.y, c.size, c.size);
        }
    }

    // add new circle -> call when mouse clicked
    public void addCircle(int x, int y, boolean down) {
        circles.add(new Circle(new Point(x, y), defaultSize, down));
    }

    // Event Handler
    public class EventHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            addCircle(x, y, true); // this is the default
        }
    }

    public void readData() {
        // read from the file
        circles.clear();
        File myFile = new File("Points.txt");
        try {
            if(myFile.createNewFile()) {
                System.out.println("Successfully created a file.");
            }
            else {
                System.out.println("File already exists");
            }

            FileReader fileReader = new FileReader(myFile);
            BufferedReader buffReader = new BufferedReader(fileReader);
            
            String s;
            while((s = buffReader.readLine()) != null) {
                String tokens[] = s.split(" ");
                if(tokens[2].equals("true")) {
                    addCircle(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), true);
                }
                else if(tokens[2].equals("false")) {
                    addCircle(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), false);
                }
            }

            buffReader.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }        
    }

    public void saveData() {
        File myFile = new File("Points.txt");
        try {
            if(myFile.createNewFile()) {
                System.out.println("Successfully created a file.");
            }
            else {
                System.out.println("File already exists");
            }

            FileWriter fw = new FileWriter(myFile);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(Circle c : circles) {
                bw.write("" + c.p.x + " " + c.p.y + " " + "" + c.isGoingDown);
                bw.write("\n");
            }
        
            bw.flush();
            bw.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    // circle class
    class Circle implements Runnable {
        Point p;
        int size;
        Thread cThread;

        // defaults
        int speed = 2;
        boolean isGoingDown;
        
        // whatever boolean you placed there
        public Circle(Point p, int size, boolean isGoingDown) {
            this.p = p;
            this.size = size;
            this.isGoingDown = isGoingDown;
            this.speed = isGoingDown ? speed : -speed; // set direction based on saved value -> my error (no checking)
            cThread = new Thread(this);
            cThread.start();
        }

        @Override
        public void run() {
            // write code for update here
            while(cThread != null) {
                if(isGoingDown && p.y + speed > screenSize - size) {
                    isGoingDown = false;
                    speed = -speed;   
                }
                
                if(!isGoingDown && p.y + speed < 0) {
                    isGoingDown = true;
                    speed = -speed;
                }

                p.y += speed;

                // schedule
                try {
                    Thread.sleep(16);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}