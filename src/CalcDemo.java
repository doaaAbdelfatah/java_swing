import javax.swing.*;
import java.awt.*;

public class CalcDemo extends JFrame {
    private  JTextField tf ;
    private  JButton [] btnNumbers ;
    private  JButton btnDot ;
    private  JButton btnEqual ;
    private  JButton btnPN ;
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

        btnPN = new JButton("+/-");
        btnPN.setFont(new Font("Tahoma" , Font.BOLD , 24));
        btnPN.setBorder(BorderFactory.createRaisedBevelBorder());
        btnPN.setBackground(new Color(230,230,230));
        panelNourth.add(btnPN);

        btnPN.addActionListener(e->{
            double d = Double.parseDouble(tf.getText());
            d =-d;
            tf.setText(d +"");

        });

        btnClear = new JButton("CE");
        btnClear.setFont(new Font("Tahoma" , Font.BOLD , 24));
        btnClear.setBorder(BorderFactory.createRaisedBevelBorder());
        btnClear.setBackground(new Color(230,230,230));
        panelNourth.add(btnClear);
        btnClear.addActionListener(e-> tf.setText("0"));

        btnClearAll = new JButton("C");
        btnClearAll.setFont(new Font("Tahoma" , Font.BOLD , 24));
        btnClearAll.setBorder(BorderFactory.createRaisedBevelBorder());
        btnClearAll.setBackground(new Color(230,230,230));
        panelNourth.add(btnClearAll);
        btnClearAll.addActionListener(e-> {
            tf.setText("0");
            firstNumber=0;
            selectedOperation=null;
            hasOperation =false;
        });


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

        btnDot.addActionListener(e->{
           if ( tf.getText().indexOf(".") == -1 ){
               tf.setText(tf.getText()+ ".");
           }

//            if (!tf.getText().contains(".")){
//                tf.setText(tf.getText()+ ".");
//            }

        });


        btnEqual = new JButton("=");
        btnEqual.addActionListener(e->{
            double secoundNumber = Double.parseDouble( tf.getText());
            if (selectedOperation != null){
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

//            JPanel panelS = new JPanel(new GridLayout(1,4,3,3));
//            panelS.setPreferredSize(new Dimension(350,40));
//            panelS.setBackground(Color.cyan);
//            panelCenter.add(panelS ,BorderLayout.SOUTH);
//            JPanel panelS2 = new JPanel(new GridLayout(1,4,3,3));
//            panelS2.setPreferredSize(new Dimension(350,40));
//            panelS2.setBackground(Color.RED);
//            this.getContentPane().add(panelS2 ,BorderLayout.SOUTH);
//
//
//
//            JPanel panelW = new JPanel(new GridLayout(4,1,3,3));
//            panelW.setPreferredSize(new Dimension(40,300));
//            panelW.setBackground(Color.BLUE);
//            panelCenter.add(panelW ,BorderLayout.WEST);
//
//            JPanel panelW2 = new JPanel(new GridLayout(4,1,3,3));
//            panelW2.setPreferredSize(new Dimension(40,300));
//            panelW2.setBackground(Color.BLACK);
//            this.getContentPane().add(panelW2 ,BorderLayout.WEST);
//
//            JPanel panelE2 = new JPanel(new GridLayout(4,1,3,3));
//            panelE2.setPreferredSize(new Dimension(80,300));
//            panelE2.setBackground(Color.BLACK);
//            this.getContentPane().add(panelE2 ,BorderLayout.EAST);
//
//            JButton bs = new JButton("11");
//            panelE2.add(bs);
//
//            JButton bs2 = new JButton("12");
//            panelE2.add(bs2);
//
//            panelS2.add(bs);
        }
    }

    public static void main(String[] args) {
        CalcDemo c = new CalcDemo();
        c.setVisible(true);
    }
}
