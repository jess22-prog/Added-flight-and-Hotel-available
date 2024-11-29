import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Booking> bookings = new ArrayList<>();
    private static JTextArea textArea;

    public static void main(String[] args) {
        // Create some sample bookings
        bookings.add(new Booking("B001", "Hotel", true, 150.00));
        bookings.add(new Booking("B002", "Flight", false, 300.00));
        bookings.add(new Booking("B003", "Hotel", false, 120.00));
        bookings.add(new Booking("B004", "Flight", true, 350.00));
        bookings.add(new Booking("B005", "Hotel", true, 200.00));
        bookings.add(new Booking("B006", "Flight", false, 250.00));

        // Create the frame
        JFrame frame = new JFrame("Booking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Create a dropdown for filter options
        String[] filterOptions = {"All Bookings", "Available Hotel Bookings", "Available Flight Bookings"};
        JComboBox<String> filterComboBox = new JComboBox<>(filterOptions);
        filterComboBox.setSelectedIndex(0);  // Default to "All Bookings"

        // Create a button to apply the filter
        JButton filterButton = new JButton("Show Bookings");
        
        // Create the text area to display booking information
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Set up layout and add components to the frame
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Select Filter:"));
        panel.add(filterComboBox);
        panel.add(filterButton);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Add action listener to the button to handle filter selection
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) filterComboBox.getSelectedItem();
                displayBookings(selectedOption);
            }
        });

        frame.setVisible(true);
    }

    // Method to display bookings based on selected filter
    private static void displayBookings(String filter) {
        textArea.setText("");  // Clear the text area before displaying new results
        boolean found = false;
        for (Booking booking : bookings) {
            boolean isHotelAvailable = filter.equals("Available Hotel Bookings") && booking.getBookingType().equals("Hotel") && booking.isAvailable();
            boolean isFlightAvailable = filter.equals("Available Flight Bookings") && booking.getBookingType().equals("Flight") && booking.isAvailable();
            boolean isAll = filter.equals("All Bookings");

            if (isAll || isHotelAvailable || isFlightAvailable) {
                textArea.append(booking + "\n");
                found = true;
            }
        }
        if (!found) {
            textArea.append("No bookings match the selected filter.\n");
        }
    }
}
