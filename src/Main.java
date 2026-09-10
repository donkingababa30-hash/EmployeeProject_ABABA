import version1.BasePlusCommissionEmployee;
import version1.CommissionEmployee;
import version1.HourlyEmployee;
import version1.PieceWorkerEmployee;

public class Main {
    public static void main(String[] args) {
        HourlyEmployee h1= new HourlyEmployee(101, "Alice Smith", 45, 200);
        h1.displayHourlyEmployee();
        System.out.println(h1);
        PieceWorkerEmployee p1 = new PieceWorkerEmployee(201, "Bob Jones", 250, 15);
        p1.displayPieceWorkerEmployee();
        System.out.println(p1);
        CommissionEmployee c1=new CommissionEmployee(1, "Don King", 49900);
        System.out.println(c1);
        BasePlusCommissionEmployee b1=new BasePlusCommissionEmployee(1, "Don King", 40000, 20);
        System.out.println(b1);

    }

}