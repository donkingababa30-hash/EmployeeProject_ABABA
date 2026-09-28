package version6;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRoster {
    private List<Employee> empList;

    public EmployeeRoster() {
        this.empList = new ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {
        if(initialCapacity < 0){
            throw new IllegalArgumentException("Initial capacity cannot be negative.");
        }
        this.empList = new ArrayList<>(initialCapacity);
    }

    public boolean addEmployee(Employee emp){
        if(emp == null){
            throw new NullPointerException("Employee cannot be null");
        }
        empList.add(emp);
        return true;
    }

    public Employee removeEmployee(int empID){
        for(int i=0; i<empList.size(); i++){
            if(empList.get(i).getEmpID() == empID){
                return empList.remove(i);
            }
        }
        return null;
    }

    public Employee searchEmployee(int empID){
        for(Employee emp : empList){
            if(emp.getEmpID() == empID){
                return emp;
            }
        }
        return null;
    }

    public int countEmployees(){
        return empList.size();
    }

    public int countHE(){
        int total = 0;
        for(Employee emp : empList){
            if(emp instanceof HourlyEmployee){
                total++;
            }
        }
        return total;
    }

    public int countPWE(){
        int total = 0;
        for(Employee emp : empList){
            if(emp instanceof PieceWorkerEmployee){
                total++;
            }
        }
        return total;
    }

    public int countCE(){
        int total = 0;
        for(Employee emp : empList){
            if(emp.getClass() == CommissionEmployee.class){
                total++;
            }
        }
        return total;
    }

    public int countBPCE(){
        int total = 0;
        for(Employee emp : empList){
            if(emp instanceof BasePlusCommissionEmployee){
                total++;
            }
        }
        return total;
    }

    public void displayPayroll(int currentMonth){
        for(Employee emp : empList){
            double salary = emp.computeSalary(currentMonth);
            boolean bonus = emp.getBirthdayBonus(currentMonth) > 0;
            System.out.printf("ID: %d | Name: %s | Payout: ₱%,.2f%s%n",
                    emp.getEmpID(), emp.getEmpName(), salary,
                    bonus ? " (Bonus Applied)" : "");
        }
    }

    public void displayAllEmployees(){
        int index = 1;
        for(Employee emp : empList){
            System.out.println(index + ". " + emp);
            index++;
        }
    }
}