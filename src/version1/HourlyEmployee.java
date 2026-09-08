package version1;

public class HourlyEmployee {
    private int empID;
    private String empName;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID=0;
        this.empName="N/A";
        this.totalHoursWorked=0.0f;
        this.ratePerHour=0.0;
    }

    public HourlyEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked=0.0f;
        this.ratePerHour=0.0;
    }

    public HourlyEmployee(int empID, String empName, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
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

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public double computeSalary(){
        if(totalHoursWorked<=0){
            return 0.0;
        }

        if(totalHoursWorked<=40){
            return totalHoursWorked*ratePerHour;
        }
        else{
            double regularPay=40*ratePerHour;
            double overtime=totalHoursWorked-40;
            double overtimePay=overtime*(ratePerHour*1.5);
            return regularPay+overtimePay;
        }

    }

    public void displayHourlyEmployee(){
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee ID: " + empID);
        System.out.println("Total Hours Worked: " + totalHoursWorked);
        System.out.printf("Rate Per Hour: " + ratePerHour);
    }

    @Override
    public String toString() {
        return "\nHourlyEmployee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", totalHoursWorked=" + totalHoursWorked +
                ", ratePerHour=" + ratePerHour +
                ", Total Salary=" + computeSalary() +
                '}';
    }
}
