import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class PaintPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.cyan);
//        Rectangle rect = new Rectangle(100,100,300,150);
        Rectangle2D rect = new Rectangle2D.Float(100,100,300,150);
        g2d.fill(rect);
        g2d.setColor(Color.red);
        g2d.draw(rect);
//        g2d.setStroke(new BasicStroke(3));
        Ellipse2D ellipse2D = new Ellipse2D.Double(100,270,200,280);

        g2d.setColor(Color.green);
        g2d.fill(ellipse2D);
        Ellipse2D ellipse2D2 = new Ellipse2D.Double(350,270,200,280);
        g2d.setColor(Color.black);
        g2d.draw(ellipse2D2);




    }
}
