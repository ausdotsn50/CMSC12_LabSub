/* 
 * FEATURES TO IMPROVE
 * 
 * Follows MDAS
 * Only one decimal point per number
 * If decimal rightmost all 0, format as just an integer instead
 * 
 * note: code still contains bugs
 * note: textField focusable, click textField to make use of key inputs
*/
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class MyFrame extends JFrame {
    private JButton backButton, clearButton;

    private JTextField textField;

    // Jbutton to be stored in this order
    // necessary
    private String[] calcButtonsLabel = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", ".", "=", "+"
    };

    // to distinguish number and operator buttons
    // equal not placed in array but will serve special function
    private String[] operatorButtons = {"*", "/", "+", "-", "."}; // in MDAS format

    // array of all calculator buttons
    private JButton[] calcButtons = new JButton[calcButtonsLabel.length];

    public MyFrame() {
        int width = 300;
        int height = 450;

        // important for this lab: event handler
        EventHandler handler = new EventHandler();

        // Frame properties
        setTitle("Calculator");
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // adding margin to top panel
        // outer top panel
        JPanel topWrapper = new JPanel();
        // topWrapper.setBackground(Color.RED);
        addPanelMargin(topWrapper, 10, 0);
    
        // inner top panel
        JPanel topPanel = new JPanel(new BorderLayout());
        
        // This is the textfield panel
        JPanel textPanel = new JPanel(new BorderLayout());
        textField = new JTextField();
        textField.setEditable(false);

        // adding a key listener to text field
        // note: textfield is set to non editable
        textField.addKeyListener(handler);
        textField.setFocusable(true);
        textField.requestFocusInWindow();
        textPanel.add(textField, BorderLayout.CENTER); // stretches textfield
        
        // top panel contains text panel
        topPanel.add(textPanel, BorderLayout.NORTH);

        // This is the backspace and clear panel
        JPanel bcPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        JPanel backPanel = new JPanel(new BorderLayout());
        JPanel clearPanel = new JPanel(new BorderLayout());

        backButton = new JButton("Backspace");
        backButton.addActionListener(handler);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(handler);
        
        backPanel.add(backButton, BorderLayout.CENTER); // stretches button
        clearPanel.add(clearButton, BorderLayout.CENTER);

        bcPanel.add(backPanel);
        bcPanel.add(clearPanel);
        
        // top panel contains backspace and clear panel
        topPanel.add(bcPanel, BorderLayout.SOUTH);
    
        topWrapper.add(topPanel, BorderLayout.CENTER);

        JPanel buttonWrapper = new JPanel();
        // buttonWrapper.setBackground(Color.BLACK);
        addPanelMargin(buttonWrapper, 0, 0);

        JPanel buttonsPanel = new JPanel(new GridLayout(4, 4, 5, 5)); 

        // assign individual calcButtons via calcButtons label string name
        for(int i = 0; i < calcButtonsLabel.length; i++) {
            calcButtons[i] = new JButton(calcButtonsLabel[i]);
            buttonsPanel.add(calcButtons[i]);
            calcButtons[i].addActionListener(handler);
        }

        buttonWrapper.add(buttonsPanel, BorderLayout.CENTER);

        JPanel botWrapper = new JPanel();
        // botWrapper.setBackground(Color.PINK);
        addPanelMargin(botWrapper, 0, 0);

        JPanel labelPanel = new JPanel(new FlowLayout());

        JLabel label = new JLabel("CMSC 12 Practice Laboratory :)");
        labelPanel.add(label);
        botWrapper.add(labelPanel);
    
        // Add to frame
        add(topWrapper, BorderLayout.NORTH);
        add(buttonWrapper, BorderLayout.CENTER);
        add(botWrapper, BorderLayout.SOUTH);

        setVisible(true);
    }
    // inner class
    public class EventHandler implements ActionListener, KeyListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Todo
            // back and clear buttons
            if(e.getSource() == backButton) {
                /* stack overflow comment:
                 * In Java the substring() method works with the first parameter being inclusive and the second parameter being exclusive. 
                 * Meaning "Hello".substring(0, 2); will result in the string He.
                */
                backspaceFunction();
            }
            else if(e.getSource() == clearButton) {
                clearFunction();
            }

            // decimal point needs fixing still for buttonss
            for(int i = 0; i < calcButtons.length; i++) {
                if(e.getSource() == calcButtons[i]) {
                    /* from stackoverflow thread: Arrays.asList(yourArray).contains(yourValue) */
                    // this checks if the button checked is an operator or not
                    
                    // FIXED: cannot press operators consecutively
                    // used then button clicked is an operator
                    if(Arrays.asList(operatorButtons).contains(calcButtonsLabel[i])) {
                        
                        String[] currentText = textField.getText().split("(?<=[*/+-.])|(?=[*/+-.])");
                        int currentLength = currentText.length - 1;
                        
                        if(textField.getText().isEmpty() || Arrays.asList(operatorButtons).contains(currentText[currentLength])) { // currentText[currentLength] is the last element
                            return;
                        }

                        else {
                            textField.setText(textField.getText() + calcButtonsLabel[i]);
                        }
                        
                    }
                    // used when button click is the equal sign
                    else if(calcButtonsLabel[i].equals("=")) {
                        if(textField.getText().isEmpty()) {
                            return;
                        }
                        double result = evaluateExpression(textField.getText()); // fix for MDAS
                        textField.setText("" + result);
                    }
                    // used when button clicked are numbers
                    else {
                        textField.setText(textField.getText() + calcButtonsLabel[i]);
                    }   
                }
            }
        }

        @Override
        
        public void keyTyped(KeyEvent e) {
            char getChar = e.getKeyChar();
            String charTyped = String.valueOf(getChar); // converts ch to String: https://www.digitalocean.com/community/tutorials/convert-char-to-string-java
            
            if(Arrays.asList(calcButtonsLabel).contains(charTyped)) {
                if(Arrays.asList(operatorButtons).contains(charTyped)) {
                        
                    String[] currentText = textField.getText().split("(?<=[*/+-.])|(?=[*/+-.])");
                    int currentLength = currentText.length - 1;
                    
                    if(textField.getText().isEmpty() || Arrays.asList(operatorButtons).contains(currentText[currentLength])) { // currentText[currentLength] is the last element
                        return;
                    }
                    else {
                        textField.setText(textField.getText() + charTyped);
                    }
                }
                else if(charTyped.equals("=")) {
                    return;
                }
                else {
                    textField.setText(textField.getText() + charTyped);
                }  
            }
        }


        // to fix more in detail
        @Override
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            System.out.println(code);
        }

    
        @Override
        public void keyReleased(KeyEvent e) {
            
        }

    }

    // method
    public JPanel addPanelMargin(JPanel wrapper, int top, int bot) {
        wrapper.setLayout(new BorderLayout());
        wrapper.setBorder(new EmptyBorder(top, 10, bot, 10));
        return wrapper;
    }

    public double evaluateExpression(String expression) {
        // positive look around ?<=
        // positive look ahead ?=
        String[] tokens = expression.split("(?<=[-+*/])|(?=[-+*/])");
        
        // take the first token
        double result = Double.parseDouble(tokens[0]);

        for (int i = 1; i < tokens.length - 1; i += 2) {
            // the second token (operator)
            String op = tokens[i];
            double next = Double.parseDouble(tokens[i + 1]); // take the next num

            switch (op) {
                case "-": 
                    result -= next; 
                    break;
                case "+": 
                    result += next; 
                    break;
                case "*": 
                    result *= next; 
                    break;
                case "/": 
                    result /= next; 
                    break;
            }
        }
        return result;
    }

    public void backspaceFunction() {
        if(!textField.getText().isEmpty()) {
            textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
        }
    }

    public void clearFunction() {
        if(!textField.getText().isEmpty()) {
            textField.setText("");
        }
    }

}

/* 
 * https://stackoverflow.com/questions/3481828/how-do-i-split-a-string-in-java
*/
