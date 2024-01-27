/**
 * The Date212 class represents a date in the format of YYYYMMDD and has various methods
 * to manipulate and manage dates, including validation, retrieval, and comparison functions.
 */
public class Date212 {
  private int year;
  private int month;
  private int day;

  /**
   * Constructs a Date212 object from a string in the format YYYYMMDD.
   *
   * @param dateStr A string representing a date in the format YYYYMMDD
   */
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

  /**
   * Checks if the current date is a valid date.
   *
   * @return true if the date is valid, false otherwise
   */
  private boolean isValidDate() {
    if (year< 1||month< 1||month> 12||day< 1||day> 31) {
      return false;
    }
    // Month of February, considering leap year 
    if (month==2) {
      if (leapYear()) {
        return day<= 29;
      } 
      else {
        return day<= 28;
      }
    } 
    else if ((month== 4||month== 6||month== 9||month== 11) && day> 30) {
      return false;
    }
    return true;
  }

  /**
   * Checks if the current year is a leap year.
   *
   * @return true if the year is a leap year, false otherwise
   */
  private boolean leapYear() {
    return (year%4== 0 && year%100!= 0)||(year%400== 0);
  }

  /**
   * Sets the date for the Date212 object based on a string in the format YYYYMMDD.
   *
   * @param dateStr A string representing a date in the format YYYYMMDD
   */
  public void setDate212(String dateStr) {
    year = Integer.parseInt(dateStr.substring(0, 4));
    month = Integer.parseInt(dateStr.substring(4,6));
    day = Integer.parseInt(dateStr.substring(6, 8));
  } 

  /**
   * Retrieves the date in the format YYYYMMDD as a string.
   *
   * @return A string representing the date in the format YYYYMMDD
   */
  public String getDate212() {
    String date = "" + year;
      if (month < 10) date += "0" + month;
      else date += month;
      if (day < 10) date += "0" + day;
      else date += day;
      return date;
  }

  // Getters and setters for year, month, and day
  /**
   * Retrieves the year of the date.
   *
   * @return The year value of the date
   */
  public int getYear() {return year;} 

  /**
   * Retrieves the month of the date.
   *
   * @return The month value of the date
   */
  public int getMonth() {return month;} 

  /**
   * Retrieves the day of the date.
   *
   * @return The day value of the date
   */
  public int getDay() {return day;}
  
  /**
   * Sets the year of the date.
   *
   * @param y The year value to set
   */
  public void setYear(int y) {year = y;} 

  /**
   * Sets the month of the date.
   *
   * @param m The month value to set
   */
  public void setMonth(int m) {month = m;} 

  /**
   * Sets the day of the date.
   *
   * @param d The day value to set
   */
  public void setDay(int d) {day = d;} 

  /**
   * Provides a string representation of the date in MM/DD/YYYY format.
   *
   * @return A string representing the date in MM/DD/YYYY format
   */
  public String toString() {
    return String.format("%02d/%02d/%04d", month, day, year);
  }

  /**
   * Checks if the current Date212 object is equal to another object.
   *
   * @param other The object to compare
   * @return true if the two objects are equal, false otherwise
   */
  public boolean equals(Object other) {
    return (other != null && getClass() == other.getClass() && getDate212().equals(((Date212) other).getDate212()));
  } 

  /**
   * Compares the current Date212 object to another Date212 object.
   *
   * @param other The Date212 object to compare
   * @return 0 if the dates are equal, a positive value if the current date is after 'other',
   * a negative value if the current date is before 'other'
   */
  public int compareTo(Date212 other) {
    if (year!= other.year) {
      return Integer.compare(year, other.year);
    }
    if (month!= other.month) {
      return Integer.compare(month, other.month);
    }
    return Integer.compare(day, other.day);
  }
} 