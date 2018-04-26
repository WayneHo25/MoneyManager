package util;
 
import java.util.Calendar;
import java.util.Date;
 
public class DateUtil {
    static long millisecondsOfOneDay = 1000*60*60*24;   
 
    public static java.sql.Date util2sql(java.util.Date d){
        return  new java.sql.Date(d.getTime());
    }
     
    /**
     * Get the value of today. Set hour, minute, second as 0.
     * @return
     */
    public static Date today(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
         
    }
 
    /**
     * Get the start of this month. Using Calendar object to get the start of this month.Using the start and the end of this month to get the data from database.
     * @return
     */
    public static Date monthBegin() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DATE, 1);
         
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
         
        return c.getTime();
    }
     
    /**
     * Get the end of this month
     * @return
     */
    public static Date monthEnd() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
         
        c.set(Calendar.DATE, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, -1);
        return c.getTime();
    }
 
    /**
     * Get the number of day in this month
     * @return
     */
    public static int thisMonthTotalDay(){
         
        long lastDayMilliSeconds = monthEnd().getTime();
        long firstDayMilliSeconds = monthBegin().getTime();
 
        return (int) ((lastDayMilliSeconds-firstDayMilliSeconds)/millisecondsOfOneDay) +1;
    }
     
    /**
     * Get the number of remaining day in this month
     * @return
     */
    public static int thisMonthLeftDay(){
        long lastDayMilliSeconds = monthEnd().getTime();
        long toDayMilliSeconds = today().getTime();
        return (int) ((lastDayMilliSeconds-toDayMilliSeconds)/millisecondsOfOneDay) +1;
    }   
    
    public static void main(String[] args) {
        System.out.println(DateUtil.monthEnd());
    
    }
}
