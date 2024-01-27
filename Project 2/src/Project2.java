import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * The Project2 class contains the main method to read dates from a file, process and sort them,
 * and display the sorted dates in a GUI using the Date212GUI class.
 */
public class Project2 {
    /**
     * The main method reads dates from a file, processes and sorts them, then displays the sorted dates in a GUI.
     *
     * @param args Command-line arguments 
     * @throws IOException If an I/O exception occurs while reading the file
     */
    public static void main(String[] args) throws IOException {
        LinkedList<Date212> unsortedDates = new LinkedList<>();
        LinkedList<Date212> sortedDates = new LinkedList<>();

        File file = new File("dates.txt"); 
        if (!file.exists()) {
            System.out.println("File not found");
            System.exit(0);
        }

        TextFileInput reader = new TextFileInput("dates.txt");
        String line;
        while ((line = reader.readLine()) != null) {
        StringTokenizer dateTokens = new StringTokenizer(line, ",");
        while (dateTokens.hasMoreTokens()) {
            String dateStr = dateTokens.nextToken();
            Date212 date = new Date212(dateStr);
        if (date.getMonth() != 0) {
            unsortedDates.add(date);
            sortedDates.add(date);
        }
    }
}
reader.close();

        // Sort the unsortedDates using UnsortedDate212List
        UnsortedDate212List unsortedList = new UnsortedDate212List();
        for (Date212 date : unsortedDates) {
            unsortedList.add(date);
        }

        // Sort the sortedDates using SortedDate212List
        SortedDate212List sortedList = new SortedDate212List();
        for (Date212 date : sortedDates) {
            sortedList.add(date);
        }

        LinkedList<Date212> sortedUnsortedDates = new LinkedList<>();
        for (Date212Node node = unsortedList.first.next; node != null; node = node.next) {
            sortedUnsortedDates.add(node.data);
        }

        LinkedList<Date212> sortedSortedDates = new LinkedList<>();
        for (Date212Node node = sortedList.first.next; node != null; node = node.next) {
            sortedSortedDates.add(node.data);
        }

        // All dates to GUI and set true to display it
        Date212GUI gui = new Date212GUI(sortedUnsortedDates, sortedSortedDates);
        gui.setVisible(true);
    }
}
