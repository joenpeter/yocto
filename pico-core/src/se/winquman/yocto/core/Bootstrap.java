/**
 * 
 */
package se.winquman.yocto.core;

import java.util.logging.Logger;

import se.winquman.yocto.core.helper.InternalSettings;
import se.winquman.yocto.core.logging.BasicLogSettings;
import se.winquman.yocto.core.logging.LogSettings;


/**
 * @author Joen
 *
 */
public abstract class Bootstrap {
	
	private RunConfiguration run;
	private Context context;
	private Configurator config;
	private LogSettings logSettings;
	private Logger logger;
	
	public final void boot(RunConfiguration run) {

		// pre-pre-init
		
		//end
		
		preBootHook();
		
		// init and stuff
		this.run = run;
		context = getContext();
		config = getConfigurator();
		logSettings = getLogSettings();
		logSettings.startLogging();
		logger = logSettings.getConfiguredLogger();
		logger.info("" + run.getName() + " " + run.getVersion());

		// end
		
		preInitializationHook();
		
		// load instances
		populateContextInstances();
		//end
		
		// load components
		populateContextComponents();
		//end
		
		// load config
		populateConfigurator();
		//end
		
		preRunnersHook();
		
		// load runners
		populateContextRunners();
		startContextRunners();
		//end
		
		
		// last and cleanup, etc
		
		//end
		
		postBootHook();
	}
	
	private void startContextRunners() {
		// TODO Auto-generated method stub
		
	}

	private void populateContextRunners() {
		// TODO Auto-generated method stub
		
	}

	private void populateContextComponents() {
		// TODO Auto-generated method stub
		
	}

	private void populateContextInstances() {
		// TODO Auto-generated method stub
		
	}

	private void populateConfigurator() {
		// TODO Auto-generated method stub
		
	}

	protected LogSettings getLogSettings() {
		return new BasicLogSettings();
	}

	protected Configurator getConfigurator() {
		return InternalSettings.getEmptyConfigurator();
	}

	protected Context getContext() {
		return InternalSettings.getEmptyContext();
	}
	
	
	
	/*
	 * BELOW IS ONLY HOOKS
	 */

	protected void preBootHook() {
		// Can be extended to hook on
	}
	
	protected void preInitializationHook() {
		// Can be extended to hook on
	}
	
	protected void preRunnersHook() {
		// Can be extended to hook on
	}
	
	protected void postBootHook() {
		// Can be extended to hook on
	}
		
}
