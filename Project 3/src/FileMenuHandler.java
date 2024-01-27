import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/**
 * Handles actions related to file menu events in the GUI.
 */
public class FileMenuHandler implements ActionListener {
    private Date212GUI dateGUI;

    /**
     * Constructs a FileMenuHandler object associated with a Date212GUI.
     *
     * @param dg The Date212GUI object to associate with this handler
     */
    public FileMenuHandler(Date212GUI dg) {
        dateGUI = dg;
    }
    
    /**
     * Handles the actionPerformed event for file menu items.
     *
     * @param event The ActionEvent triggered by a file menu item
     */
    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();
        if (menuName.equals("Open")) {
            openFile();
        } else if (menuName.equals("Quit")) {
            System.exit(0);
        }
    }
    
    /**
     * Converts a list of Date212 objects to a string representation.
     *
     * @param dates The list of Date212 objects to convert
     * @return A string representation of the dates
     */
    private String convertDatesToString(ArrayList<Date212> dates) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Date212 date : dates) {
            stringBuilder.append(date.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Opens a file using a file chooser and processes its contents.
     */
    protected void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            ArrayList<Date212> unsortedDates = new ArrayList<>();
            ArrayList<Date212> sortedDates = new ArrayList<>();
            StringTokenizer dateTokens;
            
            TextFileInput fileInput = new TextFileInput(fileChooser.getSelectedFile().getAbsolutePath());
            String line;
            while ((line = fileInput.readLine()) != null) {
                dateTokens = new StringTokenizer(line, ",");
                String dateStr;
                while (dateTokens.hasMoreTokens()) {
                    dateStr = dateTokens.nextToken();
                    try {
                        Date212 date = new Date212(dateStr);
                        unsortedDates.add(date);
                        sortedDates.add(date);
                    } catch (IllegalDate212Exception e) {
                        System.out.println("Invalid date found: " + dateStr);
                    }
                }
            }
            fileInput.close();

            Collections.sort(sortedDates);

            // Convert dates to strings for display in JTextAreas
            String unsortedContent = convertDatesToString(unsortedDates);
            String sortedContent = convertDatesToString(sortedDates);

            // Update JTextAreas in Date212GUI
            dateGUI.setUnsortedTextAreaContent(unsortedContent);
            dateGUI.setSortedTextAreaContent(sortedContent);
        }
    }
}
