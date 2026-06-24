public class BankAccount {
    private String accountNumber;
    private String holder;
    private double balance;
    private static int totalAccounts = 0;

    public BankAccount(String accountNumber, String holder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = initialBalance;
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("[" + holder + "] Deposited: ₹" + amount + " | Balance: ₹" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("[" + holder + "] Overdraft prevented! Tried: ₹" + amount + " | Available: ₹" + balance);
        } else {
            balance -= amount;
            System.out.println("[" + holder + "] Withdrew: ₹" + amount + " | Balance: ₹" + balance);
        }
    }

    public void getStatement() {
        System.out.println("------ Account Statement ------");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder         : " + holder);
        System.out.println("Current Balance: ₹" + balance);
        System.out.println("-------------------------------");
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("ACC001", "Alice", 5000);
        BankAccount a2 = new BankAccount("ACC002", "Bob", 3000);
        BankAccount a3 = new BankAccount("ACC003", "Charlie", 7000);

        System.out.println("=== Alice's Transactions ===");
        a1.deposit(2000);
        a1.withdraw(1500);
        a1.deposit(500);
        a1.withdraw(8000); // overdraft
        a1.withdraw(300);

        System.out.println("\n=== Bob's Transactions ===");
        a2.deposit(1000);
        a2.withdraw(500);
        a2.deposit(2000);
        a2.withdraw(200);
        a2.withdraw(4000); // overdraft

        System.out.println("\n=== Charlie's Transactions ===");
        a3.deposit(3000);
        a3.withdraw(2000);
        a3.deposit(1000);
        a3.withdraw(500);
        a3.deposit(750);

        System.out.println("\n=== Statements ===");
        a1.getStatement();
        a2.getStatement();
        a3.getStatement();

        System.out.println("Total Accounts Created: " + BankAccount.getTotalAccounts());
    }
}
