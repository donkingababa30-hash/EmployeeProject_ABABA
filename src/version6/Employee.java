package version6;

import java.util.Objects;

public abstract class Employee implements Cloneable {
    private final int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    protected Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        if(empName == null){
            throw new NullPointerException("Employee name cannot be null");
        }
        if(birthDate == null){
            throw new NullPointerException("Birth date cannot be null");
        }
        if(dateHired == null){
            throw new NullPointerException("Date hired cannot be null");
        }
        this.empID = empID;
        this.empName = empName.clone();
        this.birthDate = birthDate.clone();
        this.dateHired = dateHired.clone();
    }

    public final int getEmpID() {
        return empID;
    }

    public Name getEmpName() {
        return this.empName.clone();
    }

    public void setEmpName(Name empName) {
        if(empName == null){
            throw new NullPointerException("Employee name cannot be null");
        }
        this.empName = empName.clone();
    }

    public MyDate getBirthDate() {
        return this.birthDate.clone();
    }

    public void setBirthDate(MyDate birthDate) {
        if(birthDate == null){
            throw new NullPointerException("Birth date cannot be null");
        }
        this.birthDate = birthDate.clone();
    }

    public MyDate getDateHired() {
        return this.dateHired.clone();
    }

    public void setDateHired(MyDate dateHired) {
        if(dateHired == null){
            throw new NullPointerException("Date hired cannot be null");
        }
        this.dateHired = dateHired.clone();
    }

    public final double getBirthdayBonus(int currentMonth){
        if(birthDate.getMonth() == currentMonth){
            return 5000.00;
        }
        return 0.0;
    }

    public abstract double computeSalary(int currentMonth);

    public abstract double computeSalary();

    public abstract void displayEmployee();

    protected final String getIdentityInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(empID).append(" | ");
        sb.append("Name: ").append(empName).append(" | ");
        sb.append("DOB: ").append(birthDate).append(" | ");
        sb.append("Hired: ").append(dateHired);
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