public class Cirlce extends Shape {
    private double radius;
    private double piValue = 3.14;

    public Cirlce(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        area = piValue * (radius * radius);
        return area;
    }

    public double getPerimeter() {
        perimeter = 2 * piValue * radius;
        return perimeter;
    }

    public double getRadius() {
        return radius;
    }
}