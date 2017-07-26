/**
 * 
 */
package se.yoctocontainer.core.logging.impl;

import java.util.Calendar;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * @author jpeter
 *
 */
public class ConsoleFormatter extends Formatter {

	/**
	 * 
	 */
	public ConsoleFormatter() {
		// 
	}

	/* (non-Javadoc)
	 * @see java.util.logging.Formatter#format(java.util.logging.LogRecord)
	 */
	@Override
	public String format(LogRecord record) {
		
		String dateString;
		String thread = "UNKNOWN";
		String className;
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(record.getMillis());
		
		for(Thread t: Thread.getAllStackTraces().keySet()) {
			if(t.getId() == record.getThreadID()) {
				// They match, this is our thread
				thread = t.getName();
				break;
			}
		}
		
		dateString = "" + calendar.get(Calendar.YEAR)
				+ "-" + padZero(calendar.get(Calendar.MONTH), 2)
				+ "-" + padZero(calendar.get(Calendar.DAY_OF_MONTH), 2)
				+ " " + padZero(calendar.get(Calendar.HOUR_OF_DAY), 2)
				+ ":" + padZero(calendar.get(Calendar.MINUTE), 2)
				+ ":" + padZero(calendar.get(Calendar.SECOND), 2)
				+ "." + padZero(calendar.get(Calendar.MILLISECOND), 3);
		
		String classPath[] = record.getSourceClassName().split("\\.");
		
		if(classPath.length < 1) {
			className = "UNKNOWN";
		} else {
			className = classPath[classPath.length - 1];
		}
				
		
		String s = record.getLevel().toString() + " "
		
				+ dateString + " "
		
				+ className + ":" + record.getSourceMethodName()
		
				+ " [" + thread + "]: " + record.getMessage() + "\n";
		
		
		return s;
	}
	
	private String padZero(int value, int padToSize) {
		String s = "" + value;
		
		int pads = padToSize - s.length();
		for(int i = 0; i < pads; i++) {
			s = "0" + s;
		}
		return s;
	}

}
