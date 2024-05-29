import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

public class Frame4 extends JFrame {
    public Frame4(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocation(350,100);

        Font btnFont =new Font("Arial" , Font.BOLD ,20);
        Border redBorder = BorderFactory.createLineBorder(Color.red ,10 ,true );
        this.setLayout(null);
        JButton button1 = new JButton("One");
        button1.setLocation(50,20);
        button1.setFont(btnFont);
        button1.setBorder( BorderFactory.createBevelBorder(BevelBorder.RAISED ,Color.red ,Color.pink));
        button1.setSize(100,80);
        JButton button2 = new JButton("Two");
        button2.setSize(100,80);
        button2.setBorder(BorderFactory.createLoweredBevelBorder());
        button2.setLocation(200 , 20);
        JButton button3 = new JButton("Three");
        button3.setSize(100,80);
        button3.setBorder(redBorder);
        button3.setFont(btnFont);
        button3.setLocation(50,150);
        JButton button4 = new JButton("Four");
//        button4.setLocation(180,180);
//        button4.setSize(200,300);
        button4.setBackground(Color.pink);
        button4.setForeground(Color.blue);
        button4.setBorder(redBorder);
        button4.setFont(btnFont);
        button4.setBounds(180,180,200,200);

        JButton button5 = new JButton("Five");
        button5.setBounds( 400, 180 , 60,60);
        button5.setBorder(BorderFactory.createRaisedBevelBorder());
        this.getContentPane().add(button1);
        this.getContentPane().add(button2);
        this.getContentPane().add(button3);
        this.getContentPane().add(button4);
        this.getContentPane().add(button5);


        this.setVisible(true);
    }

    public static void main(String[] args) {
        Frame4 f = new Frame4("Grid Layout Demo");
    }
}