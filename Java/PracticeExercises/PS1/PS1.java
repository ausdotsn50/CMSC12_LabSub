// PS1 in CMSC 12: Fundamentals of Programming II

/*
PS description: 
    - Printing a mountain of stars based on course assignment specifications

Initial documentation: 
    - https://docs.google.com/spreadsheets/d/1MaKRb2mq7SiGUWKVU2FJP2Qw1hbofZqUS1iZNeC_DBM/edit?usp=sharing

Submitted by: 
    - Angela Denise Almazan
*/

import java.util.Scanner;

public class PS1 {
    public static void main(String[] args) {
        // creating a Scanner object with 'new' keyword calling it scanner
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter height: ");
        byte height = scanner.nextByte(); // using (methods) from Scanner

        // out-loop vars
        int firstSpc = height - 1;
        int middleSpc = height * 2 - 5;
        int minusFac = 1;

        // locating column positions using IF-ELSE
        for(int i = 0; i < height; i++) { // row iteration
            for(int j = 0; j < 4 * height - 5; j++) { // col iteration
                // in-loop vars
                int firstStr = 2 * i + 1;

                // prints first space
                if(j < firstSpc) {
                    System.out.print(" ");
                }
                
                // prints first set of stars
                else if(j >= firstSpc && j < firstSpc + firstStr) {
                    System.out.print("*");
                }

                // printing when in last two rows
                else if(i >= height - 2) {
                    int secondStr = firstStr;
                    // one star set
                    if(j >= firstSpc + firstStr && j < firstSpc + firstStr + secondStr - minusFac) {
                        System.out.print("*");
                    }
                }
                
                // rows before the last two special rows
                else {
                    // prints middle space
                    if(j >= firstSpc + firstStr && j < firstSpc + firstStr + middleSpc) {
                        System.out.print(" ");
                    }
                    // prints second set of stars
                    else if (j >= firstSpc + firstStr + middleSpc && j < firstSpc + firstStr + middleSpc + firstStr) {
                        System.out.print("*");
                    }
                }
            }

            // modifiers
            firstSpc--;
            middleSpc -=2;     
            System.out.println(""); // proceeds to next row
        }
        scanner.close();
    }
}