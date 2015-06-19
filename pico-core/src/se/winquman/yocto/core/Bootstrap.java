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
		logSettings = getLogSettings();
		config = getConfigurator();
		populateConfigurator();
		//end
		
		// XXX load config
		
		//end
		
		preInitializationHook();
		
		// XXX load instances
		
		//end
		
		// XXX load components
		
		//end
		
		preRunnersHook();
		
		// XXX load runners
		
		//end
		
		// XXX last and cleanup, etc
		
		//end
		
		postBootHook();
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
