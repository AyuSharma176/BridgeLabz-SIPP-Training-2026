public class Drone {
    private String droneId;
    private int batteryPercentage;
    private static String companyName = "SkyLogistics";

    public Drone(String droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    public void startDelivery() {
        if (batteryPercentage < 20) {
            System.out.println("[" + droneId + "] Cannot start delivery. Low battery: " + batteryPercentage + "%");
        } else {
            batteryPercentage -= 15;
            System.out.println("[" + droneId + "] Delivery started by " + companyName + ". Battery now: " + batteryPercentage + "%");
        }
    }

    public void displayStatus() {
        System.out.println("Drone ID   : " + droneId);
        System.out.println("Company    : " + companyName);
        System.out.println("Battery    : " + batteryPercentage + "%");
        System.out.println("------------------------");
    }

    public static void setCompanyName(String name) {
        companyName = name;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public static void main(String[] args) {
        Drone d1 = new Drone("DR-101", 85);
        Drone d2 = new Drone("DR-102", 15);
        Drone d3 = new Drone("DR-103", 60);

        System.out.println("=== Initial Status ===");
        d1.displayStatus();
        d2.displayStatus();
        d3.displayStatus();

        System.out.println("=== Starting Deliveries ===");
        d1.startDelivery();
        d2.startDelivery(); // low battery
        d3.startDelivery();

        System.out.println("\n=== Verifying Shared Company Name ===");
        System.out.println("d1 company: " + Drone.getCompanyName());
        System.out.println("d2 company: " + Drone.getCompanyName());
        System.out.println("d3 company: " + Drone.getCompanyName());

        System.out.println("\nChanging company name to 'AeroShip'...");
        Drone.setCompanyName("AeroShip");

        System.out.println("d1 company: " + Drone.getCompanyName());
        System.out.println("d2 company: " + Drone.getCompanyName());
        System.out.println("d3 company: " + Drone.getCompanyName());
    }
}
