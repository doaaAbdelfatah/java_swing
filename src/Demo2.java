import javax.swing.*;
import java.awt.*;

public class Demo2 extends JFrame {
    public Demo2(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(800,600);
        this.setLocation(300,200);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        Demo2 frame = new Demo2("Hi from Doaa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Demo2 frame3 = new Demo2("XO Game");
        frame3.setSize(500,500);
        frame3.setLocation(350 , 300);
        Demo2 frame2 = new Demo2("Hang MAn Game");
    }
}
