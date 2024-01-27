import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Date212GUI extends JFrame {
    private JTextArea unsortedTextArea;
    private JTextArea sortedTextArea;
    private FileMenuHandler fileHandler;
    private EditMenuHandler editHandler;

    public Date212GUI(ArrayList<Date212> unsortedDates, ArrayList<Date212> sortedDates) {
        setTitle("Date Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        leftPanel.setLayout(new BorderLayout());
        rightPanel.setLayout(new BorderLayout());

        unsortedTextArea = new JTextArea(20, 20);
        sortedTextArea = new JTextArea(20, 20);

        unsortedTextArea.setEditable(false);
        sortedTextArea.setEditable(false);

        JScrollPane unsortedScrollPane = new JScrollPane(unsortedTextArea);
        JScrollPane sortedScrollPane = new JScrollPane(sortedTextArea);

        leftPanel.add(new JLabel("Unsorted Dates"), BorderLayout.NORTH);
        rightPanel.add(new JLabel("Sorted Dates"), BorderLayout.NORTH);

        leftPanel.add(unsortedScrollPane, BorderLayout.CENTER);
        rightPanel.add(sortedScrollPane, BorderLayout.CENTER);

        add(leftPanel);
        add(rightPanel);

        populateTextArea(unsortedDates, unsortedTextArea);
        populateTextArea(sortedDates, sortedTextArea);

        pack();
        setLocationRelativeTo(null);

        fileHandler = new FileMenuHandler(this);
        editHandler = new EditMenuHandler(this, unsortedDates, sortedDates);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem quitMenuItem = new JMenuItem("Quit");

        openMenuItem.addActionListener(e -> fileHandler.openFile());
        quitMenuItem.addActionListener(e -> System.exit(0));

        fileMenu.add(openMenuItem);
        fileMenu.add(quitMenuItem);

        JMenu editMenu = new JMenu("Edit");
        JMenuItem searchMenuItem = new JMenuItem("Search");
        searchMenuItem.addActionListener(e -> editHandler.searchByYear());
        editMenu.add(searchMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);
    }

    private void populateTextArea(ArrayList<Date212> dates, JTextArea textArea) {
        StringBuilder sb = new StringBuilder();
        for (Date212 date : dates) {
            sb.append(date.toString()).append("\n");
        }
        textArea.setText(sb.toString());
    }

    public void setUnsortedTextAreaContent(String content) {
        unsortedTextArea.setText(content);
    }

    public void setSortedTextAreaContent(String content) {
        sortedTextArea.setText(content);
    }

    public static void main(String[] args) {
        ArrayList<Date212> unsortedDates = new ArrayList<>();
        ArrayList<Date212> sortedDates = new ArrayList<>();

        SwingUtilities.invokeLater(() -> {
            new Date212GUI(unsortedDates, sortedDates).setVisible(true);
        });
    }
}
