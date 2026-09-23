package version4;

import java.util.Objects;

public class CommissionEmployee extends Employee {
    private double totalSale;

    public CommissionEmployee() {
        super();
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        this.totalSale = totalSale;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if(totalSale>=0){
            this.totalSale = totalSale;
        }
    }

    public double getCommissionRate(){
        if(totalSale<50000){
            return 0.05;
        }
        else if(totalSale<100000){
            return 0.10;
        }
        else if(totalSale<500000){
            return 0.15;
        }
        else{
            return 0.20;
        }
    }

    public double computeSalary(int currentMonth){
        double basePay = totalSale*getCommissionRate();
        if(getBirthDate().getMonth()==currentMonth){
            basePay += 5000.00;
        }
        return basePay;
    }

    public double computeSalary(){
        return computeSalary(-1);
    }

    public void displayCommissionEmployee(){
        super.displayEmployee();
        StringBuilder sb = new StringBuilder();
        sb.append("Total Sales: ₱").append(String.format("%,.2f", totalSale)).append(" | ");
        sb.append("Commission Rate: ").append(String.format("%.0f", getCommissionRate()*100)).append("%");
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CommissionEmployee[").append(super.toString());
        sb.append(", Total Sales: ₱").append(String.format("%,.2f", totalSale));
        sb.append(", Total Salary: ₱").append(String.format("%,.2f", computeSalary()));
        sb.append(']');
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj)){
            return false;
        }
        CommissionEmployee other = (CommissionEmployee) obj;
        return totalSale == other.totalSale;
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