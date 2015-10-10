/**
 * 
 */
package se.winquman.yocto.core;

import java.util.logging.Level;
import java.util.logging.Logger;

import se.winquman.yocto.core.engine.config.Configurator;
import se.winquman.yocto.core.logging.LogSettings;
import se.winquman.yocto.error.ApplicationException;
import se.winquman.yocto.error.ApplicationRuntimeException;
import se.winquman.yocto.error.InitializationException;
import se.winquman.yocto.error.NotCreatedException;

/**
 * @author jpeter
 *
 */
public abstract class AbstractYoctoObject implements YoctoObject {

	protected Context context;
	protected Configurator config;
	private LogSettings logSettings;
	private Logger logger;
	
	// Is this object created?
	private boolean isCreated = false;
		
	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.YoctoObject#create()
	 */
	@Override
	public void create(Context cont, Configurator conf) {
		config = conf;
		context = cont;
		logSettings = context.getLogSettings();
		logger = logSettings.getConfiguredLogger();
		isCreated = true;
		init();
	}
	
	protected void check() throws ApplicationRuntimeException {
		if(!isCreated) {
			throw new NotCreatedException("Object called before it was created: " + this.getClass());
		}
	}
	
	public boolean isCheck() {
		return isCreated;
	}
	
	protected abstract void init();
	
	
	
	private String getStackTrace(Throwable e) {
		String s = "";
		
		StackTraceElement[] stackTrace = e.getStackTrace();
		
		for(int i = 0; i < stackTrace.length; i++) {
			s = s + stackTrace[i].toString() + "\n";
		}
		
		Throwable cause = e.getCause();
		if(cause != null) {
			stackTrace = cause.getStackTrace();
			
			for(int i = 0; i < stackTrace.length; i++) {
				s = s + stackTrace[i].toString() + "\n";
			}
		}
		
		return s;
	}
	
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
