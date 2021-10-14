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

    JTextField startField = new JTextField();
    JTextField endField = new JTextField();
    JTextField title1 = new JTextField();
    JTextField title2 = new JTextField();
    JLabel titleText = new JLabel("Top 10 Most Watched Media");
    

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
        
        JButton enterButton = new JButton("Enter");
        JLabel top10Label = new JLabel("Top 10 Media From:");
        JLabel startLabel = new JLabel("Start Date");
        JLabel endLabel = new JLabel("End Date");

        JButton hollywoodPairs = new JButton("Hollywood Pairs");  //* PHASE 4
        JButton cultClassics = new JButton("Cult Classics");      // " "
        JLabel freshTomato = new JLabel("Fresh Tomato Number:");  // " "
        JButton enterTomato = new JButton("Enter");
        JLabel title1Label = new JLabel("Title 1");
        JLabel title2Label = new JLabel("Title 2");        

        // Components config
        startField.setEditable(true);
        endField.setEditable(true);
        
        hollywoodPairs.addActionListener(e -> showPairs());   //* PHASE 4 
        cultClassics.addActionListener(e -> showCult());
        title1.setEditable(true);
        title2.setEditable(true);
        enterButton.addActionListener(e -> enterInfo());
        
        // Back to welcome page button
        btn_back_to_welc.setBounds(10, 10, 200, 25);
        add(btn_back_to_welc);
        btn_back_to_welc.addActionListener(e -> backWelcFunc());

        // Configure component placements
        titleText.setBounds(270, 20, 200, 30);
        scroll_pane_title_list.setBounds(100, 60, 500, 250);

        top10Label.setBounds(490, 300, 120, 40);
        startField.setBounds(420, 360, 120, 40);
        startLabel.setBounds(460, 320, 120, 40);
        endLabel.setBounds(580, 320, 120, 40);
        endField.setBounds(560, 360, 120, 40);
        enterButton.setBounds(490, 410, 120, 30);
        
        hollywoodPairs.setBounds(40, 315, 200, 20);
        cultClassics.setBounds(40, 340, 200, 20);
        freshTomato.setBounds(95, 360, 200, 40);
        title1Label.setBounds(40, 390, 200, 20);
        title2Label.setBounds(160, 390, 200, 20);
        title1.setBounds(20, 420, 100, 30);
        title2.setBounds(130, 420, 100, 30);
        enterTomato.setBounds(240, 418, 100, 30);

        // Add components to frame
        panel.add(titleText);
        panel.add(scroll_pane_title_list);

        panel.add(top10Label);
        panel.add(startField);
        panel.add(startLabel);
        panel.add(endField);
        panel.add(endLabel);
        panel.add(enterButton);

        panel.add(hollywoodPairs);
        panel.add(cultClassics);
        panel.add(freshTomato);
        panel.add(title1Label);
        panel.add(title2Label);
        panel.add(title1);
        panel.add(title2);
        panel.add(enterTomato);

        // Add panel to frame and allow visibility
        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null); // center the window on the screen
        setVisible(true);

    }

    public void enterInfo(){
        titleText.setText("Top 10 Most Watched Media");
        foundTitles.clear();
        
        String start_date = startField.getText();
        String end_date = endField.getText();

        MainFile mainFile = new MainFile();

        // Connect to database
        ResultSet rs = mainFile.runSQLString("SELECT A.media_title FROM mediacollection A WHERE A.media_id in (SELECT media_id FROM (SELECT media_id,COUNT(media_id) AS value_occurrence FROM customersratings WHERE (date_rated BETWEEN '" + start_date + "' AND '" + end_date + "') GROUP BY media_id ORDER BY value_occurrence DESC LIMIT 10) AS foo);");
        try {
            while (rs.next()) {
                foundTitles.add(rs.getString("media_title") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Display the titles
        foundTitlesList.setListData(foundTitles.toArray());
        foundTitlesList.repaint();
        scroll_pane_title_list.repaint();
        for (int i = 0; i < foundTitles.size(); i++) {
            System.out.println(foundTitles.get(i));
        }
    }

    //* Aidan
    public void showCult(){
        titleText.setText("Cult Classics");
        foundTitles.clear();
        
        MainFile mainFile = new MainFile();

        //Connect to database
        ResultSet rs = mainFile.runSQLString("SELECT media_title FROM mediacollection A WHERE A.media_id in( SELECT media_id FROM( SELECT media_id, COUNT(media_id) AS value_occurrence FROM customersratings WHERE customer_rating > 3 GROUP BY media_id ORDER BY value_occurrence DESC LIMIT 10) AS foo);");
        try{
            while(rs.next()){
                foundTitles.add(rs.getString("media_title") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Display found titles
        foundTitlesList.setListData(foundTitles.toArray());
        foundTitlesList.repaint();
        scroll_pane_title_list.repaint();
        for(int i = 0; i < foundTitles.size(); ++i){
            System.out.println(foundTitles.get(i));
        }
    }
    

    public void backWelcFunc(){
        new welcomeGUI();
        setVisible(false);
        dispose();
    }
    
    //* Brayden
    public void showPairs(){
        
    }

    //* Rose
    public void enterTitles(){
        foundTitles.clear();

        String firstTitle = title1.getText();
        String secondTitle = title2.getText();

        // STEP 1: Check if both titles are rated by customers
        MainFile mainFile = new MainFile();
        ResultSet rs = mainFile.runSQLString("TO DO COMMAND");
        int titleValidityCode = 0;   // 0=before scanned for title ratings; 1=first title not found; 2=second title not found; 3=both titles found
        try {
            while (rs.next()) {
                foundTitles.add(rs.getString("media_title") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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