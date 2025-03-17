// PS8 in CMSC 12: Fundamentals of Programming II

/*
PS description: 
    - Modifying the 'Shapes' laboratory exercise by adding a user defined - exception handler - for creating triangle shapes
    - Additional InputMismatchException input from class session

Submitted by: 
    - Angela Denise Almazan
*/


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static boolean validTriangle(double a, double b, double c) {
        boolean validTriangle;
        if(a + b > c && a + c > b && b + c > a) {
            validTriangle = true;
        } else {
            validTriangle = false;
        }
        return validTriangle;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int menuChoice, shpChoice, shpCount = 0, maxShpCount = 5;

        ShapeCalculator shpCalc = new ShapeCalculator(maxShpCount);

        double radius, width, height, s1, s2, s3;

        boolean running = true;

        while(running) {
            try {
                System.out.print("\nWhat do you want to do?\n1. Add shape\n2. Display shapes\n3. Exit\nChoice: ");
                menuChoice = scan.nextInt();
                    switch (menuChoice) {
                        case 1:
                            do {
                                if(shpCount >= maxShpCount) {
                                    System.out.println("This program only allows adding a max of five shapes :(");
                                    break;
                                }

                                System.out.print("\nChoose a shape:\n1. Circle\n2. Rectangle\n3. Triangle\n4. Exit\nChoice: ");
                                shpChoice = scan.nextInt();

                                if(shpChoice == 1) {
                                    System.out.print("Radius: ");
                                    radius = scan.nextDouble();
                                    shpCalc.createNewShape(shpCount, radius);
                                    shpCount++;

                                } else if(shpChoice == 2) {
                                    System.out.print("Width: ");
                                    width = scan.nextDouble();
                                    System.out.print("Height: ");
                                    height = scan.nextDouble();
                                    shpCalc.createNewShape(shpCount, width, height);
                                    shpCount++;

                                } else if(shpChoice == 3) {
                                    boolean invalidInput = true;
                                    // loops until user enters valid input
                                    while(invalidInput) {
                                        try {
                                            System.out.print("a: ");
                                            s1 = scan.nextDouble();

                                            System.out.print("b: ");
                                            s2 = scan.nextDouble();

                                            System.out.print("c: ");
                                            s3 = scan.nextDouble();

                                            if(!(validTriangle(s1, s2, s3))) { // check validTriangle method
                                                throw new TriangleException();
                                                // throws
                                                // goes to catch block
                                            }
                                            shpCalc.createNewShape(shpCount, s1, s2, s3);
                                            shpCount++;
                                            invalidInput = false;
                                        } catch(TriangleException triExcep) {
                                            System.out.println("\n" + triExcep.getMessage());
                                        }
                                    }   
                                }
                        } while(shpChoice > 0 && shpChoice < 4 && shpCount < maxShpCount);
                        break;
                        
                    case 2:
                        shpCalc.displayShapes(shpCount);
                        break;
                    case 3:
                        running = false;
                        System.out.println("Exiting...");
                        break;

                    default:
                        break;
                } 
                
            } catch(InputMismatchException inputMismatch) {
                // for all inputs
                scan.nextLine();
                System.out.println("WARNING! Input Mismatch Exception");
                continue;
            }
        }    
        scan.close();  

    }
}