package version3;

public class HourlyEmployee {
    private int empID;
    private Name empName;
    private MyDate hireDate;
    private MyDate birthDate;
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

    public HourlyEmployee(int empID, Name empName, MyDate hireDate, MyDate birthDate, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.hireDate = hireDate;
        this.birthDate=birthDate;
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

    public MyDate getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(){
        this.birthDate=birthDate;
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

    public double computeSalary(int currentMonth){
        double totalPayroll;
        if(totalHoursWorked<=0){
            totalPayroll=0.0;
        }

        if(totalHoursWorked<=40){
            totalPayroll=totalHoursWorked*ratePerHour;
        }
        else{
            double regularPay=40*ratePerHour;
            double overtime=totalHoursWorked-40;
            double overtimePay=overtime*(ratePerHour*1.5);
            totalPayroll=regularPay+overtimePay;
        }
        if(birthDate.getMonth()==currentMonth){
            return totalPayroll+5000;
        }
        else {
            return totalPayroll;
        }
    }

    public void displayHourlyEmployee(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(empID).append(" | ");
        sb.append("Name: ").append(empName.getFullName()).append(" | ");
        sb.append("DOB: ").append(birthDate.getFormattedDate()).append(" | ");
        sb.append("Hired: ").append(hireDate.getFormattedDate()).append(" | ");
        sb.append("Hours: ").append(totalHoursWorked).append(" | ");
        sb.append("Rate: ₱").append(ratePerHour).append("/hr");
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nHourlyEmployee[");
        sb.append("ID: ").append(empID);
        sb.append(", Name: ").append(empName.getFullName());
        sb.append(", DOB: ").append(birthDate.getFormattedDate());
        sb.append(", Hired: ").append(hireDate.getFormattedDate());
        sb.append(", Hours: ").append(totalHoursWorked);
        sb.append(", Rate: ₱").append(ratePerHour);
        sb.append(", Total Salary: ₱").append(computeSalary());
        sb.append(", Total Salary if birthday: ₱").append(computeSalary(9));
        sb.append(']');
        return sb.toString();
    }
}