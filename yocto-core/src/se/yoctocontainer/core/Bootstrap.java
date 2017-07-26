/**
 * 
 */
package se.yoctocontainer.core;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import se.yoctocontainer.core.engine.ContextSeed;
import se.yoctocontainer.core.engine.config.Configuration;
import se.yoctocontainer.core.engine.config.ConfigurationFetcher;
import se.yoctocontainer.core.engine.config.Configurator;
import se.yoctocontainer.core.helpers.InternalSettings;
import se.yoctocontainer.core.logging.BasicLogSettings;
import se.yoctocontainer.core.logging.LogSettings;
import se.yoctocontainer.error.ApplicationException;


/**
 * @author Joen
 *
 */
public abstract class Bootstrap {
	
	private RunConfiguration externalRun;
	private RunConfiguration internalRun;
	private List<RunConfiguration> additionalRuns;
	
	private ContextSeed seed;
	private Context context;
	private Configurator config;
	private LogSettings logSettings;
	private Logger logger;
	
	/**
	 * Add a dependency.
	 * These will be loaded before the main runtime.
	 * @param run
	 */
	public void addDependency(RunConfiguration run) {
		if(additionalRuns == null) {
			additionalRuns = new ArrayList<>();
		}
		
		additionalRuns.add(run);
	}
	
	/**
	 * Boot the application
	 * @param run this is the runtime for the main application, and will start last
	 * @throws ApplicationException
	 */
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
				
		// initialize context
		seed.addRuntime(internalRun);
		
		if(additionalRuns != null) {
			for(RunConfiguration runtime: additionalRuns) {
				seed.addRuntime(runtime);
			}
		}
		
		seed.addRuntime(externalRun);
		// end init context
		
		context = seed.getContext();
				
		// load config
		config.create(seed, config);
		try {
			populateConfigurator();
		} catch (ApplicationException e) {
			logger.severe("Could not load configuration. " + e.toString());
			throw new ApplicationException("Could not load configuration", e);
		}
		//end
	
		
		// last and cleanup, etc
		
		//end
		
		postBootHook();
	}

	private RunConfiguration getInternalRuntime() {
		return InternalSettings.getInternalRuntime();
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
		
	protected void postBootHook() {
		// Can be extended to hook on
	}
		
}
