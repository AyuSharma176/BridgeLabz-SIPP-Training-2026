// Program 5: Library Book System with title, author, price, availability, and borrow method
import java.util.Scanner;

class LibraryBook {
    // Attributes
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    // Default constructor
    public LibraryBook() {
        this.title       = "Unknown";
        this.author      = "Unknown";
        this.price       = 0.0;
        this.isAvailable = true;
    }

    // Parameterized constructor
    public LibraryBook(String title, String author, double price) {
        this.title       = title;
        this.author      = author;
        this.price       = price;
        this.isAvailable = true; // New books start as available
    }

    // Getters
    public String getTitle()      { return title; }
    public String getAuthor()     { return author; }
    public double getPrice()      { return price; }
    public boolean isAvailable()  { return isAvailable; }

    // Method to borrow a book
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book \"" + title + "\" has been borrowed successfully.");
        } else {
            System.out.println("Sorry! Book \"" + title + "\" is currently not available.");
        }
    }

    // Method to return a book
    public void returnBook() {
        isAvailable = true;
        System.out.println("Book \"" + title + "\" has been returned. Thank you!");
    }

    // Display book details
    public void displayBookDetails() {
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.printf("Price       : Rs. %.2f%n", price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Borrowed"));
    }
}

class LibraryBookDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter book details:");
        System.out.print("Title  : ");
        String title = sc.nextLine();
        System.out.print("Author : ");
        String author = sc.nextLine();
        System.out.print("Price  : ");
        double price = sc.nextDouble();

        LibraryBook book = new LibraryBook(title, author, price);

        System.out.println("\n--- Book Details ---");
        book.displayBookDetails();

        System.out.println("\n--- Borrowing the Book ---");
        book.borrowBook();
        book.displayBookDetails();

        System.out.println("\n--- Trying to Borrow Again ---");
        book.borrowBook();

        System.out.println("\n--- Returning the Book ---");
        book.returnBook();
        book.displayBookDetails();

        sc.close();
    }
}
