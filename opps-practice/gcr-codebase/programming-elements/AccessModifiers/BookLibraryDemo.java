// Access Modifiers - Problem 2: Book Library System
import java.util.Scanner;

// Base class Book
class LibraryBook2 {
    public String isbn;           // public - accessible everywhere
    protected String title;       // protected - accessible in subclass
    private String author;        // private - only within this class

    // Constructor
    public LibraryBook2(String isbn, String title, String author) {
        this.isbn   = isbn;
        this.title  = title;
        this.author = author;
    }

    // Public getter for private author
    public String getAuthor() {
        return author;
    }

    // Public setter for private author
    public void setAuthor(String author) {
        if (author != null && !author.isEmpty()) {
            this.author = author;
            System.out.println("Author updated to: " + author);
        } else {
            System.out.println("Invalid author name!");
        }
    }

    // Display book details
    public void displayBookDetails() {
        System.out.println("ISBN   : " + isbn);
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
    }
}

// Subclass EBook demonstrating access to ISBN and title
class EBook extends LibraryBook2 {
    private double fileSizeMB;
    private String format;   // e.g., PDF, EPUB

    public EBook(String isbn, String title, String author, double fileSizeMB, String format) {
        super(isbn, title, author);
        this.fileSizeMB = fileSizeMB;
        this.format     = format;
    }

    // Accesses public isbn and protected title directly
    public void displayEBookDetails() {
        System.out.println("ISBN        : " + isbn);         // public — accessible
        System.out.println("Title       : " + title);        // protected — accessible in subclass
        System.out.println("Author      : " + getAuthor());  // private — accessed via public getter
        System.out.printf("File Size   : %.1f MB%n", fileSizeMB);
        System.out.println("Format      : " + format);
    }
}

class BookLibraryDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a base library book
        System.out.println("Enter Library Book Details:");
        System.out.print("ISBN   : ");
        String isbn = sc.nextLine();
        System.out.print("Title  : ");
        String title = sc.nextLine();
        System.out.print("Author : ");
        String author = sc.nextLine();

        LibraryBook2 book = new LibraryBook2(isbn, title, author);
        System.out.println("\n--- Library Book Details ---");
        book.displayBookDetails();

        System.out.print("\nUpdate Author Name: ");
        String newAuthor = sc.nextLine();
        book.setAuthor(newAuthor);
        System.out.println("Author after update: " + book.getAuthor());

        // Create an EBook (subclass)
        System.out.println("\nEnter EBook Details:");
        System.out.print("ISBN        : ");
        String eIsbn = sc.nextLine();
        System.out.print("Title       : ");
        String eTitle = sc.nextLine();
        System.out.print("Author      : ");
        String eAuthor = sc.nextLine();
        System.out.print("File Size (MB): ");
        double size = sc.nextDouble();
        sc.nextLine();
        System.out.print("Format (PDF/EPUB): ");
        String format = sc.nextLine();

        EBook ebook = new EBook(eIsbn, eTitle, eAuthor, size, format);
        System.out.println("\n--- EBook Details (Subclass) ---");
        ebook.displayEBookDetails();

        sc.close();
    }
}
