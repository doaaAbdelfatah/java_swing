import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableTask2 extends JFrame {
    public TableTask2(){
        setBounds(400,150,500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String cols[] ={"No" , "Name"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(null , cols);
        JTable table = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        this.getContentPane().add(scrollPane);

        JLabel label = new JLabel("Enter Student Name:");
        JTextField tfName = new JTextField();
        tfName.setPreferredSize(new Dimension(200,30));
        JButton button = new JButton("Add");
        JPanel panel = new JPanel();
        this.getContentPane().add(panel , BorderLayout.NORTH);
        panel.add(label);
        panel.add(tfName);
        panel.add(button);

        button.addActionListener(e->{
            int rowNum = defaultTableModel.getRowCount() + 1;
            String [] row ={rowNum +"" , tfName.getText() };
            defaultTableModel.addRow(row);
        });
    }

    public static void main(String[] args) {
        new TableTask2().setVisible(true);
    }
}
