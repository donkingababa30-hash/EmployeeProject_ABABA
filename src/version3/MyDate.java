package version3;

import java.util.Objects;

public class MyDate implements Cloneable {
    private static final String[] MONTH_NAMES = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    private int day;
    private int month;
    private int year;

    public MyDate() {
        this.day = 1;
        this.month = 1;
        this.year = 1900;
    }

    public MyDate(int month, int day, int year) {
        setMonth(month);
        setDay(day);
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = (day >= 1 && day <= 31) ? day : 1;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = (month >= 1 && month <= 12) ? month : 1;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFormattedDate() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", day));
        sb.append(" ");
        sb.append((month >= 1 && month <= 12) ? MONTH_NAMES[month - 1] : "N/A");
        sb.append(" ");
        sb.append(year);
        return sb.toString();
    }

    public void displayDate() {
        System.out.println("Date: " + getFormattedDate());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyDate{");
        sb.append("day=").append(day);
        sb.append(", month=").append(month);
        sb.append(", year=").append(year);
        sb.append(", formattedDate=").append(getFormattedDate());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MyDate)) {
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
            throw new AssertionError("MyDate did not implement Cloneable", e);
        }
    }
}