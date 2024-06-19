import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class UiDemo extends JFrame {

    public UiDemo(){
        setBounds(400,150,400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Colors");
        this.getContentPane().add(label);

        String []colors = {"Red" , "Green" ,"Blue" ,"Black"};
        JComboBox cb = new JComboBox(colors);
//        cb.setSelectedIndex(2);
        this.getContentPane().add(cb);


        JButton button = new JButton("Show");
        this.getContentPane().add(button);

        JList list = new JList(colors);
        list.setPreferredSize(new Dimension(200 , 120));
//        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.getContentPane().add(list);

        button.addActionListener(e->{
            JOptionPane.showMessageDialog(null ,"ComboBox " + cb.getSelectedIndex() + " " + cb.getSelectedItem() );
//            JOptionPane.showMessageDialog(null ,"List " +list.getSelectedIndex() + " " + list.getSelectedValue() );
            JOptionPane.showMessageDialog(null ,"List " + Arrays.toString(list.getSelectedIndices() ));
            JOptionPane.showMessageDialog(null ,"List " + list.getSelectedValuesList());
        });



    }
    public static void main(String[] args) {
        UiDemo f = new UiDemo();
        f.setVisible(true);
    }
}
