
import javax.swing.*;
        import java.awt.*;

public class BookTask extends JFrame {
    public  BookTask(){
        JPanel panel = new JPanel(new GridLayout(7,2 , 10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        this.getContentPane().add(panel);
        setBounds(400,150,600,600);

        JLabel label1 = new JLabel("Book ID");
        JLabel label2 = new JLabel("Book ID");
        JLabel label3 = new JLabel("Book ID");
        JLabel label4 = new JLabel("Book ID");
        JLabel label5 = new JLabel("Book ID");



        JTextField tf1 = new JTextField();
        JTextField tf2 = new JTextField();
        JTextField tf3 = new JTextField();
        JTextField tf4 = new JTextField();
        JTextField tf5 = new JTextField();

        panel.add(label1); panel.add(tf1);
        panel.add(label2); panel.add(tf2);
        panel.add(label3); panel.add(tf3);
        panel.add(label4); panel.add(tf4);
        panel.add(label5); panel.add(tf5);

        JLabel label6 = new JLabel("Avaliabilty");
        String [] avalibality ={"ssss" ,"fffff","etert","werwrwe"};
        JComboBox cb = new JComboBox(avalibality);
        panel.add(label6); panel.add(cb);

        JLabel label7 =  new JLabel("Test");
        panel.add(label7);
        JPanel pCK = new JPanel();
//       pCK.setBackground(Color.BLUE);
        panel.add(pCK);
        JCheckBox [] cbArr = new JCheckBox[4];
        for (int i = 0; i < 4; i++) {
            cbArr[i] = new JCheckBox("Test");
            pCK.add(cbArr[i]);
        }

    }
    public static void main(String[] args) {
        BookTask f = new BookTask();
        f.setVisible(true);
    }
}
