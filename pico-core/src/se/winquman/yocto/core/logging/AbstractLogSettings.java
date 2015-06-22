/**
 * 
 */
package se.winquman.yocto.core.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

/**
 * @author jpeter
 *
 */
public abstract class AbstractLogSettings implements LogSettings {

	protected static String DEFAULT_LOGGING_PATH = "./yocto.log";
	protected static String START_LOG_MESSAGE = "***** Logging staring *****";
	protected static Level DEFAULT_LOG_LEVEL = Level.FINEST;
	
	protected final Logger logger;
	protected final String logFilePath;
	private FileHandler logFileHandler;

	public AbstractLogSettings() {
		logger = Logger.getLogger("DefaultYoctoLogger");
		logFilePath = DEFAULT_LOGGING_PATH;
	}
	
	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.logging.LogSettings#startLogging()
	 */
	@Override
	public void startLogging() {
		try {
			logFileHandler = new FileHandler(logFilePath);
			logger.addHandler(logFileHandler);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		logger.info(START_LOG_MESSAGE);
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.logging.LogSettings#getConfiguredLogger()
	 */
	@Override
	public Logger getConfiguredLogger() {
		return logger;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.logging.LogSettings#setLowestLogLevel(java.util.logging.Level)
	 */
	@Override
	public void setLowestLogLevel(Level level) {
		logger.setLevel(level);

	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.logging.LogSettings#getDefaultFormatter()
	 */
	@Override
	public Formatter getDefaultFormatter() {
		return logFileHandler.getFormatter();
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.logging.LogSettings#getLogFilePath()
	 */
	@Override
	public String getLogFilePath() {
		return logFilePath;
	}

}
