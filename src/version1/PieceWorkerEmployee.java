package version1;

public class PieceWorkerEmployee {
    private int empID;
    private String empName;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this.empID=0;
        this.empName="N/A";
        this.totalPiecesFinished=0;
        this.ratePerPiece=0;
    }

    public PieceWorkerEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished=0;
        this.ratePerPiece=0;
    }

    public PieceWorkerEmployee(int empID, String empName, int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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
        System.out.println("Employee ID: " + empID);
        System.out.println("Employee Name: "+ empName);
        System.out.println("Total Pieces Finished: " + totalPiecesFinished);
        System.out.println("Rate Per Piece: " + ratePerPiece);
    }

    @Override
    public String toString() {
        return "PieceWorkerEmployee{" +
                "empID=" + empID +
                ", empName='" + empName + '\'' +
                ", totalPiecesFinished=" + totalPiecesFinished +
                ", ratePerPiece=" + ratePerPiece +
                ", Total Salary=" + computeSalary() +
                '}';
    }
}
