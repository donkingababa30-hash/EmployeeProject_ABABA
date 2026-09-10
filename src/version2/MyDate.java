package version2;

public class MyDate {
    private String day;
    private int month;
    private int date;
    private int year;

    public MyDate() {
        this.day="N/A";
        this.month=0;
        this.date=0;
        this.year=0;
    }

    public MyDate(String day, int month, int date, int year) {
        this.day = day;
        this.month = month;
        this.date = date;
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
