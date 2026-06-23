public class FullTimeEmployee extends Employee{
    private int monthlySalary;

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    long calculateSalary() {
        return monthlySalary* 12L;
    }
}
