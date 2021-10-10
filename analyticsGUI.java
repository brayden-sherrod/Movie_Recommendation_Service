import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.*;   

public class analyticsGUI extends JFrame implements ActionListener {
  
    JPanel panel = new JPanel();

    public analyticsGUI() {
        // Frame configurations
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Analytics Portal");
        setSize(700,500); // width , height
        
        // Panel configurations
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(null);

        // Components
        JLabel titleText = new JLabel("Top 10 Most Watched Media");
        JTextArea list = new JTextArea("1. ...\n2. ...\n3. ...\n4. ...\n5. ...\n6. ...\n7. ...\n8. ...\n9. ...\n10. ...");
            list.setEditable(false);
        JButton weekly = new JButton("weekly");
            weekly.addActionListener( e -> viewWeekly() );
        JButton monthly = new JButton("monthly");
            monthly.addActionListener( e -> viewMonthly() );
        JButton yearly = new JButton("yearly");
            yearly.addActionListener( e -> viewYearly() );

        // Configure component placements
        titleText.setBounds(270, 20, 200, 30);
        list.setBounds(100, 60, 500, 300);
        weekly.setBounds(100, 380, 120, 40);
        monthly.setBounds(290, 380, 120, 40);
        yearly.setBounds(480, 380, 120, 40);

        // Add components to frame
        panel.add(titleText);
        panel.add(list);
        panel.add(weekly);
        panel.add(monthly);
        panel.add(yearly);
        
        // Add panel to frame and allow visibility
        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null); // center the window on the screen
        setVisible(true);
    }

    public void viewWeekly() {
        MainFile mainFile = new MainFile();

        // Connect to database
        ResultSet rs = mainFile.runSQLString("SELECT * FROM mediacollection WHERE media_title LIKE '%" + receivedTitle + "%';");
        try {
            while (rs.next()) {
                
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void viewMonthly() {
        MainFile mainFile = new MainFile();

        // Connect to database
        ResultSet rs = mainFile.runSQLString("SELECT * FROM mediacollection WHERE media_title LIKE '%" + receivedTitle + "%';");
        try {
            while (rs.next()) {
                
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewYearly() {
        MainFile mainFile = new MainFile();

        // Connect to database
        ResultSet rs = mainFile.runSQLString("SELECT * FROM mediacollection WHERE media_title LIKE '%" + receivedTitle + "%';");
        try {
            while (rs.next()) {
                
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

}