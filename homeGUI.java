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

    public homeGUI() {

        // Frame configurations
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this will make the program shut down
        setTitle("Home");
        setLayout(null);
        setSize(700,500);

        //Left side of screen
        JLabel recommendedForYou = new JLabel("Recommended For You");
            recommendedForYou.setBounds(100, 0, 300, 100);

        JTextArea tenRecommendations = new JTextArea("1. ...\n2. ...\n3. ...");
            tenRecommendations.setEditable(false);  

        JScrollPane scrollpane1 = new JScrollPane(tenRecommendations);   //Note: Had to make the JTextArea a scrollpane in order to set its dimensions
            scrollpane1.setBounds(30, 70, 300, 300);

        JButton searchButton = new JButton("Search For Titles");
            searchButton.setBounds(30, 400, 300, 40);
            searchButton.addActionListener(e -> openSearch());
        
        //Right side of screen
        JLabel historyLabel = new JLabel("Your Watch History");
            historyLabel.setBounds(460, 0, 200, 100);

        JTextArea watchHistory = new JTextArea("...\n...");
            watchHistory.setEditable(false);

        JScrollPane scrollpane2 = new JScrollPane(watchHistory);
            scrollpane2.setBounds(360, 70, 310, 300);

        JButton week = new JButton("This Week");
            week.setBounds(355, 400, 100, 50);

        JButton month = new JButton("This Month");
            month.setBounds(465, 400, 100, 50);

        JButton year = new JButton("This Year");
            year.setBounds(575, 400, 100, 50);

        add(recommendedForYou);
        add(scrollpane1);
        add(searchButton);
        add(historyLabel);
        add(scrollpane2);
        add(week);
        add(month);
        add(year);

        // Add panels to frame, and make it visible
        
        setLocationRelativeTo(null); // center the frame on the screen when it opens
        //pack();
        setVisible(true);
    }

    public void openSearch(){
        searchGUI search = new searchGUI();
        setVisible(false);
        dispose();
    }
}
