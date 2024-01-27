import javax.swing.*;
import java.util.ArrayList;

public class EditMenuHandler {
    private Date212GUI dateGUI;
    private ArrayList<Date212> unsortedDates;
    private ArrayList<Date212> sortedDates;

    public EditMenuHandler(Date212GUI dateGUI, ArrayList<Date212> unsortedDates, ArrayList<Date212> sortedDates) {
        this.dateGUI = dateGUI;
        this.unsortedDates = unsortedDates;
        this.sortedDates = sortedDates;
    }

    public void searchByYear() {
        String input = JOptionPane.showInputDialog(dateGUI, "Enter a year:");
        if (input != null && !input.isEmpty()) {
            int searchYear = Integer.parseInt(input);
            ArrayList<Date212> foundDatesUnsorted = new ArrayList<>();
            ArrayList<Date212> foundDatesSorted = new ArrayList<>();

            // Searching in unsorted dates
            for (Date212 date : unsortedDates) {
                if (date.getYear() == searchYear) {
                    foundDatesUnsorted.add(date);
                }
            }

            // Searching in sorted dates
            for (Date212 date : sortedDates) {
                if (date.getYear() == searchYear) {
                    foundDatesSorted.add(date);
                }
            }

            // Updating GUI text areas
            dateGUI.setUnsortedTextAreaContent(convertDatesToString(foundDatesUnsorted));
            dateGUI.setSortedTextAreaContent(convertDatesToString(foundDatesSorted));
        }
    }

    private String convertDatesToString(ArrayList<Date212> dates) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Date212 date : dates) {
            stringBuilder.append(date.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
