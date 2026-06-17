public class Account {
    private final String accountNumber;
    private final String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

   
    
    public double getBalance() {
        return balance;
    }
    
    public void updateBalance(double amount) {
        this.balance += amount;
    }
    
   
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
            return false;
        }
        
        if (amount > balance) {
            System.out.println("Insufficient balance! Available balance: " + balance);
            return false;
        }
        
        this.balance -= amount;
        System.out.println("Withdrawal successful! Amount: " + amount);
        System.out.println("Remaining balance: " + balance);
        return true;
    }
}
