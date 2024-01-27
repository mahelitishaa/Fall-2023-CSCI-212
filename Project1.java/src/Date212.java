public class Date212 implements Comparable <Date212> {
    private int year;
    private int month;
    private int day;
    public Date212(String dateStr) {
        // Parse the date string to an integer, initialize year, month, and day
        year = Integer.parseInt(dateStr.substring(0, 4));
        month = Integer.parseInt(dateStr.substring(4, 6));
        day = Integer.parseInt(dateStr.substring(6, 8));

        // Validate the date 
        if (!isValidDate()||dateStr.length()!= 8) {
            System.out.println("Invalid date: "+ dateStr);
            year = 0;
            month = 0;
            day = 0;
        }
    }
    // Validating all the months and their days 
    private boolean isValidDate() {
        if (year< 1||month< 1||month> 12||day< 1||day> 31) {
            return false;
        }
        // Month of February, considering leap year 
        if (month==2) {
            if (leapYear()) {
                return day<= 29;
            } else {
                return day<= 28;
            }
        } else if ((month== 4||month== 6||month== 9||month== 11) && day> 30) {
            return false;
        }
        return true;
    }
    // leapYear method
    private boolean leapYear() {
        return (year%4== 0 && year%100!= 0)||(year%400== 0);
    }
    // compareTo method
    public int compareTo(Date212 other) {
        if (year!= other.year) {
            return Integer.compare(year, other.year);
        }
        if (month!= other.month) {
            return Integer.compare(month, other.month);
        }
        return Integer.compare(day, other.day);
    }
    public String toString() {
        return String.format("%02d/%02d/%04d", month, day, year);
    }
    // Getter for the month, could also do year or day to put valid date in list array 
    public int getMonth() {
        return month;
    }
}
