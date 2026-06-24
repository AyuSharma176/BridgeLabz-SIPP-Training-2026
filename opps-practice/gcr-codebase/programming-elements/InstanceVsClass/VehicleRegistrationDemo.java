// Instance vs. Class Variables and Methods - Problem 3: Vehicle Registration
import java.util.Scanner;

class Vehicle {
    // Instance variables (unique to each vehicle)
    private String ownerName;
    private String vehicleType;

    // Class variable - fixed registration fee for ALL vehicles
    private static double registrationFee = 2500.0;

    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName   = ownerName;
        this.vehicleType = vehicleType;
    }

    // Getters and Setters
    public String getOwnerName()         { return ownerName; }
    public String getVehicleType()       { return vehicleType; }
    public void setOwnerName(String n)   { this.ownerName = n; }
    public void setVehicleType(String v) { this.vehicleType = v; }

    // Instance method - displays owner and vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name       : " + ownerName);
        System.out.println("Vehicle Type     : " + vehicleType);
        System.out.printf("Registration Fee : Rs. %.2f%n", registrationFee);
    }

    // Class (static) method - updates registration fee for ALL vehicles
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.printf("Registration fee updated to: Rs. %.2f (applies to all vehicles)%n", registrationFee);
    }

    // Getter for registration fee
    public static double getRegistrationFee() {
        return registrationFee;
    }
}

class VehicleRegistrationDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many vehicles do you want to register? ");
        int count = sc.nextInt();
        sc.nextLine();

        Vehicle[] vehicles = new Vehicle[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Vehicle " + (i + 1) + ":");
            System.out.print("Owner Name   : ");
            String owner = sc.nextLine();
            System.out.print("Vehicle Type (Car / Bike / Truck): ");
            String type = sc.nextLine();
            vehicles[i] = new Vehicle(owner, type);
        }

        System.out.println("\n--- All Vehicle Details (Instance Method) ---");
        for (Vehicle v : vehicles) {
            v.displayVehicleDetails();
            System.out.println();
        }

        // Update registration fee using class method
        System.out.print("Enter new registration fee: Rs. ");
        double newFee = sc.nextDouble();
        Vehicle.updateRegistrationFee(newFee);

        System.out.println("\n--- Vehicle Details After Fee Update ---");
        for (Vehicle v : vehicles) {
            v.displayVehicleDetails();
            System.out.println();
        }

        sc.close();
    }
}
