
import javax.swing.*;
import java.awt.event.ActionEvent;
//import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GUI2 extends JFrame {
    ArrayList<Person> aLP = new ArrayList<Person>();

    // use setVisible and setText for buttons

    // left list of contacts

    // alphabetical
    JList pplList = new JList(aLP.toArray());

    // First screen, prompt the user to enter their customerID
    JLabel lbl_customerID = new JLabel("Customer ID: ");
    JTextField txt_customerID = new JTextField();

    // instruction label
    JLabel lbl_instruction = new JLabel("Enter your customer ID");


    // bottom two buttons when creating contact
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

        // create a scroller, set its size, set scroller in constructor give it list
        lbl_instruction.setBounds(100, 10, 210, 25);

        // First screen, prompt the user to enter their customerID
        lbl_customerID.setBounds(100, 40, 175, 25);
        txt_customerID.setBounds(190, 40, 160, 25);

        // instructions

        //x, y, width, height

        // 2 buttons
        btn_save.setBounds(250, 300, 160, 25);

        // 2 buttons when contact is selected
        btn_save.setBounds(150, 250, 100, 25);

        // change away

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
        // add(btn_new);

        // buttons for editing a contact

        // change away

        // --------------------------------------------------------------------------------------------------
        setVisible(true);

    }

    boolean needsMore = false;

    // JoptionPane.showConfirmDialaog(null, "Overrite previous message", "");

    // public void save() {
    //     // System.out.println("customerID: "+txt_customerID.getText().equals(""));
    //     // make a new instance of a person each time instead of trying to change the
    //     // previous

    //     if (txt_customerID.getText().equals("") || txt_lastName.getText().equals("")) {
    //         needsMore = true;
    //         lbl_instruction.setText("First and Last Name are Required");
    //     }
    //     // else
    //     // {
    //     // lbl_instruction.setText("Enter your contact information");
    //     // }

    //     try {
    //         // System.out.println(needsMore);
    //         if (!needsMore) {
    //             Person p = new Person("John", "Doe", "0", "");

    //             p.setfName(txt_customerID.getText());

    //             // collections.sort every time you add to the list or change it
    //             // ADD TO ARRAYLIST

    //             // System.out.println("aLP: " + aLP);

    //             // System.out.println("p.toString(): " + p.toString());
    //             // SORT Arraylist ALPHABETICALLY
    //             // String.CASE_INSENSITIVE_ORDER

    //             /*
    //              * if(aLP.size() > 1){ String contactName1, contactName2;
    //              * 
    //              * for (int i = 0; i < aLP.size ( ); i++ ) { contactName1 = aLP.get(i).getlName(
    //              * ); for (int n = i + 1; n < aLP.size ( )-1; n++ ) { contactName2 =
    //              * aLP.get(n).getlName( );
    //              * 
    //              * if (contactName1.compareToIgnoreCase (contactName2) > 0) {
    //              * System.out.println("con1 is greater than con2"); Person temp = aLP.get (i);
    //              * aLP.set (i, aLP.get (n)); aLP.set (n, temp);
    //              * 
    //              * System.out.println("\ntemp " + temp.getlName( ) + "\n contact 1 " + aLP.get
    //              * (i).getlName ( ) + "\n contact 2 " + aLP.get (n).getlName ( )); } } } }else {
    //              * aLP.add(p); }
    //              */

    //             // aLP.add(p);

    //             /*
    //              * for(int i = 0; i<aLP.size(); i++) { if(comparing(aLP.get(1), aLP.get(2)) > 1)
    //              * { aLP.add( i, p); } else{ aLP.add(p); } }
    //              */

    //             // Collections.sort(aLP.toString());

    //             aLP.add(p);
    //             // add to list
    //             pplList.setListData(aLP.toArray());

    //             txt_customerID.setText("");
    //         }

    //     } catch (Exception l) {
    //         // clear();
    //         lbl_instruction.setText("Invalid Input");
    //     }
    // }

    //* All methods deleted

}
