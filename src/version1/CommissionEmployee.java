package version1;

public class CommissionEmployee {
    private int empID;
    private String empName;
    private double totalSale;

    public CommissionEmployee() {
        this.empID=0;
        this.empName="N/A";
        this.totalSale=0;
    }

    public CommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale=0;
    }

    public CommissionEmployee(int empID, String empName, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = totalSale;
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
        System.out.printf("Employee ID: " + empID);
        System.out.println("Employee Name: " + empName);
        System.out.println("Total Sales: " + totalSale);
    }

    @Override
    public String toString() {
        return "CommissionEmployee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", totalSale=" + totalSale +
                ", Total Salary=" + computeSalary() +
                '}';
    }
}
