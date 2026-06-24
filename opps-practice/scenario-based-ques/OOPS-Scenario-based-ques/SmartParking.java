public class SmartParking {

    static class Vehicle {
        String vehicleNumber;
        String ownerName;
        String vehicleType; // "Car" or "Bike"

        public Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
            this.vehicleNumber = vehicleNumber;
            this.ownerName = ownerName;
            this.vehicleType = vehicleType;
        }
    }

    static Vehicle[] vehicles = new Vehicle[10];

    static void displayCars() {
        System.out.println("=== Parked Cars ===");
        boolean found = false;
        for (Vehicle v : vehicles) {
            if (v != null && v.vehicleType.equalsIgnoreCase("Car")) {
                System.out.println("Number: " + v.vehicleNumber + " | Owner: " + v.ownerName);
                found = true;
            }
        }
        if (!found) System.out.println("No cars parked.");
    }

    static void displayBikes() {
        System.out.println("=== Parked Bikes ===");
        boolean found = false;
        for (Vehicle v : vehicles) {
            if (v != null && v.vehicleType.equalsIgnoreCase("Bike")) {
                System.out.println("Number: " + v.vehicleNumber + " | Owner: " + v.ownerName);
                found = true;
            }
        }
        if (!found) System.out.println("No bikes parked.");
    }

    public static void main(String[] args) {
        vehicles[0] = new Vehicle("UP80AB1234", "Ravi Kumar",   "Car");
        vehicles[1] = new Vehicle("DL09CD5678", "Priya Singh",  "Bike");
        vehicles[2] = new Vehicle("MH12EF9012", "Ankit Sharma", "Car");
        vehicles[3] = new Vehicle("KA03GH3456", "Sunita Rao",   "Bike");
        vehicles[4] = new Vehicle("TN22IJ7890", "Deepak Menon", "Car");
        vehicles[5] = new Vehicle("GJ05KL2345", "Neha Joshi",   "Bike");
        vehicles[6] = new Vehicle("RJ14MN6789", "Amit Verma",   "Car");
        vehicles[7] = new Vehicle("WB20OP0123", "Kavya Das",    "Bike");
        vehicles[8] = new Vehicle("PB08QR4567", "Rohit Gupta",  "Car");
        vehicles[9] = new Vehicle("HR26ST8901", "Meera Nair",   "Bike");

        System.out.println("=== Smart Parking Management System ===\n");
        displayCars();
        System.out.println();
        displayBikes();
    }
}
