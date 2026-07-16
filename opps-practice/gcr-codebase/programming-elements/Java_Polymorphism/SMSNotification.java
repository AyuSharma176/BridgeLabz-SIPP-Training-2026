public class SMSNotification extends Notification {
    private String phoneNumber;
    
    public SMSNotification(String recipientName, String message, String phoneNumber) {
        super(recipientName, message);
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public void sendNotification() {
        System.out.println("📱 SMS SENT");
        System.out.println("   To: " + phoneNumber);
        System.out.println("   Recipient: " + recipientName);
        System.out.println("   Message: " + message);
        System.out.println("   Status: ✓ Delivered\n");
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
