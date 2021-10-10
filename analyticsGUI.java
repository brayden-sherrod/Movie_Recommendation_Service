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
    JScrollPane scroll_pane_title_list = new JScrollPane(foundTitlesList, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Scroller where list goes in

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
        
        // Back to welcome page button
        btn_back_to_welc.setBounds(10, 10, 200, 25);
        add(btn_back_to_welc);
        btn_back_to_welc.addActionListener(e -> backWelcFunc());

        // Other buttons
        JButton alltime = new JButton("all time");
        alltime.addActionListener(e -> viewAlltime());
        JButton monthly = new JButton("monthly");
        monthly.addActionListener(e -> viewMonthly());
        JButton yearly = new JButton("yearly");
        yearly.addActionListener(e -> viewYearly());

        // Configure component placements
        titleText.setBounds(270, 20, 200, 30);
        scroll_pane_title_list.setBounds(100, 60, 500, 300);
        alltime.setBounds(100, 380, 120, 40);
        monthly.setBounds(290, 380, 120, 40);
        yearly.setBounds(480, 380, 120, 40);

        // Add components to frame
        panel.add(titleText);
        panel.add(scroll_pane_title_list);
        panel.add(alltime);
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

    public void viewAlltime() {

        foundTitles.clear();
        MainFile mainFile = new MainFile();

        // Connect to database
        ResultSet rs = mainFile.runSQLString("SELECT A.media_title FROM mediacollection A WHERE A.media_id in (SELECT media_id FROM (SELECT media_id,COUNT(media_id) AS value_occurrence FROM customersratings GROUP BY media_id ORDER BY value_occurrence DESC LIMIT 10) AS foo);");
        try {
            while (rs.next()) {
                foundTitles.add(rs.getString("media_title") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Print if no titles returned
        if (foundTitles.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No titles watched ever.");
        }

        // Display the titles
        foundTitlesList.setListData(foundTitles.toArray());
        foundTitlesList.repaint();
        scroll_pane_title_list.repaint();
        for (int i = 0; i < foundTitles.size(); i++) {
            System.out.println(foundTitles.get(i));
        }

    }

    public void viewMonthly() {

        foundTitles.clear();
        MainFile mainFile = new MainFile();

        // Connect to database
        ResultSet rs = mainFile.runSQLString("SELECT A.media_title FROM mediacollection A WHERE A.media_id in (SELECT media_id FROM (SELECT media_id,COUNT(media_id) AS value_occurrence FROM customersratings WHERE (date_rated BETWEEN '2005-11-30' AND '2005-12-21') GROUP BY media_id ORDER BY value_occurrence DESC LIMIT 10) AS foo);");
        try {
            while (rs.next()) {
                foundTitles.add(rs.getString("media_title") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Print if no titles returned
        if (foundTitles.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No titles watched in the past month.");
        }

        // Display the titles
        foundTitlesList.setListData(foundTitles.toArray());
        foundTitlesList.repaint();
        scroll_pane_title_list.repaint();
        for (int i = 0; i < foundTitles.size(); i++) {
            System.out.println(foundTitles.get(i));
        }
    }

    public void viewYearly() {

        foundTitles.clear();
        MainFile mainFile = new MainFile();

        // Connect to database
        ResultSet rs = mainFile.runSQLString("SELECT A.media_title FROM mediacollection A WHERE A.media_id in (SELECT media_id FROM (SELECT media_id,COUNT(media_id) AS value_occurrence FROM customersratings WHERE (date_rated BETWEEN '2004-12-31' AND '2005-12-21') GROUP BY media_id ORDER BY value_occurrence DESC LIMIT 10) AS foo);");
        try {
            while (rs.next()) {
                foundTitles.add(rs.getString("media_title") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Print if no titles returned
        if (foundTitles.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No titles watched in the past year.");
        }

        // Display the titles
        foundTitlesList.setListData(foundTitles.toArray());
        foundTitlesList.repaint();
        scroll_pane_title_list.repaint();
        for (int i = 0; i < foundTitles.size(); i++) {
            System.out.println(foundTitles.get(i));
        }
    }
}