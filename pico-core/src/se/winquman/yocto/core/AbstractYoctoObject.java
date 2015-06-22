/**
 * 
 */
package se.winquman.yocto.core;

import se.winquman.yocto.error.ApplicationException;

/**
 * @author jpeter
 *
 */
public class AbstractYoctoObject implements YoctoObject {

	protected Context context;
	protected Configurator config;
	
	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.YoctoObject#create()
	 */
	@Override
	public void create(Context cont, Configurator conf) throws ApplicationException {
		config = conf;
		context = cont;
	}
	
	protected void info(String message) {
		
	}
	
	protected void debug(String message) {
		
	}
	
	protected void warn(String message) {
		
	}
	
	protected void error(String message) {
		
	}
	
	protected void error(String message, Exception e) {
		
	}

}
