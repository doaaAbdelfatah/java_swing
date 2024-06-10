import javax.swing.*;
import java.awt.*;

public class CalcDemo extends JFrame {
    private  JTextField tf ;
    private  JButton [] btnNumbers ;
    private  JButton btnDot ;
    private  JButton btnEqual ;
    private  JButton []  btnOperation;
    public CalcDemo(){
        setTitle("Calculator");
        setBounds(400,15,350,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelN = new JPanel();
        this.getContentPane().add(panelN , BorderLayout.NORTH);

        tf = new JTextField("0");
        tf.setHorizontalAlignment(JTextField.RIGHT);
        tf.setFont(new Font("Tahoma" , Font.BOLD , 30));
        tf.setPreferredSize(new Dimension(300 , 50) );
        tf.setEditable(false);
        panelN.add(tf);

        ////////////////////////////////////////////////////
        JPanel panelC = new JPanel(new GridLayout(4,3 , 3,3));
        this.getContentPane().add(panelC);

        btnNumbers = new JButton[10];
        for (int i = 9; i >=0 ; i--) {
            btnNumbers [i] = new JButton(i + "");
            btnNumbers [i].setFont(new Font("Tahoma" , Font.BOLD , 24));
            btnNumbers [i].setBorder(BorderFactory.createRaisedBevelBorder());
            btnNumbers [i].setBackground(new Color(230,230,230));
            panelC.add(btnNumbers [i]);
        }

        btnDot = new JButton(".");
        btnDot.setFont(new Font("Tahoma" , Font.BOLD , 24));
        btnDot.setBorder(BorderFactory.createRaisedBevelBorder());
        btnDot.setBackground(new Color(230,230,230));
        panelC.add(btnDot);

        btnEqual = new JButton("=");
        btnEqual.setFont(new Font("Tahoma" , Font.BOLD , 24));
        btnEqual.setBorder(BorderFactory.createRaisedBevelBorder());
        btnEqual.setBackground(new Color(230,230,230));
        panelC.add(btnEqual);


        JPanel panelE = new JPanel(new GridLayout(4,1,3,3));
        panelE.setPreferredSize(new Dimension(80,300));
        this.getContentPane().add(panelE, BorderLayout.EAST);
        btnOperation = new JButton[4];
        String [] op = {"/" , "*" , "-" ,"+"};
        for (int i = 0; i < op.length ; i++) {
            btnOperation [i] = new JButton(op[i]);
            btnOperation [i].setFont(new Font("Tahoma" , Font.BOLD , 24));
            btnOperation [i].setBorder(BorderFactory.createRaisedBevelBorder());
            btnOperation [i].setBackground(new Color(230,230,230));
            panelE.add(btnOperation [i]);
        }
    }

    public static void main(String[] args) {
        CalcDemo c = new CalcDemo();
        c.setVisible(true);
    }
}
