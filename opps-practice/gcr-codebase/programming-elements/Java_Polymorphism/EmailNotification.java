public class EmailNotification extends Notification {
    private String emailAddress;
    
    public EmailNotification(String recipientName, String message, String emailAddress) {
        super(recipientName, message);
        this.emailAddress = emailAddress;
    }
    
    @Override
    public void sendNotification() {
        System.out.println("📧 EMAIL SENT");
        System.out.println("   To: " + emailAddress);
        System.out.println("   Recipient: " + recipientName);
        System.out.println("   Subject: Important Notification");
        System.out.println("   Body: " + message);
        System.out.println("   Status: ✓ Delivered\n");
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
}
