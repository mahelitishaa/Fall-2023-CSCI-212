import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Represents the main class for Project3 that reads dates from a file,
 * stores them, sorts them, and displays them in a GUI.
 */
public class Project3 {

    /**
     * Main method to execute the process of reading, storing, sorting, and displaying dates.
     *
     * @param args Command-line arguments
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static void main(String[] args) throws IOException{
        StringTokenizer dateTokens;
        ArrayList<Date212> unsortedDates = new ArrayList<>();
        ArrayList<Date212> sortedDates = new ArrayList<>();

        TextFileInput fileInput = new TextFileInput("dates.txt");

        String line;
        while ((line = fileInput.readLine()) != null) {
            dateTokens = new StringTokenizer(line, ",");
            String dateStr;
            while (dateTokens.hasMoreTokens()) {
                dateStr = dateTokens.nextToken();
                try {
                    // Attempting to create Date212 objects from the date string
                    Date212 date = new Date212(dateStr);
                    unsortedDates.add(date);
                    sortedDates.add(date);
                } catch (IllegalDate212Exception e) {
                    // Catching and printing invalid dates
                    System.out.println("Invalid date found: " + dateStr);
                }
            }
        }
        fileInput.close();

        // Sorting using Collections.sort()
        Collections.sort(sortedDates);

        // All dates to GUI and set true to display it
        Date212GUI gui = new Date212GUI(unsortedDates, sortedDates);
        gui.setVisible(true);
    }
}
