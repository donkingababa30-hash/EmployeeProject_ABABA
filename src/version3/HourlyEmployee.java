package version3;

import java.util.Objects;

public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                          float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = (totalHoursWorked >= 0) ? totalHoursWorked : 0;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = (ratePerHour >= 0) ? ratePerHour : 0;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double basePay;
        if (totalHoursWorked <= 40) {
            basePay = totalHoursWorked * ratePerHour;
        } else {
            double regularPay = 40 * ratePerHour;
            double overtimeHours = totalHoursWorked - 40;
            double overtimePay = overtimeHours * (ratePerHour * 1.5);
            basePay = regularPay + overtimePay;
        }
        return basePay + super.computeSalary(currentMonth);
    }

    public void displayHourlyEmployee() {
        displayEmployee();
        System.out.printf("Hours Worked: %.2f | Rate/Hour: ₱%.2f%n", totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format(
                "HourlyEmployee[ID: %d, Name: %s, DOB: %s, Hired: %s, Hours: %.2f, Rate: ₱%.2f, Total Salary: ₱%.2f]",
                getEmpID(), getEmpName().getFullName(), getBirthDate().getFormattedDate(),
                getDateHired().getFormattedDate(), totalHoursWorked, ratePerHour, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof HourlyEmployee)) {
            return false;
        }
        HourlyEmployee other = (HourlyEmployee) obj;
        return Float.compare(totalHoursWorked, other.totalHoursWorked) == 0
                && Double.compare(ratePerHour, other.ratePerHour) == 0;
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