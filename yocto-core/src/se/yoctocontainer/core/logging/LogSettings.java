/**
 * 
 */
package se.yoctocontainer.core.logging;

import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Joen
 *
 */
public interface LogSettings {
	
	/**
	 * Start the logging for this session.
	 */
	public void startLogging();
	
	/**
	 * Get the logger
	 * @return the Logger configured for logging
	 */
	public Logger getConfiguredLogger();
	
	/**
	 * Set the lowest log level to log to
	 * @param level the lowest log level to log
	 */
	public void setLowestLogLevel(Level level);
	
	/**
	 * Get the default formatter
	 * @return the Formatter
	 */
	public Formatter getDefaultFormatter();
	
	/**
	 * Return the path to the log file
	 * @return
	 */
	public String getLogFilePath();

}
