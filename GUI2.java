
import javax.swing.*;
//import javax.swing.JComboBox;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.sql.*;
import java.awt.event.*;
import java.awt.Dimension;



public class GUI2 extends JFrame {

    // First screen, prompt the user to enter their customerID
    JLabel lbl_customerID = new JLabel("Customer ID: ");
    JTextField txt_customerID = new JTextField();
    JLabel lbl_instruction = new JLabel("Enter your customer ID");
    JButton btn_save = new JButton("Enter");

    public static void main(String[] args) {
        // Building the connection
        Connection conn = null;
        
        // STEP 1: Connecting to the database
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

        // STEP 2: Get something from the database
        String name = "";
        try {
            // create a statement object
            Statement stmt = conn.createStatement();
            // create an SQL statement
            String sqlStatement = "SELECT * FROM mediacollection LIMIT 10;";
            // send statement to DBMS
            ResultSet result = stmt.executeQuery(sqlStatement);
            while (result.next()) {
                name += result.getString("media_title") + "\n";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error accessing Database.");
        }

        // STEP 3: Call our GUI
        new GUI2();
    }

    public GUI2() {
        super("Client Site Name");

        // numberOfTerms();

        // this will make the program shut down
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(400, 400);

        // sets the layout to null so we can manually place items
        setLayout(null);

        // left list of contacts

        // Create a scroller, set its size, set scroller in constructor give it list
        lbl_instruction.setBounds(100, 10, 210, 25);

        // First screen, prompt the user to enter their customerID
        lbl_customerID.setBounds(100, 40, 175, 25);
        txt_customerID.setBounds(190, 40, 160, 25);
        btn_save.setBounds(150, 250, 100, 25);

        // ------------------------------------------------------------------------------------------------
        // running the operation once the button is pressed

        // save button action
        // btn_save.addActionListener(e -> save());

        // btn_new.addActionListener(e -> clear());

        // pplList.addListSelectionListener(e -> selected());

        // btn_delete.addActionListener(e -> delete(e));

        // btn_enter.addActionListener(e -> saveChanges());

        // -------------------------------------------------------------------------------------------------
        // adding to screen

        // instructions
        add(lbl_instruction);

        // Customer_ID
        add(lbl_customerID);
        add(txt_customerID);

        // buttons
        add(btn_save);

        // --------------------------------------------------------------------------------------------------
        setVisible(true);

    }

    boolean needsMore = false;

    //* All methods deleted

}
