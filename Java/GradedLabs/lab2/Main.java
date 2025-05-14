import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int menuChoice, shpChoice, shpCount = 0, maxShpCount = 5;

        ShapeCalculator shpCalc = new ShapeCalculator(maxShpCount);

        double radius, width, height, s1, s2, s3;
        do {
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
                            System.out.print("a: ");
                            s1 = scan.nextDouble();

                            System.out.print("b: ");
                            s2 = scan.nextDouble();

                            System.out.print("c: ");
                            s3 = scan.nextDouble();

                            shpCalc.createNewShape(shpCount, s1, s2, s3);
                            shpCount++;
                        }
                } while(shpChoice > 0 && shpChoice < 4 && shpCount < maxShpCount);
                break;
                
            case 2:
                shpCalc.displayShapes(shpCount);
                break;
            case 3:
                System.out.println("Exiting...");
                break;

            default:
                break;
            
            } 
        } while(menuChoice > 0 && menuChoice < 3); 
        scan.close();
    }
}