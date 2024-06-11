import javax.swing.*;
import java.awt.*;

public class CalcDemo extends JFrame {
    private  JTextField tf ;
    private  JButton [] btnNumbers ;
    private  JButton btnDot ;
    private  JButton btnEqual ;
    private  JButton btnPercent ;
    private  JButton btnClear ;
    private  JButton btnClearAll ;
    private  JButton btnBackSpace ;
    private  JButton []  btnOperation;
    private String selectedOperation ; // + , - , /,*
    private double firstNumber;
    private boolean hasOperation;

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

        JPanel panelCenter = new JPanel(new BorderLayout());
        this.getContentPane().add(panelCenter);

        JPanel panelNourth = new JPanel(new GridLayout(1,4 ,3,3));
        panelNourth.setPreferredSize(new Dimension(350,60));

        btnPercent = new JButton("%");
        btnPercent.setFont(new Font("Tahoma" , Font.BOLD , 24));
        btnPercent.setBorder(BorderFactory.createRaisedBevelBorder());
        btnPercent.setBackground(new Color(230,230,230));
        panelNourth.add(btnPercent);

        btnClear = new JButton("C");
        btnClear.setFont(new Font("Tahoma" , Font.BOLD , 24));
        btnClear.setBorder(BorderFactory.createRaisedBevelBorder());
        btnClear.setBackground(new Color(230,230,230));
        panelNourth.add(btnClear);

        btnClearAll = new JButton("CE");
        btnClearAll.setFont(new Font("Tahoma" , Font.BOLD , 24));
        btnClearAll.setBorder(BorderFactory.createRaisedBevelBorder());
        btnClearAll.setBackground(new Color(230,230,230));
        panelNourth.add(btnClearAll);


        btnBackSpace = new JButton("<-");
        btnBackSpace.addActionListener(e->{
            String txt = tf.getText();
            tf.setText(txt.substring(0,txt.length()-1));
            if (tf.getText().equals("")) tf.setText("0");
        });
        btnBackSpace.setFont(new Font("Tahoma" , Font.BOLD , 24));
        btnBackSpace.setBorder(BorderFactory.createRaisedBevelBorder());
        btnBackSpace.setBackground(new Color(230,230,230));
        panelNourth.add(btnBackSpace);

        panelCenter.add(panelNourth ,BorderLayout.NORTH);
        JPanel panelC = new JPanel(new GridLayout(4,3 , 3,3));
        panelCenter.add(panelC);

        btnNumbers = new JButton[10];
        for (int i = 9; i >=0 ; i--) {
            btnNumbers [i] = new JButton(i + "");
            btnNumbers [i].addActionListener(e -> {
                if (tf.getText().equals("0")  || hasOperation ){
                    tf.setText(e.getActionCommand());
                    hasOperation=false;
                }else{
                    tf.setText(tf.getText() + e.getActionCommand());
                }
            });
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
        btnEqual.addActionListener(e->{
            double secoundNumber = Double.parseDouble( tf.getText());
            switch (selectedOperation){
                case  "+":
                    tf.setText((firstNumber + secoundNumber) +"");
                    break;
                case  "-":
                    tf.setText((firstNumber - secoundNumber) +"");
                    break;
                case  "*":
                    tf.setText((firstNumber * secoundNumber) +"");
                    break;
                case  "/":
                    tf.setText((firstNumber / secoundNumber) +"");
                    break;
            }
        });
        btnEqual.setFont(new Font("Tahoma" , Font.BOLD , 24));
        btnEqual.setBorder(BorderFactory.createRaisedBevelBorder());
        btnEqual.setBackground(new Color(230,230,230));
        panelC.add(btnEqual);


        JPanel panelE = new JPanel(new GridLayout(4,1,3,3));
        panelE.setPreferredSize(new Dimension(80,300));
        panelCenter.add(panelE, BorderLayout.EAST);
        btnOperation = new JButton[4];
        String [] op = {"/" , "*" , "-" ,"+"};
        for (int i = 0; i < op.length ; i++) {
            btnOperation [i] = new JButton(op[i]);
            btnOperation[i].addActionListener(e->{
               selectedOperation = e.getActionCommand(); // + - * /
               firstNumber = Double.parseDouble( tf.getText());
               hasOperation = true;
            });
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
