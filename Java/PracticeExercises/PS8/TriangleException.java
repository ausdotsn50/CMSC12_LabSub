public class TriangleException extends Exception {
    public TriangleException() {
        super("For a valid triangle input, the sum of its two sides must be greater than the third side :)");
    }
}