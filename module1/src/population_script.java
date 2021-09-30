import java.io.*;
import java.util.Scanner;

public class population_script {

    /*----------------------------------------ONE FOR EACH CLEANED CSV---------------------------------------*/

    public static void scanCrewMembers() {

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
        // * cleansing
        // TODO
        // keep most recent media if there are duplicates
        // redirect output to a file in folder clean_data
        scanFile("../../cleanedCSVFIles/crew_member.csv"); // ? starts at 6405819
        // scanFile("../../data/customer_ratings.csv");
        // scanFile("../../data/names.csv");
        // scanFile("../../data/principals.csv");
        // scanFile("../../data/titles.csv");
    }
}
