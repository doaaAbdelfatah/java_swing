import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class TableDemo2 extends JFrame {

    public TableDemo2(){
        setBounds(400,150,400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField tfName = new JTextField();
        JTextField tfArabic = new JTextField();
        JTextField tfEn = new JTextField();
        JTextField tfMath = new JTextField();

        JButton button = new JButton("Add");
        JPanel panel = new JPanel( new GridLayout(1,5));
        panel.setBorder(BorderFactory.createEmptyBorder(20,10,10,10));
        panel.add(tfName);
        panel.add(tfArabic);
        panel.add(tfEn);
        panel.add(tfMath);
        panel.add(button);
        this.getContentPane().add(panel , BorderLayout.NORTH);

        String [] header ={"No" ,"Name" , "Arabic" , "English" , "Math"};
        String [][] students = {
                {"1" ,"Ahmed" ,"14" ,"15","17" },
                {"2" ,"Dina" ,"13" ,"16","18" },
                {"3" ,"Sara" ,"14" ,"14","17" },
        };
        DefaultTableModel dtm = new DefaultTableModel(students , header);
        JTable table =  new JTable(dtm);
        JScrollPane scrollPane = new JScrollPane(table);

        this.getContentPane().add(scrollPane);

        button.addActionListener(e->{
//            int rowCount = table.getModel().getRowCount();
            int rowCount = dtm.getRowCount();
            String [] row ={(rowCount+1) +"", tfName.getText() ,tfArabic.getText(),tfEn.getText(),tfMath.getText()};
            dtm.addRow(row);

        });
    }
    public static void main(String[] args) {
        new TableDemo2().setVisible(true);
    }
}
