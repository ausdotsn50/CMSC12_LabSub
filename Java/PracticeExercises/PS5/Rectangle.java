public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return area = length * width;
    }
    
    @Override
    public double getPerimeter() {
        return perimeter = (2 * length) + (2 * width);
    }
}