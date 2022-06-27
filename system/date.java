package system;

public class date {
    int year,month, day;
    public date(int year, int month,int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public date(){

    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
