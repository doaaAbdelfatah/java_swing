import javax.swing.*;
import java.awt.*;

public class StudentRegistrationForm extends JFrame {

    private JTextField nameTextField;
    private JTextField studentIdTextField;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JTextField statusTextField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;

    private JCheckBox[] courseCheckBoxes;
    private JComboBox<String> yearComboBox;

    public StudentRegistrationForm() {
        // Set up the main frame
        setTitle("Student Registration Form");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("path/to/icon.png"); // Update with the correct path
        setIconImage(icon.getImage());

        // Create and set up the menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(newItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Create the center panel
        JPanel centerPanel = new JPanel(null);
        this.getContentPane().add(centerPanel);
        Font font = new Font("Tahoma", Font.PLAIN, 22);

        JLabel nameLabel = new JLabel("Student Name:"); nameLabel.setFont(font);
        nameLabel.setBounds(20, 30, 200, 30);
        nameTextField = new JTextField(); nameTextField.setFont(font);
        nameTextField.setBounds(220, 30, 300, 30);

        JLabel studentIdLabel = new JLabel("Student ID:"); studentIdLabel.setFont(font);
        studentIdLabel.setBounds(20, 70, 200, 30);
        studentIdTextField = new JTextField(); studentIdTextField.setFont(font);
        studentIdTextField.setBounds(220, 70, 300, 30);

        JLabel emailLabel = new JLabel("Email:"); emailLabel.setFont(font);
        emailLabel.setBounds(20, 110, 200, 30);
        emailTextField = new JTextField(); emailTextField.setFont(font);
        emailTextField.setBounds(220, 110, 300, 30);

        JLabel phoneLabel = new JLabel("Phone:"); phoneLabel.setFont(font);
        phoneLabel.setBounds(20, 150, 200, 30);
        phoneTextField = new JTextField(); phoneTextField.setFont(font);
        phoneTextField.setBounds(220, 150, 300, 30);

        JLabel genderLabel = new JLabel("Gender:"); genderLabel.setFont(font);
        genderLabel.setBounds(20, 190, 200, 30);
        maleRadioButton = new JRadioButton("Male"); maleRadioButton.setFont(font);
        femaleRadioButton = new JRadioButton("Female"); femaleRadioButton.setFont(font);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        maleRadioButton.setBounds(220, 190, 100, 30);
        femaleRadioButton.setBounds(320, 190, 100, 30);

        JLabel coursesLabel = new JLabel("Courses:"); coursesLabel.setFont(font);
        coursesLabel.setBounds(20, 230, 200, 30);
        String[] courses = {"Mathematics", "Science", "Literature"};
        courseCheckBoxes = new JCheckBox[courses.length];
        int y = 0;
        for (int i = 0; i < courseCheckBoxes.length; i++) {
            courseCheckBoxes[i] = new JCheckBox(courses[i]);
            courseCheckBoxes[i].setFont(font);
            courseCheckBoxes[i].setBounds(220, 230 + y, 200, 30);
            y += 30;
            centerPanel.add(courseCheckBoxes[i]);
        }

        JLabel yearLabel = new JLabel("Year of Study:"); yearLabel.setFont(font);
        yearLabel.setBounds(20, 320, 200, 30);
        String[] years = {"First Year", "Second Year", "Third Year", "Fourth Year"};
        yearComboBox = new JComboBox<>(years); yearComboBox.setFont(font);
        yearComboBox.setBounds(220, 320, 200, 30);

        centerPanel.add(nameLabel);
        centerPanel.add(nameTextField);
        centerPanel.add(studentIdLabel);
        centerPanel.add(studentIdTextField);
        centerPanel.add(emailLabel);
        centerPanel.add(emailTextField);
        centerPanel.add(phoneLabel);
        centerPanel.add(phoneTextField);
        centerPanel.add(genderLabel);
        centerPanel.add(maleRadioButton);
        centerPanel.add(femaleRadioButton);
        centerPanel.add(coursesLabel);
        centerPanel.add(yearLabel);
        centerPanel.add(yearComboBox);

        // Create the south panel
        JPanel southPanel = new JPanel();
        JButton registerButton = new JButton("Register");
        JButton clearButton = new JButton("Clear");
        statusTextField = new JTextField(30);
        statusTextField.setEditable(false);
        registerButton.setFont(font);
        clearButton.setFont(font);
        southPanel.add(registerButton);
        southPanel.add(clearButton);
        southPanel.add(statusTextField);
        add(southPanel, BorderLayout.SOUTH);

        // Add action listeners
        newItem.addActionListener(e -> clearForm());
        exitItem.addActionListener(e -> System.exit(0));
        registerButton.addActionListener(e -> registerStudent());
        clearButton.addActionListener(e -> clearForm());
    }

    private void registerStudent() {
        String name = nameTextField.getText();
        String studentId = studentIdTextField.getText();
        String email = emailTextField.getText();
        String phone = phoneTextField.getText();
        String gender = maleRadioButton.isSelected() ? "Male" : (femaleRadioButton.isSelected() ? "Female" : "Not specified");
        String year = (String) yearComboBox.getSelectedItem();
        StringBuilder courses = new StringBuilder();
        for (JCheckBox courseCheckBox : courseCheckBoxes) {
            if (courseCheckBox.isSelected()) {
                courses.append(courseCheckBox.getText()).append(" ");
            }
        }

        if (!name.isEmpty() && !studentId.isEmpty() && !email.isEmpty() && !phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name: " + name + "\nStudent ID: " + studentId + "\nEmail: " + email + "\nPhone: " + phone + "\nGender: " + gender + "\nYear: " + year + "\nCourses: " + courses.toString());
            statusTextField.setText("Registration successful.");
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        nameTextField.setText("");
        studentIdTextField.setText("");
        emailTextField.setText("");
        phoneTextField.setText("");
        statusTextField.setText("");
        yearComboBox.setSelectedIndex(0);
        maleRadioButton.setSelected(false);
        femaleRadioButton.setSelected(false);
        for (JCheckBox courseCheckBox : courseCheckBoxes) {
            courseCheckBox.setSelected(false);
        }
    }

    public static void main(String[] args) {
        StudentRegistrationForm form = new StudentRegistrationForm();
        form.setVisible(true);
    }
}
