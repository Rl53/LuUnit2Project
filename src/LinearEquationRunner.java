import java.util.Scanner;
public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        // welcomes the user
        System.out.println("Welcome to this program!");
        System.out.println("Enter coordinate 1: ");
        String str1 = myScanner.nextLine();
        // separates the numbers in the strings using substrings
        int indexX1 = str1.indexOf(",");
        String substringX1 = str1.substring(1, indexX1);
        // parses to obtain integer values from strings
        int x1 = Integer.parseInt(substringX1);
        int indexY1 = str1.indexOf(")");
        String substringY1 = str1.substring(indexX1 + 2, indexY1);
        int y1 = Integer.parseInt(substringY1);

        System.out.println("Enter coordinate 2: ");
        String str2 = myScanner.nextLine();
        // separates the numbers in the strings using substrings
        int indexX2 = str2.indexOf(",");
        String substringX2 = str2.substring(1, indexX2);
        // parses to obtain integer values from strings
        int x2 = Integer.parseInt(substringX2);
        int indexY2 = str2.indexOf(")");
        String substringY2 = str2.substring(indexX2 + 2, indexY2);
        int y2 = Integer.parseInt(substringY2);

        /* determines whether x1 == x2 and ends the program by telling the
        user what x-value the points lie on if there is a vertical line */
        if (x1 == x2) {
            System.out.println("These points are on a vertical line: x = " + x1);
        }
        // creates a LinearEquation object and assign the corresponding values
        else {
            LinearEquation linearEquation = new LinearEquation(x1, y1, x2, y2);
            // prints out the line information
            System.out.println(linearEquation.lineInfo());

            /* asks the user to enter an x-value to print out the coordinate for that
            x-value on the line */
            System.out.println("Enter a value for x: ");
            double newX = myScanner.nextDouble();
            System.out.println(linearEquation.coordinateForX(newX));
        }
        myScanner.close();
    }
}

