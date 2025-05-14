public abstract class Product {
    protected String productName;
    protected double price;
    protected String productID;

    public Product(String productName, double price, String productID) {
        this.productName = productName;
        this.price = price;
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getProductID() {
        return productID;
    }


    public abstract void displayInfo();
}