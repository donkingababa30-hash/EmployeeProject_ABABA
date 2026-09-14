package version2;

public class PieceWorkerEmployee {
    private int empID;
    private Name empName;
    private MyDate hireDate;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.hireDate = new MyDate();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.hireDate = new MyDate();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate hireDate, int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.hireDate = hireDate;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public MyDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(MyDate hireDate) {
        this.hireDate = hireDate;
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }

    public double computeSalary(){
        if(totalPiecesFinished>100){
            double bonusPay=((totalPiecesFinished*ratePerPiece) + (totalPiecesFinished/100)*(10*ratePerPiece));
            return bonusPay;
        }
        else{
            return totalPiecesFinished*ratePerPiece;
        }
    }

    public void displayPieceWorkerEmployee(){
        StringBuilder sb = new StringBuilder();
        sb.append("Employee ID: ").append(empID).append("\n");
        sb.append("Employee Name: ").append(empName.getFullName()).append("\n");
        sb.append("Hire Date: ").append(hireDate.getFormattedDate()).append("\n");
        sb.append("Total Pieces Finished: ").append(totalPiecesFinished).append("\n");
        sb.append("Rate Per Piece: ").append(ratePerPiece);
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PieceWorkerEmployee{");
        sb.append("empID=").append(empID);
        sb.append(", empName=").append(empName.getFullName());
        sb.append(", hireDate=").append(hireDate.getFormattedDate());
        sb.append(", totalPiecesFinished=").append(totalPiecesFinished);
        sb.append(", ratePerPiece=").append(ratePerPiece);
        sb.append(", Total Salary=").append(computeSalary());
        sb.append('}');
        return sb.toString();
    }
}