package version6;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public final void setTotalPiecesFinished(int totalPiecesFinished) {
        if(totalPiecesFinished < 0){
            throw new IllegalArgumentException("Total pieces finished cannot be negative.");
        }
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public final void setRatePerPiece(double ratePerPiece) {
        if(!(ratePerPiece >= 0)){
            throw new IllegalArgumentException("Rate per piece cannot be negative.");
        }
        this.ratePerPiece = ratePerPiece;
    }

    @Override
    public double computeSalary(int currentMonth){
        double basePay = (totalPiecesFinished*ratePerPiece) + (totalPiecesFinished/100)*(10*ratePerPiece);
        return basePay + getBirthdayBonus(currentMonth);
    }

    @Override
    public double computeSalary(){
        return computeSalary(-1);
    }

    @Override
    public void displayEmployee(){
        System.out.println(getIdentityInfo());
        StringBuilder sb = new StringBuilder();
        sb.append("Pieces Finished: ").append(totalPiecesFinished).append(" | ");
        sb.append("Rate Per Piece: ₱").append(String.format("%,.2f", ratePerPiece));
        System.out.println(sb.toString());
    }

    public void displayPieceWorkerEmployee(){
        displayEmployee();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PieceWorkerEmployee [ID: ").append(getEmpID());
        sb.append(", Name: ").append(getEmpName());
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