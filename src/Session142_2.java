import javax.swing.*;
import java.awt.*;

public class Session142_2 extends JFrame {

    public Session142_2(){
        setBounds(400,150,500,400);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.yellow);

        JPanel p = new JPanel();
        p.setBounds(50,50 , 200 ,150);
        p.setBackground(Color.green);
        this.getContentPane().add(p);

        JButton b = new JButton("Hello");
        b.setPreferredSize(new Dimension(180,40));


        JPanel p2 = new JPanel();
//        p2.setBounds(40,40,150,50);
        p2.setPreferredSize(new Dimension(190,50));
        p2.setBackground(Color.BLUE);
        p.add(p2);

        p2.add(b);


    }

    public static void main(String[] args) {
        Session142_2 s = new Session142_2();
        s.setVisible(true);
    }
}
