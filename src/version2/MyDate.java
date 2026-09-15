package version2;

public class MyDate {
    private static final String[] monthNames = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    private String day;
    private int month;
    private int date;
    private int year;

    public MyDate() {
        this.day = "N/A";
        this.month = 0;
        this.date = 0;
        this.year = 0;
    }

    public MyDate(int month, int date, int year) {
        this.day = "N/A";
        this.month = month;
        this.date = date;
        this.year = year;
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

    public String getFormattedDate(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", date));
        sb.append(" ");
        if(month>=1 && month<=12){
            sb.append(monthNames[month-1]);
        }
        else{
            sb.append("N/A");
        }
        sb.append(" ");
        sb.append(year);
        return sb.toString();
    }

    public void displayMyDate(){
        StringBuilder sb = new StringBuilder();
        System.out.printf("Date: ");
        sb.append(String.format("%02d", date));
        sb.append(" ");
        if(month>=1 && month<=12){
            sb.append(monthNames[month-1]);
        }
        else{
            sb.append("N/A");
        }
        sb.append(" ");
        sb.append(year);
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyDate{");
        sb.append("day='").append(day).append('\'');
        sb.append(", month=").append(month);
        sb.append(", date=").append(date);
        sb.append(", year=").append(year);
        sb.append(", formattedDate=").append(getFormattedDate());
        sb.append('}');
        return sb.toString();
    }
}