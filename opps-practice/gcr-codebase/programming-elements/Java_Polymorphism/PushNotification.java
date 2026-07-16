public class PushNotification extends Notification {
    private String deviceToken;
    private String appName;
    
    public PushNotification(String recipientName, String message, String deviceToken, String appName) {
        super(recipientName, message);
        this.deviceToken = deviceToken;
        this.appName = appName;
    }
    
    @Override
    public void sendNotification() {
        System.out.println("🔔 PUSH NOTIFICATION SENT");
        System.out.println("   Device Token: " + deviceToken);
        System.out.println("   App: " + appName);
        System.out.println("   Recipient: " + recipientName);
        System.out.println("   Title: New Update");
        System.out.println("   Message: " + message);
        System.out.println("   Status: ✓ Delivered\n");
    }
    
    public String getDeviceToken() {
        return deviceToken;
    }
    
    public String getAppName() {
        return appName;
    }
}
