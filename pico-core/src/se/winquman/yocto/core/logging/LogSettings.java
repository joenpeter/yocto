/**
 * 
 */
package se.winquman.yocto.core.logging;

import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Joen
 *
 */
public interface LogSettings {
	
	public void startLogging();
	
	public Logger getConfiguredLogger();
	
	public void setLowestLogLevel(Level level);
	
	public Formatter getDefaultFormatter();
	
	public String getLogFilePath();
	
	public void setLogFilePath(String path);

}
