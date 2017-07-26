/**
 * 
 */
package se.yoctocontainer.core;

import java.util.logging.Level;
import java.util.logging.Logger;

import se.yoctocontainer.core.engine.config.Configurator;
import se.yoctocontainer.core.logging.LogSettings;

/**
 * @author jpeter
 *
 */
public abstract class AbstractYoctoObject implements YoctoObject {

	protected Context context;
	protected Configurator config;
	private LogSettings logSettings;
	private Logger logger;
	private String name;
		
	@Override
	public void create(Context cont, Configurator conf) {
		config = conf;
		context = cont;
		logSettings = context.getLogSettings();
		logger = logSettings.getConfiguredLogger();
		init();
	}
	
	@Override
	public void setObjectName(String name) {
		this.name = name;
	}
	
	@Override
	public String getObjectName() {
		return name;
	}
	
	/**
	 * Do object-specific initializations.
	 * This is the local constructor.
	 */
	protected abstract void init();
	
	private void log(Level level, String msg, Throwable e) {
		int number = 2;
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();
		
		if(elements.length > number+1 && elements[number] != null) {
			logger.logp(level, this.getClass().getSimpleName().toString(), elements[number].getMethodName(), msg, e);
		} else {
			logger.logp(level, this.getClass().getSimpleName().toString(), "", msg, e);
		}
		
	}
	
	protected void debug(String msg) {
		log(Level.FINER, msg, null);
	}
	
	protected void debug(String msg, Throwable e) {
		log(Level.FINER, msg, e);
	}

	protected void info(String msg) {
		log(Level.INFO, msg, null);
	}
	
	protected void info(String msg, Throwable e) {
		log(Level.INFO, msg, e);
	}
	
	protected void warn(String msg) {
		log(Level.WARNING, msg, null);
	}
	
	protected void warn(String msg, Throwable e) {
		log(Level.WARNING, msg, e);
	}
	
	protected void error(String msg) {
		log(Level.SEVERE, msg, null);
	}
	
	protected void error(String msg, Throwable e) {
		log(Level.SEVERE, msg, e);
	}
	
}
