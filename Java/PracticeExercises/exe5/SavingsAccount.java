public class SavingsAccount extends BankAccount {
    public SavingsAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void withdraw(double amount) {
        if(balance - amount >= 100){
            balance -= amount;
        }
        else {
            System.out.println("Insufficient balance");
        }
    }
}
