// PS5 in CMSC 12: Fundamentals of Programming II

/*
PS description: 
    - Creating a simple shape calculator program in Java using anonymous/nested/abstract classes

Submitted by: 
    - Angela Denise Almazan
*/

import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        
        int choice;
        double radius, length, width, base, height;

        System.out.print("Menu:\n1) Circle\n2) Rectangle\n3) Triangle\nEnter choice: ");
        choice = scan.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter radius: ");
                radius = scan.nextDouble();
                
                Shape circle = new Circle(radius);
                System.out.printf("Area: %.2f\n", circle.getArea());
                System.out.printf("Perimeter: %.2f\n", circle.getPerimeter());
                break;
            case 2:
                System.out.print("Enter length: ");
                length = scan.nextDouble();
                System.out.print("Enter width: ");
                width = scan.nextDouble();
                
                Shape rectangle = new Rectangle(length, width);
                System.out.printf("Area: %.0f\n", rectangle.getArea());
                System.out.printf("Perimeter: %.0f\n", rectangle.getPerimeter());
                break;
            case 3:
                System.out.print("Enter base: ");
                base = scan.nextDouble();
                System.out.print("Enter height: ");
                height = scan.nextDouble();

                Shape rTriangle = new RightTriangle(base, height);
                System.out.printf("Area: %.1f\n", rTriangle.getArea());
                System.out.printf("Perimeter: %.1f\n", rTriangle.getPerimeter());
                break;
            default:
                break;
        }
        scan.close();
    }
}