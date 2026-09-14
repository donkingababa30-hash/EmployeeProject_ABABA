package version2;

public class HourlyEmployee {
    private int empID;
    private Name empName;
    private MyDate hireDate;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.hireDate = new MyDate();
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.hireDate = new MyDate();
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate hireDate, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.hireDate = hireDate;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
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
        StringBuilder sb = new StringBuilder();
        sb.append("Employee ID: ").append(empID).append("\n");
        sb.append("Employee Name: ").append(empName.getFullName()).append("\n");
        sb.append("Hire Date: ").append(hireDate.getFormattedDate()).append("\n");
        sb.append("Total Hours Worked: ").append(totalHoursWorked).append("\n");
        sb.append("Rate Per Hour: ").append(ratePerHour);
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nHourlyEmployee{");
        sb.append("empID=").append(empID);
        sb.append(", empName=").append(empName.getFullName());
        sb.append(", hireDate=").append(hireDate.getFormattedDate());
        sb.append(", totalHoursWorked=").append(totalHoursWorked);
        sb.append(", ratePerHour=").append(ratePerHour);
        sb.append(", Total Salary=").append(computeSalary());
        sb.append('}');
        return sb.toString();
    }
}