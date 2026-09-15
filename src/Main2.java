import version2.BasePlusCommissionEmployee;
import version2.CommissionEmployee;
import version2.HourlyEmployee;
import version2.PieceWorkerEmployee;
import version2.Name;
import version2.MyDate;

public class Main2 {
    public static void main(String[] args){
        Name n1 = new Name("Alice", "Marie", "Smith");
        MyDate d1 = new MyDate("Monday", 6, 1, 2022);
        MyDate b1= new MyDate("Monday", 9, 18, 2000);
        HourlyEmployee h1 = new HourlyEmployee(101, n1, d1, b1, 45, 200);
        n1.displayName();
        b1.displayMyDate();
        h1.displayHourlyEmployee();
        System.out.println(h1);
    }
}