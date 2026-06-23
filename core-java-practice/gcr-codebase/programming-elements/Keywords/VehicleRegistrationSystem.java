// Program 6: Vehicle Registration System
// Demonstrates: static, this, final, instanceof
import java.util.Scanner;

class Vehicle {

    // STATIC: registration fee is common for all vehicles
    private static double registrationFee = 2500.0;

    // FINAL: registrationNumber uniquely identifies each vehicle and cannot change
    private final String registrationNumber;

    // Instance variables
    private String ownerName;
    private String vehicleType;

    // Constructor - uses THIS to resolve ambiguity
    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;  // 'this' resolves ambiguity
        this.ownerName          = ownerName;
        this.vehicleType        = vehicleType;
    }

    // Getters
    public String getRegistrationNumber() { return registrationNumber; }
    public String getOwnerName()          { return ownerName; }
    public String getVehicleType()        { return vehicleType; }

    // Setters (registrationNumber is final — no setter for it)
    public void setOwnerName(String name)       { this.ownerName = name; }
    public void setVehicleType(String type)     { this.vehicleType = type; }

    // STATIC methods: update and display shared registration fee
    public static void updateRegistrationFee(double newFee) {
        if (newFee > 0) {
            registrationFee = newFee;
            System.out.printf("Registration fee updated to Rs. %.2f for all vehicles.%n", registrationFee);
        } else {
            System.out.println("Fee must be a positive value!");
        }
    }

    public static double getRegistrationFee() { return registrationFee; }

    // Display vehicle registration details
    public void displayVehicleDetails() {
        System.out.println("Registration No  : " + registrationNumber);  // final — cannot change
        System.out.println("Owner Name       : " + ownerName);
        System.out.println("Vehicle Type     : " + vehicleType);
        System.out.printf("Registration Fee : Rs. %.2f%n", registrationFee);
    }
}

class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many vehicles to register? ");
        int count = sc.nextInt();
        sc.nextLine();

        Vehicle[] vehicles = new Vehicle[count];

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Vehicle " + (i + 1) + ":");
            System.out.print("Registration No (e.g. UP80AB1234): ");
            String regNo = sc.nextLine();
            System.out.print("Owner Name                        : ");
            String owner = sc.nextLine();
            System.out.print("Vehicle Type (Car/Bike/Truck)     : ");
            String type = sc.nextLine();
            vehicles[i] = new Vehicle(regNo, owner, type);
        }

        // STATIC method call — display current fee
        System.out.printf("%nCurrent Registration Fee (Static): Rs. %.2f%n",
                Vehicle.getRegistrationFee());

        // INSTANCEOF check before displaying registration details
        System.out.println("\n--- Vehicle Registration Details (instanceof check) ---");
        Object[] objects = vehicles;
        for (Object obj : objects) {
            if (obj instanceof Vehicle) {           // INSTANCEOF verification
                Vehicle v = (Vehicle) obj;
                v.displayVehicleDetails();
                System.out.println();
            }
        }

        // Update registration fee using STATIC method — affects all vehicles
        System.out.print("Enter new registration fee (Rs.): ");
        double newFee = sc.nextDouble();
        Vehicle.updateRegistrationFee(newFee);

        System.out.println("\n--- Vehicle Details After Fee Update ---");
        for (Object obj : objects) {
            if (obj instanceof Vehicle) {
                ((Vehicle) obj).displayVehicleDetails();
                System.out.println();
            }
        }

        System.out.println("Note: 'registrationNumber' is declared 'final' — it cannot be changed after creation.");

        sc.close();
    }
}
