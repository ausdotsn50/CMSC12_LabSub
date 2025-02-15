import java.util.Scanner;

public class Mountain {
    public static void main(String[] args) {
        // creating a Scanner object with 'new' keyword calling it scanner
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter height: ");
        byte height = scanner.nextByte(); // using (methods) from Scanner

        // height number of rows
        int firstSpc = height - 1;
        int middleSpc = height * 2 - 5;
        int minusFac = 1;
        for (byte i = 0; i < height; i++) {

            // prints first space
            for (byte j = 0; j < firstSpc; j++) {
                System.out.print(" ");
            }

            // prints first set of stars
            int firstStr = 2*i+1;;
            for (byte k = 0; k < firstStr; k++) {
                    System.out.print("*");
            }
            
            if (i >= height - 2) {
                // no middle space
                int secondStr = firstStr;
                for (byte k = 0; k < secondStr - minusFac; k++) {
                    System.out.print("*");
                }
                minusFac += 2;
            }
            else {
                // prints middle space
                for (byte l = 0; l < middleSpc; l++) {
                    System.out.print(" ");
                }

                // prints second set of stars
                int secondStr = firstStr;
                for (byte k = 0; k < secondStr; k++) {
                    System.out.print("*");
                }
            }

            firstSpc--;
            middleSpc -=2;     

            System.out.println(""); // new line per row
        }
        scanner.close(); // close
    }
}