import javax.swing.*;
import java.awt.*;

public class MyPaintPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawLine(100, 50, 280, 50);
        g.setColor(Color.RED);
        g.drawRect(100,150 , 180 ,100);
        g.fillRect(100,280 , 180 ,100);
        g.setColor(Color.BLUE);
        g.drawOval(300 , 100 , 180,120);
        g.setColor(Color.green);
        g.fillOval(300 , 280 , 180,180);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Paint");
        frame.setBounds(300,150,700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MyPaintPanel());
        frame.setVisible(true);
    }
}
