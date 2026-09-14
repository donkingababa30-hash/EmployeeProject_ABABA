package version2;

public class BasePlusCommissionEmployee {
    private int empID;
    private Name empName;
    private MyDate hireDate;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.hireDate = new MyDate();
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.hireDate = new MyDate();
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate hireDate, double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.hireDate = hireDate;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
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

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double computeSalary(){
        if(totalSale>50000 && totalSale<100000){
            return baseSalary+ (0.10*totalSale);
        }
        else if(totalSale>100000 && totalSale<500000){
            return baseSalary + (0.15*totalSale);
        }
        else if(totalSale>500000){
            return baseSalary+ (0.20*totalSale);
        }
        else{
            return baseSalary + (0.05*totalSale);
        }
    }

    public void displayBasePlusCommissionEmployee(){
        StringBuilder sb = new StringBuilder();
        sb.append("Employee ID: ").append(empID).append("\n");
        sb.append("Employee Name: ").append(empName.getFullName()).append("\n");
        sb.append("Hire Date: ").append(hireDate.getFormattedDate()).append("\n");
        sb.append("Total Sales: ").append(totalSale).append("\n");
        sb.append("Base Salary: ").append(baseSalary);
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BasePlusCommissionEmployee{");
        sb.append("empID=").append(empID);
        sb.append(", empName=").append(empName.getFullName());
        sb.append(", hireDate=").append(hireDate.getFormattedDate());
        sb.append(", totalSale=").append(totalSale);
        sb.append(", baseSalary=").append(baseSalary);
        sb.append(", totalSalary=").append(computeSalary());
        sb.append('}');
        return sb.toString();
    }
}