package version6;

import java.util.Objects;

public final class MyDate implements Cloneable {
    private static final String[] monthNames = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        validate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private static int daysInMonth(int month, int year){
        switch(month){
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    private static void validate(int day, int month, int year){
        if(month < 1 || month > 12 || year <= 1900 || day < 1 || day > daysInMonth(month, year)){
            throw new IllegalArgumentException("Invalid calendar date");
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        validate(day, this.month, this.year);
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        validate(this.day, month, this.year);
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        validate(this.day, this.month, year);
        this.year = year;
    }

    public String getMonthName(){
        return monthNames[month-1];
    }

    public void displayDate(){
        StringBuilder sb = new StringBuilder();
        sb.append("Date: ").append(toString());
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", day));
        sb.append(" ");
        sb.append(monthNames[month-1]);
        sb.append(" ");
        sb.append(year);
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        MyDate other = (MyDate) obj;
        return day == other.day && month == other.month && year == other.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public MyDate clone() {
        try {
            return (MyDate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}