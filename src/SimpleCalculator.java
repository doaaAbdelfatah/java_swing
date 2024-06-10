import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {

    private JTextField number1TextField;
    private JTextField number2TextField;
    private JTextField resultTextField;

    public SimpleCalculator() {
        // Set up the main frame
        setTitle("Simple Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create and set up the menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu optionsMenu = new JMenu("Options");
        JMenuItem helpItem = new JMenuItem("Help");
        JMenuItem exitItem = new JMenuItem("Exit");
        optionsMenu.add(helpItem);
        optionsMenu.add(exitItem);

        menuBar.add(optionsMenu);
        setJMenuBar(menuBar);

        // Create the north panel with BorderLayout
        JPanel northPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Calculator", JLabel.CENTER);
        northPanel.add(titleLabel, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);

        // Create the center panel with FlowLayout
        JPanel centerPanel = new JPanel(new FlowLayout());
        number1TextField = new JTextField();
        number1TextField.setPreferredSize(new Dimension(100, 30));
        number2TextField = new JTextField();
        number2TextField.setPreferredSize(new Dimension(100, 30));
        JLabel plusLabel = new JLabel("+");
        resultTextField = new JTextField();
        resultTextField.setPreferredSize(new Dimension(100, 30));
        resultTextField.setEditable(false);
        centerPanel.add(number1TextField);
        centerPanel.add(plusLabel);
        centerPanel.add(number2TextField);
        centerPanel.add(new JLabel("="));
        centerPanel.add(resultTextField);
        add(centerPanel, BorderLayout.CENTER);

        // Create the south panel with null layout
        JPanel southPanel = new JPanel(null);
        southPanel.setPreferredSize(new Dimension(400, 50));
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(50, 10, 100, 30);
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(160, 10, 100, 30);
        southPanel.add(calculateButton);
        southPanel.add(clearButton);
        add(southPanel, BorderLayout.SOUTH);

        // Add action listeners
        helpItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Enter two numbers and click 'Calculate' to see the sum."));
        exitItem.addActionListener(e -> System.exit(0));
        calculateButton.addActionListener(e -> {
            try {
                double num1 = Double.parseDouble(number1TextField.getText());
                double num2 = Double.parseDouble(number2TextField.getText());
                double sum = num1 + num2;
                resultTextField.setText(String.valueOf(sum));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        clearButton.addActionListener(e -> {
            number1TextField.setText("");
            number2TextField.setText("");
            resultTextField.setText("");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator app = new SimpleCalculator();
            app.setVisible(true);
        });
    }
}
