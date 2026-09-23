import version4.Employee;
import version4.HourlyEmployee;
import version4.PieceWorkerEmployee;
import version4.CommissionEmployee;
import version4.BasePlusCommissionEmployee;
import version4.Name;
import version4.MyDate;
import version4.EmployeeRoster;

public class Main4 {
    public static void main(String[] args) {
        final int targetMonth = 9;

        EmployeeRoster roster = new EmployeeRoster(6);

        System.out.println("======================================================================");
        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        System.out.println("======================================================================");

        HourlyEmployee smith = new HourlyEmployee(101, new Name("Alice", "Marie", "Smith"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45, 200);
        PieceWorkerEmployee jones = new PieceWorkerEmployee(201, new Name("Bob", "Cruz", "Jones", "Jr."),
                new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 15);
        CommissionEmployee reyes = new CommissionEmployee(301, new Name("Maria", "Luz", "Reyes"),
                new MyDate(2, 9, 1990), new MyDate(5, 5, 2021), 100000);
        BasePlusCommissionEmployee tan = new BasePlusCommissionEmployee(401, new Name("Kevin", "Santos", "Tan"),
                new MyDate(10, 3, 1988), new MyDate(1, 2, 2020), 120000, 14000);
        HourlyEmployee white = new HourlyEmployee(102, new Name("David", "Allan", "White"),
                new MyDate(22, 7, 1995), new MyDate(10, 8, 2023), 40, 200);
        PieceWorkerEmployee delaCruz = new PieceWorkerEmployee(501, new Name("Mark", "Jay", "Dela Cruz"),
                new MyDate(14, 11, 1993), new MyDate(3, 3, 2022), 80, 20);

        printAddResult(roster, smith, "Hourly");
        printAddResult(roster, jones, "Piece Worker");
        printAddResult(roster, reyes, "Commission");
        printAddResult(roster, tan, "Base Plus Commission");
        printAddResult(roster, white, "Hourly");
        printAddResult(roster, delaCruz, "Piece Worker");

        CommissionEmployee overflow = new CommissionEmployee(601, new Name("Extra", "Overflow"),
                new MyDate(), new MyDate(), 10000);
        System.out.println();
        System.out.println("--- CAPACITY BOUNDARY CHECK ---");
        boolean overflowResult = roster.addEmployee(overflow);
        System.out.println("Attempting to add ID 601 (Overflow, Extra) to a full roster -> " +
                (overflowResult ? "Success" : "Failed (Roster is full)"));

        System.out.println();
        System.out.println("--- ROSTER COMPOSITION COUNTS ---");
        System.out.println("Total Employees: " + roster.getCount() + " / " + roster.getMax());
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());

        System.out.println();
        System.out.println("--- CATEGORICAL DISPLAY: HOURLY EMPLOYEES ---");
        roster.displayHE();
        System.out.println();
        System.out.println("--- CATEGORICAL DISPLAY: PIECE WORKER EMPLOYEES ---");
        roster.displayPWE();
        System.out.println();
        System.out.println("--- CATEGORICAL DISPLAY: COMMISSION EMPLOYEES (PURE) ---");
        roster.displayCE();
        System.out.println();
        System.out.println("--- CATEGORICAL DISPLAY: BASE PLUS COMMISSION EMPLOYEES ---");
        roster.displayBPCE();

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("ROSTER PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");
        roster.displayPayroll(targetMonth);

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        System.out.println("======================================================================");
        Employee removedEmp = roster.removeEmployee(201);
        if(removedEmp != null){
            System.out.println("Removing Employee ID 201 (" + removedEmp.getEmpName() + ")... Successfully removed.");
        }
        else{
            System.out.println("Employee ID 201 not found.");
        }
        System.out.println("Current Employee Count: " + roster.getCount());
        System.out.println("Remaining Employees in Roster:");
        roster.displayAllEmployees();
        System.out.println("======================================================================");
    }

    private static void printAddResult(EmployeeRoster roster, Employee emp, String label){
        boolean added = roster.addEmployee(emp);
        System.out.println("Added: " + emp.getEmpName() + " (" + label + ") -> " +
                (added ? "Success" : "Failed"));
    }
}