public class ShapeCalculator {
    private Shape[] shape; // array creating
    
    public ShapeCalculator(int maxShpCount) {
        shape = new Shape[maxShpCount];
    }

    public void createNewShape(int shpCount, double radius) {
        shape[shpCount] = new Cirlce(radius);
        System.out.printf("Area: %.1f\n", (shape[shpCount].getArea()));
        System.out.printf("Perimeter: %.1f\n", (shape[shpCount].getPerimeter()));
    }

    public void createNewShape(int shpCount, double width, double height) {
        shape[shpCount] = new Rectangle(width, height);
        System.out.printf("Area: %.1f\n", (shape[shpCount].getArea()));
        System.out.printf("Perimeter: %.1f\n", (shape[shpCount].getPerimeter()));
    }

    public void createNewShape(int shpCount, double side1, double side2, double side3) {
        shape[shpCount] = new Triangle(side1, side2, side3);
        System.out.printf("Area: %.1f\n", (shape[shpCount].getArea()));
        System.out.printf("Perimeter: %.1f\n", (shape[shpCount].getPerimeter()));
    }

    public void displayShapes(int shpCount) {
        for(int i = 0; i < shpCount; i++) {
            System.out.println("\nShape " + (i + 1));
            if(shape[i] instanceof Cirlce) {
                Cirlce temp = (Cirlce) shape[i];
                System.out.println("Shape: Cirlce");
                System.out.println("Radius: " + temp.getRadius());
                System.out.printf("Area: %.1f\n", temp.getArea()); 
                System.out.printf("Perimeter: %.1f\n", temp.getPerimeter());
            } else if(shape[i] instanceof Rectangle) {
                Rectangle temp = (Rectangle) shape[i];
                System.out.println("Shape: Rectangle");
                System.out.println("Width: " + temp.getWidth());
                System.out.println("Height: " + temp.getHeight());
                System.out.printf("Area: %.1f\n", temp.getArea()); 
                System.out.printf("Perimeter: %.1f\n", temp.getPerimeter());
            } else if(shape[i] instanceof Triangle) {
                Triangle temp = (Triangle) shape[i];
                System.out.println("Shape: Triangle");
                System.out.println("a: " + temp.getA());
                System.out.println("b: " + temp.getB());
                System.out.println("c: " + temp.getC());
                System.out.printf("Area: %.1f\n", temp.getArea()); 
                System.out.printf("Perimeter: %.1f\n", temp.getPerimeter());
            }
        }
    }
}