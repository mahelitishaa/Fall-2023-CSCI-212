import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
/**
 * The Date212GUI class generates a GUI to display unsorted and sorted dates.
 */
public class Date212GUI extends JFrame {
    /**
     * Constructor for Date212GUI class, initializes the GUI with unsorted and sorted dates.
     *
     * @param unsortedDates A LinkedList of unsorted Date212 objects
     * @param sortedDates   A LinkedList of sorted Date212 objects
     */
    public Date212GUI(LinkedList<Date212> unsortedDates, LinkedList<Date212> sortedDates) {
        // Create the main frame
        setTitle("Date Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        // Create left and right panels 
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        // Set the layout for left and right panel
        leftPanel.setLayout(new BorderLayout());
        rightPanel.setLayout(new BorderLayout());

        // Create text areas for unsorted and sorted dates
        JTextArea unsortedTextArea = new JTextArea(20, 20);
        JTextArea sortedTextArea = new JTextArea(20, 20);

        // Set the text areas to not be editable
        unsortedTextArea.setEditable(false);
        sortedTextArea.setEditable(false);

        // Create scroll panes for the text areas 
        JScrollPane unsortedScrollPane = new JScrollPane(unsortedTextArea);
        JScrollPane sortedScrollPane = new JScrollPane(sortedTextArea);

        // Label each panel for unsorted and sorted dates 
        leftPanel.add(new JLabel("Unsorted Dates"), BorderLayout.NORTH);
        rightPanel.add(new JLabel("Sorted Dates"), BorderLayout.NORTH);

        // Add the scroll panes to the left and right panels 
        leftPanel.add(unsortedScrollPane, BorderLayout.CENTER);
        rightPanel.add(sortedScrollPane, BorderLayout.CENTER);

        // Add both panels to the frame
        add(leftPanel);
        add(rightPanel);

        // Populate the text areas with dates and positioning
        populateTextArea(unsortedTextArea, unsortedDates);
        populateTextArea(sortedTextArea, sortedDates);
        pack();
        setLocationRelativeTo(null);
    }
    /** 
     * Populates the provided text area with the given list of dates.
     *
     * @param textArea The JTextArea to populate with dates
     * @param dates    A LinkedList of Date212 objects
     */
    private void populateTextArea(JTextArea textArea, LinkedList<Date212> dates) {
        for (int i=0; i< dates.size(); i++) {
            Date212 date = dates.get(i);
            // Format the date in MM/DD/YYYY format when displayed in GUI
            textArea.append(date.toString() + "\n");
        }
    }    
}
