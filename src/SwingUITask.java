import javax.swing.*;
import java.awt.*;

public class SwingUITask  extends JFrame {
    private JTextField centerTextField;
    private JTextField statusTextField;

    public SwingUITask() {
        // Set up the main frame
        setTitle("Swing UI Design Task");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and set up the menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(newItem);
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem pasteItem = new JMenuItem("Paste");
        editMenu.add(cutItem);
        editMenu.add(pasteItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);

        // Create the north panel with BorderLayout
        JPanel northPanel = new JPanel(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome to the Swing UI Design Task", JLabel.CENTER);
        northPanel.add(welcomeLabel, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);

        // Create the center panel with FlowLayout
        JPanel centerPanel = new JPanel(new FlowLayout());
        centerTextField = new JTextField();
        centerTextField.setPreferredSize(new Dimension(200, 30));
        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");
        centerPanel.add(centerTextField);
        centerPanel.add(submitButton);
        centerPanel.add(clearButton);
        add(centerPanel, BorderLayout.CENTER);

        // Create the south panel with null layout
        JPanel southPanel = new JPanel(null);
        southPanel.setBackground(Color.green);
        southPanel.setPreferredSize(new Dimension(400,50));
        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(10, 10, 50, 20);
        statusTextField = new JTextField();
        statusTextField.setBounds(60, 10, 400, 20);
        southPanel.add(statusLabel);
        southPanel.add(statusTextField);
        add(southPanel, BorderLayout.SOUTH);

        // Add action listeners
        newItem.addActionListener(e -> centerTextField.setText(""));
        exitItem.addActionListener(e -> System.exit(0));
        cutItem.addActionListener(e -> centerTextField.cut());
        pasteItem.addActionListener(e -> centerTextField.paste());
        submitButton.addActionListener(e -> JOptionPane.showMessageDialog(this, centerTextField.getText()));
        clearButton.addActionListener(e -> {
            centerTextField.setText("");
            statusTextField.setText("");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingUITask app = new SwingUITask();
            app.setVisible(true);
        });
    }
}
