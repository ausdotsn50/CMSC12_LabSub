// syntax for abstract classes
public abstract class BankAccount {
    protected int accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getNumber() {
        return accountNumber;
    }

    
    public String getHolder() {
        return accountHolder;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }

    public double checkBalance() {
        return balance;
    }

    public abstract void withdraw(double amount);
}