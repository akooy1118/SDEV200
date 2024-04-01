import java.util.Calendar;
import java.util.GregorianCalendar;


/* Creates date */
public class MyDate {
   private int year;
   private int month;
   private int day;

   /* Gets current date from system */
   public MyDate() {
    GregorianCalendar currentDate = new GregorianCalendar();
    this.year = currentDate.get(Calendar.YEAR);
    this.month = currentDate.get(Calendar.MONTH);
    this.day = currentDate.get(Calendar.DAY_OF_MONTH);
   }

   /* Gets current date from an elapsed time */
   public MyDate(long elapsedTime) {
    setDate(elapsedTime);
   }

   public MyDate(int year, int month, int day) {
    this.year = year;
    this.month = month;
    this. day = day;
   }

   public int getYear() {
    return year;
   }

   public int getMonth() {
    return month;
   }

   public int getDay() {
    return day;
   }

   public void setDate(long elapsedTime) {
    GregorianCalendar calendar = new GregorianCalendar();
    calendar.setTimeInMillis(elapsedTime);
    this.year = calendar.get(Calendar.YEAR);
    this.month = calendar. get(Calendar.MONTH);
    this.day = calendar.get(Calendar.DAY_OF_MONTH);
   }

   public static void main(String[] args) {

    /* Output for current date */
    MyDate date1 = new MyDate();
    System.out.println("Current Date:");
    System.out.println("Year: " + date1.getYear());
    System.out.println("Month: " + (date1.getMonth() + 1)); // Adding 1 as month is 0-based
    System.out.println("Day: " + date1.getDay());

    /* Output for elapsed time  */
    MyDate date2 = new MyDate(34355555133101L);
    System.out.println("\nDate from elapsed time (34355555133101L):");
    System.out.println("Year: " + date2.getYear());
    System.out.println("Month: " + (date2.getMonth() + 1)); // Adding 1 as month is 0-based
    System.out.println("Day: " + date2.getDay());
    }
}

