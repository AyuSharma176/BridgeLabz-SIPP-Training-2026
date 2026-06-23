// Program 4: Shopping Cart System
// Demonstrates: static, this, final, instanceof
import java.util.Scanner;

class Product {

    // STATIC: discount percentage shared across ALL products
    private static double discount = 10.0; // 10% default discount

    // FINAL: productID is a unique identifier that cannot be changed
    private final String productID;

    // Instance variables
    private String productName;
    private double price;
    private int quantity;

    // Constructor - uses THIS to resolve ambiguity
    public Product(String productID, String productName, double price, int quantity) {
        this.productID   = productID;    // 'this' resolves parameter vs attribute
        this.productName = productName;
        this.price       = price;
        this.quantity    = quantity;
    }

    // Getters
    public String getProductID()   { return productID; }
    public String getProductName() { return productName; }
    public double getPrice()       { return price; }
    public int getQuantity()       { return quantity; }

    // Setters (productID is final — no setter for it)
    public void setProductName(String name) { this.productName = name; }
    public void setPrice(double price)      { this.price = price; }
    public void setQuantity(int quantity)   { this.quantity = quantity; }

    // Calculate total price after applying shared discount
    private double calculateDiscountedPrice() {
        double discountAmount = price * (discount / 100);
        return (price - discountAmount) * quantity;
    }

    // STATIC methods: accessed via class, not object
    public static void updateDiscount(double newDiscount) {
        if (newDiscount >= 0 && newDiscount <= 100) {
            discount = newDiscount;
            System.out.printf("Discount updated to %.1f%% for ALL products.%n", discount);
        } else {
            System.out.println("Invalid discount! Must be between 0 and 100.");
        }
    }

    public static double getDiscount() { return discount; }

    // Display product details
    public void displayProductDetails() {
        System.out.println("Product ID      : " + productID);     // final — cannot change
        System.out.println("Product Name    : " + productName);
        System.out.printf("Price           : Rs. %.2f%n", price);
        System.out.println("Quantity        : " + quantity);
        System.out.printf("Discount        : %.1f%%%n", discount);
        System.out.printf("Total (after disc): Rs. %.2f%n", calculateDiscountedPrice());
    }
}

class ShoppingCartSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many products in the cart? ");
        int count = sc.nextInt();
        sc.nextLine();

        Product[] cart = new Product[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Product " + (i + 1) + ":");
            System.out.print("Product ID   : ");
            String pid = sc.nextLine();
            System.out.print("Product Name : ");
            String pname = sc.nextLine();
            System.out.print("Price        : ");
            double price = sc.nextDouble();
            System.out.print("Quantity     : ");
            int qty = sc.nextInt();
            sc.nextLine();
            cart[i] = new Product(pid, pname, price, qty);
        }

        // STATIC method call — initial discount display
        System.out.printf("%nCurrent Discount (Static): %.1f%%%n", Product.getDiscount());

        // INSTANCEOF check before displaying product details
        System.out.println("\n--- Cart Details (instanceof check) ---");
        Object[] objects = cart;
        for (Object obj : objects) {
            if (obj instanceof Product) {           // INSTANCEOF verification
                Product p = (Product) obj;
                p.displayProductDetails();
                System.out.println();
            }
        }

        // Update discount using STATIC method — affects ALL products
        System.out.print("Enter new discount percentage for all products: ");
        double newDiscount = sc.nextDouble();
        Product.updateDiscount(newDiscount);

        System.out.println("\n--- Cart After Discount Update ---");
        for (Object obj : objects) {
            if (obj instanceof Product) {
                Product p = (Product) obj;
                p.displayProductDetails();
                System.out.println();
            }
        }

        System.out.println("Note: 'productID' is declared 'final' — it cannot be changed after creation.");

        sc.close();
    }
}
