import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class FileMenuHandler implements ActionListener {
    private Date212GUI dateGUI;
    private ArrayList<Date212> allUnsortedDates;
    private ArrayList<Date212> allSortedDates;

    public FileMenuHandler(Date212GUI dateGUI) {
        this.dateGUI = dateGUI;
    }

    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();
        if (menuName.equals("Open")) {
            openFile();
        } else if (menuName.equals("Quit")) {
            System.exit(0);
        } else if (menuName.equals("Search")) {
            searchByYear();
        }
    }

    private String convertDatesToString(ArrayList<Date212> dates) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Date212 date : dates) {
            stringBuilder.append(date.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

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

            allUnsortedDates = new ArrayList<>(unsortedDates);
            allSortedDates = new ArrayList<>(sortedDates);

            String unsortedContent = convertDatesToString(unsortedDates);
            String sortedContent = convertDatesToString(sortedDates);

            dateGUI.setUnsortedTextAreaContent(unsortedContent);
            dateGUI.setSortedTextAreaContent(sortedContent);
        }
    }

    public void searchByYear() {
        String input = JOptionPane.showInputDialog(dateGUI, "Enter a year:");
        if (input != null && !input.isEmpty()) {
            int searchYear = Integer.parseInt(input);
            ArrayList<Date212> foundDatesUnsorted = new ArrayList<>();
            ArrayList<Date212> foundDatesSorted = new ArrayList<>();

            for (Date212 date : allUnsortedDates) {
                if (date.getYear() == searchYear) {
                    foundDatesUnsorted.add(date);
                }
            }

            for (Date212 date : allSortedDates) {
                if (date.getYear() == searchYear) {
                    foundDatesSorted.add(date);
                }
            }

            dateGUI.setUnsortedTextAreaContent(convertDatesToString(foundDatesUnsorted));
            dateGUI.setSortedTextAreaContent(convertDatesToString(foundDatesSorted));
        }
    }
}
