public class MainFile {
    public static void main(String[] args)
    {
        Building the connection
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
        new GUI2();
    }
}
