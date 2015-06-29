/**
 * 
 */
package se.winquman.yocto.core.logging;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
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
	protected static Level DEFAULT_CONSOLE_LEVEL = Level.FINE;
	
	protected final Logger logger;
	protected final String logFilePath;
	private FileHandler logFileHandler;
	private StreamHandler consoleHandler;
	private Formatter consoleFormatter;

	public AbstractLogSettings() {
		logger = Logger.getLogger("DefaultYoctoLogger");
		logFilePath = DEFAULT_LOGGING_PATH;
		consoleFormatter = new SimpleFormatter();
	}
	
	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.logging.LogSettings#startLogging()
	 */
	@Override
	public void startLogging() {
		try {
			logFileHandler = new FileHandler(logFilePath);
			logFileHandler.setLevel(DEFAULT_LOG_LEVEL);
			consoleHandler = new StreamHandler(System.out, consoleFormatter);
			consoleHandler.setLevel(DEFAULT_CONSOLE_LEVEL);
			logger.setUseParentHandlers(false);
			logger.addHandler(logFileHandler);
			logger.addHandler(consoleHandler);
			logger.setLevel(DEFAULT_LOG_LEVEL);
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
