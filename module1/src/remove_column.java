import java.io.*;
import java.util.Scanner;

public class population_script {
    public static void main(String[] args) throws Exception {
        //parsing a CSV file into Scanner class constructor
        Scanner sc1 = new Scanner(new File("../../data/crew.csv"));
        sc1.useDelimiter("\n");   //sets the delimiter pattern
        while (sc1.hasNext()) {  //returns a boolean value
            System.out.print(sc1.next());  //find and returns the next complete token from this scanner
        }
        sc1.close();  //closes the scanner
    }
}
