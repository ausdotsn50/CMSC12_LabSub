public class Dean extends Employee {
    private double bonusPercentage = 0.70;
    public Dean(String name, int employeeId, double baseBonus) {
        super(name, employeeId, baseBonus);
    }

    public double getBonus() {
        return baseBonus * bonusPercentage;
    }
}
