/* 
    Sequence
        Main
        Methods in ClassRecord
*/
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ClassRecord cr = new ClassRecord(); // this is an instance, use methods from ClassRecord

        // counter is in Main
        int counter = 0;
        int maxStudents = 10;

        // array is in Main
        Student[] students = new Student[maxStudents];

        int choice;
        do {
            cr.Menu();
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    cr.addStudent(students, scanner, counter);
                    counter++;
                    break;
                case 2:
                    cr.delStudent(students, scanner, counter);
                    counter--;
                    break;
                case 3:
                    cr.listStudents(students, counter);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    break;
            }
        } while (choice > 0 && choice < 4);
    
    }
}