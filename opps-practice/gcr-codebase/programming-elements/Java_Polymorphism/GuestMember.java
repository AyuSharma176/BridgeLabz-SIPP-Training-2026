public class GuestMember extends LibraryMember {
    private String guestType;
    private static final double FINE_PER_DAY = 20.0;
    private static final int FREE_DAYS = 7;
    
    public GuestMember(String memberName, String memberId, String guestType) {
        super(memberName, memberId);
        this.guestType = guestType;
    }
    
    @Override
    public double calculateFine(int overdueDays) {
        if (overdueDays <= FREE_DAYS) {
            return 0.0;
        }
        return (overdueDays - FREE_DAYS) * FINE_PER_DAY;
    }
    
    @Override
    public void displayMemberInfo() {
        super.displayMemberInfo();
        System.out.println("  Type: Guest | Pass Type: " + guestType);
    }
    
    public String getGuestType() {
        return guestType;
    }
}
