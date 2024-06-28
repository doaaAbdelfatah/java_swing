import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

public class DemoP  extends JPanel implements MouseListener {

    private  int x1 ,x2 , y1 ,y2;

    public DemoP(){
        this.addMouseListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.RED);

        Line2D l = new Line2D.Float(x1,y1 ,x2,y2);
        g2d.draw(l);
    }

    public static void main(String[] args) {
        JFrame frame= new JFrame();
        frame.getContentPane().add(new DemoP());
        frame.setBounds(400,150,700,600);
        frame.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2= e.getX();
        y2 = e.getY();
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
