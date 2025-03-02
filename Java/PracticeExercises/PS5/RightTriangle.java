public class RightTriangle extends Shape  {
    private double base;
    private double height;

    public RightTriangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return area = (base * height) / 2;
    }

    @Override
    public double getPerimeter() {
        double hyp = Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
        return perimeter = base + height + hyp;
    }
}