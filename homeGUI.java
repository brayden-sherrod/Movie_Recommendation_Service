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
        setTitle("Eleven Tech Solutions");
        setSize(700,500);
        setLayout(null);
        
        JLabel recommendedForYou = new JLabel("Recommended For You");
            recommendedForYou.setBounds(50, 0, 300, 100);
        JTextArea tenRecommendations = new JTextArea("1. ...\n2. ...\n3. ...");
            tenRecommendations.setEditable(false);
        JScrollPane scrollpane = new JScrollPane(tenRecommendations);
            scrollpane.setBounds(30, 70, 300, 300);
        JTextField searchForTitles = new JTextField("Search for Titles");
            searchForTitles.setBounds(30, 420, 300, 40);
        
        add(recommendedForYou);
        add(scrollpane);
        add(searchForTitles);

        // Add panels to frame, and make it visible
        
        setLocationRelativeTo(null); // center the frame on the screen when it opens
        pack();
        setVisible(true);
    }

}
