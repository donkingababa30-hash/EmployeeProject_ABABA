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

    public boolean addEmployee(Employee emp){
        if(count<max){
            empList[count]=emp;
            count++;
            return true;
        }
        return false;
    }

    public Employee removeEmployee(int empID){
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

    public Employee searchEmployee(int empID){
        for(int i=0;i<count;i++){
            if(empList[i].getEmpID() == empID){
                return empList[i];
            }
        }
        return null;
    }

    public int countHE(){
        int HourlyEmployees=0;
        for(int i=0;i<count;i++){
            if(empList[i] instanceof HourlyEmployee){
                HourlyEmployees++;
            }
        }
        return HourlyEmployees;
    }

    public int countPWE(){
        int pwEmployees=0;
        for(int i=0;i<count;i++){
            if(empList[i] instanceof PieceWorkerEmployee){
                pwEmployees++;
            }
        }
        return pwEmployees;
    }

    public int countCE(){
        int ComissionEmployees=0;
        for(int i=0;i<count;i++){
            if(empList[i] instanceof CommissionEmployee && !(empList[i] instanceof BasePlusCommissionEmployee)){
                ComissionEmployees++;
            }
        }
        return ComissionEmployees;
    }

    public int countBPCE(){
        int bpEmployees=0;
        for(int i=0;i<count;i++){
            if(empList[i] instanceof BasePlusCommissionEmployee){
                bpEmployees++;
            }
        }
        return bpEmployees;
    }

    public void displayHE(){
        for(int i=0;i<count;i++){
            if(empList[i] instanceof HourlyEmployee){
                HourlyEmployee he=(HourlyEmployee) empList[i];
                he.displayHourlyEmployee();
            }
        }
    }

    public void displayPWE(){
        for(int i=0;i<count;i++){
            if(empList[i] instanceof PieceWorkerEmployee){
                PieceWorkerEmployee pwe=(PieceWorkerEmployee) empList[i];
                pwe.displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE(){
        for(int i=0;i<count;i++){
            if(empList[i] instanceof CommissionEmployee && !(empList[i] instanceof BasePlusCommissionEmployee)){
                CommissionEmployee ce=(CommissionEmployee) empList[i];
                ce.displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE(){
        for(int i=0;i<count;i++){
            if(empList[i] instanceof BasePlusCommissionEmployee){
                BasePlusCommissionEmployee bpce=(BasePlusCommissionEmployee) empList[i];
                bpce.displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees(){
        for(int i=0;i<count;i++){
            StringBuilder sb = new StringBuilder();
            sb.append("ID: ").append(empList[i].getEmpID()).append(" | ");
            sb.append("Name: ").append(empList[i].getEmpName()).append(" | ");
            sb.append("Type: ").append(empList[i].getClass()).append(" | ");
            System.out.println(sb.toString());
        }
    }

    public int getCount() {
        return count;
    }

    public int getMax() {
        return max;
    }

    public void displayPayroll(int currentMonth){
        for(int i=0; i<count; i++){
            Employee emp = empList[i];
            StringBuilder sb = new StringBuilder();

            if(emp instanceof HourlyEmployee){
                HourlyEmployee he = (HourlyEmployee) emp;
                double salary = he.computeSalary(currentMonth);
                boolean bonus = he.getBirthDate().getMonth() == currentMonth;
                sb.append("[Hourly] ID: ").append(he.getEmpID());
                sb.append(" | Name: ").append(he.getEmpName());
                sb.append(" | Salary: ₱").append(String.format("%,.2f", salary));
                if(bonus){
                    sb.append(" (Birthday Bonus Applied)");
                }
            }
            else if(emp instanceof BasePlusCommissionEmployee){
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) emp;
                double salary = bpce.computeSalary(currentMonth);
                boolean bonus = bpce.getBirthDate().getMonth() == currentMonth;
                sb.append("[Base Plus Commission] ID: ").append(bpce.getEmpID());
                sb.append(" | Name: ").append(bpce.getEmpName());
                sb.append(" | Salary: ₱").append(String.format("%,.2f", salary));
                if(bonus){
                    sb.append(" (Birthday Bonus Applied)");
                }
            }
            else if(emp instanceof CommissionEmployee){
                CommissionEmployee ce = (CommissionEmployee) emp;
                double salary = ce.computeSalary(currentMonth);
                boolean bonus = ce.getBirthDate().getMonth() == currentMonth;
                sb.append("[Commission] ID: ").append(ce.getEmpID());
                sb.append(" | Name: ").append(ce.getEmpName());
                sb.append(" | Salary: ₱").append(String.format("%,.2f", salary));
                if(bonus){
                    sb.append(" (Birthday Bonus Applied)");
                }
            }
            else if(emp instanceof PieceWorkerEmployee){
                PieceWorkerEmployee pwe = (PieceWorkerEmployee) emp;
                double salary = pwe.computeSalary(currentMonth);
                boolean bonus = pwe.getBirthDate().getMonth() == currentMonth;
                sb.append("[Piece Worker] ID: ").append(pwe.getEmpID());
                sb.append(" | Name: ").append(pwe.getEmpName());
                sb.append(" | Salary: ₱").append(String.format("%,.2f", salary));
                if(bonus){
                    sb.append(" (Birthday Bonus Applied)");
                }
            }
            System.out.println(sb.toString());
        }
    }
}

