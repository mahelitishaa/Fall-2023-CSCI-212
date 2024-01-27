import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Represents the GUI for displaying unsorted and sorted dates.
 */
public class Date212GUI extends JFrame {
    private JTextArea unsortedTextArea;
    private JTextArea sortedTextArea;
    private FileMenuHandler fileHandler;

    /**
     * Constructs the Date212GUI with unsorted and sorted dates.
     *
     * @param unsortedDates The list of unsorted dates
     * @param sortedDates   The list of sorted dates
     */
    public Date212GUI(ArrayList<Date212> unsortedDates, ArrayList<Date212> sortedDates) {
        // Set up the frame and layout
        setTitle("Date Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        // Create left and right panels for unsorted and sorted dates
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        // Set layouts for left and right panels
        leftPanel.setLayout(new BorderLayout());
        rightPanel.setLayout(new BorderLayout());

        // Create text areas for unsorted and sorted dates
        unsortedTextArea = new JTextArea(20, 20);
        sortedTextArea = new JTextArea(20, 20);

        // Set text areas to be non-editable
        unsortedTextArea.setEditable(false);
        sortedTextArea.setEditable(false);

        // Create scroll panes for the text areas
        JScrollPane unsortedScrollPane = new JScrollPane(unsortedTextArea);
        JScrollPane sortedScrollPane = new JScrollPane(sortedTextArea);

        // Add labels to the left and right panels
        leftPanel.add(new JLabel("Unsorted Dates"), BorderLayout.NORTH);
        rightPanel.add(new JLabel("Sorted Dates"), BorderLayout.NORTH);

        // Add scroll panes to the left and right panels
        leftPanel.add(unsortedScrollPane, BorderLayout.CENTER);
        rightPanel.add(sortedScrollPane, BorderLayout.CENTER);

        // Add left and right panels to the frame
        add(leftPanel);
        add(rightPanel);

        // Populate text areas with unsorted and sorted dates
        populateTextArea(unsortedDates, unsortedTextArea);
        populateTextArea(sortedDates, sortedTextArea);

        pack();
        setLocationRelativeTo(null);

        // Initialize the FileMenuHandler
        fileHandler = new FileMenuHandler(this);

        // Adding file menu handling
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem quitMenuItem = new JMenuItem("Quit");

        openMenuItem.addActionListener(e -> fileHandler.openFile());
        quitMenuItem.addActionListener(e -> System.exit(0));

        fileMenu.add(openMenuItem);
        fileMenu.add(quitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    /**
     * Populates the text area with the dates.
     *
     * @param dates    The list of dates to display
     * @param textArea The JTextArea to populate
     */
    private void populateTextArea(ArrayList<Date212> dates, JTextArea textArea) {
        // Create a string builder to construct the text to display
        StringBuilder sb = new StringBuilder();
        // Iterate through each date and append it to the string builder
        for (Date212 date : dates) {
            sb.append(date.toString()).append("\n");
        }
        // Set the constructed text to the text area
        textArea.setText(sb.toString());
    }

    /**
     * Sets the content of the unsorted text area.
     *
     * @param content The content to set
     */
    public void setUnsortedTextAreaContent(String content) {
        unsortedTextArea.setText(content);
    }

    /**
     * Sets the content of the sorted text area.
     *
     * @param content The content to set
     */
    public void setSortedTextAreaContent(String content) {
        sortedTextArea.setText(content);
    }

    /**
     * The main method to initialize the GUI.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        ArrayList<Date212> unsortedDates = new ArrayList<>();
        ArrayList<Date212> sortedDates = new ArrayList<>();

        SwingUtilities.invokeLater(() -> {
            new Date212GUI(unsortedDates, sortedDates).setVisible(true);
        });
    }
}

