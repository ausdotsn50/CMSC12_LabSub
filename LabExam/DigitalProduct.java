import java.util.ArrayList;
import java.util.UUID;
import java.util.Scanner;

public class DigitalProduct extends Product implements Purchaseable {
    // list of valid license keys
    // is this for every product???
    private ArrayList<String> licenseKey = new ArrayList<String>();
    Scanner scan = new Scanner(System.in);
    // associate a licenseKey to a product?

    public DigitalProduct(String productName, double price, String productID) {
        super(productName, price, productID);
    }

    public ArrayList<String> getLicenseKey() {
        return licenseKey;
    }

    public void purchase() {
        String newLicenseKey = UUID.randomUUID().toString();
        licenseKey.add(newLicenseKey);
        System.out.println("Purchase license key: " + newLicenseKey);
    }   

    public void refund() {
        System.out.print("Enter license key: ");
        String refundKey = scan.next();
        
        int refundIndex = licenseKey.indexOf(refundKey);

        licenseKey.remove(refundIndex);
        
        System.out.println("Refund succesful");
        displayInfo();
    }

    public void displayInfo() {
        System.out.println("License Keys Issued: " + licenseKey.size());
    }
}