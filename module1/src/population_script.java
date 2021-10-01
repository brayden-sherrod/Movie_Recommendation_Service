import java.io.*;
import java.util.Scanner;
import java.sql.*;

  // Commands to run this script
  // This will compile all java files in this directory
  // javac *.java
  // This command tells the file where to find the postgres jar which it needs to
  // execute postgres commands, then executes the code
  //* Windows: java -cp ".;postgresql-42.2.8.jar" population_script
  //* Mac/Linux: java -cp ".:postgresql-42.2.8.jar" population_script

  // MAKE SURE YOU ARE ON VPN or TAMU WIFI TO ACCESS DATABASE

public class population_script {
    /*----------------------------------------ONE FOR EACH CLEANED CSV---------------------------------------*/

    public static void scanCrewMembers(Connection conn) {
        try{
            Statement stmt = conn.createStatement();
            String sqlString = "CREATE TABLE CrewMembers(crewId text PRIMARY KEY, primaryName text, birthYear int);";
            stmt.executeUpdate(sqlString);

        } catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}  
    }

    public static void scanCustomersRatings() {

    }

    public static void scanCustomesrWatchedLists() {

    }

    public static void scanMediaCollection() {

    }

    public static void scanMediaCrewMembers() {

    }

    public static void scanMediaGenres() {
        // string s;
        // String[] arrays = s.split(",", 2);
    }

    /*-----------------------------------------------------------------------------------------------------*/

    /**
     * For a column category, it splits up possible multiple entries
     * 
     * @param pod - String of comma separated elements
     */
    public static void separatePod(String pod) {
        String[] splitPod = pod.split(",");

        // Iterate over array
        for (String element : splitPod) {
            System.out.print(element + "-");
        }
    }

    /**
     * Parses through a csv file provided.
     * 
     * @param fileName - Name of csv file
     * @throws FileNotFoundException
     */
    public static void scanFile(String fileName) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File(fileName));
        sc1.useDelimiter("\n"); // Sets the delimiter pattern

        System.out.println(sc1.next()); // Skips first line

        while (sc1.hasNext()) { // Returns a boolean value
            String[] splitLine = (sc1.next()).split(","); // Splits each line into array

            // Iterate over array
            for (String pod : splitLine) {
                separatePod(pod);
                System.out.print("|");
            }
            System.out.println();
        }
        sc1.close(); // Closes the scanner
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Building the connection with your credentials
		Connection conn = null;
		String teamNumber = "11";
		String sectionNumber = "903";
		String dbName = "csce315" + sectionNumber + "_" + teamNumber + "db";
		String dbConnectionString = "jdbc:postgresql://csce-315-db.engr.tamu.edu/" + dbName;
		String userName = "csce315" + sectionNumber + "_" + teamNumber + "user";
		String userPassword = "new_password";

		// Connecting to the database
		try{
			conn = DriverManager.getConnection(dbConnectionString, userName, userPassword);
		} catch (Exception e) {
            System.out.println("Failed Driver Manager");
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

        System.out.println("Opened database successfully");


        
        // * cleansing
        // keep most recent media if there are duplicates
        // redirect output to a file in folder clean_data
        // scanFile("../../cleanedCSVFIles/crew_member.csv"); // ? starts at 6405819
        // scanFile("../../data/customer_ratings.csv");
        // scanFile("../../data/names.csv");
        // scanFile("../../data/principals.csv");
        // scanFile("../../data/titles.csv");




        // closing the connection
        System.out.println("Closing the connection");
                
		try {
			conn.close();
			System.out.println("Connection Closed.");
		} catch (Exception e) {
			System.out.println("Connection NOT Closed.");
		}
    }
}
