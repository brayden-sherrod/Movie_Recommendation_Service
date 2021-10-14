import javax.swing.*;

//import javax.swing.JComboBox;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.sql.*;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class homeGUI extends JFrame {

    JLabel lbl_start = new JLabel("Start Date: ");
    JTextField txt_start = new JTextField();

    JLabel lbl_end = new JLabel("End Date: ");
    JTextField txt_end = new JTextField();

    // scroll pane for recommended
    ArrayList<String> arr_list_rec = new ArrayList<String>();
    JList jList_rec = new JList(arr_list_rec.toArray());
    JScrollPane scroll_pane_rec = new JScrollPane(jList_rec, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Scroller where list goes in

    // Scroll pane setup for watch history
    ArrayList<String> arr_list_watch_hist = new ArrayList<String>();
    JList jList_watch_hist = new JList(arr_list_watch_hist.toArray());
    JScrollPane scroll_pane_watch_hist = new JScrollPane(jList_watch_hist,
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Scroller
                                                                                                            // where
                                                                                                            // list goes
                                                                                                            // in

    // Variables that will be used in multiple functions of the class
    public String receivedID;
    public String startDate;
    public String endDate;

    public homeGUI(String receivedID) {

        this.receivedID = receivedID;

        // Frame configurations
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this will make the program shut down
        setTitle("Home");
        setLayout(null);
        setSize(700, 500);

        //viewer beware and veiwer recommendation buttons
        JButton searchButton = new JButton("Search For Titles");
        searchButton.setBounds(30, 400, 150, 40);
        // searchButton.addActionListener(e -> openSearch());

        // Left side of screen
        JLabel recommendedForYou = new JLabel("Recommended For You");
        recommendedForYou.setBounds(100, 20, 300, 100);
        scroll_pane_rec.setBounds(30, 90, 300, 300);
        JButton searchButton = new JButton("Search For Titles");
        searchButton.setBounds(30, 400, 150, 40);
        searchButton.addActionListener(e -> openSearch());

        // Right side of screen
        JLabel historyLabel = new JLabel("Your Watch History");
        historyLabel.setBounds(460, 20, 200, 100);
        scroll_pane_watch_hist.setBounds(360, 90, 310, 300);
        JButton search = new JButton("Search");
        search.setBounds(575, 400, 100, 50);
        search.addActionListener(e -> populateWatchHist());

        // START AND END DATES
        // x, y, width, height
        lbl_start.setBounds(220, 405, 175, 25);
        txt_start.setBounds(300, 405, 100, 25);

        lbl_end.setBounds(400, 405, 175, 25);
        txt_end.setBounds(470, 405, 100, 25);

        // Add components to frame
        add(scroll_pane_rec);
        add(scroll_pane_watch_hist);
        add(recommendedForYou);
        add(searchButton);
        add(historyLabel);
        add(lbl_start);
        add(txt_start);
        add(lbl_end);
        add(txt_end);
        add(search);

        jList_watch_hist.addMouseListener(mouseListener);

        // Center the frame window on middle of screen and then allow it to be visible
        setLocationRelativeTo(null);
        setVisible(true);

        txt_start.repaint();
    }

    public void openSearch() {
        new searchGUI(receivedID);
        setVisible(false);
        dispose();
    }

    // Depends on startDate and endDate specified by customer
    public void populateWatchHist() {

        startDate = txt_start.getText();
        endDate = txt_end.getText();

        arr_list_watch_hist.clear();

        MainFile mainFile = new MainFile();

        ResultSet rs = mainFile.runSQLString(
                "SELECT * FROM mediacollection JOIN customersratings ON mediacollection.media_id=customersratings.media_id WHERE (customersratings.customer_id = '"
                        + receivedID + "') AND (customersratings.date_rated BETWEEN '" + startDate + "' AND '" + endDate
                        + "') ORDER BY date_rated DESC;");
        ;

        // ! nullptr exception catch

        try {
            try {
                while (rs.next()) {
                    arr_list_watch_hist.add(rs.getString("media_title") + "\n");
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Check your dates and try again.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (arr_list_watch_hist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No Titles Found");
        }

        jList_watch_hist.setListData(arr_list_watch_hist.toArray());
        jList_watch_hist.repaint();
        scroll_pane_watch_hist.repaint();
    }

    // Makes titles of media clickable (to open up the watch screen)
    MouseListener mouseListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 1) {

                String selectedItem = (String) jList_watch_hist.getSelectedValue();
                System.out.println("found Title: " + selectedItem);

                new watchGUI(selectedItem, receivedID);
            }
        }
    };
}
