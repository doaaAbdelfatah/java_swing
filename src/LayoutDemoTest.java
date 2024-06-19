import javax.swing.*;
import java.awt.*;

public class LayoutDemoTest extends JFrame {
    public  LayoutDemoTest(){
        JPanel panel = new JPanel(new GridLayout(10,2 , 10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        this.getContentPane().add(panel);
        setBounds(400,150,600,500);
        JButton b [] = new JButton[10];
        for (int i = 0; i < 10 ; i++) {
            b[i] =  new JButton("" + i);
            panel.add(b[i]);
        }
    }
    public static void main(String[] args) {
        LayoutDemoTest f = new LayoutDemoTest();
        f.setVisible(true);
    }
}
