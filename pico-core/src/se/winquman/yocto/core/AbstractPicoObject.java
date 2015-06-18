/**
 * 
 */
package se.winquman.yocto.core;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

/**
 * @author Joen
 *
 */
public abstract class AbstractPicoObject {
	
	private Logger logger;
	
	public void create() {
		logger = Logger.getLogger("YoctoLogger");
		
		Formatter formatter = new SimpleFormatter();
		Handler consoleHandler = new StreamHandler(System.out, formatter);
		
		logger.addHandler(consoleHandler);
		
		logger.info("********** Logging started **********");
	}
	
	public void debug(String message) {
		logger.finer(message);
	}
	
	public void info(String message) {
		logger.info(message);
	}
	
	public void warn(String message) {
		logger.warning(message);
	}
	
	public void error(String message) {
		logger.severe(message);
	}

}
