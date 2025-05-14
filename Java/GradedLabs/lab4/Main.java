import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Laboratory Exercise");
        
        MyPanel myPanel = new MyPanel(); // JPanel
        frame.add(myPanel);
        frame.pack(); // fits the preferred size of its subcomponents 

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        myPanel.startThread();
    }
}
