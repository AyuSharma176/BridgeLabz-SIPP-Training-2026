// Program 1: Bank Account System
// Demonstrates: static, this, final, instanceof
import java.util.Scanner;

class BankAccount {

    // STATIC: shared across all BankAccount objects
    private static String bankName = "National Trust Bank";
    private static int totalAccounts = 0;

    // FINAL: accountNumber cannot be changed once assigned
    private final String accountNumber;

    // Instance variables
    private String accountHolderName;
    private double balance;

    // Constructor - uses THIS to resolve ambiguity
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber      = accountNumber;   // 'this' resolves parameter vs attribute
        this.accountHolderName  = accountHolderName;
        this.balance            = balance;
        totalAccounts++;                           // Increment shared counter
    }

    // Getters
    public String getAccountNumber()     { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public double getBalance()           { return balance; }

    // Setter (accountNumber is final — no setter for it)
    public void setAccountHolderName(String name) { this.accountHolderName = name; }

    // Deposit and Withdraw
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited Rs. %.2f | New Balance: Rs. %.2f%n", amount, balance);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

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

    // STATIC method: accessed via class, not object
    public static void getTotalAccounts() {
        System.out.println("Bank Name      : " + bankName);
        System.out.println("Total Accounts : " + totalAccounts);
    }

    public static void setBankName(String name) { bankName = name; }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("Bank Name      : " + bankName);
        System.out.println("Account Number : " + accountNumber);  // final - cannot be changed
        System.out.println("Account Holder : " + accountHolderName);
        System.out.printf("Balance        : Rs. %.2f%n", balance);
    }
}

class BankAccountSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many bank accounts to create? ");
        int count = sc.nextInt();
        sc.nextLine();

        BankAccount[] accounts = new BankAccount[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Account " + (i + 1) + ":");
            System.out.print("Account Number : ");
            String accNo = sc.nextLine();
            System.out.print("Account Holder : ");
            String holder = sc.nextLine();
            System.out.print("Initial Balance: ");
            double balance = sc.nextDouble();
            sc.nextLine();
            accounts[i] = new BankAccount(accNo, holder, balance);
        }

        // STATIC method call - no object needed
        System.out.println("\n--- Bank Summary (Static Method) ---");
        BankAccount.getTotalAccounts();

        // INSTANCEOF check before displaying details
        System.out.println("\n--- Account Details (instanceof check) ---");
        Object[] objects = accounts; // treat as Object array to demonstrate instanceof
        for (Object obj : objects) {
            if (obj instanceof BankAccount) {         // INSTANCEOF verification
                BankAccount acc = (BankAccount) obj;
                acc.displayAccountDetails();
                System.out.println();
            }
        }

        // Demonstrate FINAL — trying to change accountNumber is a compile error
        System.out.println("Note: accountNumber is declared 'final' — it cannot be reassigned after creation.");

        sc.close();
    }
}
