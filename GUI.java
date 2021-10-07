import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
    TODO:
    1) Change credentials for your own team's database
    2) Change SQL command to a relevant query that retrieves a small amount of data
    3) Create a JTextArea object using the queried data
    4) Add the new object to the JPanel p
*/

public class GUI extends JFrame implements ActionListener {
    static JFrame f;

    public static void main(String[] args) {
        // Building the connection
        Connection conn = null;
        // TODO STEP 1
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://csce-315-db.engr.tamu.edu/csce315903_11db",
                    "csce315903_11user", "new_password");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        JOptionPane.showMessageDialog(null, "Opened database successfully");

        String name = "";
        try {
            // create a statement object
            Statement stmt = conn.createStatement();
            // create an SQL statement
            // TODO Step 2
            String sqlStatement = "SELECT * FROM mediacollection LIMIT 10;";
            // send statement to DBMS
            ResultSet result = stmt.executeQuery(sqlStatement);
            while (result.next()) {
                name += result.getString("media_title") + "\n";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error accessing Database.");
        }
        
        f = new JFrame("DB GUI");           // Create a new frame
        GUI mygui = new GUI();                  // Create a GUI Object
        JPanel mypanel = new JPanel();            // Create a panel
        JButton b = new JButton("Close");  

        // add actionlistener to button
        b.addActionListener(mygui);

        // First screen, prompt the user to enter their customerID
        JLabel lbl_customerID = new JLabel("Customer ID: ");
        JTextField txt_customerID = new JTextField();
        lbl_customerID.setBounds(300,10,175,25);
        //txt_customerID.setBounds(50,100, 200,30);
        txt_customerID.setPreferredSize(new Dimension(300,25));
        mypanel.add(lbl_customerID);              
        mypanel.add(txt_customerID);               


        // TODO Step 4 - adding text area to panel

        // add button to panel
        //p.add(b);

        // add panel to frame
        f.add(mypanel);

        // set the size of frame
        f.setSize(400, 400);
        f.setVisible(true);

        // closing the connection
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "Connection Closed.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection NOT Closed.");
        }
    }

    // if button is pressed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Close")) {
            f.dispose();
        }
    }
}