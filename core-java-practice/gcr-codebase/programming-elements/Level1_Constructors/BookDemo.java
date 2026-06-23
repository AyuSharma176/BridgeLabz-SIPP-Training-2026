// Program 1: Book class with default and parameterized constructors
import java.util.Scanner;

class Book {
    // Attributes (private - encapsulation)
    private String title;
    private String author;
    private double price;

    // Default constructor - assigns default values
    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
    }

    // Parameterized constructor - assigns user-provided values
    // 'this' keyword avoids ambiguity when parameter names match attribute names
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getters
    public String getTitle()  { return title; }
    public String getAuthor() { return author; }
    public double getPrice()  { return price; }

    // Setters
    public void setTitle(String title)   { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPrice(double price)   { this.price = price; }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : Rs. " + price);
    }
}

class BookDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Using default constructor
        Book defaultBook = new Book();
        System.out.println("--- Default Constructor ---");
        defaultBook.displayBookDetails();

        // Using parameterized constructor
        System.out.println("\nEnter book details:");
        System.out.print("Title  : ");
        String title = sc.nextLine();
        System.out.print("Author : ");
        String author = sc.nextLine();
        System.out.print("Price  : ");
        double price = sc.nextDouble();

        Book userBook = new Book(title, author, price);
        System.out.println("\n--- Parameterized Constructor ---");
        userBook.displayBookDetails();

        sc.close();
    }
}
