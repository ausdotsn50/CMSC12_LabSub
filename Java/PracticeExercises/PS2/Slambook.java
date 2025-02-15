// PS2 in CMSC 12: Fundamentals of Programming II

/*
PS description: 
    - Creating a Java program that functions as a slambook

Submitted by: 
    - Angela Denise Almazan
*/

import java.util.Scanner;
public class Slambook {
    // acts like a func
    public void mainMenu() {
        System.out.println("*********************************Welcome to my Slambook****************************");
        System.out.println("M E N U\n1) Add entry\n2) List entries\n3) Exit");
    }

    public void addEntry(Person[] person, Scanner scn, int ctr) {
        System.out.println("Please enter the details of the new entry!");
        
        System.out.print("Name: ");
        String name = scn.next();

        System.out.print("Age: ");
        int age = scn.nextInt();
        
        System.out.print("Gender: ");
        String gender = scn.next();

        System.out.print("Crush: ");
        String crush = scn.next();

        System.out.print("Favorite Movie: ");
        String favMovie = scn.next();
        
        System.out.print("Favorite Color: ");
        String favColor = scn.next();

        System.out.print("Favorite Subject: ");
        String favSub = scn.next();

        System.out.print("Motto: ");
        String motto = scn.next();

        // from tempVar -> obj in array
        person[ctr] = new Person(name, age, gender, crush, favMovie, favColor, favSub, motto);
    }

    public void listEntries(Person[] person, Scanner scn, int ctr) {
        for(int i = 0; i < ctr; i++) {
            System.out.println("\nEntry "+ (i + 1));
            person[i].setName("John"); // replacing 
            System.out.println("Name: "+ person[i].getName());
            System.out.println("Name: "+ person[i].getAge());
            System.out.println("Name: "+ person[i].getGender());
            System.out.println("Name: "+ person[i].getCrush());
            System.out.println("Name: "+ person[i].getFavMovie());
            System.out.println("Name: "+ person[i].getFavColor());
            System.out.println("Name: "+ person[i].getFavSub());
            System.out.println("Name: "+ person[i].getMotto());
        }
    }

    // main (no separate file)
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Slambook sb = new Slambook();
        
        int choice;
        int counter = 0;
        int maxEntry = 5;
        Person[] person = new Person[maxEntry]; // modify
        
        do {
            sb.mainMenu();
            System.out.print("Enter choice: ");
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    if(counter < maxEntry) {
                        sb.addEntry(person, scan, counter);
                        counter++;
                    }
                    else {
                        System.err.println("[ Max entry reached ]");
                    }
                    break;
                case 2:
                    sb.listEntries(person, scan, counter);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    break;
            }

        } while(choice > 0 && choice < 3);
        scan.close(); // prac
    }
}