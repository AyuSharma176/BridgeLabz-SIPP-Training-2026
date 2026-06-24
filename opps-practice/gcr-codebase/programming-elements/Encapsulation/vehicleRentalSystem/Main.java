public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.setVehicleNumber("CAR123");
        car.setVehicleType("Car");
        car.setDailyRate(50);
        car.setDailyUse(3);
        car.displayVehicleDetails();
        System.out.println("-----------------------------");
        Bike bike = new Bike();
        bike.setVehicleNumber("BIKE456");
        bike.setVehicleType("Bike");
        bike.setDailyRate(20);
        bike.setDailyUse(2);
        bike.displayVehicleDetails();
        System.out.println("-----------------------------");
        Truck truck = new Truck();
        truck.setVehicleNumber("TRUCK789");
        truck.setVehicleType("Truck");
        truck.setDailyRate(100);
        truck.setLoadingCharge(30);
        truck.setDailyUse(4);
        truck.displayVehicleDetails();
    }
}
