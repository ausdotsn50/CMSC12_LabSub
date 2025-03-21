import java.util.ArrayList;
// import java.util.HashMap;

public class ProductManager {
    private ArrayList<Product> product = new ArrayList<Product>();
    // private HashMap<String, Product> map = new HashMap<String,Product>();
    // handles product storage, purchases, and refunds
    
    // add physical product
    public void addProduct(String productName, double price, String productID, int stockQuantity) {
        Product newProduct = new PhysicalProduct(productName, price, productID, stockQuantity);
        product.add(newProduct);

        System.out.printf("\nPhysical product '%s' added succesfully\n", productName);
    }

    // add digital product
    public void addProduct(String productName, double price, String productID) {
        Product newProduct = new DigitalProduct(productName, price, productID);
        product.add(newProduct);

        System.out.printf("\nDigital product '%s' added succesfully\n", productName);
    }

    public void viewAllProducts() {
        System.out.println("\nAvailable Products: ");
        System.out.println("-------------------");
        for(int index = 0; index < product.size(); index++) {
            // ????
            Product currProduct = product.get(index);
            if(currProduct instanceof PhysicalProduct) {
                PhysicalProduct temp = (PhysicalProduct) currProduct;
                System.out.printf("[Physical] %s | Price: %.2f | ID: %s | Stock: %d\n", temp.getProductName(), temp.getPrice(), temp.getProductID(), temp.getStockQuantity());
            }
            else if(currProduct instanceof DigitalProduct) {
                DigitalProduct temp = (DigitalProduct) currProduct;
                // lacks license key still
                System.out.printf("[Digital] %s | Price: %.2f | ID: %s | License Keys Issued: %d\n", temp.getProductName(), temp.getPrice(), temp.getProductID(), temp.getLicenseKey().size());
            }
        }
        System.out.println("-------------------");
    }

    // return product index
    public int findProduct(String productID) {
        // "for Product p in <the product ArrayList obj>"
        for(Product p : product) {
            // using .equals for String comparison
            if(p.getProductID().equals(productID)) {
                return product.indexOf(p);
            }
        }
        return -1; // not found
    }

    // this is for Physical
    public void purchaseProduct(int index) {
        if(index < 0) {
            System.out.println("Product ID does not exist.");
            return;
        }

        Product targetProduct = product.get(index);
        if(targetProduct instanceof PhysicalProduct) {
            PhysicalProduct physicalPurchase = (PhysicalProduct) targetProduct;
            physicalPurchase.purchase();
        }
        else if(targetProduct instanceof DigitalProduct) {
            DigitalProduct digitalPurchase = (DigitalProduct) targetProduct;
            digitalPurchase.purchase();
        }
    }
    
    public void refundProduct(int index) {
        if(index < 0) {
            System.out.println("Product ID does not exist.");
            return;
        }

        Product targetProduct = product.get(index);
        if(targetProduct instanceof PhysicalProduct) {
            PhysicalProduct physicalPurchase = (PhysicalProduct) targetProduct;
            physicalPurchase.refund();
        }
        else if(targetProduct instanceof DigitalProduct) {
            DigitalProduct digitalPurchase = (DigitalProduct) targetProduct;
            digitalPurchase.refund();
        }
    }
    
}