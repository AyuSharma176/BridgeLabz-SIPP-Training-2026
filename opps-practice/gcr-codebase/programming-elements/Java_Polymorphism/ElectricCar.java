public class ElectricCar extends Vehicle {
    private double batteryCapacity;
    private double electricityPrice;
    private double energyConsumption;
    
    public ElectricCar(String vehicleName, String licenseNumber, double batteryCapacity, 
                      double electricityPrice, double energyConsumption) {
        super(vehicleName, licenseNumber);
        this.batteryCapacity = batteryCapacity;
        this.electricityPrice = electricityPrice;
        this.energyConsumption = energyConsumption;
    }
    
    @Override
    public double fuelCost(double km) {
        double energyNeeded = km * energyConsumption;
        return energyNeeded * electricityPrice;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  Type: Electric Car | Battery: " + batteryCapacity + " kWh | Range: " + (batteryCapacity / energyConsumption) + " km");
    }
}
