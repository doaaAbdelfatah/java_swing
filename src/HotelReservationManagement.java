import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelReservationManagement extends JFrame {

    private JTextField guestNameTextField;
    private JTextField phoneTextField;
    private JTextField checkInDateTextField;
    private JTextField checkOutDateTextField;
    private JTextField statusTextField;
    private JRadioButton singleRadioButton;
    private JRadioButton doubleRadioButton;
    private JRadioButton suiteRadioButton;
    private JComboBox<String> mealPlanComboBox;
    private JList<String> amenitiesList;
    private JTable reservationTable;
    private DefaultTableModel tableModel;

    public HotelReservationManagement() {
        // Set up the main frame
        setTitle("Hotel Reservation Management");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("path/to/icon.png"); // Update with the correct path
        setIconImage(icon.getImage());

        // Create and set up the menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu optionsMenu = new JMenu("Options");
        JMenuItem newReservationItem = new JMenuItem("New Reservation");
        JMenuItem exitItem = new JMenuItem("Exit");
        optionsMenu.add(newReservationItem);
        optionsMenu.add(exitItem);

        menuBar.add(optionsMenu);
        setJMenuBar(menuBar);

        // Create the center panel with GridBagLayout
        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        this.getContentPane().add(centerPanel, BorderLayout.WEST);
        Font font = new Font("Tahoma", Font.PLAIN, 16);

        // Guest Name
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        JLabel guestNameLabel = new JLabel("Guest Name:"); guestNameLabel.setFont(font);
        centerPanel.add(guestNameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST; gbc.fill = GridBagConstraints.HORIZONTAL;
        guestNameTextField = new JTextField(20); guestNameTextField.setFont(font);
        centerPanel.add(guestNameTextField, gbc);

        // Phone Number
        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        JLabel phoneLabel = new JLabel("Phone Number:"); phoneLabel.setFont(font);
        centerPanel.add(phoneLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.anchor = GridBagConstraints.WEST; gbc.fill = GridBagConstraints.HORIZONTAL;
        phoneTextField = new JTextField(20); phoneTextField.setFont(font);
        centerPanel.add(phoneTextField, gbc);

        // Check-In Date
        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.EAST;
        JLabel checkInDateLabel = new JLabel("Check-In Date:"); checkInDateLabel.setFont(font);
        centerPanel.add(checkInDateLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.anchor = GridBagConstraints.WEST; gbc.fill = GridBagConstraints.HORIZONTAL;
        checkInDateTextField = new JTextField(20); checkInDateTextField.setFont(font);
        centerPanel.add(checkInDateTextField, gbc);

        // Check-Out Date
        gbc.gridx = 0; gbc.gridy = 3; gbc.anchor = GridBagConstraints.EAST;
        JLabel checkOutDateLabel = new JLabel("Check-Out Date:"); checkOutDateLabel.setFont(font);
        centerPanel.add(checkOutDateLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3; gbc.anchor = GridBagConstraints.WEST; gbc.fill = GridBagConstraints.HORIZONTAL;
        checkOutDateTextField = new JTextField(20); checkOutDateTextField.setFont(font);
        centerPanel.add(checkOutDateTextField, gbc);

        // Room Type
        gbc.gridx = 0; gbc.gridy = 4; gbc.anchor = GridBagConstraints.EAST;
        JLabel roomTypeLabel = new JLabel("Room Type:"); roomTypeLabel.setFont(font);
        centerPanel.add(roomTypeLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 4; gbc.anchor = GridBagConstraints.WEST;
        singleRadioButton = new JRadioButton("Single"); singleRadioButton.setFont(font);
        doubleRadioButton = new JRadioButton("Double"); doubleRadioButton.setFont(font);
        suiteRadioButton = new JRadioButton("Suite"); suiteRadioButton.setFont(font);
        ButtonGroup roomTypeGroup = new ButtonGroup();
        roomTypeGroup.add(singleRadioButton);
        roomTypeGroup.add(doubleRadioButton);
        roomTypeGroup.add(suiteRadioButton);
        JPanel roomTypePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        roomTypePanel.add(singleRadioButton);
        roomTypePanel.add(doubleRadioButton);
        roomTypePanel.add(suiteRadioButton);
        centerPanel.add(roomTypePanel, gbc);

        // Meal Plan
        gbc.gridx = 0; gbc.gridy = 5; gbc.anchor = GridBagConstraints.EAST;
        JLabel mealPlanLabel = new JLabel("Meal Plan:"); mealPlanLabel.setFont(font);
        centerPanel.add(mealPlanLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 5; gbc.anchor = GridBagConstraints.WEST; gbc.fill = GridBagConstraints.HORIZONTAL;
        String[] mealPlans = {"Breakfast Only", "Half Board", "Full Board"};
        mealPlanComboBox = new JComboBox<>(mealPlans); mealPlanComboBox.setFont(font);
        centerPanel.add(mealPlanComboBox, gbc);

        // Room Amenities
        gbc.gridx = 0; gbc.gridy = 6; gbc.anchor = GridBagConstraints.NORTHEAST;
        JLabel amenitiesLabel = new JLabel("Room Amenities:"); amenitiesLabel.setFont(font);
        centerPanel.add(amenitiesLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 6; gbc.anchor = GridBagConstraints.NORTHWEST; gbc.fill = GridBagConstraints.BOTH;
        String[] amenities = {"WiFi", "TV", "Minibar", "Air Conditioning", "Balcony"};
        amenitiesList = new JList<>(amenities); amenitiesList.setFont(font);
        amenitiesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane amenitiesScrollPane = new JScrollPane(amenitiesList);
        centerPanel.add(amenitiesScrollPane, gbc);

        // Create the south panel
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton addButton = new JButton("Add Reservation"); addButton.setFont(font);
        JButton clearButton = new JButton("Clear"); clearButton.setFont(font);
        JButton saveButton = new JButton("Save"); saveButton.setFont(font);
        statusTextField = new JTextField(30); statusTextField.setFont(font);
        statusTextField.setEditable(false);
        southPanel.add(addButton);
        southPanel.add(clearButton);
        southPanel.add(saveButton);
        southPanel.add(statusTextField);
        add(southPanel, BorderLayout.SOUTH);

        // Create the east panel with JTable
        JPanel eastPanel = new JPanel(new BorderLayout());
        String[] columnNames = {"No","Guest Name", "Phone Number", "Check-In Date", "Check-Out Date", "Room Type", "Meal Plan", "Room Amenities"};
        tableModel = new DefaultTableModel(columnNames, 0);
        reservationTable = new JTable(tableModel);
        eastPanel.add(new JScrollPane(reservationTable), BorderLayout.CENTER);
        this.getContentPane().add(eastPanel, BorderLayout.CENTER);

        // Add action listeners
        newReservationItem.addActionListener(e -> clearForm());
        exitItem.addActionListener(e -> System.exit(0));
        addButton.addActionListener(e -> addToTable());
        clearButton.addActionListener(e -> clearForm());
        saveButton.addActionListener(e -> saveReservation());
    }

    private void addToTable() {

//        String selectedRoomType = "";
//        if (singleRadioButton.isSelected()) selectedRoomType ="Single";
//        else if (doubleRadioButton.isSelected()) selectedRoomType ="Double";
//        else selectedRoomType ="Suite";

        String no = String.valueOf(tableModel.getRowCount() + 1 ) ;
        String name = guestNameTextField.getText();
        String phone = phoneTextField.getText();
        String checkIN = checkInDateTextField.getText();
        String checkOut = checkOutDateTextField.getText();
        String selectedRoomType = (singleRadioButton.isSelected())? "Single" :
                (doubleRadioButton.isSelected())? "Double" :"Suite";
        String meal =  mealPlanComboBox.getSelectedItem().toString();
        String aList =  amenitiesList.getSelectedValuesList().toString();

        String [] row ={no ,name , phone ,checkIN , checkOut, selectedRoomType,meal,aList};

        tableModel.addRow(row);
    }

    private void saveReservation() {
        String guestName = guestNameTextField.getText();
        String phone = phoneTextField.getText();
        String checkInDate = checkInDateTextField.getText();
        String checkOutDate = checkOutDateTextField.getText();
        String roomType = singleRadioButton.isSelected() ? "Single" : (doubleRadioButton.isSelected() ? "Double" : "Suite");
        String mealPlan = (String) mealPlanComboBox.getSelectedItem();
        StringBuilder amenities = new StringBuilder();
        for (String amenity : amenitiesList.getSelectedValuesList()) {
            amenities.append(amenity).append(", ");
        }

        JOptionPane.showMessageDialog(this, "Reservation Details:\n" +
                "Guest Name: " + guestName + "\n" +
                "Phone Number: " + phone + "\n" +
                "Check-In Date: " + checkInDate + "\n" +
                "Check-Out Date: " + checkOutDate + "\n" +
                "Room Type: " + roomType + "\n" +
                "Meal Plan: " + mealPlan + "\n" +
                "Room Amenities: " + amenities.toString());

        statusTextField.setText("Reservation details saved successfully.");
    }

    private void clearForm() {
        guestNameTextField.setText("");
        phoneTextField.setText("");
        checkInDateTextField.setText("");
        checkOutDateTextField.setText("");
        statusTextField.setText("");
        singleRadioButton.setSelected(false);
        doubleRadioButton.setSelected(false);
        suiteRadioButton.setSelected(false);
        mealPlanComboBox.setSelectedIndex(0);
        amenitiesList.clearSelection();
    }

    public static void main(String[] args) {

            HotelReservationManagement form = new HotelReservationManagement();
            form.setVisible(true);

    }
}
