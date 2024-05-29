import javax.swing.*;
import java.awt.*;

public class Frame2  extends JFrame {
    public Frame2(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(800,600);
        this.setLocation(350,100);
//        FlowLayout flowLayout =new FlowLayout();
        this.setLayout(new FlowLayout());
        JButton button1 = new JButton("One");
        button1.setBackground(Color.ORANGE);

        JButton button2 = new JButton("Two");
        button2.setBackground(Color.GREEN);
        JButton button3 = new JButton("Three");
        button3.setBackground(Color.BLUE);
        JButton button4 = new JButton("Four");
        button4.setForeground(Color.red);
        button4.setBackground(new Color(255,255,0));
        JButton button5 = new JButton("Five");
        button5.setBackground(new Color(255, 124, 255));
        button5.setForeground(Color.white);
        this.getContentPane().add(button1);
        this.getContentPane().add(button2);
        this.getContentPane().add(button3);
        this.getContentPane().add(button4);
        this.getContentPane().add(button5);
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Frame2 f = new Frame2("Flow Layout Demo");
    }
}