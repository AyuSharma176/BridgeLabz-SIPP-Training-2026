public abstract class Vehicle {
    protected String vehicleName;
    protected String licenseNumber;
    
    public Vehicle(String vehicleName, String licenseNumber) {
        this.vehicleName = vehicleName;
        this.licenseNumber = licenseNumber;
    }
    
    public abstract double fuelCost(double km);
    
    public String getVehicleName() {
        return vehicleName;
    }
    
    public String getLicenseNumber() {
        return licenseNumber;
    }
    
    public void displayInfo() {
        System.out.println("Vehicle: " + vehicleName + " (License: " + licenseNumber + ")");
    }
}
