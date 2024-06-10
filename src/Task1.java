import javax.swing.*;
import java.awt.*;

public class Task1 extends JFrame {

    private  JTextField tf;
    private  JTextField textFieldS;
    public Task1(String title)  {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);
        this.setLocation(400,150);

        // 2.	Menu Bar:
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        JMenu menuFile = new JMenu("File");
        JMenu menuEdit = new JMenu("Edit");

        menuBar.add(menuFile);
        menuBar.add(menuEdit);


        JMenuItem menuItemNew = new JMenuItem("New");
        menuItemNew.addActionListener(e -> {
            tf.setText(null);
        });
        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuItemExit.addActionListener(e -> System.exit(0));
        menuFile.add(menuItemNew);
        menuFile.add(menuItemExit);
        JMenuItem menuItemCut = new JMenuItem("Cut");
        JMenuItem menuItemPaste = new JMenuItem("Paste");

        menuEdit.add(menuItemCut);
        menuEdit.add(menuItemPaste);


        menuItemCut.addActionListener(e -> tf.cut());
        menuItemPaste.addActionListener(e-> tf.paste());
        ////////////////////////////////


        // 3.	BorderLayout (North Panel):

        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new BorderLayout());
        this.getContentPane().add(panelNorth , BorderLayout.NORTH);

        JLabel labelCenter = new JLabel("Welcome to the Swing UI Design Task");
        panelNorth.add(labelCenter);
        ////////////////////////////////

        // 4.	FlowLayout (Center Panel):

        JPanel panelCenter = new JPanel();
        this.getContentPane().add(panelCenter);

        tf = new JTextField();
//        tf.setSize(200,30);
        tf.setPreferredSize(new Dimension(200,30));
        JButton buttonSubmit = new JButton("Submit");
        buttonSubmit.addActionListener(e -> JOptionPane.showMessageDialog(null , tf.getText()));
        JButton buttonClear = new JButton("Clear");
        buttonClear.addActionListener(e -> {
            tf.setText(null);
            textFieldS.setText(null);
        });

        panelCenter.add(tf);
        panelCenter.add(buttonSubmit);
        panelCenter.add(buttonClear);

        /////////////////////////////////

        // 5.	Null Layout (South Panel):

        JPanel panelS = new JPanel(null);
//        panelS.setBackground(Color.cyan);
        panelS.setPreferredSize(new Dimension(600,60));
        this.getContentPane().add(panelS ,BorderLayout.SOUTH);
        JLabel labelS = new JLabel("Status : ");
        labelS.setBounds(10,10,100,20);
        panelS.add(labelS);

        textFieldS = new JTextField();
        textFieldS.setBounds(60,10 ,400,20);
        panelS.add(textFieldS);


    }

    public static void main(String[] args) {
        Task1 t = new Task1("Swing UI Design Task");
        t.setVisible(true);
    }
}
