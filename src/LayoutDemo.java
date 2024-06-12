import javax.swing.*;
import java.awt.*;

public class LayoutDemo extends JFrame {

    public LayoutDemo(){
        setBounds(400,150,400,400);
        this.getContentPane().setBackground(Color.BLACK);

        JPanel pN = new JPanel(new GridLayout(2,1 ,5,5));
        pN.setBackground(Color.BLUE);
//        pN.setPreferredSize(new Dimension(400,80));
        this.getContentPane().add(pN , BorderLayout.NORTH);

        JPanel pNR1 = new JPanel(new GridLayout(1,3,4,4));
        pNR1.setBackground(Color.PINK);

        JPanel pNR2 = new JPanel(new GridLayout(1,5,5,5));
        pNR2.setBackground(Color.RED);

        pN.add(pNR1);
        pN.add(pNR2);

        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");

        pNR1.add(b1);
        pNR1.add(b2);
        pNR1.add(b3);

        JButton b4 = new JButton("1");
        JButton b5 = new JButton("2");
        JButton b6 = new JButton("3");
        JButton b7 = new JButton("4");
        JButton b8 = new JButton("5");

        pNR2.add(b4 ,BorderLayout.NORTH);
        pNR2.add(b5 ,BorderLayout.CENTER);
        pNR2.add(b6 ,BorderLayout.WEST);
        pNR2.add(b7 ,BorderLayout.EAST);
        pNR2.add(b8 ,BorderLayout.SOUTH);


    }
    public static void main(String[] args) {
        LayoutDemo l = new LayoutDemo();
        l.setVisible(true);
    }
}
