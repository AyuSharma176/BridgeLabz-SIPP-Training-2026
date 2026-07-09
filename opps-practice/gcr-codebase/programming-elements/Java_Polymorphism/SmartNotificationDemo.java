public class SmartNotificationDemo {
    public static void main(String[] args) {
        System.out.println("========== SMART NOTIFICATION SYSTEM ==========\n");
        
        Notification[] notifications = {
            new EmailNotification("John Doe", "Your account has been verified successfully", "john.doe@email.com"),
            new SMSNotification("Jane Smith", "Your OTP is 123456. Valid for 10 minutes", "+91-9876543210"),
            new PushNotification("Alice Johnson", "New message from Sarah", "device_token_xyz_123", "ChatApp"),
            new EmailNotification("Bob Wilson", "Monthly invoice is ready for download", "bob.wilson@email.com"),
            new SMSNotification("Carol White", "Delivery Update: Package on the way", "+91-8765432109"),
            new PushNotification("David Brown", "Sale Alert: 50% off on Electronics!", "device_token_abc_456", "ShoppingApp")
        };
        
        System.out.println("Sending notifications through different channels...\n");
        
        for (Notification notification : notifications) {
            notification.sendNotification();
        }
        
        displaySummary(notifications);
    }
    
    private static void displaySummary(Notification[] notifications) {
        System.out.println("\n========== NOTIFICATION SUMMARY ==========\n");
        
        int emailCount = 0;
        int smsCount = 0;
        int pushCount = 0;
        
        System.out.println("All Sent Notifications:");
        for (int i = 0; i < notifications.length; i++) {
            Notification notif = notifications[i];
            String channel = "Unknown";
            
            if (notif instanceof EmailNotification) {
                channel = "EMAIL";
                emailCount++;
                System.out.println((i + 1) + ". [" + channel + "] To: " + 
                    ((EmailNotification)notif).getEmailAddress() + 
                    " | Recipient: " + notif.getRecipientName());
            } else if (notif instanceof SMSNotification) {
                channel = "SMS";
                smsCount++;
                System.out.println((i + 1) + ". [" + channel + "] To: " + 
                    ((SMSNotification)notif).getPhoneNumber() + 
                    " | Recipient: " + notif.getRecipientName());
            } else if (notif instanceof PushNotification) {
                channel = "PUSH";
                pushCount++;
                System.out.println((i + 1) + ". [" + channel + "] App: " + 
                    ((PushNotification)notif).getAppName() + 
                    " | Recipient: " + notif.getRecipientName());
            }
        }
        
        System.out.println("\nChannel Breakdown:");
        System.out.println("  📧 Emails: " + emailCount);
        System.out.println("  📱 SMS: " + smsCount);
        System.out.println("  🔔 Push Notifications: " + pushCount);
        System.out.println("  Total: " + notifications.length);
        
        System.out.println("\n✓ Dynamic Method Dispatch: Each notification uses its own sendNotification() implementation");
    }
}
