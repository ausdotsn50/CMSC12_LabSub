public class Professor extends Employee {
    public Professor(String name, int employeeId, double baseBonus) {
        super(name, employeeId, baseBonus);
    }

    public double getBonus() {
        return baseBonus * 0.80;
    }
}
