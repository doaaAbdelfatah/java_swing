import javax.swing.*;
import java.awt.*;

public class Frame3 extends JFrame {
    public Frame3(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocation(350,100);
//        GridLayout gridLayout =new GridLayout(3,2 ,10,10);
//        this.setLayout(gridLayout);
        this.setLayout(new GridLayout(3,2 ,20,10));
        JButton button1 = new JButton("One");
        JButton button2 = new JButton("Two");
        JButton button3 = new JButton("Three");
        JButton button4 = new JButton("Four");
        JButton button5 = new JButton("Five");
        this.getContentPane().add(button1);
        this.getContentPane().add(button2);
        this.getContentPane().add(button3);
        this.getContentPane().add(button4);
        this.getContentPane().add(button5);

        this.getContentPane().setBackground(Color.BLACK);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        Frame3 f = new Frame3("Grid Layout Demo");
    }
}