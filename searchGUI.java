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

public class searchGUI extends JFrame {

        // First screen, prompt the user to enter their customerID
    // Declare GUI variables for first screen
    
    JButton btn_back_to_browse = new JButton("Back to Browse");

    JTextField txt_search = new JTextField();
    
    JButton btn_enter = new JButton("Enter");

    public searchGUI() {
        super("Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);

        setLayout(null);

        // x, y, width, height ..?
        // First screen, prompt the user to enter their customerID
        btn_back_to_browse.setBounds(5, 40, 175, 25);
        txt_search.setBounds(230, 40, 400, 25);
        btn_enter.setBounds(150, 250, 100, 25);


        // Adding to screen

        // button 1
        add(btn_back_to_browse);

        // search bar
        add(txt_search);

        // button 2
        add(btn_enter);

        // if button clicked then run the save function
        btn_enter.addActionListener(e -> enterForTitleFunc());

        setVisible(true);
    }

    public String receivedID;
    // public boolean validIDFound;
    
    public void enterForTitleFunc() {

        receivedID = txt_search.getText();

        //Valid ID:  1488844
        System.out.println("I got the following customer id: " + receivedID);

        MainFile mainFile = new MainFile();

        // this function returns result of type ResultSet
        ResultSet rs = mainFile.runSQLString("SELECT COUNT(*) FROM customerswatchedlist WHERE customer_Id = '" + receivedID + "';");


        
    }
}