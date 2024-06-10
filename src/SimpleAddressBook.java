import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleAddressBook extends JFrame {

    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JTextField statusTextField;

    public SimpleAddressBook() {
        // Set up the main frame
        setTitle("Simple Address Book");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and set up the menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(newItem);
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Create the north panel with BorderLayout
        JPanel northPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Address Book", JLabel.CENTER);
        northPanel.add(titleLabel, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);

        // Create the center panel with FlowLayout
        JPanel centerPanel = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Name:");
        nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(200, 30));
        JLabel emailLabel = new JLabel("Email:");
        emailTextField = new JTextField();
        emailTextField.setPreferredSize(new Dimension(200, 30));
        JLabel phoneLabel = new JLabel("Phone:");
        phoneTextField = new JTextField();
        phoneTextField.setPreferredSize(new Dimension(200, 30));
        centerPanel.add(nameLabel);
        centerPanel.add(nameTextField);
        centerPanel.add(emailLabel);
        centerPanel.add(emailTextField);
        centerPanel.add(phoneLabel);
        centerPanel.add(phoneTextField);
        add(centerPanel, BorderLayout.CENTER);

        // Create the south panel with null layout
        JPanel southPanel = new JPanel(null);
        southPanel.setPreferredSize(new Dimension(500, 100));
        JButton addButton = new JButton("Add");
        addButton.setBounds(100, 10, 100, 30);
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(210, 10, 100, 30);
        statusTextField = new JTextField();
        statusTextField.setBounds(50, 50, 300, 20);
        statusTextField.setEditable(false);
        southPanel.add(addButton);
        southPanel.add(clearButton);
        southPanel.add(statusTextField);
        add(southPanel, BorderLayout.SOUTH);

        // Add action listeners
        newItem.addActionListener(e -> {
            nameTextField.setText("");
            emailTextField.setText("");
            phoneTextField.setText("");
            statusTextField.setText("");
        });
        exitItem.addActionListener(e -> System.exit(0));
        addButton.addActionListener(e -> {
            String name = nameTextField.getText();
            String email = emailTextField.getText();
            String phone = phoneTextField.getText();
            if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone);
                statusTextField.setText("Contact added: " + name);
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        clearButton.addActionListener(e -> {
            nameTextField.setText("");
            emailTextField.setText("");
            phoneTextField.setText("");
            statusTextField.setText("");
        });


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleAddressBook app = new SimpleAddressBook();
            app.setVisible(true);
        });
    }
}
