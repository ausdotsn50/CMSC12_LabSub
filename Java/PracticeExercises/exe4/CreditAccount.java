public class CreditAccount extends BankAccount {
    private double maxCredit;
    public CreditAccount(int accountNumber, String accountHolder, double balance, double maxCredit) {
        super(accountNumber, accountHolder, balance);
        this.maxCredit = maxCredit; // super should go above
    }

    public double getMaxCredit() {
        return maxCredit;
    }

    public void withdraw(double amount) {
        if(balance - amount >= -maxCredit){
            balance -= amount;
        }
        else {
            System.out.println("Insufficient balance");
        }
    }
}