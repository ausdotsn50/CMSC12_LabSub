public class Dean extends Employee {
    public Dean(String name, int employeeId, double baseBonus) {
        super(name, employeeId, baseBonus);
    }

    public double getBonus() {
        return baseBonus * 0.70;
    }
}
