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

    ArrayList<String> foundTitles = new ArrayList<String>();

    // alphabetical
    JList foundTitlesList = new JList(foundTitles.toArray());

    JButton btn_back_to_browse = new JButton("Back to Browse");

    JTextField txt_search = new JTextField();

    JButton btn_enter = new JButton("Enter");

    // scroller where list goes in
    JScrollPane scroll_pane_title_list = new JScrollPane(foundTitlesList, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    public searchGUI() {
        super("Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);

        setLayout(null);

        // x, y, width, height ..?
        // First screen, prompt the user to enter their customerID
        btn_back_to_browse.setBounds(5, 20, 175, 25);
        txt_search.setBounds(190, 20, 400, 25);
        btn_enter.setBounds(600, 20, 100, 25);
        scroll_pane_title_list.setBounds(10, 50, 680, 400);

        // Adding to screen
        // button 1
        add(btn_back_to_browse);

        // search bar
        add(txt_search);

        // button 2
        add(btn_enter);

        //big list
        add(scroll_pane_title_list);


        // if button clicked then run the save function
        btn_enter.addActionListener(e -> enterForTitleFunc());

        setVisible(true);
    }

    public String receivedTitle;
    // public boolean validIDFound;

    public void enterForTitleFunc() {

        receivedTitle = txt_search.getText();

        // Valid ID: 1488844
        System.out.println("I got the following media_title: " + receivedTitle);

        MainFile mainFile = new MainFile();

        // this function returns result of type ResultSet
        ResultSet rs = mainFile.runSQLString("SELECT * FROM mediacollection WHERE media_title LIKE '%" + receivedTitle + "%';");
        try {
            while (rs.next()) {
                foundTitles.add(rs.getString("media_title") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        foundTitlesList.repaint();
        scroll_pane_title_list.repaint();

        for(int i = 0; i < foundTitles.size(); i++){
            System.out.println(foundTitles.get(i));
        }
    }
}