import javax.swing.*;
import java.awt.*;

public class Session142 extends JFrame {

    public Session142(){
        setBounds(400,150,500,400);

        JPanel panelN = new JPanel(); // flow
        this.getContentPane().add(panelN , BorderLayout.NORTH);

        JTextField tf1 = new JTextField();
        tf1.setPreferredSize(new Dimension(200,40));
        panelN.add(tf1); // tf => flowlayout

        JButton b1 = new JButton("Hello");
        b1.setPreferredSize(new Dimension(100,40));

        panelN.add(b1);

        ///////////////////////////////////////

        JPanel panelS = new JPanel(null);
        panelS.setBackground(Color.pink);
        this.getContentPane().add(panelS , BorderLayout.SOUTH);
        panelS.setPreferredSize(new Dimension(500,80));

        JButton btn =new JButton("Bye Bye");
        btn.setBounds(100, 20 , 100 ,40);

        panelS.add(btn);
    }

    public static void main(String[] args) {
        Session142 s = new Session142();
        s.setVisible(true);
    }
}
