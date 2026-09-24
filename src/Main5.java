import version5.Employee;
import version5.HourlyEmployee;
import version5.PieceWorkerEmployee;
import version5.CommissionEmployee;
import version5.BasePlusCommissionEmployee;
import version5.Name;
import version5.MyDate;
import version5.EmployeeRoster;

public class Main5 {
    public static void main(String[] args) {
        final int targetMonth = 9;

        EmployeeRoster roster = new EmployeeRoster();

        System.out.println("======================================================================");
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println("======================================================================");

        HourlyEmployee smith = new HourlyEmployee(101, new Name("Alice", "Marie", "Smith"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45, 200);
        PieceWorkerEmployee jones = new PieceWorkerEmployee(201, new Name("Bob", "Cruz", "Jones", "Jr."),
                new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 15);
        CommissionEmployee reyes = new CommissionEmployee(301, new Name("Maria", "Luz", "Reyes"),
                new MyDate(2, 9, 1990), new MyDate(5, 5, 2021), 100000);
        BasePlusCommissionEmployee tan = new BasePlusCommissionEmployee(401, new Name("Kevin", "Santos", "Tan"),
                new MyDate(10, 3, 1988), new MyDate(1, 2, 2020), 120000, 14000);

        enroll(roster, smith, "Hourly");
        enroll(roster, jones, "Piece Worker");
        enroll(roster, reyes, "Commission");
        enroll(roster, tan, "Base Plus Commission");

        System.out.println("Total Roster Size: " + roster.countEmployees() + " employees");

        System.out.println("======================================================================");
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        System.out.println("======================================================================");
        roster.displayPayroll(targetMonth);

        System.out.println("======================================================================");
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println("======================================================================");
        Employee removed = roster.removeEmployee(201);
        if(removed != null){
            System.out.println("Removing Employee ID 201... Successfully removed.");
        }
        else{
            System.out.println("Employee ID 201 not found.");
        }
        System.out.println("Updated Roster Size: " + roster.countEmployees());
        System.out.println("Current Active Employees:");
        roster.displayAllEmployees();
        System.out.println("======================================================================");
    }

    private static void enroll(EmployeeRoster roster, Employee emp, String label){
        boolean added = roster.addEmployee(emp);
        if(added){
            System.out.println("Enrolled: " + emp.getEmpName() + " (" + label + ")");
        }
        else{
            System.out.println("Failed to enroll employee (" + label + ")");
        }
    }
}