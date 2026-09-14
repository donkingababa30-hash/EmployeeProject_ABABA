import version2.BasePlusCommissionEmployee;
import version2.CommissionEmployee;
import version2.HourlyEmployee;
import version2.PieceWorkerEmployee;
import version2.Name;
import version2.MyDate;

public class Main2 {
    public static void main(String[] args){
        Name n1 = new Name("Alice", "Marie", "Smith");
        MyDate d1 = new MyDate("Monday", 3, 15, 2021);
        HourlyEmployee h1 = new HourlyEmployee(101, n1, d1, 45, 200);
        h1.displayHourlyEmployee();
        System.out.println(h1);

        Name n2 = new Name("Bob", "Jones");
        MyDate d2 = new MyDate("Tuesday", 6, 1, 2022);
        PieceWorkerEmployee p1 = new PieceWorkerEmployee(201, n2, d2, 250, 15);
        p1.displayPieceWorkerEmployee();
        System.out.println(p1);

        Name n3 = new Name("Don", "King");
        MyDate d3 = new MyDate("Friday", 1, 10, 2020);
        CommissionEmployee c1 = new CommissionEmployee(1, n3, d3, 49900);
        System.out.println(c1);

        BasePlusCommissionEmployee b1 = new BasePlusCommissionEmployee(1, n3, d3, 40000, 20);
        System.out.println(b1);
    }
}