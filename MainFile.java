import java.sql.*;

public class MainFile {
        
    public static void main(String[] args) {
        // STEP 2: Build new GUI object
        new welcomeGUI(); // Test Customer ID: 923517

        // TEST VALUES
        // Weekly
        // 2005-12-24
        // 2005-12-31

        //Monthly
        // 2005-11-30
        // 2005-12-31

        // yearly
        // 2004-12-31
        // 2005-12-31
        
        //! TEMPORARY for testing
        // analyticsGUI anGUI = new analyticsGUI();
        // homeGUI homeGUI = new homeGUI("923517");
        // searchGUI searchGUI = new searchGUI();
        // watchGUI wG = new watchGUI("test title", "1488844");
    }

    public ResultSet runSQLString(String inputSQLString) {

        Connection conn = null;

        // STEP 1: Connecting to the database
        try {
            System.out.println("point 1");
            Class.forName("org.postgresql.Driver"); //!
            System.out.println("point 2");
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

        } catch (Exception e) {
            System.out.println("Error accessing Database");
        }

        //STEP 3: Closing the connection
        try {
            conn.close();
            System.out.println("Connection Closed.");
        } catch(Exception e) {
            System.out.println("Connection NOT Closed.");
        }
        
        return result;
    }
}
