abstract class Vehicle{
    private String vehicleNumber;
    private String vehicleType;
    private int dailyUse;
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public String getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
   public int getDailyUse() {
        return dailyUse;
    }
    public void setDailyUse(int dailyUse) {
        this.dailyUse = dailyUse;
    }
    abstract int calculateRentalCost(int dailyUse);
    
    public void displayVehicleDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Rental Cost: " + calculateRentalCost(getDailyUse()) + " per day");
    }
    
}