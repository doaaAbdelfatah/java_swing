
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Calculator" );
        frame.setSize(400,350);

        JLabel label = new JLabel("Welcome to JAVA");
        JButton button = new JButton("Click me");
        JButton button2 = new JButton("+");
        JButton button3 = new JButton("=");
        JTextField textField =  new JTextField();

        frame.getContentPane().add(button, BorderLayout.SOUTH);
        frame.getContentPane().add(label, BorderLayout.NORTH);
        frame.getContentPane().add(button2 , BorderLayout.EAST);
        frame.getContentPane().add(button3 , BorderLayout.WEST);
        frame.getContentPane().add(textField );

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
