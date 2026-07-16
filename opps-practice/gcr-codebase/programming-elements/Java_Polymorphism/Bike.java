public class Bike extends Vehicle {
    private double fuelConsumption;
    private double fuelPrice;
    
    public Bike(String vehicleName, String licenseNumber, double fuelConsumption, double fuelPrice) {
        super(vehicleName, licenseNumber);
        this.fuelConsumption = fuelConsumption;
        this.fuelPrice = fuelPrice;
    }
    
    @Override
    public double fuelCost(double km) {
        double litersNeeded = km / fuelConsumption;
        return litersNeeded * fuelPrice;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Type: Bike | Fuel Consumption: " + fuelConsumption + " km/liter");
    }
}
