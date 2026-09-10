package version1;

public class BasePlusCommissionEmployee {
    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this.empID=0;
        this.empName="N/A";
        this.totalSale=0;
        this.baseSalary=0;
    }

    public BasePlusCommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale=0;
        this.baseSalary=0;
    }

    public BasePlusCommissionEmployee(int empID, String empName, double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
        this.baseSalary = baseSalary;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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
        System.out.printf("Employee ID: " + empID);
        System.out.println("Employee Name: " + empName);
        System.out.println("Total Sales: " + totalSale);
        System.out.println("Base Salary: " + baseSalary);
    }

    @Override
    public String toString() {
        return "BasePlusCommissionEmployee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", totalSale=" + totalSale +
                ", baseSalary=" + baseSalary +
                ", totalSalary=" + computeSalary() +
                '}';
    }
}
