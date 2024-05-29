import javax.swing.*;
import java.awt.*;

public class Frame5 extends JFrame  {
    public  Frame5(String title){
        super(title);
        this.setLocation(400,150);
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");

        this.getContentPane().add(b1 , BorderLayout.NORTH);
        this.getContentPane().add(b2 , BorderLayout.WEST);
        this.getContentPane().add(b3 , BorderLayout.CENTER);

        JPanel eastPanel =  new JPanel(new GridLayout(3,1));
        this.getContentPane().add(eastPanel , BorderLayout.EAST);
        eastPanel.add(b4);
        eastPanel.add(b5);
        eastPanel.add(b6);
        JPanel sPanel =  new JPanel(new GridLayout(1,2));
        this.getContentPane().add(sPanel , BorderLayout.SOUTH);
        sPanel.add(b7);
        sPanel.add(b8);
        setVisible(true);
    }

    public static void main(String[] args) {
        Frame5 f5 = new Frame5("Test");
    }

}
