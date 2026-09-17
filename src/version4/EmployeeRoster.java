package version4;

public class EmployeeRoster {
    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this(10);
    }

    public EmployeeRoster(int max) {
        this.max = max;
        this.empList=new Employee[this.max];
        this.count=0;
    }

    boolean addEmployee(Employee emp){
        if(count<max){
            empList[count]=emp;
            count++;
            return true;
        }
        return false;
    }

    Employee removeEmployee(int empID){
        for(int i=0;i<count;i++){
            if(empList[i].getEmpID() == empID){
                Employee removed = empList[i];
                for(int j=i;j<count-1;j++){
                    empList[j]=empList[j+1];
                }
                empList[count-1]=null;
                count--;
                return removed;
            }
        }
        return null;
    }

    Employee searchEmployee(int empID){
        for(int i=0;i<count;i++){
            if(empList[i].getEmpID() == empID){
                return empList[i];
            }
        }
        return null;
    }

    int countHE(){
        int HourlyEmployees=0;
        for(int i=0;i<count;i++){
            if(empList[i] instanceof HourlyEmployee){
                HourlyEmployees++;
            }
        }
        return HourlyEmployees;
    }

    int countPWE(){
        int pwEmployees=0;
        for(int i=0;i<count;i++){
            if(empList[i] instanceof PieceWorkerEmployee){
                pwEmployees++;
            }
        }
        return pwEmployees;
    }

    int countCE(){
        int ComissionEmployees=0;
        for(int i=0;i<count;i++){
            if(empList[i] instanceof CommissionEmployee && !(empList[i] instanceof BasePlusCommissionEmployee)){
                ComissionEmployees++;
            }
        }
        return ComissionEmployees;
    }

    int countBPCE(){
        int bpEmployees=0;
        for(int i=0;i<count;i++){
            if(empList[i] instanceof BasePlusCommissionEmployee){
                bpEmployees++;
            }
        }
        return bpEmployees;
    }

    void displayHE(){
        for(int i=0;i<count;i++){
            if(empList[i] instanceof HourlyEmployee){
                HourlyEmployee he=(HourlyEmployee) empList[i];
                he.displayHourlyEmployee();
            }
        }
    }

    void displayPWE(){
        for(int i=0;i<count;i++){
            if(empList[i] instanceof PieceWorkerEmployee){
                PieceWorkerEmployee pwe=(PieceWorkerEmployee) empList[i];
                pwe.displayPieceWorkerEmployee();
            }
        }
    }

    void displayCE(){
        for(int i=0;i<count;i++){
            if(empList[i] instanceof CommissionEmployee){
                CommissionEmployee ce=(CommissionEmployee) empList[i];
                ce.displayCommissionEmployee();
            }
        }
    }

    void displayBPCE(){
        for(int i=0;i<count;i++){
            if(empList[i] instanceof BasePlusCommissionEmployee){
                BasePlusCommissionEmployee bpce=(BasePlusCommissionEmployee) empList[i];
                bpce.displayBasePlusCommissionEmployee();
            }
        }
    }

    void displayAllEmployees(){
        for(int i=0;i<count-1;i++){
            StringBuilder sb = new StringBuilder();
            sb.append("ID: ").append(empList[i].getEmpID()).append(" | ");
            sb.append("Name: ").append(empList[i].getEmpName()).append(" | ");
            sb.append("Type: ").append(empList[i].getClass()).append(" | ");
            System.out.println(sb.toString());
        }
    }
    void displayPayroll(int currentMonth){

    }

}
