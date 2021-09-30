import java.io.*;
import java.util.Scanner;

public class population_script {

    /**
     * Parses through a csv file provided.
     * @param fileName Name of csv file
     * @throws FileNotFoundException
     */
    public static void scanFile(String fileName) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("../../data/crew.csv"));
        sc1.useDelimiter("\n");   //sets the delimiter pattern
        while (sc1.hasNext()) {  //returns a boolean value
            String[] splitLine = (sc1.next()).split("\t", 2);   // Splits each line into array
            System.out.println(splitLine[0]);                   // Only print first unneccesary column
        }
        sc1.close();  //closes the scanner
    }

    public static void main(String[] args) throws FileNotFoundException {
        scanFile("../../data/crew.csv");
        scanFile("../../data/customer_ratings.csv");
        scanFile("../../data/names.csv");
        scanFile("../../data/principals.csv");
        scanFile("../../data/titles.csv");
    }
}
