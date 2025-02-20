public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea() {
        double s = (side1 + side2 + side3) / 2.00;
        area = Math.sqrt(s*(s - side1)*(s - side2)*(s - side3));
        return area;
    }

    public double getPerimeter() {
        perimeter = side1 + side2 + side3;
        return perimeter;
    }

    public double getA() {
        return side1;
    }

    public double getB() {
        return side2;
    }

    public double getC() {
        return side3;
    }
}