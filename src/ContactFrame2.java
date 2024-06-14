import javax.swing.*;
import java.awt.*;

public class ContactFrame2 extends JFrame {

    public ContactFrame2(){
        setTitle("Contacts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("C:\\Users\\dode3\\IdeaProjects\\ui\\src\\contact-book.png");
        setIconImage(icon.getImage());
        setBounds(400,150,500,500);

        JPanel panelCenter = new JPanel(null);
        this.getContentPane().add(panelCenter);
        Font font = new Font("Tahoma" , Font.PLAIN , 22);

        JLabel labelName = new JLabel("Name:"); labelName.setFont(font);
        labelName.setBounds(20,50,130,30);
        JTextField tfName = new JTextField(); tfName.setFont(font);
        tfName.setBounds(150,50,200,30);

        panelCenter.add(labelName);
        panelCenter.add(tfName);


        JLabel labelPhone = new JLabel("Phone:"); labelPhone.setFont(font);
        labelPhone.setBounds(20,90,130,30);
        JTextField tfPhone = new JTextField(); tfPhone.setFont(font);
        tfPhone.setBounds(150,90,200,30);

        panelCenter.add(labelPhone);
        panelCenter.add(tfPhone);

        JLabel labelGender = new JLabel("Gender:"); labelGender.setFont(font);
        labelGender.setBounds(20,130,130,30);

        panelCenter.add(labelGender);

        JRadioButton radioButtonMale = new JRadioButton("Male");    radioButtonMale.setFont(font);
        JRadioButton radioButtonFemale = new JRadioButton("Female");radioButtonFemale.setFont(font);
        radioButtonFemale.setSelected(true);
        ButtonGroup genderBG = new ButtonGroup();
        genderBG.add(radioButtonMale);
        genderBG.add(radioButtonFemale);

        radioButtonMale.setBounds(150,130,100,30);
        radioButtonFemale.setBounds(260,130,120,30);

        panelCenter.add(radioButtonMale);
        panelCenter.add(radioButtonFemale);


        JLabel labelLanguages = new JLabel("Languages:"); labelLanguages.setFont(font);
        labelLanguages.setBounds(20,170,130,30);
        panelCenter.add(labelLanguages);

        String langs [] = {"English" , "German" , "Arabic" , "French" , "Chinese" , "Italy" , "Japanes"};
        JCheckBox [] checkBoxLangs = new JCheckBox[langs.length];
        int y =0;
        for (int i = 0; i <checkBoxLangs.length ; i++) {
            checkBoxLangs[i] = new JCheckBox(langs[i]);
            checkBoxLangs[i].setFont(font);
            checkBoxLangs[i].setBounds(150 ,170 +y ,150,30);
            y +=30;
            panelCenter.add(checkBoxLangs[i]);
        }

        ImageIcon icSave =new ImageIcon("C:\\Users\\dode3\\IdeaProjects\\ui\\src\\diskette.png");
        JButton buttonSave = new JButton("Save" ,icSave);buttonSave.setFont(font);
        JButton buttonClear = new JButton("Clear");buttonClear.setFont(font);
        buttonSave.setBounds(150,400,150,50);
        buttonClear.setBounds(310,400,150,50);

        buttonSave.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonClear.setBorder(BorderFactory.createRaisedBevelBorder());
        panelCenter.add(buttonSave);
        panelCenter.add(buttonClear);

        buttonSave.addActionListener(e-> {
            String data = "Name : " + tfName.getText() + "\nPhone : " + tfPhone.getText() ;
            if (radioButtonMale.isSelected()){
                data += "\nGender : " + radioButtonMale.getText();
            }else{
                data += "\nGender : " + radioButtonFemale.getText();
            }
            data += "\nLanguages : " ;

            for (JCheckBox ck : checkBoxLangs)
                if (ck.isSelected())  data += ck.getText() + " ";


            JOptionPane.showMessageDialog(null , data);
        });
    }


    public static void main(String[] args) {
        ContactFrame2 f = new ContactFrame2();
        f.setVisible(true);
    }
}
