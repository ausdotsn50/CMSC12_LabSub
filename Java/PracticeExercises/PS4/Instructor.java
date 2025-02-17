public class Instructor extends Employee {
    public Instructor(String name, int employeeId, double baseBonus) {
        super(name, employeeId, baseBonus);
    }

    public double getBonus() {
        return baseBonus * 0.90;
    }
}
