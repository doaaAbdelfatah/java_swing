import javax.swing.*;
import java.awt.*;
public class DrawingClass extends JFrame {
    public DrawingClass(){
        setBounds(400,150,600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel panel =new MyPanel();
        this.getContentPane().add(panel);
    }
    public static void main(String[] args) {
        new DrawingClass().setVisible(true);
    }
}
class  MyPanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {

        g.drawLine(100, 100, 280, 100);
        g.drawRect(100,150 , 180 ,100);
        g.fillRect(100,280 , 180 ,100);

        g.drawOval(300 , 150 , 180,100);
        g.fillOval(300 , 280 , 180,180);
    }

}
