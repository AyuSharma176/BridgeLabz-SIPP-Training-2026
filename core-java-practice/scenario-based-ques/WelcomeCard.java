// Class to store member details and display welcome card
class WelcomeCard {
    public static void main(String[] args) {

        // Store member details
        String name = "Ravi";
        int age = 22;
        char rank = 'A';
        double salary = 50000.0;
        float membershipFee = 1500.50f;

        // Calculate annual bonus (12% of salary)
        double annualBonus = salary * 0.12;

        // Cast bonus to int
        int bonusAmount = (int) annualBonus;

        // Display welcome card
        System.out.println("----------------------------------");
        System.out.println("      CODING GUILD WELCOME       ");
        System.out.println("----------------------------------");
        System.out.println("Name            : " + name);
        System.out.println("Age             : " + age);
        System.out.println("Rank            : " + rank);
        System.out.println("Salary          : INR " + salary);
        System.out.println("Membership Fee  : INR " + membershipFee);
        System.out.println("Annual Bonus    : INR " + bonusAmount);
        System.out.println("----------------------------------");
        System.out.println("Welcome to the Coding Guild, " + name + "!");
    }
}