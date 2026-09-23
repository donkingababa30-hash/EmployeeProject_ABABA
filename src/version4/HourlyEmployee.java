package version4;

import java.util.Objects;

public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if(totalHoursWorked>=0){
            this.totalHoursWorked = totalHoursWorked;
        }
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if(ratePerHour>=0){
            this.ratePerHour = ratePerHour;
        }
    }

    public double computeSalary(int currentMonth){
        double basePay;
        if(totalHoursWorked<=40){
            basePay = totalHoursWorked*ratePerHour;
        }
        else{
            double regularPay=40*ratePerHour;
            double overtime=totalHoursWorked-40;
            double overtimePay=overtime*(ratePerHour*1.5);
            basePay=regularPay+overtimePay;
        }
        if(getBirthDate().getMonth()==currentMonth){
            basePay += 5000.00;
        }
        return basePay;
    }

    public double computeSalary(){
        return computeSalary(-1);
    }

    public void displayHourlyEmployee(){
        super.displayEmployee();
        StringBuilder sb = new StringBuilder();
        sb.append("Hours Worked: ").append(totalHoursWorked).append(" | ");
        sb.append("Rate Per Hour: ₱").append(String.format("%,.2f", ratePerHour));
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HourlyEmployee[").append(super.toString());
        sb.append(", Hours: ").append(totalHoursWorked);
        sb.append(", Rate: ₱").append(String.format("%,.2f", ratePerHour));
        sb.append(", Total Salary: ₱").append(String.format("%,.2f", computeSalary()));
        sb.append(']');
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj)){
            return false;
        }
        HourlyEmployee other = (HourlyEmployee) obj;
        return totalHoursWorked == other.totalHoursWorked && ratePerHour == other.ratePerHour;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour);
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }
}