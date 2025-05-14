import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Exam");

        Panel panel = new Panel();
        frame.add(panel);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // what will be excuted when the JFrame is closed
                // call a panel method here
                panel.saveData();
            } 
        });

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        panel.startThread();
    }
}

/* 
// frame.addWindowListener(new WindowAdapter() {
    // loguc to saing to the file
    public void windowClosing(WindowEvent e) {

    }
});

int i = Integer.parsetInt(s);
Strign tokens[] = s.split(" ");
*/