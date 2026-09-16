import version3.BasePlusCommissionEmployee;
import version3.CommissionEmployee;
import version3.HourlyEmployee;
import version3.PieceWorkerEmployee;
import version3.Name;
import version3.MyDate;
import version3.Employee;

public class Main3 {

    private static final String[] MONTH_NAMES = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public static void main(String[] args) {
        int targetMonth = 9;

        HourlyEmployee hourly = new HourlyEmployee(
                101,
                new Name("Alice", "Mae", "Smith"),
                new MyDate(9, 18, 2000),
                new MyDate(6, 1, 2022),
                38.0f, 250.0);

        PieceWorkerEmployee pieceWorker = new PieceWorkerEmployee(
                201,
                new Name("Bob", "Cruz", "Jones", "Jr."),
                new MyDate(4, 5, 1998),
                new MyDate(1, 15, 2023),
                90, 45.0);

        CommissionEmployee commission = new CommissionEmployee(
                301,
                new Name("Carla", "Reyes", "Dela Cruz"),
                new MyDate(9, 3, 1995),
                new MyDate(3, 10, 2021),
                120000.0);

        BasePlusCommissionEmployee basePlusCommission = new BasePlusCommissionEmployee(
                401,
                new Name("Dave", "Luis", "Santos"),
                new MyDate(11, 20, 1990),
                new MyDate(9, 5, 2019),
                60000.0, 15000.0);

        Employee[] employees = { hourly, pieceWorker, commission, basePlusCommission };

        System.out.println("POLYMORPHIC PAYROLL REPORT (Target Month: " + MONTH_NAMES[targetMonth - 1] + ")");

        for (int i = 0; i < employees.length; i++) {
            Employee emp = employees[i];
            double totalPayout = emp.computeSalary(targetMonth);
            double withoutBonus = emp.computeSalary(-1);
            double bonus = totalPayout - withoutBonus;
            boolean eligible = bonus > 0;

            System.out.println(describe(emp));
            System.out.printf("Base Pay: ₱%.2f | Birthday Bonus: ₱%.2f (%s)%n",
                    withoutBonus, bonus, eligible ? "Eligible" : "Ineligible");
            System.out.printf("Total Payout: ₱%.2f%n", totalPayout);
        }

        System.out.println("\nOBJECT CONTRACT TESTS (equals & hashCode)");

        HourlyEmployee emp1 = new HourlyEmployee(
                501, new Name("Erika", "Lopez", "Torres"),
                new MyDate(2, 14, 1999), new MyDate(5, 1, 2020),
                40.0f, 300.0);

        HourlyEmployee emp1Identical = new HourlyEmployee(
                501, new Name("Erika", "Lopez", "Torres"),
                new MyDate(2, 14, 1999), new MyDate(5, 1, 2020),
                40.0f, 300.0);

        HourlyEmployee emp2 = new HourlyEmployee(
                502, new Name("Fiona", "Cruz", "Reyes"),
                new MyDate(7, 30, 2001), new MyDate(8, 15, 2021),
                20.0f, 200.0);

        System.out.println("emp1 equals emp1Identical: " + emp1.equals(emp1Identical));
        System.out.println("emp1 hashCode: " + emp1.hashCode()
                + " | emp1Identical hashCode: " + emp1Identical.hashCode()
                + " (Match: " + (emp1.hashCode() == emp1Identical.hashCode()) + ")");
        System.out.println("emp1 equals emp2: " + emp1.equals(emp2));

        System.out.println("\nDEEP CLONE VERIFICATION");

        HourlyEmployee empOriginal = new HourlyEmployee(
                101, new Name("Alice", "Mae", "Smith"),
                new MyDate(9, 18, 2000), new MyDate(6, 1, 2022),
                38.0f, 250.0);

        HourlyEmployee empClone = empOriginal.clone();

        System.out.println("Original Name before modification: " + empOriginal.getEmpName().getFullName());

        Name cloneName = empClone.getEmpName();
        cloneName.setLastName("Taylor");
        empClone.setEmpName(cloneName);
        empClone.getBirthDate().setMonth(3);

        System.out.println("Clone Name changed to: " + empClone.getEmpName().getFullName());
        System.out.println("Original Name after modification: " + empOriginal.getEmpName().getFullName()
                + (empOriginal.getEmpName().getFullName().equals("Smith, Alice M.")
                ? " (Deep copy successful!)" : " (Deep copy FAILED)"));
    }

    private static String describe(Employee emp) {
        String type = emp.getClass().getSimpleName();
        return String.format("%s [ID: %d, Name: %s, DOB: %s, Hired: %s]",
                type, emp.getEmpID(), emp.getEmpName().getFullName(),
                emp.getBirthDate().getFormattedDate(), emp.getDateHired().getFormattedDate());
    }
}