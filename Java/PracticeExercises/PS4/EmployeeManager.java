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
            employee[i] = new Professor(name, Id, 20000);
        }
        else if(role == 3) {
            // new Dean
            employee[i] = new Dean(name, Id, 20000);
        }
    }
    
    public void showEmployee(int ctr) {
        System.out.println();
        for(int i = 0; i < ctr; i++) {
            if(employee[i] instanceof Instructor) {
                Instructor temp = (Instructor) employee[i];
                System.out.println("Employee " + (i + 1));
                System.out.println("Role: Instructor");
                System.out.println("Name: " + temp.getName());
                System.out.println("Employee ID: " + temp.getEmployeeId());
                System.out.println("Bonus: " + temp.getBonus());
            }
            else if(employee[i] instanceof Professor) {
                Professor temp = (Professor) employee[i];
                System.out.println("Employee " + (i + 1));
                System.out.println("Role: Professor");
                System.out.println("Name: " + temp.getName());
                System.out.println("Employee ID: " + temp.getEmployeeId());
                System.out.println("Bonus: " + temp.getBonus());
            }
            else if (employee[i] instanceof Dean) {
                Dean temp = (Dean) employee[i];
                System.out.println("Employee " + (i + 1));
                System.out.println("Role: Dean");
                System.out.println("Name: " + temp.getName());
                System.out.println("Employee ID: " + temp.getEmployeeId());
                System.out.println("Bonus: " + temp.getBonus());
            }
            System.out.println();
        }
    }



}