import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProductManager pm = new ProductManager();

        boolean running = true;
        int loginChoice, customerChoice, managerChoice, productType;

        String productName, productID;

        double price;

        int stockQuantity;


        System.out.print("\nWelcome to the Online Shopping System!");
        do {
            System.out.print("\nLogin as:\n1. Customer\n2. Manager\n3. Exit\nEnter your choice: "); 
            loginChoice = scan.nextInt();
            
            switch (loginChoice) {
                case 1: // customer
                    System.out.print("\nCustomer Menu:\n1. View all products\n2. Purchase a product\n3. Refund a product\n4. Logout\nEnter your choice: "); 
                    customerChoice = scan.nextInt();

                    if(customerChoice == 1) {
                        pm.viewAllProducts();
                    }
                    else if(customerChoice == 2) {
                        System.out.print("Enter Product ID to purchase: ");
                        productID = scan.next();

                        // pm.purchaseItem(productID);
                        pm.purchaseProduct(pm.findProduct(productID));
                    }
                    else if(customerChoice == 3) {
                        System.out.print("Enter Product ID to refund: ");
                        productID = scan.next();

                        pm.refundProduct(pm.findProduct(productID));

                    }
                    break;

                case 2: // manager
                    System.out.print("\nManager Menu:\n1. View all products\n2. Add a new product\n3. Logout\nEnter your choice: "); 
                    managerChoice = scan.nextInt();

                    // view
                    if(managerChoice == 1) {
                        pm.viewAllProducts();
                    }
                    // add
                    else if(managerChoice == 2) {
                        System.out.print("\nAdd a new product:\nChoose a product type:\n1. Physical Product\n2. Digital Product\nEnter choice: ");
                        productType = scan.nextInt();
                        
                        // physical product
                        if(productType == 1) {
                            System.out.print("Enter product name: ");
                            productName = scan.next();
                            System.out.print("Enter price: ");
                            price = scan.nextDouble();
                            System.out.print("Enter product ID: ");
                            productID = scan.next();
                            System.out.print("Enter stock quantity: ");
                            stockQuantity = scan.nextInt();

                            pm.addProduct(productName, price, productID, stockQuantity);
                            // Success message
                        }
                        
                        // digital product
                        else if(productType == 2) {
                            System.out.print("Enter product name: ");
                            productName = scan.next();
                            System.out.print("Enter price: ");
                            price = scan.nextDouble();
                            System.out.print("Enter product ID: ");
                            productID = scan.next();

                            pm.addProduct(productName, price, productID);
                        }
                    }

                    else if(managerChoice == 3) {
                        break;
                    }
                    break;
                
                case 3:
                    running = false;
                    System.out.println("Bye!");
                    break;

                default:
                    break;
            }
        } while (running);
        
        
    
        scan.close();
    }
}