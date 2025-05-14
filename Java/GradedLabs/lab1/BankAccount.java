public class BankAccount {
    // attributes
    // also called instance variables
    private int accountNumber;
    private String accountHolder;
    private double balance;

    // make a constructor that initializes the attributes declared
/* 
    note that the constructor name must match the class name, 
    and it cannot have a return type (like void)

    can contain parameters
*/

    // this is a constructor
/* 
    - can have different parameter names to attributes above
    - when you create an instance of BankAccount you provide these info (parameter)
    x LEFTHAND
        - 'this' refers to object's account number for example
    x RIGHTHAND
        - refers to the provided parameter
*/

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // functions/methods
    public int getNumber() {
        // returning the private attribute
        return accountNumber;
    }

    
    public String getHolder() {
        return accountHolder;
    }

    /* 
    public double getBalance() {
        return balance;
    }

    
    // void return type
    public void setBalance(double newBalance) {
        // accessing the private balance [?]
        balance = newBalance;
    }
    */

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double checkBalance() {
        return balance;
    }
}