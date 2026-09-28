package version6;

import java.util.Objects;

public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public final void setTotalHoursWorked(float totalHoursWorked) {
        if(!(totalHoursWorked >= 0)){
            throw new IllegalArgumentException("Total hours worked cannot be negative.");
        }
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public final void setRatePerHour(double ratePerHour) {
        if(!(ratePerHour >= 0)){
            throw new IllegalArgumentException("Rate per hour cannot be negative.");
        }
        this.ratePerHour = ratePerHour;
    }

    @Override
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
        return basePay + getBirthdayBonus(currentMonth);
    }

    @Override
    public double computeSalary(){
        return computeSalary(-1);
    }

    @Override
    public void displayEmployee(){
        System.out.println(getIdentityInfo());
        StringBuilder sb = new StringBuilder();
        sb.append("Hours Worked: ").append(totalHoursWorked).append(" | ");
        sb.append("Rate Per Hour: ₱").append(String.format("%,.2f", ratePerHour));
        System.out.println(sb.toString());
    }

    public void displayHourlyEmployee(){
        displayEmployee();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HourlyEmployee [ID: ").append(getEmpID());
        sb.append(", Name: ").append(getEmpName());
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