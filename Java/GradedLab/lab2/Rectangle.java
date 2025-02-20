public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        area = width * height;
        return area;
    }

    public double getPerimeter() {
        perimeter = 2 * (width + height);
        return perimeter;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}