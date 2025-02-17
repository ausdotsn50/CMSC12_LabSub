import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        // variables here
        Scanner scan = new Scanner(System.in);
        
        int employeeCount, role, employeeId, counter = 0;
        String name;

        System.out.print("Enter the number of employees to add: ");
        employeeCount = scan.nextInt();
        
        EmployeeManager em = new EmployeeManager(employeeCount); // can use em.something() from here
        
        // adding employees here
        do {
            System.out.print("\nEmployee " + (counter + 1) + "\n1) Instructor\n2) Professor\n3) Dean\n");
            System.out.print("Enter role of the employee: ");
            role = scan.nextInt();

            System.out.print("Enter name: ");
            name = scan.next();

            System.out.print("Enter employee ID: ");
            employeeId = scan.nextInt();

            em.addEmployee(role, name, employeeId, counter);
            counter++;
        } while(counter < employeeCount);


        // for(index = 0; index < employeeCount; index++) {
            

            
        // }

        em.showEmployee(employeeCount);
        scan.close();
    }
}

// em.showEmployee(index);