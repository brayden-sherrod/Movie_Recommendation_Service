import java.sql.*;

public class MainFile {
    public static void main(String[] args) {
        // Build new GUI object
        welcomeGUI welGUI = new welcomeGUI();

        //! TEMPORARY
        // homeGUI homeGUI = new homeGUI();
        searchGUI searchGUI = new searchGUI();

    }

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
            System.out.println("Error accessing Database");
        }
        return result;
    }

    
}
