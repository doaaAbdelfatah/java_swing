import javax.swing.*;
import java.awt.*;

public class ContactFrame extends JFrame {

    public ContactFrame(){
        setTitle("Contacts");
        ImageIcon icon = new ImageIcon("C:\\Users\\dode3\\IdeaProjects\\ui\\src\\contact-book.png");
        setIconImage(icon.getImage());
        setBounds(400,150,500,400);

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

        JCheckBox checkBoxEn = new JCheckBox("English");checkBoxEn.setFont(font);
        JCheckBox checkBoxGr = new JCheckBox("German");checkBoxGr.setFont(font);
        JCheckBox checkBoxAr = new JCheckBox("Arabic");checkBoxAr.setFont(font);

        checkBoxEn.setBounds(150,170,150,30);
        checkBoxGr.setBounds(150,200,150,30);
        checkBoxAr.setBounds(150,230,150,30);

        panelCenter.add(checkBoxEn);
        panelCenter.add(checkBoxGr);
        panelCenter.add(checkBoxAr);

        ImageIcon icSave =new ImageIcon("C:\\Users\\dode3\\IdeaProjects\\ui\\src\\diskette.png");
        JButton buttonSave = new JButton("Save" ,icSave);buttonSave.setFont(font);
        JButton buttonClear = new JButton("Clear");buttonClear.setFont(font);
        buttonSave.setBounds(150,290,150,50);
        buttonClear.setBounds(310,290,150,50);

        buttonSave.setBorder(BorderFactory.createRaisedBevelBorder());
        buttonClear.setBorder(BorderFactory.createRaisedBevelBorder());
        panelCenter.add(buttonSave);
        panelCenter.add(buttonClear);


    }


    public static void main(String[] args) {
        ContactFrame f = new ContactFrame();
        f.setVisible(true);
    }
}
