import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class TrianglePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Define the points of the triangle
        int[] xPoints = {50, 100, 150};
        int[] yPoints = {150, 50, 150};

        // Create a Path2D object to represent the triangle
        Path2D triangle = new Path2D.Double();
        triangle.moveTo(xPoints[0], yPoints[0]);
        triangle.lineTo(xPoints[1], yPoints[1]);
        triangle.lineTo(xPoints[2], yPoints[2]);
        triangle.closePath();

        // Set the color to fill the triangle
        g2d.setColor(Color.BLUE);

        // Fill the triangle
        g2d.fill(triangle);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Triangle");
        TrianglePanel panel = new TrianglePanel();
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
