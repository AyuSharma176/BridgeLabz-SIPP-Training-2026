public class SmartLibraryDemo {
    public static void main(String[] args) {
        System.out.println("========== SMART LIBRARY MEMBERSHIP SYSTEM ==========\n");
        
        LibraryMember[] members = {
            new StudentMember("Rahul Kumar", "STU001", "Delhi University"),
            new FacultyMember("Dr. Sharma", "FAC001", "Computer Science"),
            new GuestMember("Anita Patel", "GUEST001", "Weekly Pass"),
            new StudentMember("Priya Singh", "STU002", "IIT Delhi"),
            new FacultyMember("Prof. Verma", "FAC002", "Physics"),
            new GuestMember("Rohan Gupta", "GUEST002", "Monthly Pass")
        };
        
        System.out.println("Library Members:");
        for (LibraryMember member : members) {
            member.displayMemberInfo();
        }
        
        System.out.println("\n========== FINE CALCULATION ==========\n");
        calculateAndDisplayFines(members);
        
        System.out.println("\n========== MEMBER SEARCH ==========\n");
        searchMemberById(members, "FAC001");
        searchMemberById(members, "STU002");
        searchMemberById(members, "GUEST001");
        
        System.out.println("\n========== MEMBERSHIP SUMMARY ==========\n");
        displayMembershipStats(members);
    }
    
    private static void calculateAndDisplayFines(LibraryMember[] members) {
        int[] overdueDays = {10, 35, 5, 20, 40, 8};
        
        double totalFines = 0;
        for (int i = 0; i < members.length; i++) {
            double fine = members[i].calculateFine(overdueDays[i]);
            totalFines += fine;
            
            String memberType = "Unknown";
            if (members[i] instanceof StudentMember) {
                memberType = "Student";
            } else if (members[i] instanceof FacultyMember) {
                memberType = "Faculty";
            } else if (members[i] instanceof GuestMember) {
                memberType = "Guest";
            }
            
            System.out.printf("%s (%s) - Overdue Days: %d | Fine: ₹%.2f%n",
                members[i].getMemberName(), memberType, overdueDays[i], fine);
        }
        
        System.out.printf("\nTotal Fines Collected: ₹%.2f%n", totalFines);
    }
    
    private static void searchMemberById(LibraryMember[] members, String searchId) {
        System.out.println("Searching for ID: " + searchId);
        
        for (LibraryMember member : members) {
            if (member.getMemberId().equals(searchId)) {
                System.out.println("✓ Found!");
                System.out.println("  Name: " + member.getMemberName());
                System.out.println("  ID: " + member.getMemberId());
                System.out.println("  Books Issued: " + member.getBooksIssued());
                
                if (member instanceof StudentMember) {
                    StudentMember student = (StudentMember) member;
                    System.out.println("  University: " + student.getUniversityName());
                } else if (member instanceof FacultyMember) {
                    FacultyMember faculty = (FacultyMember) member;
                    System.out.println("  Department: " + faculty.getDepartmentName());
                } else if (member instanceof GuestMember) {
                    GuestMember guest = (GuestMember) member;
                    System.out.println("  Pass Type: " + guest.getGuestType());
                }
                System.out.println();
                return;
            }
        }
        
        System.out.println("✗ Member not found\n");
    }
    
    private static void displayMembershipStats(LibraryMember[] members) {
        int studentCount = 0;
        int facultyCount = 0;
        int guestCount = 0;
        int totalBooks = 0;
        
        for (LibraryMember member : members) {
            totalBooks += member.getBooksIssued();
            
            if (member instanceof StudentMember) {
                studentCount++;
            } else if (member instanceof FacultyMember) {
                facultyCount++;
            } else if (member instanceof GuestMember) {
                guestCount++;
            }
        }
        
        System.out.println("Total Members: " + members.length);
        System.out.println("  👨‍🎓 Student Members: " + studentCount);
        System.out.println("  👨‍🏫 Faculty Members: " + facultyCount);
        System.out.println("  👤 Guest Members: " + guestCount);
        System.out.println("\nTotal Books Issued: " + totalBooks);
        
        System.out.println("\n✓ Dynamic Method Dispatch: Each membership type calculates fines differently!");
    }
}
