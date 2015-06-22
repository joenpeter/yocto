/**
 * 
 */
package se.winquman.yocto.core;

import java.util.logging.Logger;

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
	
	public final void boot(RunConfiguration run) {

		// XXX pre-pre-init?
		
		//end
		
		preBootHook();
		
		// XXX init and stuff
		this.run = run;
		context = getContext();
		logSettings = getLogSettings();
		config = getConfigurator();
		logSettings.startLogging();
		//end
		
		// XXX load config
		populateConfigurator();
		
		//end
		
		preInitializationHook();
		
		// XXX load instances
		populateContextInstances();
		//end
		
		// XXX load components
		populateContextComponents();
		//end
		
		preRunnersHook();
		
		// XXX load runners
		populateContextRunners();
		startContextRunners();
		//end
		
		// XXX last and cleanup, etc
		
		//end
		
		postBootHook();
	}
	
	private Configurator getConfigurator() {
		// TODO Auto-generated method stub
		return null;
	}

	private LogSettings getLogSettings() {
		// TODO Auto-generated method stub
		return null;
	}

	private Context getContext() {
		// TODO Auto-generated method stub
		return null;
	}

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
