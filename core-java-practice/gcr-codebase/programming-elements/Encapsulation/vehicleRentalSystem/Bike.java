public class Bike extends Vehicle {
    private int dailyRate;

    public int getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    int calculateRentalCost(int dailyUse) {
        return dailyRate * dailyUse;
    }   
}
