import java.io.*;
import java.util.Scanner;

public class remove_column {
    public static void main(String[] args) throws Exception {
        //parsing a CSV file into Scanner class constructor
        Scanner sc1 = new Scanner(new File("../../data/crew.csv"));
        sc1.useDelimiter("\n");   //sets the delimiter pattern
        while (sc1.hasNext()) {  //returns a boolean value
            String[] splitLine = (sc1.next()).split("\t", 2);   // Splits each line into array
            System.out.println(splitLine[0]);                   // Only print first unneccesary column
        }
        sc1.close();  //closes the scanner
    }
}
