// PS3 in CMSC 12: Fundamentals of Programming II

/*
PS description: 
    - Utilizing method overloading in Java to calculate for the factorial of a number

Submitted by: 
    - Angela Denise Almazan
*/

import java.util.Scanner;
public class FactorialCalculator {
    // the iterative approach
    // one parameter
    public int calculateFactorial(int num) {
        int factorial = 1; // explicitly assigning 1 as baseNum inside method
        while(num != 1) {
            factorial *= num;
            num--;
        }
        return factorial;
    }

    // the recursive approach
    // two parameters
    public int calculateFactorial(int baseNum, int num) {
        if(num == baseNum) {
            return 1;
        }
        else {
            return num * calculateFactorial(num - 1);
        }
    }

    // main method
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        FactorialCalculator fc = new FactorialCalculator();
        int factorialBase = 1; // base number for factorial calculation

        System.out.print("Enter a number: ");
        int number = scan.nextInt();

/*  
    This is an example of method overloading
        - same method name, different number of arguments
*/

        System.out.println("Factorial using iterative approach: " + fc.calculateFactorial(number));
        System.out.println("Factorial using factorial approach: " + fc.calculateFactorial(factorialBase, number));
        scan.close();
    }
}