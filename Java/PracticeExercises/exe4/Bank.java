import java.util.Scanner;

public class Bank {
    Scanner scn = new Scanner(System.in); // reduce Scanner declaration redundancy

    // bank account array initialized [?]
    // as this is initialize, i don't have to put array as parameter again and again [?]
    private BankAccount[] account; // uses BankAccount (belongs to same directory)
    public Bank(int maxAccs) {
        account = new BankAccount[maxAccs];
    }


    // creating correct instance
    public void createNewAccount(int accNum, String accHolder, int accType, int ctr) {
        if(accType == 1) {
            account[ctr] = new SavingsAccount(accNum, accHolder, 0);
        }
        else if(accType == 2) {
            account[ctr] = new CreditAccount(accNum, accHolder, 0, 32500.5);
        }
        
    }

    public void listAccounts(int ctr) {
        System.out.println("\nList of Bank Accounts");
        for(BankAccount i : account) {
            if(i instanceof SavingsAccount) {
                SavingsAccount temp = (SavingsAccount) i;
                System.out.println("Savings Account");
                System.out.println(temp.getHolder());
                System.out.println(temp.getNumber());
                System.out.println(temp.checkBalance());
            } else if(i instanceof CreditAccount) {
                CreditAccount temp = (CreditAccount) i;
                System.out.println("Credit Account");
                System.out.println(temp.getHolder());
                System.out.println(temp.getNumber());
                System.out.println(temp.checkBalance());
                System.out.println(temp.getMaxCredit());
            }
        }
        System.out.println();
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