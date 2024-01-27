import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Project1 {
    public static void main(String[] args) throws IOException{
        StringTokenizer dateTokens;
        // Array list, so no size is set
        ArrayList<Date212> unsortedDates = new ArrayList<>();
        ArrayList<Date212> sortedDates = new ArrayList<>();

        File file = new File (args[0]);
        if (!file.exists()) {
            System.out.println("File not found");
            System.exit(0);
        }
        //Read the input file and parse dates
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            //Tokens 
            dateTokens= new StringTokenizer(line,"," );
            String dateStr;
            while (dateTokens.hasMoreTokens()) {
                dateStr = dateTokens.nextToken();
                Date212 date = new Date212(dateStr);
                // Check if date is valid before adding to the lists 
                if (date.getMonth() != 0) {
                    unsortedDates.add(date);
                    sortedDates.add(date);
                }
            }
        }
        reader.close();

        // Sort the dates using Selection Sort
        selectionSort(sortedDates);
        // All dates to GUI and set true to display it
        DateGUI gui= new DateGUI(unsortedDates, sortedDates);
        gui.setVisible(true);
    }
    
    // Selection sort method 
    private static void selectionSort(ArrayList<Date212> dates) {
        int size= dates.size();
        for (int i= 0; i < size; i++) {
            int min= i;
            for (int n= i; n < size; n++) {
                if (dates.get(n).compareTo(dates.get(min))< 0) {
                    min=n;
                }
            }
            if (min!= i) {
                Date212 hold = dates.get(i);
                dates.set(i, dates.get(min));
                dates.set(min, hold);
            }
        }
    }
}
