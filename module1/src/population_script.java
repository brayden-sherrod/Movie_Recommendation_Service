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

    // TODO: Rose is going to write the population lines
    // *Need to iterate a primary key
    public static void scanCustomersRatings(Connection conn) throws FileNotFoundException {
        // Populate database
        try {
            System.out.println("Populating CustomerRatings Table...");
            Statement stmt = conn.createStatement();
            String sqlString = "";
            stmt.executeUpdate(sqlString);

        } catch (Exception e) {
            System.out.println("Failed to populate CustomerRatings table");
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    // *Need to iterate a primary key
    public static void scanCustomersWatchedLists(Connection conn) {

        String fileName = "customers_watched_lists.csv";

        try {
            System.out.println("Populating Table...");
            Statement stmt = conn.createStatement();
            String sqlString = "";
            stmt.executeUpdate(sqlString);

        } catch (Exception e) {
            System.out.println("Failed to populate CustomersWatchedLists table");
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

        // TODO: enumerate files with duplicates in order to avoid duplicate primary key
        // problem

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

        scanCrewMembers(conn);

        // Call functions to populate date
            // * cleansing
            // keep most recent media if there are duplicates
            // redirect output to a file in folder clean_data
            // scanFile("../../cleanedCSVFiles/crew_member.csv"); // ? starts at 6405819
            // scanFile("../../data/customer_ratings.csv");
            // scanFile("../../data/names.csv");
            // scanFile("../../data/principals.csv");
            // scanFile("../../data/titles.csv");

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
