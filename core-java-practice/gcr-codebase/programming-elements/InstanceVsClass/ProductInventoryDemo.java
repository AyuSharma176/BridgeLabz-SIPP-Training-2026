// Instance vs. Class Variables and Methods - Problem 1: Product Inventory
import java.util.Scanner;

class Product {
    // Instance variables (unique to each product object)
    private String productName;
    private double price;

    // Class (static) variable - shared among ALL Product objects
    private static int totalProducts = 0;

    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price       = price;
        totalProducts++;  // Increment shared counter whenever a product is created
    }

    // Getters and Setters
    public String getProductName()       { return productName; }
    public double getPrice()             { return price; }
    public void setProductName(String n) { this.productName = n; }
    public void setPrice(double p)       { this.price = p; }

    // Instance method - displays details of THIS product object
    public void displayProductDetails() {
        System.out.println("Product Name : " + productName);
        System.out.printf("Price        : Rs. %.2f%n", price);
    }

    // Class (static) method - displays total products (shared data, no object needed)
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
}

class ProductInventoryDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many products do you want to add? ");
        int count = sc.nextInt();
        sc.nextLine();

        Product[] products = new Product[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Product " + (i + 1) + ":");
            System.out.print("Product Name : ");
            String name = sc.nextLine();
            System.out.print("Price        : ");
            double price = sc.nextDouble();
            sc.nextLine();
            products[i] = new Product(name, price);
        }

        System.out.println("\n--- All Product Details (Instance Method) ---");
        for (Product p : products) {
            p.displayProductDetails();
            System.out.println();
        }

        // Class method called on the class itself, not an object
        System.out.println("--- Product Count (Class Method) ---");
        Product.displayTotalProducts();

        sc.close();
    }
}
