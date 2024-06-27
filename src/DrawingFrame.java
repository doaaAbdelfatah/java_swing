import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class DrawingFrame extends JFrame {

    public  DrawingFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350,150,700,650);
        this.getContentPane().add(new PaintPanel());

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        new DrawingFrame().setVisible(true);
    }
}


