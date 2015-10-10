/**
 * 
 */
package se.winquman.yocto.core;

import java.util.Iterator;
import java.util.logging.Logger;

import se.winquman.yocto.core.engine.ContextSeed;
import se.winquman.yocto.core.engine.config.Configuration;
import se.winquman.yocto.core.engine.config.ConfigurationFetcher;
import se.winquman.yocto.core.engine.config.Configurator;
import se.winquman.yocto.core.helpers.InternalSettings;
import se.winquman.yocto.core.logging.BasicLogSettings;
import se.winquman.yocto.core.logging.LogSettings;
import se.winquman.yocto.error.ApplicationException;


/**
 * @author Joen
 *
 */
public abstract class Bootstrap {
	
	private RunConfiguration externalRun;
	private RunConfiguration internalRun;
	
	private ContextSeed seed;
	private Context context;
	private Configurator config;
	private LogSettings logSettings;
	private Logger logger;
	
	public final void boot(RunConfiguration run) throws ApplicationException {

		// pre-pre-init
		
		//end
		
		preBootHook();
		
		// init and stuff
		this.externalRun = run;
		config = getConfigurator();
		logSettings = getLogSettings();
		logSettings.startLogging();
		logger = logSettings.getConfiguredLogger();
		logger.info("" + run.getName() + " " + run.getVersion());
		seed = getContext();
		internalRun = getInternalRuntime();
		// end
		
		preInitializationHook();
				
		// XXX initialize context
		seed.addRuntime(internalRun);
		context = seed.addRuntime(externalRun);
		// end init context
				
		// load config
		config.create(seed, config);
		try {
			populateConfigurator();
		} catch (ApplicationException e) {
			logger.severe("Could not load configuration. " + e.toString());
			throw new ApplicationException("Could not load configuration", e);
		}
		//end
		

		preRunnersHook();
		
		// start runners
		startInstances();
		//end
		
		
		// last and cleanup, etc
		
		//end
		
		postBootHook();
	}

	private RunConfiguration getInternalRuntime() {
		return InternalSettings.getInternalRuntime();
	}

	private void startInstances() {
		
		Iterator<Instance> it = seed.getAllInstances();
		Instance instance = null;
		while(it.hasNext()) {
			instance = it.next();
			if(instance instanceof Startable) {
				logger.fine("Starting up: " + instance);
				((Startable) instance).start();
			}
		}
	}

	private void populateConfigurator() throws ApplicationException {
		ConfigurationFetcher fetcher = (ConfigurationFetcher) context.newComponent("ConfigurationFetcher");
		Configuration c = fetcher.fetchConfiguration(externalRun.getConfigFilePath());
		config.loadConfiguration(c);
	}

	protected LogSettings getLogSettings() {
		return new BasicLogSettings();
	}

	protected Configurator getConfigurator() {
		return InternalSettings.getEmptyConfigurator();
	}

	protected ContextSeed getContext() {
		return InternalSettings.getEmptyContext(config, logSettings);
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
