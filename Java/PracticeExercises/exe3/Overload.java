import java.util.Scanner;
public class Overload {
    
    public void Menu() {
        System.out.print("Choose via which method to pay\n1. Cash\n2. Credit Card\n3. Debit Card\nPress 4 to exit\nEnter choice: ");
    }

    // cash
    public void payAmount(double amount) {
        System.out.print("Thank you for paying Php " + amount + " via Cash!\n\n");
    }

    // credit card
    public void payAmount(double amount, int accNumber) {
        System.out.print("Thank you for paying Php " + amount + " via Credit Card!\n\n");
    }

    // debit
    public void payAmount(double amount, int accNumber, int pin) {
        System.out.print("Thank you for paying Php " + amount + " via Debit Card!\n\n");
    }
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        Overload ol = new Overload();
        
        int choice, accNumber, pin;
        double amount;
        do {
            ol.Menu();
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to pay: ");
                    amount = scan.nextDouble();
                    ol.payAmount(amount);
                    break;

                case 2:
                    System.out.print("Enter amount to pay: ");
                    amount = scan.nextDouble();
                    System.out.print("Enter account number: ");
                    accNumber = scan.nextInt();
                    ol.payAmount(amount, accNumber);
                    break;
                
                case 3:
                    System.out.print("Enter amount to pay: ");
                    amount = scan.nextDouble();
                    System.out.print("Enter account number: ");
                    accNumber = scan.nextInt();
                    System.out.print("Enter pin: ");
                    pin = scan.nextInt();
                    ol.payAmount(amount, accNumber, pin);
                    break;
                
                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    break;
            }
        } while (choice > 0 && choice < 4);
        
        /* 
        ol.payAmount(300.25);
        ol.payAmount(365.33, 202350064);
        ol.payAmount(789.55, 202350064, 8714);
        */

        scan.close();
    }
}