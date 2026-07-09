public abstract class Notification {
    protected String recipientName;
    protected String message;
    protected long timestamp;
    
    public Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }
    
    public abstract void sendNotification();
    
    public String getRecipientName() {
        return recipientName;
    }
    
    public String getMessage() {
        return message;
    }
    
    public long getTimestamp() {
        return timestamp;
    }
}
