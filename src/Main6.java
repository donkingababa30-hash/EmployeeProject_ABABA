import version6.Employee;
import version6.HourlyEmployee;
import version6.PieceWorkerEmployee;
import version6.CommissionEmployee;
import version6.BasePlusCommissionEmployee;
import version6.Name;
import version6.MyDate;
import version6.EmployeeRoster;

public class Main6 {
    public static void main(String[] args) {
        final int targetMonth = 9;

        System.out.println("======================================================================");
        System.out.println("1. TESTING ENCAPSULATION & DEFENSIVE COPYING");
        System.out.println("======================================================================");
        MyDate birth = new MyDate(15, 12, 1995);
        HourlyEmployee testEmp = new HourlyEmployee(105, new Name("Carla", "Ann", "Diaz"),
                birth, new MyDate(1, 3, 2022), 40, 150);

        System.out.println("Original Birth Month: " + birth.getMonth() + " (" + birth.getMonthName() + ")");
        System.out.println("Attempting external tampering: emp.getBirthDate().setMonth(9)...");
        testEmp.getBirthDate().setMonth(9);
        birth.setMonth(9);
        System.out.println("Employee's Actual Birth Date after tampering attempt: " + testEmp.getBirthDate());
        if(testEmp.getBirthDate().getMonth() == 12){
            System.out.println("Result: SUCCESS (Internal state protected via defensive copying)");
        }
        else{
            System.out.println("Result: FAILED (Internal state was modified)");
        }

        System.out.println("======================================================================");
        System.out.println("2. TESTING EXCEPTION HANDLING & INPUT VALIDATION");
        System.out.println("======================================================================");
        try{
            System.out.println("Attempting to create HourlyEmployee with rate: -150.00...");
            new HourlyEmployee(106, new Name("Dan", "Cruz"), new MyDate(3, 4, 1990),
                    new MyDate(1, 1, 2021), 40, -150.00);
        } catch(IllegalArgumentException e){
            System.out.println("Caught Expected Exception: [" + e.getClass().getSimpleName() + "] " + e.getMessage());
        }

        try{
            System.out.println("Attempting to assign invalid calendar date: 31 Feb 2026...");
            new MyDate(31, 2, 2026);
        } catch(IllegalArgumentException e){
            System.out.println("Caught Expected Exception: [" + e.getClass().getSimpleName() + "] " + e.getMessage());
        }

        try{
            System.out.println("Attempting to create a Name with a blank first name...");
            new Name("   ", "Cruz");
        } catch(IllegalArgumentException e){
            System.out.println("Caught Expected Exception: [" + e.getClass().getSimpleName() + "] " + e.getMessage());
        }

        try{
            System.out.println("Attempting to create HourlyEmployee with a null name...");
            new HourlyEmployee(107, null, new MyDate(3, 4, 1990),
                    new MyDate(1, 1, 2021), 40, 150);
        } catch(NullPointerException e){
            System.out.println("Caught Expected Exception: [" + e.getClass().getSimpleName() + "] " + e.getMessage());
        }

        System.out.println("======================================================================");
        System.out.println("3. POLYMORPHIC PAYROLL EXECUTION (Target Month: Sep)");
        System.out.println("[Dynamic Dispatch via Abstract Contract computeSalary()]");
        System.out.println("======================================================================");
        EmployeeRoster roster = new EmployeeRoster();
        roster.addEmployee(new HourlyEmployee(101, new Name("Alice", "Marie", "Smith"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45, 200));
        roster.addEmployee(new PieceWorkerEmployee(201, new Name("Bob", "Cruz", "Jones", "Jr."),
                new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 15));
        roster.addEmployee(new CommissionEmployee(301, new Name("Maria", "Luz", "Reyes"),
                new MyDate(2, 9, 1990), new MyDate(5, 5, 2021), 100000));
        roster.addEmployee(new BasePlusCommissionEmployee(401, new Name("Kevin", "Santos", "Tan"),
                new MyDate(10, 3, 1988), new MyDate(1, 2, 2020), 120000, 14000));
        roster.displayPayroll(targetMonth);
        System.out.println("======================================================================");
    }
}