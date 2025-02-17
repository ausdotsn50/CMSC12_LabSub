public class EmployeeManager {
    private Employee[] employee; // private arrray
    
    // public constructor
    public EmployeeManager(int empCount) {
        employee = new Employee[empCount];
    }

    public void addEmployee(int role, String name, int Id, int i) {
        // with the assumption that user add only from choices
        if(role == 1) {
            // new Instructor
            employee[i] = new Instructor(name, Id, 20000);
        }
        else if(role == 2) {
            // new Professor
            // employee[i] = new Professor(name, Id, 20000);
        }
        else if(role == 3) {
            // new Dean
            employee[i] = new Dean(name, Id, 20000);
        }
    }
    
    public void showEmployee(int ctr) {
        System.out.println("\nList of Bank Accounts");
        for(Employee i : employee) {
            if(i instanceof Instructor) {
                Instructor temp = (Instructor) i;
                System.out.println("Instructor");
                System.out.println(temp.getBonus());
            }
        }
        System.out.println();
    }



}