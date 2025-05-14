import java.util.Scanner;

public class Bank {
    Scanner scn = new Scanner(System.in); // reduce Scanner declaration redundancy

    // bank account array initialized [?]
    // as this is initialize, i don't have to put array as parameter again and again [?]
    private BankAccount[] account; // uses BankAccount (belongs to same directory)
    public Bank(int maxAccs) {
        account = new BankAccount[maxAccs];
    }

    public void createNewAccount(int ctr) {
        System.out.print("Enter account number: ");
        int accountNumber = scn.nextInt();

        System.out.print("Enter account holder name: ");
        String accountHolder = scn.next();
        
        account[ctr] = new BankAccount(accountNumber, accountHolder, 0);
        System.out.print("Account created successfully!\n\n");
    }

/* 
    public void displayAccounts(int index) {
        System.out.println("\nList of Bank Accounts:");
        for (int i = 0; i < index; i++) {
            if (account[i] != null) { // Ensure the slot is not empty
                System.out.println("Account Number: " + account[i].getNumber());
                System.out.println("Account Holder: " + account[i].getHolder());
                System.out.println("Balance: " + account[i].getBalance());
                System.out.println("-------------------------");
            }
        }
    }
*/

    public void deposit(int accNum, double amt, int ctr) {
        for(int i = 0; i < ctr; i++) {
            if(accNum == account[i].getNumber()) {
                account[i].deposit(amt);
                break;
            }
        }
    }

    public void withdraw(int accNum, double amt, int ctr) {
        for(int i = 0; i < ctr; i++) {
            if(accNum == account[i].getNumber()) {
                account[i].withdraw(amt);
                break;
            }
        }
    }

    public void checkBalance(int accNum, int ctr) {
        for(int i = 0; i < ctr; i++) {
            if(accNum == account[i].getNumber()) {
                System.out.println("Check Balance: " + account[i].checkBalance());
                break;
            }
        }
    }


}