import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryBookEntryForm extends JFrame {

    private JTextField titleTextField;
    private JTextField authorTextField;
    private JTextField isbnTextField;
    private JTextField yearTextField;
    private JTextField statusTextField;
    private JRadioButton newRadioButton;
    private JRadioButton usedRadioButton;
    private JCheckBox fictionCheckBox;
    private JCheckBox nonFictionCheckBox;
    private JCheckBox mysteryCheckBox;
    private JCheckBox sciFiCheckBox;
    private JComboBox<String> availabilityComboBox;
    private JList<String> categoryList;

    public LibraryBookEntryForm() {
        // Set up the main frame
        setTitle("Library Book Entry Form");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("path/to/icon.png"); // Update with the correct path
        setIconImage(icon.getImage());

        // Create and set up the menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu optionsMenu = new JMenu("Options");
        JMenuItem newEntryItem = new JMenuItem("New Entry");
        JMenuItem exitItem = new JMenuItem("Exit");
        optionsMenu.add(newEntryItem);
        optionsMenu.add(exitItem);

        menuBar.add(optionsMenu);
        setJMenuBar(menuBar);

        // Create the center panel
        JPanel centerPanel = new JPanel(null);
        this.getContentPane().add(centerPanel);
        Font font = new Font("Tahoma", Font.PLAIN, 22);

        JLabel titleLabel = new JLabel("Book Title:"); titleLabel.setFont(font);
        titleLabel.setBounds(20, 30, 200, 30);
        titleTextField = new JTextField(); titleTextField.setFont(font);
        titleTextField.setBounds(220, 30, 300, 30);

        JLabel authorLabel = new JLabel("Author:"); authorLabel.setFont(font);
        authorLabel.setBounds(20, 70, 200, 30);
        authorTextField = new JTextField(); authorTextField.setFont(font);
        authorTextField.setBounds(220, 70, 300, 30);

        JLabel isbnLabel = new JLabel("ISBN:"); isbnLabel.setFont(font);
        isbnLabel.setBounds(20, 110, 200, 30);
        isbnTextField = new JTextField(); isbnTextField.setFont(font);
        isbnTextField.setBounds(220, 110, 300, 30);

        JLabel yearLabel = new JLabel("Publication Year:"); yearLabel.setFont(font);
        yearLabel.setBounds(20, 150, 200, 30);
        yearTextField = new JTextField(); yearTextField.setFont(font);
        yearTextField.setBounds(220, 150, 300, 30);

        JLabel genreLabel = new JLabel("Genres:"); genreLabel.setFont(font);
        genreLabel.setBounds(20, 190, 200, 30);
        String[] genres = {"Fiction", "Non-Fiction", "Mystery", "Science Fiction"};
        JCheckBox[] genreCheckBoxes = new JCheckBox[genres.length];
        int y = 0;
        for (int i = 0; i < genreCheckBoxes.length; i++) {
            genreCheckBoxes[i] = new JCheckBox(genres[i]);
            genreCheckBoxes[i].setFont(font);
            genreCheckBoxes[i].setBounds(220, 190 + y, 200, 30);
            y += 30;
            centerPanel.add(genreCheckBoxes[i]);
        }

        JLabel conditionLabel = new JLabel("Condition:"); conditionLabel.setFont(font);
        conditionLabel.setBounds(20, 320, 200, 30);
        newRadioButton = new JRadioButton("New"); newRadioButton.setFont(font);
        usedRadioButton = new JRadioButton("Used"); usedRadioButton.setFont(font);
        ButtonGroup conditionGroup = new ButtonGroup();
        conditionGroup.add(newRadioButton);
        conditionGroup.add(usedRadioButton);
        newRadioButton.setBounds(220, 320, 100, 30);
        usedRadioButton.setBounds(320, 320, 100, 30);

        JLabel availabilityLabel = new JLabel("Availability:"); availabilityLabel.setFont(font);
        availabilityLabel.setBounds(20, 360, 200, 30);
        String[] availability = {"Available", "Checked Out", "Reserved"};
        availabilityComboBox = new JComboBox<>(availability); availabilityComboBox.setFont(font);
        availabilityComboBox.setBounds(220, 360, 200, 30);

        JLabel categoryLabel = new JLabel("Categories:"); categoryLabel.setFont(font);
        categoryLabel.setBounds(20, 400, 200, 30);
        String[] categories = {"Science", "Literature", "Technology", "Arts", "History"};
        categoryList = new JList<>(categories); categoryList.setFont(font);
        categoryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        categoryList.setBounds(220, 400, 200, 100);
        centerPanel.add(new JScrollPane(categoryList));

        centerPanel.add(titleLabel);
        centerPanel.add(titleTextField);
        centerPanel.add(authorLabel);
        centerPanel.add(authorTextField);
        centerPanel.add(isbnLabel);
        centerPanel.add(isbnTextField);
        centerPanel.add(yearLabel);
        centerPanel.add(yearTextField);
        centerPanel.add(genreLabel);
        centerPanel.add(conditionLabel);
        centerPanel.add(newRadioButton);
        centerPanel.add(usedRadioButton);
        centerPanel.add(availabilityLabel);
        centerPanel.add(availabilityComboBox);
        centerPanel.add(categoryLabel);
        centerPanel.add(categoryList);

        // Create the south panel
        JPanel southPanel = new JPanel();
        JButton saveButton = new JButton("Save");
        JButton clearButton = new JButton("Clear");
        statusTextField = new JTextField(30);
        statusTextField.setEditable(false);
        saveButton.setFont(font);
        clearButton.setFont(font);
        southPanel.add(saveButton);
        southPanel.add(clearButton);
        southPanel.add(statusTextField);
        add(southPanel, BorderLayout.SOUTH);

        // Add action listeners
        newEntryItem.addActionListener(e -> clearForm());
        exitItem.addActionListener(e -> System.exit(0));
        saveButton.addActionListener(e -> saveBook(genreCheckBoxes));
        clearButton.addActionListener(e -> clearForm());
    }

    private void saveBook(JCheckBox[] genreCheckBoxes) {
        String title = titleTextField.getText();
        String author = authorTextField.getText();
        String isbn = isbnTextField.getText();
        String year = yearTextField.getText();
        String condition = newRadioButton.isSelected() ? "New" : (usedRadioButton.isSelected() ? "Used" : "Not specified");
        String availability = (String) availabilityComboBox.getSelectedItem();
        StringBuilder genres = new StringBuilder();
        for (JCheckBox genreCheckBox : genreCheckBoxes) {
            if (genreCheckBox.isSelected()) {
                genres.append(genreCheckBox.getText()).append(", ");
            }
        }
        StringBuilder categories = new StringBuilder();
        for (String category : categoryList.getSelectedValuesList()) {
            categories.append(category).append(", ");
        }

        JOptionPane.showMessageDialog(this, "Book Details:\n" +
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "ISBN: " + isbn + "\n" +
                "Publication Year: " + year + "\n" +
                "Genres: " + genres.toString() + "\n" +
                "Condition: " + condition + "\n" +
                "Availability: " + availability + "\n" +
                "Categories: " + categories.toString());

        statusTextField.setText("Book details saved successfully.");
    }

    private void clearForm() {
        titleTextField.setText("");
        authorTextField.setText("");
        isbnTextField.setText("");
        yearTextField.setText("");
        statusTextField.setText("");
        newRadioButton.setSelected(false);
        usedRadioButton.setSelected(false);
        availabilityComboBox.setSelectedIndex(0);
        for (Component component : getContentPane().getComponents()) {
            if (component instanceof JCheckBox) {
                ((JCheckBox) component).setSelected(false);
            }
        }
        categoryList.clearSelection();
    }

    public static void main(String[] args) {

        LibraryBookEntryForm form = new LibraryBookEntryForm();
        form.setVisible(true);

    }
}
