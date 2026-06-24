// Access Modifiers - Problem 3: Bank Account Management
import java.util.Scanner;

// Base class BankAccount
class BankAccount {
    public String accountNumber;       // public - accessible everywhere
    protected String accountHolder;    // protected - accessible in subclass
    private double balance;            // private - only within this class

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance       = balance;
    }

    // Public getter for private balance
    public double getBalance() {
        return balance;
    }

    // Public method to deposit into balance
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited Rs. %.2f | New Balance: Rs. %.2f%n", amount, balance);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    // Public method to withdraw from balance
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.printf("Withdrawn Rs. %.2f | New Balance: Rs. %.2f%n", amount, balance);
        }
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.printf("Balance        : Rs. %.2f%n", balance);
    }
}

// Subclass SavingsAccount demonstrating access modifiers
class SavingsAccount extends BankAccount {
    private double interestRate;  // % per annum

    public SavingsAccount(String accountNumber, String accountHolder,
                          double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Calculates yearly interest on current balance
    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        System.out.printf("Interest @ %.1f%% applied: Rs. %.2f%n", interestRate, interest);
    }

    // Access public accountNumber and protected accountHolder directly
    public void displaySavingsDetails() {
        System.out.println("Account Number : " + accountNumber);      // public
        System.out.println("Account Holder : " + accountHolder);      // protected
        System.out.printf("Balance        : Rs. %.2f%n", getBalance()); // private via getter
        System.out.printf("Interest Rate  : %.1f%% per annum%n", interestRate);
    }
}

class BankAccountDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a base bank account
        System.out.println("Enter Bank Account Details:");
        System.out.print("Account Number : ");
        String accNo = sc.nextLine();
        System.out.print("Account Holder : ");
        String holder = sc.nextLine();
        System.out.print("Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(accNo, holder, balance);
        System.out.println("\n--- Account Details ---");
        account.displayAccountDetails();

        System.out.print("\nDeposit Amount : ");
        account.deposit(sc.nextDouble());

        System.out.print("Withdrawal Amount: ");
        account.withdraw(sc.nextDouble());
        sc.nextLine();

        // Create a savings account (subclass)
        System.out.println("\nEnter Savings Account Details:");
        System.out.print("Account Number : ");
        String sAccNo = sc.nextLine();
        System.out.print("Account Holder : ");
        String sHolder = sc.nextLine();
        System.out.print("Initial Balance: ");
        double sBal = sc.nextDouble();
        System.out.print("Interest Rate (%) per annum: ");
        double rate = sc.nextDouble();

        SavingsAccount savingsAccount = new SavingsAccount(sAccNo, sHolder, sBal, rate);
        System.out.println("\n--- Savings Account Details (Subclass) ---");
        savingsAccount.displaySavingsDetails();
        System.out.println("\nApplying annual interest...");
        savingsAccount.applyInterest();
        savingsAccount.displaySavingsDetails();

        sc.close();
    }
}
