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

    public void displayEmployee(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(empID).append(" | ");
        sb.append("Name: ").append(empName).append(" | ");
        sb.append("DOB: ").append(birthDate).append(" | ");
        sb.append("Hired: ").append(dateHired);
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(empID);
        sb.append(", Name: ").append(empName);
        sb.append(", DOB: ").append(birthDate);
        sb.append(", Hired: ").append(dateHired);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Employee other = (Employee) obj;
        return empID == other.empID &&
                empName.equals(other.empName) &&
                birthDate.equals(other.birthDate) &&
                dateHired.equals(other.dateHired);
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
            throw new AssertionError(e);
        }
    }
}