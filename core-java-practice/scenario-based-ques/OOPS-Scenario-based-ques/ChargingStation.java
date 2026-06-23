public class ChargingStation {
    private static int totalStations = 0;
    private static double electricityRate = 8.50; // ₹ per unit

    private String stationId;
    private double unitsConsumed;

    public ChargingStation(String stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    public double calculateBill() {
        double bill = unitsConsumed * electricityRate;
        System.out.println("[" + stationId + "] Units: " + unitsConsumed + " @ ₹" + electricityRate + "/unit = ₹" + bill);
        return bill;
    }

    public void displayStationDetails() {
        System.out.println("Station ID     : " + stationId);
        System.out.println("Units Consumed : " + unitsConsumed);
        System.out.println("Electricity Rate: ₹" + electricityRate + "/unit");
        System.out.println("Total Bill     : ₹" + calculateBill());
        System.out.println("Total Stations : " + totalStations);
        System.out.println("----------------------------");
    }

    public static void setElectricityRate(double rate) {
        electricityRate = rate;
        System.out.println("Electricity rate updated to ₹" + rate + "/unit for all stations.");
    }

    public static int getTotalStations() {
        return totalStations;
    }

    public static void main(String[] args) {
        ChargingStation s1 = new ChargingStation("CS-001", 45.5);
        ChargingStation s2 = new ChargingStation("CS-002", 30.0);
        ChargingStation s3 = new ChargingStation("CS-003", 60.2);
        ChargingStation s4 = new ChargingStation("CS-004", 22.8);
        ChargingStation s5 = new ChargingStation("CS-005", 75.0);

        System.out.println("=== Station Details at ₹8.50/unit ===");
        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        System.out.println("=== Updating Rate to ₹10.00/unit ===");
        ChargingStation.setElectricityRate(10.00);

        System.out.println("\n=== Recalculated Bills ===");
        s1.calculateBill();
        s2.calculateBill();
        s3.calculateBill();
        s4.calculateBill();
        s5.calculateBill();

        System.out.println("\nTotal Stations: " + ChargingStation.getTotalStations());
    }
}
