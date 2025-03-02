public class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return area = Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return perimeter = 2 * Math.PI * radius;
    }
}