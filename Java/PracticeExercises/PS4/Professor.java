public class Professor extends Employee {
    private double bonusPercentage = 0.80;
    public Professor(String name, int employeeId, double baseBonus) {
        super(name, employeeId, baseBonus);
    }

    public double getBonus() {
        return baseBonus * bonusPercentage;
    }
}