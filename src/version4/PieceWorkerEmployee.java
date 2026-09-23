package version4;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if(totalPiecesFinished>=0){
            this.totalPiecesFinished = totalPiecesFinished;
        }
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if(ratePerPiece>=0){
            this.ratePerPiece = ratePerPiece;
        }
    }

    public double computeSalary(int currentMonth){
        double basePay;
        if(totalPiecesFinished>100){
            basePay = (totalPiecesFinished*ratePerPiece) + (totalPiecesFinished/100)*(10*ratePerPiece);
        }
        else{
            basePay = totalPiecesFinished*ratePerPiece;
        }
        if(getBirthDate().getMonth()==currentMonth){
            basePay += 5000.00;
        }
        return basePay;
    }

    public double computeSalary(){
        return computeSalary(-1);
    }

    public void displayPieceWorkerEmployee(){
        super.displayEmployee();
        StringBuilder sb = new StringBuilder();
        sb.append("Pieces Finished: ").append(totalPiecesFinished).append(" | ");
        sb.append("Rate Per Piece: ₱").append(String.format("%,.2f", ratePerPiece));
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PieceWorkerEmployee[").append(super.toString());
        sb.append(", Pieces: ").append(totalPiecesFinished);
        sb.append(", Rate: ₱").append(String.format("%,.2f", ratePerPiece));
        sb.append(", Total Salary: ₱").append(String.format("%,.2f", computeSalary()));
        sb.append(']');
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(!super.equals(obj)){
            return false;
        }
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == other.totalPiecesFinished && ratePerPiece == other.ratePerPiece;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}