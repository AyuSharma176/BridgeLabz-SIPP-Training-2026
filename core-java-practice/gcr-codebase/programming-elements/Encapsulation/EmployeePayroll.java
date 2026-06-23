
public class EmployeePayroll {
    public static void main(String[] args) {
        FullTimeEmployee emp1=new FullTimeEmployee();
        PartTimeEmployee emp2=new PartTimeEmployee();

        emp1.setEmployeeId("1A");
        emp1.setEmployeeName("Ayush");
        emp1.setMonthlySalary(680000);

        emp2.setEmployeeId("1B");
        emp2.setEmployeeName("Nitin");
        emp2.setHourlyRate(1200);
        emp2.setHoursWorked(8);

        emp1.displayEmployeeInfo();
        emp2.displayEmployeeInfo();
    }
}
