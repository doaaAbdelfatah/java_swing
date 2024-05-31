import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDemo extends JFrame {

    public  PanelDemo(String title){
        super(title);
        this.setSize(500,400);
        this.setLocation(400,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2,2));

        JPanel p1 = new JPanel(new FlowLayout());
        JButton btn1 = new JButton("One");
        JButton btnx = new JButton("Test");
        p1.add(btn1);
        btn1.addActionListener(new MyActionHandler());
        p1.add(btnx);
        this.getContentPane().add(p1);

        JPanel panel1 = new JPanel(new GridLayout(2,2));
        this.getContentPane().add(panel1);
        JButton btn2 = new JButton("Two");
        btn2.addActionListener(new MyActionHandler());
        JButton btn3 = new JButton("Three");
        JButton btn4 = new JButton("Four");
        JButton btn5 = new JButton("Five");
        panel1.add(btn2);panel1.add(btn3);panel1.add(btn4);panel1.add(btn5);

        JPanel px = new JPanel(new BorderLayout());
        px.setBackground(Color.yellow);
        JTextField tf = new JTextField();
        tf.setFont(new Font("Arial" , Font.PLAIN , 35));
        px.add(tf , BorderLayout.NORTH);
        JButton bb2 = new JButton("Test");
        px.add(bb2 ,BorderLayout.CENTER);

        JPanel pp = new JPanel(new GridLayout(1,2));

        JButton bb = new JButton("Goo");
        JButton bbxx = new JButton("Goo2");
        bbxx.addActionListener(new MyActionHandler2());
        pp.add(bb);
        pp.add(bbxx);
        px.add(pp ,BorderLayout.SOUTH);

        JButton bb3 = new JButton("EAST");
        px.add(bb3 ,BorderLayout.EAST);


        JButton bb4 = new JButton("WEST");
        px.add(bb4 ,BorderLayout.WEST);

        this.getContentPane().add(px);

        JPanel panel2 = new JPanel(new GridLayout(4,1));
        this.getContentPane().add(panel2);

        JTextField tf2 = new JTextField();
        JTextField tf3 = new JTextField();
        JTextField tf4 = new JTextField();
        JTextField tf5 = new JTextField();
        panel2.add(tf2);
        panel2.add(tf3);
        panel2.add(tf4);
        panel2.add(tf5);

    }

    public static void main(String[] args) {
        PanelDemo p = new PanelDemo("Good Morning");
        p.setVisible(true);
    }

    class MyActionHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null ,"Test");
        }
    }

    class MyActionHandler2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null ,"Hello....");
        }
    }
}
