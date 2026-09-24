package version5;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if(baseSalary>=0){
            this.baseSalary = baseSalary;
        }
    }

    @Override
    public double computeSalary(int currentMonth){
        return baseSalary + super.computeSalary(currentMonth);
    }

    public void displayBasePlusCommissionEmployee(){
        super.displayCommissionEmployee();
        StringBuilder sb = new StringBuilder();
        sb.append("Base Salary: ₱").append(String.format("%,.2f", baseSalary));
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BasePlusCommissionEmployee [ID: ").append(getEmpID());
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
        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return baseSalary == other.baseSalary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}