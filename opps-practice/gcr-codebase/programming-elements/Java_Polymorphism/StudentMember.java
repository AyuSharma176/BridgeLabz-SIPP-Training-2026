public class StudentMember extends LibraryMember {
    private String universityName;
    private static final double FINE_PER_DAY = 5.0;
    private static final int FREE_DAYS = 14;
    
    public StudentMember(String memberName, String memberId, String universityName) {
        super(memberName, memberId);
        this.universityName = universityName;
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
        System.out.println("  Type: Student | University: " + universityName);
    }
    
    public String getUniversityName() {
        return universityName;
    }
}
