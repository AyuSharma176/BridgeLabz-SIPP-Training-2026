
public class User {
    public static void main(String[] args) {
        Account account = new Account("123456789", "Ayush", 1000.0);
        account.withdraw(500.0);
    }
}
