public class TransportFleetDemo {
    public static void main(String[] args) {
        System.out.println("========== TRANSPORT FLEET MANAGEMENT ==========\n");
        
        Vehicle[] fleet = {
            new Car("Sedan-001", "MH-01-AB-1234", 12.0, 90),
            new Bus("Bus-Express-01", "MH-02-BC-5678", 5.0, 85),
            new Bike("Hero-Bike-001", "MH-03-CD-9012", 50.0, 88),
            new Car("SUV-002", "MH-04-DE-3456", 8.0, 95),
            new Bus("Bus-Local-02", "MH-05-EF-7890", 6.0, 85),
            new ElectricCar("Tesla-Model-3", "MH-06-FG-2345", 75.0, 8.0, 0.18)
        };
        
        System.out.println("Fleet Inventory:");
        for (Vehicle vehicle : fleet) {
            vehicle.displayInfo();
        }
        
        System.out.println("\n========== FUEL COST CALCULATION (500 km) ==========\n");
        
        double totalCost = 0;
        int carCount = 0;
        int busCount = 0;
        int bikeCount = 0;
        int electricCarCount = 0;
        
        for (Vehicle vehicle : fleet) {
            double cost = vehicle.fuelCost(500);
            totalCost += cost;
            
            String type = "Unknown";
            if (vehicle instanceof ElectricCar) {
                type = "Electric Car";
                electricCarCount++;
            } else if (vehicle instanceof Car) {
                type = "Car";
                carCount++;
            } else if (vehicle instanceof Bus) {
                type = "Bus";
                busCount++;
            } else if (vehicle instanceof Bike) {
                type = "Bike";
                bikeCount++;
            }
            
            System.out.printf("%s (%s): ₹%.2f%n", vehicle.getVehicleName(), type, cost);
        }
        
        System.out.println("\n========== SUMMARY ==========");
        System.out.printf("Total Fuel Cost for Fleet (500 km): ₹%.2f%n", totalCost);
        System.out.println("Vehicle Types:");
        System.out.println("  • Cars: " + carCount);
        System.out.println("  • Buses: " + busCount);
        System.out.println("  • Bikes: " + bikeCount);
        System.out.println("  • Electric Cars: " + electricCarCount);
        
        System.out.println("\n========== OPEN/CLOSED PRINCIPLE DEMO ==========");
        System.out.println("✓ Added ElectricCar without modifying:");
        System.out.println("  - Vehicle base class");
        System.out.println("  - Car, Bus, or Bike classes");
        System.out.println("  - Existing fleet management code");
        System.out.println("✓ New ElectricCar type is seamlessly integrated!");
    }
}
