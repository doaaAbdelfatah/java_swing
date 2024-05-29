import javax.swing.*;
import java.awt.*;

public class Frame1 extends JFrame {
    public Frame1(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocation(350,100);

        JButton button1 = new JButton("North");
        this.getContentPane().add(button1 , BorderLayout.NORTH);

        JButton button2 = new JButton("SOUTH");
        this.getContentPane().add(button2 , BorderLayout.SOUTH);

        JButton button3 = new JButton("CENTER");
        this.getContentPane().add(button3 , BorderLayout.CENTER);

        JButton button4 = new JButton("EAST");
        this.getContentPane().add(button4 , BorderLayout.EAST);

        JButton button5 = new JButton("WEST");
        this.getContentPane().add(button5 , BorderLayout.WEST);
        this.getContentPane().setBackground(Color.BLACK);


        this.setVisible(true);
    }

    public static void main(String[] args) {
        Frame1 f = new Frame1("Border Layout Demo");
    }
}
