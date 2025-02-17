public class Employee {
    protected String name;
    protected int employeeId;
    protected double baseBonus;

    public Employee(String name, int employeeId, double baseBonus) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseBonus = baseBonus;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getBonus() {
        return baseBonus;
    }
}