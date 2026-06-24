// Program 2: Circle class with constructor chaining using this()
import java.util.Scanner;

class Circle {
    // Attribute
    private double radius;

    // Default constructor - chains to parameterized constructor with default radius
    public Circle() {
        this(1.0); // Constructor chaining — calls Circle(double radius)
        System.out.println("Default constructor called. Radius set to 1.0");
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
        System.out.println("Parameterized constructor called. Radius set to " + radius);
    }

    // Getter and Setter
    public double getRadius()          { return radius; }
    public void setRadius(double r)    { this.radius = r; }

    // Method to calculate and display area and circumference
    public void displayCircleDetails() {
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;
        System.out.println("Radius        : " + radius);
        System.out.printf("Area          : %.2f%n", area);
        System.out.printf("Circumference : %.2f%n", circumference);
    }
}

class CircleDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Using default constructor (chains to parameterized)
        System.out.println("--- Default Constructor (Chained) ---");
        Circle defaultCircle = new Circle();
        defaultCircle.displayCircleDetails();

        // Using parameterized constructor
        System.out.print("\nEnter radius for a new circle: ");
        double radius = sc.nextDouble();
        System.out.println("\n--- Parameterized Constructor ---");
        Circle userCircle = new Circle(radius);
        userCircle.displayCircleDetails();

        sc.close();
    }
}
