import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventDemo extends JFrame {
    private JButton btn ;
    public EventDemo(String title ){
        super(title);
        this.setSize(500,500);
        this.setLocation(400,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        btn = new JButton("Say Hello");
        btn.setBounds(100,100,150,80);
        btn.addActionListener( new BtnAction());
        this.getContentPane().add(btn);

        JButton btnUp = new JButton("⬆️");
        JButton btnDown = new JButton("⬇️");
        btnUp.setBounds(180,240,50,50);
        btnDown.setBounds(180,360,50,50);
        JButton btnLeft = new JButton("<");
        btnLeft.setBounds(150, 300 , 50,50);
        btnLeft.setBounds(150, 300 , 50,50);
        JButton btnRight = new JButton(">");
        btnRight.setBounds(210, 300 , 50,50);
        btnLeft.addActionListener(e-> {
            btn.setLocation(btn.getX() -5 , btn.getY());
            btn.setBackground(Color.green);
            btn.setFont(new Font("Arial" , Font.BOLD , 17));
            btn.setForeground(Color.red);
            btn.setText("Left Clicked");
        });
        btnRight.addActionListener(new BtnRightAction());
        this.getContentPane().add(btnLeft);
        this.getContentPane().add(btnRight);
        this.getContentPane().add(btnUp);
        this.getContentPane().add(btnDown);


        btnUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btn.setLocation(btn.getX() , btn.getY()-5);
                btn.setBackground(Color.yellow);
                btn.setText("Up Clicked");

            }
        });

        btnDown.addActionListener(e -> {
            btn.setLocation(btn.getX() , btn.getY()+5);
            btn.setBackground(Color.cyan);
        });

    }
    class BtnAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null , "Good Morning");
        }
    }


    class BtnRightAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            btn.setLocation(btn.getX() +5 , btn.getY());
        }
    }

    public static void main(String[] args) {
        EventDemo e = new EventDemo("HEllo");
        e.setVisible(true);
    }
}
