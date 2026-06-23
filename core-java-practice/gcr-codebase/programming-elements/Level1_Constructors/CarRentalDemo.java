// Program 6: Car Rental System with constructors and total cost calculation
import java.util.Scanner;

class CarRental {
    // Attributes
    private String customerName;
    private String carModel;
    private int rentalDays;

    // Fixed rate per day (private helper constant)
    private static final double RATE_PER_DAY = 1500.0;

    // Default constructor
    public CarRental() {
        this.customerName = "Walk-in Customer";
        this.carModel     = "Economy Car";
        this.rentalDays   = 1;
    }

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel     = carModel;
        this.rentalDays   = rentalDays;
    }

    // Copy constructor
    public CarRental(CarRental other) {
        this.customerName = other.customerName;
        this.carModel     = other.carModel;
        this.rentalDays   = other.rentalDays;
    }

    // Private method to calculate total rental cost (encapsulated logic)
    private double calculateTotalCost() {
        return RATE_PER_DAY * rentalDays;
    }

    // Getters
    public String getCustomerName() { return customerName; }
    public String getCarModel()     { return carModel; }
    public int getRentalDays()      { return rentalDays; }

    // Setters
    public void setCustomerName(String n) { this.customerName = n; }
    public void setCarModel(String m)     { this.carModel = m; }
    public void setRentalDays(int d)      { this.rentalDays = d; }

    // Display rental details and total cost
    public void displayRentalDetails() {
        System.out.println("Customer Name : " + customerName);
        System.out.println("Car Model     : " + carModel);
        System.out.println("Rental Days   : " + rentalDays);
        System.out.printf("Rate/Day      : Rs. %.2f%n", RATE_PER_DAY);
        System.out.printf("Total Cost    : Rs. %.2f%n", calculateTotalCost());
    }
}

class CarRentalDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Default constructor
        System.out.println("--- Default Rental ---");
        CarRental defaultRental = new CarRental();
        defaultRental.displayRentalDetails();

        // Parameterized constructor
        System.out.println("\nEnter rental details:");
        System.out.print("Customer Name : ");
        String customerName = sc.nextLine();
        System.out.print("Car Model     : ");
        String carModel = sc.nextLine();
        System.out.print("Rental Days   : ");
        int rentalDays = sc.nextInt();

        CarRental newRental = new CarRental(customerName, carModel, rentalDays);
        System.out.println("\n--- New Rental ---");
        newRental.displayRentalDetails();

        // Copy constructor
        CarRental copiedRental = new CarRental(newRental);
        copiedRental.setCustomerName("Copy Customer");
        System.out.println("\n--- Copied Rental (customer name updated) ---");
        copiedRental.displayRentalDetails();

        sc.close();
    }
}
