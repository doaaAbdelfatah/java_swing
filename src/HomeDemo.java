import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
public class HomeDemo extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(6));
        Rectangle2D rectangle1 = new Rectangle2D.Float(150,150,400,400);
        g2d.setColor(Color.PINK);
        g2d.fill(rectangle1);
        g2d.setColor(Color.CYAN);
        g2d.draw(rectangle1);

        Rectangle2D rectW1 = new Rectangle2D.Float(200,200,80,80);
        g2d.fill(rectW1);

        Rectangle2D rectW2 = new Rectangle2D.Float(400,200,80,80);
        g2d.fill(rectW2);

        Rectangle2D rectD = new Rectangle2D.Float(300,370,80,180);
        g2d.fill(rectD);

        Path2D tri = new Path2D.Float();
        tri.moveTo(150,150);
        tri.lineTo(350 , 70);
        tri.lineTo(550 , 150);
        tri.closePath();
        g2d.fill(tri);
        g2d.draw(tri);

        Ellipse2D sun =new Ellipse2D.Float(-100,-100,200,200);
        g2d.setColor(Color.yellow);
        g2d.fill(sun);

        Line2D line2D1 = new Line2D.Float(0,0,20,120);
        g2d.draw(line2D1);
        Line2D line2D2 = new Line2D.Float(0,0,40,120);
        g2d.draw(line2D2);
        Line2D line2D3 = new Line2D.Float(0,0,60,120);
        g2d.draw(line2D3);
        Line2D line2D4 = new Line2D.Float(0,0,80,110);
        g2d.draw(line2D4);
    }
    public static void main(String[] args) {
        JFrame frame= new JFrame();
        frame.setBounds(300,150,700,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new HomeDemo());
        frame.setVisible(true);

    }
}
