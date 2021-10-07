
import javax.swing.*;
import java.awt.event.ActionEvent;
//import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GUI2 extends JFrame{
    // use setVisible and setText for buttons

    // First screen, prompt the user to enter their customerID
    JLabel lbl_customerID = new JLabel("Customer ID: ");
    JTextField txt_customerID = new JTextField();
    JLabel lbl_instruction = new JLabel("Enter your customer ID");
    JButton btn_save = new JButton("Enter");

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
