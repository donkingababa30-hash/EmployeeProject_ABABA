package version5;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRoster {
    private List<Employee> empList;

    public EmployeeRoster() {
        this.empList = new ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {
        this.empList = new ArrayList<>(initialCapacity);
    }

    public boolean addEmployee(Employee emp){
        if(emp == null){
            return false;
        }
        empList.add(emp);
        return true;
    }

    public Employee removeEmployee(int empID){
        int indexFound = -1;
        for(int i=0; i<empList.size(); i++){
            if(empList.get(i).getEmpID() == empID){
                indexFound = i;
                break;
            }
        }
        if(indexFound == -1){
            return null;
        }
        return empList.remove(indexFound);
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
            boolean bonus = emp.getBirthDate().getMonth() == currentMonth;
            System.out.printf("ID: %d | Name: %s | Payout: ₱%,.2f%s%n",
                    emp.getEmpID(), emp.getEmpName(), salary,
                    bonus ? " (Birthday Bonus Applied)" : "");
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