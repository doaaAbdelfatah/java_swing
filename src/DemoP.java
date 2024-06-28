import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class DemoP  extends JPanel implements MouseListener  {

    private  int x1 ,x2 , y1 ,y2;

    private static String shape ="line";
    private static Color  color;

    public DemoP(){
        color = Color.RED;
        this.addMouseListener(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(color);

        if (shape.equals("line")){
            Line2D l = new Line2D.Float(x1,y1 ,x2,y2);
            g2d.draw(l);
        }else if(shape.equals("rect")){
            int w = x2 -x1;
            int h =y2 -y1;
            Rectangle2D r = new Rectangle2D.Float(x1,y1,w,h );
            g2d.fill(r);
        }else if(shape.equals("oval")){
            int w = x2 -x1;
            int h =y2 -y1;
            Ellipse2D r = new Ellipse2D.Float(x1,y1,w,h );
            g2d.fill(r);
        }
    }

    public static void main(String[] args) {
        JFrame frame= new JFrame();
        frame.getContentPane().add(new DemoP());
        frame.setBounds(400,150,700,600);

//        JPanel pN = new JPanel();
        JToolBar toolBar = new JToolBar();

        frame.getContentPane().add(toolBar, BorderLayout.NORTH);

        JToggleButton bLine = new JToggleButton("Line");
        JToggleButton bRect = new JToggleButton("Rect");
        JToggleButton bOval = new JToggleButton("Oval");

        bLine.addActionListener(e->{
            shape = "line";
        });
        bRect.addActionListener(e->{
            shape = "rect";
        });
        bOval.addActionListener(e->{
            shape = "oval";
        });
        ButtonGroup bg = new ButtonGroup();
        bg.add(bLine);
        bg.add(bRect);
        bg.add(bOval);

        toolBar.add(bLine);toolBar.add(bRect);toolBar.add(bOval);
        toolBar.addSeparator();
        JToggleButton bR = new JToggleButton();
        bR.setBackground(Color.RED);
        bR.setPreferredSize(new Dimension(30,30));
        JToggleButton bG = new JToggleButton();
        bG.setBackground(Color.GREEN);bG.setPreferredSize(new Dimension(30,30));
        JToggleButton bB = new JToggleButton();
        bB.setBackground(Color.BLUE);bB.setPreferredSize(new Dimension(30,30));
        JToggleButton bP = new JToggleButton();
        bP.setBackground(Color.PINK);bP.setPreferredSize(new Dimension(30,30));
        ButtonGroup bgC = new ButtonGroup();
        bgC.add(bR);
        bgC.add(bG);
        bgC.add(bB);
        bgC.add(bP);

        bR.addActionListener(e->color = Color.RED);
        bG.addActionListener(e->color = Color.GREEN);
        bB.addActionListener(e->color = Color.BLUE);
        bP.addActionListener(e->color = Color.PINK);

        toolBar.add(bR);
        toolBar.add(bG);
        toolBar.add(bB);
        toolBar.add(bP);

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
