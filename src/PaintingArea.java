import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

public class PaintingArea  extends JPanel implements MouseListener {

    private int x1 ,x2;
    private int y1  ,y2;

    public PaintingArea(){
        this.addMouseListener(this);

    }
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        Line2D line2D = new Line2D.Float(x1 ,y1 , x2,y2);
        g2d.draw(line2D);
    }

    public static void main(String[] args) {
        JFrame frame= new JFrame();
        frame.setBounds(300,150,700,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new PaintingArea());
        frame.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        System.out.println("X1  :" + x1 );
        System.out.println("Y1  :" + y1 );
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        System.out.println("X2  :" + x2 );
        System.out.println("Y2  :" + y2 );
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
