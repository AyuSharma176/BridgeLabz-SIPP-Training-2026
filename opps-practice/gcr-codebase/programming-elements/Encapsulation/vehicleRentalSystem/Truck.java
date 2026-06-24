public class Truck extends Vehicle {
    private int dailyRate;
    private int loadingCharge;
    public int getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(int dailyRate) {
        this.dailyRate = dailyRate;
    }
    public int getLoadingCharge() {
        return loadingCharge;
    }

    public void setLoadingCharge(int loadingCharge) {
        this.loadingCharge = loadingCharge;
    }   
    @Override
    int calculateRentalCost(int dailyUse) {
        return (dailyRate * dailyUse) + loadingCharge;
    }

   
}
