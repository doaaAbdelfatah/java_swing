import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseEventDemo1 extends JFrame {
    private  JLabel label;
    private JPanel panel;
    public  MouseEventDemo1(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400,150,600,555);

        label = new JLabel("Result here");
        label.setFont(new Font("Tahoma" , Font.PLAIN , 30));
        this.getContentPane().add(label , BorderLayout.NORTH);
        panel = new JPanel();
        panel.addMouseMotionListener(new MouseHandler());

        panel.setBackground(Color.white);
        this.getContentPane().add(panel);

    }

    public static void main(String[] args) {
        MouseEventDemo1 m = new MouseEventDemo1();
        m.setVisible(true);
    }

    class MouseHandler implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            label.setText("X = " + e.getX() + " , Y = " + e.getY());
            int x  = e.getX()/2;
            int y  = e.getY()/2;
            if (x >255){
                x =255;
            }
            if (y >255){
                y =255;
            }
            panel.setBackground(new Color(x , y , 100));
        }
    }
}
