public class Date212 implements Comparable<Date212> {
    private int year;
    private int month;
    private int day;

    public Date212(String dateStr) throws IllegalDate212Exception {
        year = Integer.parseInt(dateStr.substring(0, 4));
        month = Integer.parseInt(dateStr.substring(4, 6));
        day = Integer.parseInt(dateStr.substring(6, 8));

        if (!isValidDate() || dateStr.length() != 8) {
            throw new IllegalDate212Exception("Invalid date: " + dateStr);
        }
    }

    private boolean isValidDate() {
        if (year < 1 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }

        if (month == 2) {
            if (leapYear()) {
                return day <= 29;
            } else {
                return day <= 28;
            }
        } else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            return false;
        }
        return true;
    }

    private boolean leapYear() {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public String toString() {
        return String.format("%02d/%02d/%04d", month, day, year);
    }

    public int getYear() {
        return year;
    }

    public int compareTo(Date212 other) {
        if (year != other.year) {
            return Integer.compare(year, other.year);
        }
        if (month != other.month) {
            return Integer.compare(month, other.month);
        }
        return Integer.compare(day, other.day);
    }
}
