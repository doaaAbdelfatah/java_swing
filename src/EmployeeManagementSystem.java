import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeManagementSystem extends JFrame {

    private JTextField nameTextField;
    private JTextField phoneTextField;
    private JTextField departmentTextField;
    private JTextField statusTextField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JComboBox<String> positionComboBox;
    private JList<String> skillsList;
    private JTable employeeTable;
    private DefaultTableModel tableModel;

    public EmployeeManagementSystem() {
        // Set up the main frame
        setTitle("Employee Management System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("path/to/icon.png"); // Update with the correct path
        setIconImage(icon.getImage());
        setLayout(null);

        // Create and set up the menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu optionsMenu = new JMenu("Options");
        JMenuItem newEmployeeItem = new JMenuItem("New Employee");
        JMenuItem exitItem = new JMenuItem("Exit");
        optionsMenu.add(newEmployeeItem);
        optionsMenu.add(exitItem);

        menuBar.add(optionsMenu);
        setJMenuBar(menuBar);

        Font font = new Font("Tahoma", Font.PLAIN, 16);

        // Name
        JLabel nameLabel = new JLabel("Name:"); nameLabel.setFont(font);
        nameLabel.setBounds(10, 10, 100, 30);
        add(nameLabel);
        nameTextField = new JTextField(20); nameTextField.setFont(font);
        nameTextField.setBounds(120, 10, 200, 30);
        add(nameTextField);

        // Phone Number
        JLabel phoneLabel = new JLabel("Phone Number:"); phoneLabel.setFont(font);
        phoneLabel.setBounds(10, 50, 120, 30);
        add(phoneLabel);
        phoneTextField = new JTextField(20); phoneTextField.setFont(font);
        phoneTextField.setBounds(140, 50, 180, 30);
        add(phoneTextField);

        // Department
        JLabel departmentLabel = new JLabel("Department:"); departmentLabel.setFont(font);
        departmentLabel.setBounds(10, 90, 100, 30);
        add(departmentLabel);
        departmentTextField = new JTextField(20); departmentTextField.setFont(font);
        departmentTextField.setBounds(120, 90, 200, 30);
        add(departmentTextField);

        // Gender
        JLabel genderLabel = new JLabel("Gender:"); genderLabel.setFont(font);
        genderLabel.setBounds(10, 130, 100, 30);
        add(genderLabel);
        maleRadioButton = new JRadioButton("Male"); maleRadioButton.setFont(font);
        maleRadioButton.setBounds(120, 130, 70, 30);
        femaleRadioButton = new JRadioButton("Female"); femaleRadioButton.setFont(font);
        femaleRadioButton.setBounds(200, 130, 90, 30);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        add(maleRadioButton);
        add(femaleRadioButton);

        // Position
        JLabel positionLabel = new JLabel("Position:"); positionLabel.setFont(font);
        positionLabel.setBounds(10, 170, 100, 30);
        add(positionLabel);
        String[] positions = {"Manager", "Developer", "Designer", "Tester", "HR"};
        positionComboBox = new JComboBox<>(positions); positionComboBox.setFont(font);
        positionComboBox.setBounds(120, 170, 200, 30);
        add(positionComboBox);

        // Skills
        JLabel skillsLabel = new JLabel("Skills:"); skillsLabel.setFont(font);
        skillsLabel.setBounds(10, 210, 100, 30);
        add(skillsLabel);
        String[] skills = {"Java", "C++", "Python", "HTML", "CSS", "JavaScript"};
        skillsList = new JList<>(skills); skillsList.setFont(font);
        skillsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane skillsScrollPane = new JScrollPane(skillsList);
        skillsScrollPane.setBounds(120, 210, 200, 80);
        add(skillsScrollPane);

        // Buttons and Status
        JButton addButton = new JButton("Add Employee"); addButton.setFont(font);
        addButton.setBounds(10, 300, 150, 30);
        add(addButton);
        JButton clearButton = new JButton("Clear"); clearButton.setFont(font);
        clearButton.setBounds(170, 300, 80, 30);
        add(clearButton);
        JButton saveButton = new JButton("Save"); saveButton.setFont(font);
        saveButton.setBounds(260, 300, 80, 30);
        add(saveButton);
        statusTextField = new JTextField(30); statusTextField.setFont(font);
        statusTextField.setEditable(false);
        statusTextField.setBounds(10, 340, 330, 30);
        add(statusTextField);

        // Employee Table
        String[] columnNames = {"Name", "Phone Number", "Department", "Gender", "Position", "Skills"};
        tableModel = new DefaultTableModel(columnNames, 0);
        employeeTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(employeeTable);
        tableScrollPane.setBounds(350, 10, 520, 360);
        add(tableScrollPane);

        // Add action listeners
        newEmployeeItem.addActionListener(e -> clearForm());
        exitItem.addActionListener(e -> System.exit(0));
        addButton.addActionListener(e -> addToTable());
        clearButton.addActionListener(e -> clearForm());
        saveButton.addActionListener(e -> saveEmployeeDetails());
    }

    private void addToTable() {
        String name = nameTextField.getText();
        String phone = phoneTextField.getText();
        String department = departmentTextField.getText();
        String gender = maleRadioButton.isSelected() ? "Male" : (femaleRadioButton.isSelected() ? "Female" : "");
        String position = (String) positionComboBox.getSelectedItem();
        StringBuilder skills = new StringBuilder();
        for (String skill : skillsList.getSelectedValuesList()) {
            skills.append(skill).append(", ");
        }

        tableModel.addRow(new Object[]{name, phone, department, gender, position, skills.toString()});
        statusTextField.setText("Employee added to list.");
    }

    private void saveEmployeeDetails() {
        String name = nameTextField.getText();
        String phone = phoneTextField.getText();
        String department = departmentTextField.getText();
        String gender = maleRadioButton.isSelected() ? "Male" : (femaleRadioButton.isSelected() ? "Female" : "");
        String position = (String) positionComboBox.getSelectedItem();
        StringBuilder skills = new StringBuilder();
        for (String skill : skillsList.getSelectedValuesList()) {
            skills.append(skill).append(", ");
        }

        JOptionPane.showMessageDialog(this, "Employee Details:\n" +
                "Name: " + name + "\n" +
                "Phone Number: " + phone + "\n" +
                "Department: " + department + "\n" +
                "Gender: " + gender + "\n" +
                "Position: " + position + "\n" +
                "Skills: " + skills.toString());

        statusTextField.setText("Employee details saved successfully.");
    }

    private void clearForm() {
        nameTextField.setText("");
        phoneTextField.setText("");
        departmentTextField.setText("");
        statusTextField.setText("");
        maleRadioButton.setSelected(false);
        femaleRadioButton.setSelected(false);
        positionComboBox.setSelectedIndex(0);
        skillsList.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmployeeManagementSystem frame = new EmployeeManagementSystem();
            frame.setVisible(true);
        });
    }
}
