import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int counter = 0, maxAccounts = 5, accountNumber, menuChoice, logChoice;
        double amount;

        Scanner scan = new Scanner(System.in);
        Bank bk = new Bank(maxAccounts);

        do {
            System.out.print("1. Create Account\n2. Login to Account\n3. Exit\nChoose an option: ");
            menuChoice = scan.nextInt();

            switch (menuChoice) {
                case 1:
                    bk.createNewAccount(counter);
                    counter++;
                    break;
                
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scan.nextInt();

                    do {
                        System.out.print("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Logout\nChoose an option: ");
                        logChoice = scan.nextInt();

                        if(logChoice == 1) {
                            System.out.print("Enter deposit amount: ");
                            amount = scan.nextDouble();
                            bk.deposit(accountNumber, amount, counter);
                        }
                        else if(logChoice == 2) {
                            System.out.print("Enter withdraw amount: ");
                            amount = scan.nextDouble();
                            bk.withdraw(accountNumber, amount, counter);
                        }
                        else if(logChoice == 3) {
                            bk.checkBalance(accountNumber, counter);
                        }
                        else if(logChoice == 4) {
                            System.out.print("Logging out\n\n");
                        }
                    } while(logChoice > 0 && logChoice < 4);
                    break;
                
                case 3:
                    System.out.println("Exiting...");
                    break;
                
                default:
                    break;
            }
        } while(menuChoice > 0 && menuChoice < 3);
        scan.close();
    }
}
