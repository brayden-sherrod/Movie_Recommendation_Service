import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class analyticsGUI extends JFrame {

    // Public class variables
    JPanel panel = new JPanel();
    ArrayList<String> foundTitles = new ArrayList<String>();
    JList foundTitlesList = new JList(foundTitles.toArray());
    JScrollPane scroll_pane_title_list = new JScrollPane(foundTitlesList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Scroller where list goes in

    JButton btn_back_to_welc = new JButton("Back to Welcome Page");

    public analyticsGUI() {
        // Frame configurations
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Analytics Portal");
        setSize(700, 500); // width , height

        // Panel configurations
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(null);

        // Components
        JLabel titleText = new JLabel("Top 10 Most Watched Media");
        JTextArea list = new JTextArea(
                "1. ...\n2. ...\n3. ...\n4. ...\n5. ...\n6. ...\n7. ...\n8. ...\n9. ...\n10. ...");
        list.setEditable(false);

        // back to welcome page button
        btn_back_to_welc.setBounds(10, 10, 200, 25);
        add(btn_back_to_welc);
        btn_back_to_welc.addActionListener(e -> backWelcFunc());

        JButton weekly = new JButton("weekly");
        weekly.addActionListener(e -> viewWeekly());
        JButton monthly = new JButton("monthly");
        monthly.addActionListener(e -> viewMonthly());
        JButton yearly = new JButton("yearly");
        yearly.addActionListener(e -> viewYearly());

        // Configure component placements
        titleText.setBounds(270, 20, 200, 30);
        list.setBounds(100, 60, 500, 300);
        weekly.setBounds(100, 380, 120, 40);
        monthly.setBounds(290, 380, 120, 40);
        yearly.setBounds(480, 380, 120, 40);

        // Add components to frame
        panel.add(titleText);
        panel.add(list);
        panel.add(weekly);
        panel.add(monthly);
        panel.add(yearly);

        // Add panel to frame and allow visibility
        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null); // center the window on the screen
        setVisible(true);
    }

    public void backWelcFunc(){
        welcomeGUI wG = new welcomeGUI();
        setVisible(false);
        dispose();
    }

    public void viewWeekly() {

        foundTitles.clear();
        MainFile mainFile = new MainFile();

        // Connect to database
        ResultSet rs = mainFile.runSQLString("SELECT * FROM customerswatchedlist LIMIT 10;");
        try {
            while (rs.next()) {
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void viewMonthly() {

        foundTitles.clear();
        MainFile mainFile = new MainFile();

        // Connect to database
        ResultSet rs = mainFile.runSQLString("SELECT * FROM customerswatchedlist LIMIT 10;");
        try {
            while (rs.next()) {
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewYearly() {

        foundTitles.clear();
        MainFile mainFile = new MainFile();

        // Connect to database
        ResultSet rs = mainFile.runSQLString("SELECT * FROM customerswatchedlist LIMIT 10;");
        try {
            while (rs.next()) {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}