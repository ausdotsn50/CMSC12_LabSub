// PS6 in CMSC 12: Fundamentals of Programming II

/*
PS description: 
    - Creating a Library Management System in Java using abstract class and interfaces

Submitted by: 
    - Angela Denise Almazan
*/

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        
        int menuChoice, studentChoice, librarianChoice, borrowChoice, returnChoice, maxItems = 5; // choices

        int isbn;
        double volume;

        String name, author, publisher;

        Scanner scan = new Scanner(System.in);
        LibraryManagementSystem lms = new LibraryManagementSystem(maxItems);

        do {
            // This is the main menu
            System.out.print("\nMenu\n1. Student\n2. Librarian\n3. Exit\nEnter choice: ");
            menuChoice = scan.nextInt();
            
            switch (menuChoice) {
                // Student menu
                case 1: 
                    System.out.print("\n1. Borrow Item\n2. Return Item\n3. List Items\nEnter choice: ");
                    studentChoice = scan.nextInt();

                    if(studentChoice == 1) {
                        System.out.print("\n1. Borrow Book\n2. Borrow Magazine\nEnter choice: ");
                        borrowChoice = scan.nextInt();

                        if(borrowChoice == 1) {
                            System.out.print("Enter ISBN: ");
                            isbn = scan.nextInt();
                            if(lms.findItem(isbn) == null) {
                                System.out.println("\nBook ISBN " + isbn + " does not exist");
                            } else {
                                lms.findItem(isbn).borrowItem();
                            }
                            // add "item not found"
                            // find item via ISBN
                            // change status to borrowed
                        } else if(borrowChoice == 2) {
                            System.out.print("Enter volume: ");
                            volume = scan.nextDouble();
                            if(lms.findItem(volume) == null) {
                                System.out.println("\nMagazine volume" + volume + " does not exist");
                            } else {
                                lms.findItem(volume).borrowItem();
                            }
                            // find item via volume
                            // change status to borrowed
                        }         

                    } else if(studentChoice == 2) {
                        System.out.print("\n1. Return Book\n2. Return Magazine\nEnter choice: ");
                        returnChoice = scan.nextInt();

                        if(returnChoice == 1) {
                            System.out.print("Enter ISBN: ");
                            isbn = scan.nextInt();
                            if(lms.findItem(isbn) == null) {
                                System.out.println("\nBook ISBN " + isbn + " does not exist");
                            } else {
                                lms.findItem(isbn).returnItem();
                            }
                            // find item via ISBN
                            // change status to returned
                        } else if(returnChoice == 2) {
                            System.out.print("Enter volume: ");
                            volume = scan.nextDouble();
                            if(lms.findItem(volume) == null) {
                                System.out.println("\nMagazine volume " + volume + " does not exist");
                            } else {
                                lms.findItem(volume).returnItem();
                            }
                            // find item via volume
                            // change status to returned
                        }      

                    } else if(studentChoice == 3) {
                        lms.listItems();
                    }

                    break;

                // Librarian menu
                case 2: 
                    System.out.print("\n1. Add Book\n2. Add Magazine\nEnter choice: ");
                    librarianChoice = scan.nextInt();
                    if(librarianChoice == 1) {
                        System.out.print("\nEnter ISBN: ");
                        isbn = scan.nextInt();
                        System.out.print("Enter name: ");
                        name = scan.next();
                        System.out.print("Enter author: ");
                        author = scan.next();
                        lms.addItem(isbn, name, author);
                    } else if(librarianChoice == 2) {
                        System.out.print("\nEnter volume: ");
                        volume = scan.nextDouble();
                        System.out.print("Enter name: ");
                        name = scan.next();
                        System.out.print("Enter publisher: ");
                        publisher = scan.next();
                        lms.addItem(volume, name, publisher);
                    }
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