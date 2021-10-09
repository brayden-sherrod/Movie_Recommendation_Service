
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

    JPanel panelLeft;
    JPanel panelRight;

    public homeGUI() {

        // Frame configurations
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this will make the program shut down
        setTitle("Eleven Tech Solutions");
        setSize(700,500);
        
        // panelLeft configurations
        panelLeft = new JPanel();
        panelLeft.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panelLeft.setLayout(new GridLayout(1,1));
        
        // panelLeft Components
        JLabel recommendedForYou = new JLabel("Recommended For You");
        JTextArea tenRecommendations = new JTextArea("1. ...\n2. ...\n3. ...");
            tenRecommendations.setSize(100, 300);
        JTextField searchForTitles = new JTextField("Search for Titles");
        panelLeft.add(recommendedForYou);
        panelLeft.add(tenRecommendations);
        panelLeft.add(searchForTitles);

        // Add panels to frame, and make it visible
        add(panelLeft, BorderLayout.WEST);
        setLocationRelativeTo(null); // center the frame on the screen when it opens
        pack();
        setVisible(true);
    }

}
