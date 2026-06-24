// Program 2: Library Management System
// Demonstrates: static, this, final, instanceof
import java.util.Scanner;

class LibraryBook {

    // STATIC: shared across all Book objects
    private static String libraryName = "City Central Library";

    // FINAL: isbn is a unique identifier that cannot be changed after assignment
    private final String isbn;

    // Instance variables
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor - uses THIS to resolve ambiguity
    public LibraryBook(String isbn, String title, String author) {
        this.isbn        = isbn;    // 'this' resolves parameter vs attribute
        this.title       = title;
        this.author      = author;
        this.isAvailable = true;    // New books start as available
    }

    // Getters
    public String getIsbn()   { return isbn; }
    public String getTitle()  { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    // Setters (isbn is final — no setter for it)
    public void setTitle(String title)   { this.title = title; }
    public void setAuthor(String author) { this.author = author; }

    // Borrow and return methods
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book \"" + title + "\" borrowed successfully.");
        } else {
            System.out.println("Book \"" + title + "\" is currently not available.");
        }
    }

    public void returnBook() {
        isAvailable = true;
        System.out.println("Book \"" + title + "\" returned. Thank you!");
    }

    // STATIC method: display library name, called on class not object
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public static void setLibraryName(String name) { libraryName = name; }

    // Display book details
    public void displayBookDetails() {
        System.out.println("Library     : " + libraryName);
        System.out.println("ISBN        : " + isbn);          // final — cannot change
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Borrowed"));
    }
}

class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many books to add? ");
        int count = sc.nextInt();
        sc.nextLine();

        LibraryBook[] books = new LibraryBook[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Book " + (i + 1) + ":");
            System.out.print("ISBN   : ");
            String isbn = sc.nextLine();
            System.out.print("Title  : ");
            String title = sc.nextLine();
            System.out.print("Author : ");
            String author = sc.nextLine();
            books[i] = new LibraryBook(isbn, title, author);
        }

        // STATIC method call
        System.out.println("\n--- Library Info (Static Method) ---");
        LibraryBook.displayLibraryName();

        // INSTANCEOF check before displaying book details
        System.out.println("\n--- Book Details (instanceof check) ---");
        Object[] objects = books;
        for (Object obj : objects) {
            if (obj instanceof LibraryBook) {       // INSTANCEOF verification
                LibraryBook book = (LibraryBook) obj;
                book.displayBookDetails();
                System.out.println();
            }
        }

        // Demonstrate borrow
        if (books.length > 0) {
            System.out.println("--- Borrowing First Book ---");
            books[0].borrowBook();
            books[0].borrowBook(); // Try borrowing again (should fail)
            books[0].returnBook();
        }

        System.out.println("\nNote: 'isbn' is declared 'final' — it cannot be changed after creation.");

        sc.close();
    }
}
