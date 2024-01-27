import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Project4 {
    public static void main(String[] args) throws IOException {
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
