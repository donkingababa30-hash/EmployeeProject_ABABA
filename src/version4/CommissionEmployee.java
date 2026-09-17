package version4;

import java.util.Objects;

public class CommissionEmployee extends Employee {
    private double totalSale;

    public CommissionEmployee() {
        super();
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        this.totalSale = totalSale;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = (totalSale >= 0) ? totalSale : 0;
    }

    public double getCommissionRate() {
        if (totalSale >= 500000) {
            return 0.20;
        } else if (totalSale >= 100000) {
            return 0.15;
        } else if (totalSale >= 50000) {
            return 0.10;
        } else {
            return 0.05;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        double basePay = totalSale * getCommissionRate();
        return basePay + super.computeSalary(currentMonth);
    }

    public void displayCommissionEmployee() {
        displayEmployee();
        System.out.printf("Total Sale: ₱%.2f | Commission Rate: %.0f%%%n", totalSale, getCommissionRate() * 100);
    }

    @Override
    public String toString() {
        return String.format(
                "CommissionEmployee[ID: %d, Name: %s, DOB: %s, Hired: %s, Sale: ₱%.2f, Rate: %.0f%%, Total Salary: ₱%.2f]",
                getEmpID(), getEmpName().getFullName(), getBirthDate().getFormattedDate(),
                getDateHired().getFormattedDate(), totalSale, getCommissionRate() * 100, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof CommissionEmployee)) {
            return false;
        }
        CommissionEmployee other = (CommissionEmployee) obj;
        return Double.compare(totalSale, other.totalSale) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalSale);
    }

    @Override
    public CommissionEmployee clone() {
        return (CommissionEmployee) super.clone();
    }
}