package version3;

public class CommissionEmployee {
    private int empID;
    private Name empName;
    private MyDate hireDate;
    private double totalSale;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.hireDate = new MyDate();
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.hireDate = new MyDate();
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate hireDate, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.hireDate = hireDate;
        this.totalSale = totalSale;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public MyDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(MyDate hireDate) {
        this.hireDate = hireDate;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public double computeSalary(){
        if(totalSale>50000 && totalSale<100000){
            return 0.10*totalSale;
        }
        else if(totalSale>100000 && totalSale<500000){
            return 0.15*totalSale;
        }
        else if(totalSale>500000){
            return 0.20*totalSale;
        }
        else{
            return 0.05*totalSale;
        }
    }

    public void displayCommissionEmployee(){
        StringBuilder sb = new StringBuilder();
        sb.append("Employee ID: ").append(empID).append("\n");
        sb.append("Employee Name: ").append(empName.getFullName()).append("\n");
        sb.append("Hire Date: ").append(hireDate.getFormattedDate()).append("\n");
        sb.append("Total Sales: ").append(totalSale);
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CommissionEmployee{");
        sb.append("empID=").append(empID);
        sb.append(", empName=").append(empName.getFullName());
        sb.append(", hireDate=").append(hireDate.getFormattedDate());
        sb.append(", totalSale=").append(totalSale);
        sb.append(", Total Salary=").append(computeSalary());
        sb.append('}');
        return sb.toString();
    }
}