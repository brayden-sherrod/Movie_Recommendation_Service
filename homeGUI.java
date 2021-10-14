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
    JScrollPane scroll_pane_rec = new JScrollPane(jList_rec, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Scroller where list goes in

    // Scroll pane setup for watch history
    ArrayList<String> arr_list_watch_hist = new ArrayList<String>();
    JList jList_watch_hist = new JList(arr_list_watch_hist.toArray());
    JScrollPane scroll_pane_watch_hist = new JScrollPane(jList_watch_hist, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Scroller where list goes in

    public String receivedID;

    public String startDate;
    public String endDate;

    public homeGUI(String receivedID) {

        this.receivedID = receivedID;

        // Frame configurations
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this will make the program shut down
        setTitle("Home");
        setLayout(null);
        setSize(700,500);

        //* Left side of screen
        JLabel recommendedForYou = new JLabel("Recommended For You");
            recommendedForYou.setBounds(100, 0, 300, 100);

        // JTextArea tenRecommendations = new JTextArea("1. ...\n2. ...\n3. ...");
        //     tenRecommendations.setEditable(false);  

        // JScrollPane scrollpane1 = new JScrollPane(tenRecommendations);   //Note: Had to make the JTextArea a scrollpane in order to set its dimensions
        //     scrollpane1.setBounds(30, 70, 300, 300);

        scroll_pane_rec.setBounds(30, 70, 300, 300);
        add(scroll_pane_rec);


        JButton searchButton = new JButton("Search For Titles");
            searchButton.setBounds(30, 400, 300, 40);
            searchButton.addActionListener(e -> openSearch());
        
        //* Right side of screen
        JLabel historyLabel = new JLabel("Your Watch History");
            historyLabel.setBounds(460, 0, 200, 100);

        // JTextArea watchHistory = new JTextArea("...\n...");
        //     watchHistory.setEditable(false);


        // JScrollPane scrollpane2 = new JScrollPane(watchHistory);
        //     scrollpane2.setBounds(360, 70, 310, 300);


        scroll_pane_watch_hist.setBounds(360, 70, 310, 300);
        add(scroll_pane_watch_hist);


        



        // JButton week = new JButton("This Week");
        //     week.setBounds(355, 400, 100, 50);
        //     week.addActionListener(e -> populateWeeklyWatchHist());

        // JButton month = new JButton("This Month");
        //     month.setBounds(465, 400, 100, 50);
        //     month.addActionListener(e -> populateMonthlyWatchHist());

        // JButton year = new JButton("This Year");
        //     year.setBounds(575, 400, 100, 50);
        //     year.addActionListener(e -> populateYearlyWatchHist());

        JButton search = new JButton ("Search");
            search.setBounds(575, 400, 100, 50);
            search.addActionListener(e -> populateWatchHist());


        add(recommendedForYou);
        // add(scrollpane1);
        add(searchButton);
        add(historyLabel);
        // add(scrollpane2);
        // add(week);
        // add(month);
        // add(year);
        add(search);



        // label for start date
        lbl_start.setBounds(10, 0, 175, 25);
        add(lbl_start);
        // text of start date
        txt_start.setBounds(80, 0, 175, 25);
        add(txt_start);

        // label of end date
        lbl_end.setBounds(340, 0, 175, 25);
        add(lbl_end);

        // text for end date
        txt_end.setBounds(400, 0, 175, 25);
        add(txt_end);




        jList_watch_hist.addMouseListener(mouseListener);
        
        setLocationRelativeTo(null); // center the frame on the screen when it opens
        //pack();
        setVisible(true);
    }

    public void openSearch(){
        new searchGUI(receivedID);
        setVisible(false);
        dispose();
    }

    public void populateWeeklyWatchHist(){
        arr_list_watch_hist.clear();

        MainFile mainFile = new MainFile();
        // this function returns the result of trying to get a weeks worth of watch history
        ResultSet rs = mainFile.runSQLString("SELECT * FROM mediacollection JOIN customersratings ON mediacollection.media_id=customersratings.media_id WHERE (customersratings.customer_id = '" + receivedID + "') AND (customersratings.date_rated BETWEEN '2005-12-24' AND '2005-12-31') ORDER BY date_rated DESC;");
    
        try {
            while (rs.next()) {
                arr_list_watch_hist.add(rs.getString("media_title") + "\n");
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

    public void populateMonthlyWatchHist(){
        arr_list_watch_hist.clear();

        MainFile mainFile = new MainFile();
        // this function returns the result of trying to get a weeks worth of watch history
        ResultSet rs = mainFile.runSQLString("SELECT * FROM mediacollection JOIN customersratings ON mediacollection.media_id=customersratings.media_id WHERE (customersratings.customer_id = '" + receivedID + "') AND (customersratings.date_rated BETWEEN '2005-11-30' AND '2005-12-31') ORDER BY date_rated DESC;");
    
        try {
            while (rs.next()) {
                arr_list_watch_hist.add(rs.getString("media_title") + "\n");
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

    public void populateYearlyWatchHist(){
        arr_list_watch_hist.clear();

        MainFile mainFile = new MainFile();
        // this function returns the result of trying to get a weeks worth of watch history
        ResultSet rs = mainFile.runSQLString("SELECT * FROM mediacollection JOIN customersratings ON mediacollection.media_id=customersratings.media_id WHERE (customersratings.customer_id = '" + receivedID + "') AND (customersratings.date_rated BETWEEN '2004-12-31' AND '2005-12-31') ORDER BY date_rated DESC;");
    
        try {
            while (rs.next()) {
                arr_list_watch_hist.add(rs.getString("media_title") + "\n");
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

    public void populateWatchHist(){

        startDate = txt_start.getText();
        endDate = txt_end.getText();

        arr_list_watch_hist.clear();

        MainFile mainFile = new MainFile();
        // this function returns the result of trying to get a weeks worth of watch history
        ResultSet rs = mainFile.runSQLString("SELECT * FROM mediacollection JOIN customersratings ON mediacollection.media_id=customersratings.media_id WHERE (customersratings.customer_id = '" + receivedID + "') AND (customersratings.date_rated BETWEEN '" + startDate + "' AND '" + endDate + "') ORDER BY date_rated DESC;");
    
        try {
            while (rs.next()) {
                arr_list_watch_hist.add(rs.getString("media_title") + "\n");
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
