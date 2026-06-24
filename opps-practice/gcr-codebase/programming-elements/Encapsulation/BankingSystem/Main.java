public class Main {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountNumber("SAV12345");
        savingsAccount.setHolderName("John Doe");
        savingsAccount.setBalance(10000);
        savingsAccount.setInterestRate(5);
        System.out.println("-------- SAVINGS ACCOUNT --------");
        savingsAccount.displayAccountDetails();
        System.out.println("-----------------------------");
        savingsAccount.deposit(2000);
        System.out.println("After deposit:");
        savingsAccount.displayAccountDetails();
        System.out.println("-----------------------------");
        savingsAccount.withdraw(1500);
        System.out.println("After withdrawal:");
        savingsAccount.displayAccountDetails();
        System.out.println("\n");

        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.setAccountNumber("CUR67890");
        currentAccount.setHolderName("Jane Smith");
        currentAccount.setBalance(50000);
        currentAccount.setMonthlyBonusRate(3);
        System.out.println("-------- CURRENT ACCOUNT --------");
        currentAccount.displayAccountDetails();
        System.out.println("-----------------------------");
        currentAccount.deposit(5000);
        System.out.println("After deposit:");
        currentAccount.displayAccountDetails();
        System.out.println("-----------------------------");
        currentAccount.withdraw(10000);
        System.out.println("After withdrawal:");
        currentAccount.displayAccountDetails();
    }
}
