import java.io.*;
import java.util.Scanner;

public class population_script {
    
    /**
     * For a column category, it splits up possible multiple entries
     * @param pod 
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
     * @param fileName Name of csv file
     * @throws FileNotFoundException
     */
    public static void scanFile(String fileName) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("../../data/crew.csv"));
        sc1.useDelimiter("\n");   // Sets the delimiter pattern
        while (sc1.hasNext()) {  // Returns a boolean value
            String[] splitLine = (sc1.next()).split("\t");   // Splits each line into array
            
            // Iterate over array
            for (String pod : splitLine) {
                separatePod(pod);
                System.out.print("|");
            }
            System.out.println();
        }
        sc1.close();  // Closes the scanner
    }

    public static void main(String[] args) throws FileNotFoundException {
        scanFile("../../data/crew.csv");
        // scanFile("../../data/customer_ratings.csv");
        // scanFile("../../data/names.csv");
        // scanFile("../../data/principals.csv");
        // scanFile("../../data/titles.csv");
    }
}
