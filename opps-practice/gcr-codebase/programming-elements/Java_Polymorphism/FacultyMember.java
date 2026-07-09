public class FacultyMember extends LibraryMember {
    private String departmentName;
    private static final double FINE_PER_DAY = 10.0;
    private static final int FREE_DAYS = 30;
    
    public FacultyMember(String memberName, String memberId, String departmentName) {
        super(memberName, memberId);
        this.departmentName = departmentName;
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
        System.out.println("  Type: Faculty | Department: " + departmentName);
    }
    
    public String getDepartmentName() {
        return departmentName;
    }
}
