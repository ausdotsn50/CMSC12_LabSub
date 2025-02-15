import java.util.Scanner;

public class ClassRecord {
    // M1
    public void Menu() {
        System.out.println("Menu\n1. Add Student\n2. Delete Student\n3. List Students\n4. Exit");
    }

    // M2
    // note that void = noReturn
    public void addStudent(Student[] students, Scanner scanner, int counter) {
        System.out.print("Name: ");
        String name = scanner.next();

        System.out.print("Age: ");
        int age = scanner.nextInt();

        System.out.print("Student Number: ");
        int studentNumber = scanner.nextInt();

        System.out.print("Course: ");
        String course = scanner.next();

        students[counter] = new Student(name, age, studentNumber, course);
        System.out.println("Student succesfully added!");
    }

    // M3
    public void delStudent(Student[] students, Scanner scanner, int counter) {
        int SN;
        System.out.println("Enter student number to DELETE: ");
        SN = scanner.nextInt();
    
        for(int i = 0; i < counter; i++) {
            if(SN == students[i].getStudentNumber()) {
                // inner loop starts from index of SN match
                // loop j until index - 1
                for(int j = i; j < counter - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[counter - 1] = null;
                break;
            }
        }
        
    }

    // M4
    public void listStudents(Student[] students, int counter) {
        for(int i = 0; i < counter; i++) {
            System.out.println(students[i].getName());
            System.out.println(students[i].getAge());
            System.out.println(students[i].getStudentNumber());
            System.out.println(students[i].getCourse());
            // because getCollege is static, it's called from the Student class
            System.out.println(Student.getCollege()); // test
        }
    }
}