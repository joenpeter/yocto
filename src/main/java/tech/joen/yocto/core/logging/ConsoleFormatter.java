/**
 * 
 */
package tech.joen.yocto.core.logging;

import java.util.Calendar;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * 
 */
public class ConsoleFormatter extends Formatter {

  @Override
  public String format(LogRecord record) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(record.getMillis());
    String dateString = "" + calendar.get(Calendar.YEAR)
        + "-" + padZero(calendar.get(Calendar.MONTH), 2)
        + "-" + padZero(calendar.get(Calendar.DAY_OF_MONTH), 2)
        + " " + padZero(calendar.get(Calendar.HOUR_OF_DAY), 2)
        + ":" + padZero(calendar.get(Calendar.MINUTE), 2)
        + ":" + padZero(calendar.get(Calendar.SECOND), 2)
        + "." + padZero(calendar.get(Calendar.MILLISECOND), 3);
    
    String threadName = "UNKNOWN";
    for(Thread t: Thread.getAllStackTraces().keySet()) {
      if(t.threadId() == record.getLongThreadID()) {
          threadName = t.getName();
          break;
      }
    }
    
    return record.getLevel().toString() 
        + " " + dateString 
        + " " + record.getLoggerName() 
        + "." + record.getSourceMethodName() 
        + " [" + threadName + "]: "
        + record.getMessage() + "\n";
  }

  private String padZero(int number, int size) {
    StringBuilder builder = new StringBuilder(Integer.toString(number));
    for(int padding = size - builder.length(); padding > 0; padding--) {
      builder.insert(0, "0");
    }
    return builder.toString();
  }

  
}
