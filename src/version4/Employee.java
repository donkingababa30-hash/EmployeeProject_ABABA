package version4;

import java.util.Objects;

public class Employee implements Cloneable {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public Employee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
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

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    public double computeSalary(int currentMonth) {
        double bonus = 0.0;
        if (birthDate != null && birthDate.getMonth() == currentMonth) {
            bonus = 5000.0;
        }
        return bonus;
    }

    public double computeSalary() {
        return computeSalary(-1);
    }

    public void displayEmployee() {
        System.out.println("Employee ID: " + empID);
        System.out.println("Name: " + empName.getFullName());
        System.out.println("Birth Date: " + birthDate.getFormattedDate());
        System.out.println("Hire Date: " + dateHired.getFormattedDate());
    }

    @Override
    public String toString() {
        return String.format("Employee[ID: %d, Name: %s, DOB: %s, Hired: %s]",
                empID, empName.getFullName(), birthDate.getFormattedDate(), dateHired.getFormattedDate());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) obj;
        return empID == other.empID
                && Objects.equals(empName, other.empName)
                && Objects.equals(birthDate, other.birthDate)
                && Objects.equals(dateHired, other.dateHired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, empName, birthDate, dateHired);
    }

    @Override
    public Employee clone() {
        try {
            Employee cloned = (Employee) super.clone();
            cloned.empName = this.empName.clone();
            cloned.birthDate = this.birthDate.clone();
            cloned.dateHired = this.dateHired.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Employee did not implement Cloneable", e);
        }
    }
}