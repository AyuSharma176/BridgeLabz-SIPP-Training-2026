public abstract class LibraryMember {
    protected String memberName;
    protected String memberId;
    protected int booksIssued;
    
    public LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.booksIssued = 0;
    }
    
    public abstract double calculateFine(int overdueDays);
    
    public String getMemberName() {
        return memberName;
    }
    
    public String getMemberId() {
        return memberId;
    }
    
    public int getBooksIssued() {
        return booksIssued;
    }
    
    public void issueBook() {
        booksIssued++;
    }
    
    public void returnBook() {
        if (booksIssued > 0) {
            booksIssued--;
        }
    }
    
    public void displayMemberInfo() {
        System.out.println("Member: " + memberName + " | ID: " + memberId + " | Books Issued: " + booksIssued);
    }
}
