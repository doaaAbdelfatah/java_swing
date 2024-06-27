import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ConferenceRegistrationSystem extends JFrame {

    private JTextField participantNameTextField;
    private JTextField participantIDTextField;
    private JComboBox<String> conferenceNameComboBox;
    private JComboBox<String> sessionTimeComboBox;
    private JRadioButton onlineRadioButton;
    private JRadioButton offlineRadioButton;
    private JCheckBox machineLearningCheckBox;
    private JCheckBox webTechnologiesCheckBox;
    private JCheckBox networkSecurityCheckBox;
    private JCheckBox cloudComputingCheckBox;
    private JList<String> skillsList;
    private JTable registrationTable;
    private DefaultTableModel tableModel;
    private JTextField statusTextField;

    public ConferenceRegistrationSystem() {
        // Set up the main frame
        setTitle("Conference Registration System");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Create and set up the menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newRegistrationItem = new JMenuItem("New Registration");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(newRegistrationItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        Font font = new Font("Tahoma", Font.PLAIN, 16);

        // Participant Name
        JLabel participantNameLabel = new JLabel("Participant Name:"); participantNameLabel.setFont(font);
        participantNameLabel.setBounds(10, 10, 150, 30);
        add(participantNameLabel);
        participantNameTextField = new JTextField(20); participantNameTextField.setFont(font);
        participantNameTextField.setBounds(170, 10, 200, 30);
        add(participantNameTextField);

        // Participant ID
        JLabel participantIDLabel = new JLabel("Participant ID:"); participantIDLabel.setFont(font);
        participantIDLabel.setBounds(10, 50, 150, 30);
        add(participantIDLabel);
        participantIDTextField = new JTextField(20); participantIDTextField.setFont(font);
        participantIDTextField.setBounds(170, 50, 200, 30);
        add(participantIDTextField);

        // Conference Name
        JLabel conferenceNameLabel = new JLabel("Conference Name:"); conferenceNameLabel.setFont(font);
        conferenceNameLabel.setBounds(10, 90, 150, 30);
        add(conferenceNameLabel);
        String[] conferences = {"AI Conference", "Web Development Conference", "Cyber Security Conference"};
        conferenceNameComboBox = new JComboBox<>(conferences); conferenceNameComboBox.setFont(font);
        conferenceNameComboBox.setBounds(170, 90, 200, 30);
        add(conferenceNameComboBox);

        // Session Time
        JLabel sessionTimeLabel = new JLabel("Session Time:"); sessionTimeLabel.setFont(font);
        sessionTimeLabel.setBounds(10, 130, 150, 30);
        add(sessionTimeLabel);
        String[] times = {"Morning", "Afternoon", "Evening"};
        sessionTimeComboBox = new JComboBox<>(times); sessionTimeComboBox.setFont(font);
        sessionTimeComboBox.setBounds(170, 130, 200, 30);
        add(sessionTimeComboBox);

        // Attendance Mode
        JLabel modeLabel = new JLabel("Attendance Mode:"); modeLabel.setFont(font);
        modeLabel.setBounds(10, 170, 150, 30);
        add(modeLabel);
        onlineRadioButton = new JRadioButton("Online"); onlineRadioButton.setFont(font);
        onlineRadioButton.setBounds(170, 170, 80, 30);
        offlineRadioButton = new JRadioButton("Offline"); offlineRadioButton.setFont(font);
        offlineRadioButton.setBounds(260, 170, 80, 30);
        ButtonGroup modeGroup = new ButtonGroup();
        modeGroup.add(onlineRadioButton);
        modeGroup.add(offlineRadioButton);
        add(onlineRadioButton);
        add(offlineRadioButton);

        // Topics of Interest
        JLabel topicsLabel = new JLabel("Topics of Interest:"); topicsLabel.setFont(font);
        topicsLabel.setBounds(10, 210, 150, 30);
        add(topicsLabel);
        machineLearningCheckBox = new JCheckBox("Machine Learning"); machineLearningCheckBox.setFont(font);
        machineLearningCheckBox.setBounds(170, 210, 200, 30);
        webTechnologiesCheckBox = new JCheckBox("Web Technologies"); webTechnologiesCheckBox.setFont(font);
        webTechnologiesCheckBox.setBounds(170, 250, 200, 30);
        networkSecurityCheckBox = new JCheckBox("Network Security"); networkSecurityCheckBox.setFont(font);
        networkSecurityCheckBox.setBounds(170, 290, 200, 30);
        cloudComputingCheckBox = new JCheckBox("Cloud Computing"); cloudComputingCheckBox.setFont(font);
        cloudComputingCheckBox.setBounds(170, 330, 200, 30);
        add(machineLearningCheckBox);
        add(webTechnologiesCheckBox);
        add(networkSecurityCheckBox);
        add(cloudComputingCheckBox);

        // Skills
        JLabel skillsLabel = new JLabel("Skills:"); skillsLabel.setFont(font);
        skillsLabel.setBounds(10, 370, 150, 30);
        add(skillsLabel);
        String[] skills = {"Critical Thinking", "Teamwork", "Communication", "Technical Skills"};
        skillsList = new JList<>(skills); skillsList.setFont(font);
        skillsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane skillsScrollPane = new JScrollPane(skillsList);
        skillsScrollPane.setBounds(170, 370, 200, 80);
        add(skillsScrollPane);

        // Buttons and Status
        JButton registerButton = new JButton("Register"); registerButton.setFont(font);
        registerButton.setBounds(10, 460, 120, 30);
        add(registerButton);
        JButton clearButton = new JButton("Clear"); clearButton.setFont(font);
        clearButton.setBounds(140, 460, 80, 30);
        add(clearButton);
        JButton saveButton = new JButton("Save"); saveButton.setFont(font);
        saveButton.setBounds(230, 460, 80, 30);
        add(saveButton);
        statusTextField = new JTextField(30); statusTextField.setFont(font);
        statusTextField.setEditable(false);
        statusTextField.setBounds(10, 500, 300, 30);
        add(statusTextField);

        // Registration Table
        String[] columnNames = {"Participant Name", "Participant ID", "Conference Name", "Session Time", "Attendance Mode", "Topics of Interest", "Skills"};
        tableModel = new DefaultTableModel(columnNames, 0);
        registrationTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(registrationTable);
        tableScrollPane.setBounds(380, 10, 800, 520);
        add(tableScrollPane);

        // Add action listeners
        newRegistrationItem.addActionListener(e -> clearForm());
        exitItem.addActionListener(e -> System.exit(0));
        registerButton.addActionListener(e -> addToTable());
        clearButton.addActionListener(e -> clearForm());
        saveButton.addActionListener(e -> saveRegistrationDetails());
    }

    private void addToTable() {
        String name = participantNameTextField.getText();
        String participantID = participantIDTextField.getText();
        String conferenceName = (String) conferenceNameComboBox.getSelectedItem();
        String sessionTime = (String) sessionTimeComboBox.getSelectedItem();
        String mode = onlineRadioButton.isSelected() ? "Online" : (offlineRadioButton.isSelected() ? "Offline" : "");
        List<String> topics = new ArrayList<>();
        if (machineLearningCheckBox.isSelected()) topics.add("Machine Learning");
        if (webTechnologiesCheckBox.isSelected()) topics.add("Web Technologies");
        if (networkSecurityCheckBox.isSelected()) topics.add("Network Security");
        if (cloudComputingCheckBox.isSelected()) topics.add("Cloud Computing");

        StringBuilder skills = new StringBuilder();
        for (String skill : skillsList.getSelectedValuesList()) {
            skills.append(skill).append(", ");
        }

        tableModel.addRow(new Object[]{name, participantID, conferenceName, sessionTime, mode, topics.toString(), skills.toString()});
        statusTextField.setText("Participant registered for conference.");
    }

    private void saveRegistrationDetails() {
        String name = participantNameTextField.getText();
        String participantID = participantIDTextField.getText();
        String conferenceName = (String) conferenceNameComboBox.getSelectedItem();
        String sessionTime = (String) sessionTimeComboBox.getSelectedItem();
        String mode = onlineRadioButton.isSelected() ? "Online" : (offlineRadioButton.isSelected() ? "Offline" : "");
        List<String> topics = new ArrayList<>();
        if (machineLearningCheckBox.isSelected()) topics.add("Machine Learning");
        if (webTechnologiesCheckBox.isSelected()) topics.add("Web Technologies");
        if (networkSecurityCheckBox.isSelected()) topics.add("Network Security");
        if (cloudComputingCheckBox.isSelected()) topics.add("Cloud Computing");

        StringBuilder skills = new StringBuilder();
        for (String skill : skillsList.getSelectedValuesList()) {
            skills.append(skill).append(", ");
        }

        JOptionPane.showMessageDialog(this, "Registration Details:\n" +
                "Participant Name: " + name + "\n" +
                "Participant ID: " + participantID + "\n" +
                "Conference Name: " + conferenceName + "\n" +
                "Session Time: " + sessionTime + "\n" +
                "Attendance Mode: " + mode + "\n" +
                "Topics of Interest: " + topics.toString() + "\n" +
                "Skills: " + skills.toString());

        statusTextField.setText("Registration details saved successfully.");
    }

    private void clearForm() {
        participantNameTextField.setText("");
        participantIDTextField.setText("");
        conferenceNameComboBox.setSelectedIndex(0);
        sessionTimeComboBox.setSelectedIndex(0);
        onlineRadioButton.setSelected(false);
        offlineRadioButton.setSelected(false);
        machineLearningCheckBox.setSelected(false);
        webTechnologiesCheckBox.setSelected(false);
        networkSecurityCheckBox.setSelected(false);
        cloudComputingCheckBox.setSelected(false);
        skillsList.clearSelection();
        statusTextField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConferenceRegistrationSystem frame = new ConferenceRegistrationSystem();
            frame.setVisible(true);
        });
    }
}
