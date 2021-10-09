/* 
import javax.swing.*;

//import javax.swing.JComboBox;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.sql.*;
import java.awt.event.*;
import java.awt.Dimension;

public class welcomeGUI extends JFrame {

    // First screen, prompt the user to enter their customerID
    // Declare GUI variables for first screen
    JLabel lbl_customerID = new JLabel("Customer ID: ");
    JTextField txt_customerID = new JTextField();
    JLabel lbl_instruction = new JLabel("Enter your customer ID");
    JButton btn_save = new JButton("Enter");

    // MAIN FUNCTION
    

    public ResultSet runSQLString(String inputSQLString) {
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

        // JOptionPane.showMessageDialog(null, "");

        System.out.println("Opened database successfully");

        // STEP 2: Get something from the database
        String name = "";

        ResultSet result = null;
        try {
            // create a statement object
            Statement stmt = conn.createStatement();
            // create an SQL statement
            String sqlStatement = inputSQLString;
            // send statement to DBMS
            result = stmt.executeQuery(sqlStatement);

            // System.out.println("result: " + result);

            // while (result.next()) {
            //     name += result.getString("media_title") + "\n";
            // }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error accessing Database."); //!Failing
        }

        return result;
    }

    // METHODS
    public welcomeGUI() {
        super("Client Site Name");

        // numberOfTerms();

        // this will make the program shut down
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 700 by 500 is for the larger one
        // 400 by 400 is for small square pane
        setSize(400, 400);

        // sets the layout to null so we can manually place items
        setLayout(null);

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

        // if button clicked then run the save function
        btn_save.addActionListener(e -> saveID());

        // --------------------------------------------------------------------------------------------------
        setVisible(true);
    }

    // * All methods deleted

    public boolean saveID() {

        boolean validIDFound = false;

        String receivedID = txt_customerID.getText();

        //Valid ID:  1488844
        System.out.println("I got the following customer id: " + receivedID);

        // this function returns result of type ResultSet
        ResultSet rs = runSQLString("SELECT COUNT(*) FROM customerswatchedlist WHERE customer_Id = '" + receivedID + "';");

        // System.out.println("result val: " + rs);
        // System.out.println((Number) rs.getObject(1).intValue());

        int intCount = 0;

        try {
            while (rs.next()){
                
                long count = rs.getLong(1);
                intCount = (int)count;
                System.out.println("intCount: " + intCount);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(intCount > 0){
            validIDFound = true;
        }

        return validIDFound;
        
    }
}
 */