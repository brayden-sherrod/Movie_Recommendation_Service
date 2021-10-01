import java.io.*;
import java.util.Scanner;
import java.sql.*;
// import java.util.regex.*;

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
    
    // * DONT need to iterate a primary key
    public static void scanCrewMembers(Connection conn) {
        // Populate Database
        try{
            System.out.println("Populating CrewMembers Table...");
            
            String fileName = "../../cleanedCSVFiles/crew_member.csv";
            
            Scanner sc = new Scanner(new File(fileName));
            sc.useDelimiter("\n"); // Sets the delimiter pattern

            sc.next();             // Skips first line
            
            String crewId;
            String primaryName;
            String birthYear;
            String[] splitLine;

            // Iterate through each line of file
            while (sc.hasNext()) { 
                splitLine = (sc.next()).split(",");    // Split line at commas, splitLine is size 3
                
                if (splitLine.length < 3) {             // If the array is less than 3 elements
                    continue;
                }
                if (splitLine[2].length() < 4) {       // If the line does not have a birthYear, skip that person
                    continue;
                }

                crewId = splitLine[0];
                primaryName = splitLine[1];
                birthYear = splitLine[2];
                birthYear = birthYear.substring(0, birthYear.length()-1);
                    

                // If the name is super weird, then we're going to skip it
                if ( !(primaryName.matches("[a-zA-Z\s+_.-]+")) ){
                    continue;
                }else{
                    // Populate database
                    String sqlCommand = "INSERT INTO crewmembers VALUES('" + crewId + "', '" + primaryName + "', '" + birthYear + "');";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(sqlCommand);
                }
            }

            // Close the scanner
            sc.close();
        } catch (Exception e) {
            System.out.println("Failed to populate CrewMembers table");
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} 
    }

    // *Need to iterate a primary key
    public static void scanCustomersRatings(Connection conn) throws FileNotFoundException {
        // Populate Database
        try{
            System.out.println("Populating CustomersRatings Table...");
            
            String fileName = "../../cleanedCSVFiles/customers_ratings.csv";
            
            Scanner sc = new Scanner(new File(fileName));
            sc.useDelimiter("\n"); // Sets the delimiter pattern

            sc.next();             // Skips first line
            
            int customer_ratings_pk = 1;
            String media_ID;
            String customer_ID;
            String customer_rating;
            String date_rated;
            String[] splitLine;

            // Iterate through each line of file
            while (sc.hasNext()) { 
                splitLine = (sc.next()).split(",");    // Split line at commas, splitLine is size 3

                media_ID = splitLine[0];
                customer_ID= splitLine[1];
                customer_rating = splitLine[2];
                date_rated = splitLine[3];
                    
                // Populate database
                String sqlCommand = "INSERT INTO customersratings VALUES('" + customer_ratings_pk + "', '" + media_ID + "', '" + customer_ID + "', '" + customer_rating + "', '" + date_rated + "');";
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sqlCommand);
                
                customer_ratings_pk++;
            }

            // Close the scanner
            sc.close();
        } catch (Exception e) {
            System.out.println("Failed to populate CrewMembers table");
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} 
    }

    // *Need to iterate a primary key
    public static void scanCustomersWatchedLists(Connection conn) {
        // Populate Database
        try{
            System.out.println("Populating CustomersWatchedList Table...");
            
            String fileName = "../../cleanedCSVFiles/customers_watched_lists.csv";
            
            Scanner sc = new Scanner(new File(fileName));
            sc.useDelimiter("\n"); // Sets the delimiter pattern

            sc.next();             // Skips first line
            
            int customer_watched_lists_pk = 1;
            String customer_ID;
            String media_ID;
            String[] splitLine;

            // Iterate through each line of file
            while (sc.hasNext()) { 
                splitLine = (sc.next()).split(",");    // Split line at commas, splitLine is size 3

                customer_ID= splitLine[0];
                media_ID = splitLine[1];
                    
                // Populate database
                String sqlCommand = "INSERT INTO customerswatchedlist VALUES('" + customer_watched_lists_pk + "', '" + customer_ID + "', '" + media_ID + "');";
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sqlCommand);
                
                customer_watched_lists_pk++;
            }

            // Close the scanner
            sc.close();
        } catch (Exception e) {
            System.out.println("Failed to populate CrewMembers table");
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} 
    }

    // * DONT need to iterate a primary key
    public static void scanMediaCollection(Connection conn) {

        String fileName = "media_collection.csv";

        try {
            System.out.println("Populating MediaCollection Table...");
            Statement stmt = conn.createStatement();
            String sqlString = "";
            stmt.executeUpdate(sqlString);

        } catch (Exception e) {
            System.out.println("Failed to populate MediaCollection table");
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    // *Need to iterate a primary key
    public static void scanMediaCrewMembers(Connection conn) {

        String fileName = "media_crew_members.csv";

        try {
            System.out.println("Populating MediaCrewMembers Table...");
            Statement stmt = conn.createStatement();
            String sqlString = "";
            stmt.executeUpdate(sqlString);

        } catch (Exception e) {
            System.out.println("Failed to populate MediaCrewMembers table.");
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    // *Need to iterate a primary key
    public static void scanMediaGenres(Connection conn) {
        
        String fileName = "media_genres.csv";
        
        try {
            System.out.println("Populating MediaGenres Table...");
            Statement stmt = conn.createStatement();
            String sqlString = "";
            stmt.executeUpdate(sqlString);

        } catch (Exception e) {
            System.out.println("Failed to populate MediaGenres table.");
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        // string s;
        // String[] arrays = s.split(",", 2);
    }

    /*-----------------------------------------------------------------------------------------------------*/


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
        try {
            conn = DriverManager.getConnection(dbConnectionString, userName, userPassword);
        } catch (Exception e) {
            System.out.println("Failed Driver Manager");
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

        // Call functions to populate date
        scanCrewMembers(conn);

        // Closing the connection
        System.out.println("Closing the connection");
        try {
            conn.close();
            System.out.println("Connection Closed.");
        } catch (Exception e) {
            System.out.println("Connection NOT Closed.");
        }
    }

}
