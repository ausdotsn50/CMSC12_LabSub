import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int menuChoice;
        boolean running = true;

        String un, name, gender, crush, favMovie, favColor, favSub, motto;
        int age;

        Slambook sb = new Slambook();

        do {
            System.out.print("\n*****************************Welcome to my Slambook************************\n");
            System.out.print("Menu:\n1) Add entry\n2) Search entry\n3) List entries\n4) Delete entry\n5) Exit\nEnter choice: ");
            menuChoice = scan.nextInt();
            switch (menuChoice) {
                case 1:
                    System.out.print("\nPlease enter the details of the new entry!\n");
                    
                    System.out.print("\nUsername: ");
                    un = scan.next();

                    System.out.print("Name: ");
                    name = scan.next();
                    
                    System.out.print("Age: ");
                    age = scan.nextInt();

                    System.out.print("Gender: ");
                    gender = scan.next();

                    System.out.print("Crush: ");
                    crush = scan.next();

                    System.out.print("Favorite Movie: ");
                    favMovie = scan.next();

                    System.out.print("Favorite Color: ");
                    favColor = scan.next();
                    
                    System.out.print("Favorite Subject: ");
                    favSub = scan.next();

                    System.out.print("Motto: ");
                    motto = scan.next();

                    sb.addEntry(un, name, age, gender, crush, favMovie, favColor, favSub, motto);
                    break;
                case 2:
                    System.out.print("\nEnter username: ");
                    un = scan.next();
                    sb.searchEntry(un);
                    break;
                case 3:
                    sb.listEntries();
                    break;
                case 4:
                    System.out.print("\nEnter username of entry to delete: ");
                    un = scan.next();
                    sb.deleteEntry(un);
                    break;
                case 5:
                    System.out.print("\nBye!\n");
                    running = false;
                default:
                    break;
            }
        } while (running);
        
        scan.close();

    }
}