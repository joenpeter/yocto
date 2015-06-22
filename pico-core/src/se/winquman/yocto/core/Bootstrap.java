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

		// pre-pre-init
		
		//end
		
		preBootHook();
		
		// XXX init and stuff
		this.run = run;
		context = getContext();
		config = getConfigurator();
		logSettings = getLogSettings();
		logSettings.startLogging();
		//end
		
		// load config
		populateConfigurator();
		//end
		
		preInitializationHook();
		
		// load instances
		populateContextInstances();
		//end
		
		// load components
		populateContextComponents();
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
		// TODO Auto-generated method stub
		return null;
	}

	protected Configurator getConfigurator() {
		// TODO Auto-generated method stub
		return null;
	}

	protected Context getContext() {
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
