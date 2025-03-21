public class PhysicalProduct extends Product implements Purchaseable {
    private int stockQuantity;

    public PhysicalProduct(String productName, double price, String productID, int stockQuantity) {
        super(productName, price, productID);
        this.stockQuantity = stockQuantity;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    // check stock before purchasing
    // restocks on refund
    public void purchase() {
        if(stockQuantity > 0) {
            stockQuantity--;
            System.out.printf("Purchase Succesful!");
            displayInfo();
        }
        else {
            System.out.printf("Currently out of stocks for %s\n");
            return;
        }
    }

    public void refund() {
        stockQuantity++;
        System.out.printf("Refund Succesful!");
        displayInfo();
    }

    public void displayInfo() {
        System.out.println("Stock: " + stockQuantity);
    }
}