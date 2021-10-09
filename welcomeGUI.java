
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



    public welcomeGUI() {
        super("Eleven Tech Solutions");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 400);

        setLayout(null);

        // Create a scroller, set its size, set scroller in constructor give it list
        lbl_instruction.setBounds(100, 10, 400, 25);

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

    public String receivedID;
    public boolean validIDFound;
    
    public boolean saveID() {

        validIDFound = false;

        receivedID = txt_customerID.getText();

        //Valid ID:  1488844
        System.out.println("I got the following customer id: " + receivedID);

        MainFile mainFile = new MainFile();

        // this function returns result of type ResultSet
        ResultSet rs = mainFile.runSQLString("SELECT COUNT(*) FROM customerswatchedlist WHERE customer_Id = '" + receivedID + "';");

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
        }else{
            lbl_instruction.setText("ERROR: Please enter an ID with at least 1 entry.");
        }

        return validIDFound;
        
    }

    public String getCustomerID(){
        return receivedID;
    }

    public boolean getValidIDFound(){
        return validIDFound;
    }
}
