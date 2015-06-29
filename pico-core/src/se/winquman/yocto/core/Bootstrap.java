/**
 * 
 */
package se.winquman.yocto.core;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import se.winquman.yocto.core.engine.RunnerState;
import se.winquman.yocto.core.engine.RuntimeReference;
import se.winquman.yocto.core.engine.config.ConfigurationFetcher;
import se.winquman.yocto.core.helpers.InternalSettings;
import se.winquman.yocto.core.helpers.RunnerHelper;
import se.winquman.yocto.core.logging.BasicLogSettings;
import se.winquman.yocto.core.logging.LogSettings;
import se.winquman.yocto.error.ApplicationException;
import se.winquman.yocto.error.ApplicationRuntimeException;


/**
 * @author Joen
 *
 */
public abstract class Bootstrap {
	
	private RunConfiguration run;
	private RunConfiguration internalRun;
	private Context context;
	private Configurator config;
	private LogSettings logSettings;
	private Logger logger;
	private RuntimeReference runRef;
	
	public final void boot(RunConfiguration run) throws ApplicationException {

		// pre-pre-init
		
		//end
		
		preBootHook();
		
		// init and stuff
		this.run = run;
		config = getConfigurator();
		logSettings = getLogSettings();
		logSettings.startLogging();
		logger = logSettings.getConfiguredLogger();
		logger.info("" + run.getName() + " " + run.getVersion());
		context = getContext();
		config.create(context, config);
		internalRun = getInternalRuntime();
		// end
		
		preInitializationHook();
		
		//load runtime
		logger.fine("Loading program components");
		runRef = populateContext();
		//end
		
		// load config
		try {
			populateConfigurator();
		} catch (ApplicationException e) {
			logger.severe("Could not load configuration. " + e.toString());
			throw new ApplicationException("Could not load configuration", e);
		}
		//end
		
		preRunnersHook();
		
		// start runners
		startContextRunners();
		//end
		
		
		// last and cleanup, etc
		
		//end
		
		postBootHook();
	}
	
	private RunConfiguration getInternalRuntime() {
		return InternalSettings.getInternalRuntime();
	}

	private RuntimeReference populateContext() {
		context.addRuntime(internalRun);
		return context.addRuntime(run);
	}

	private void startContextRunners() {
		Runner[] runners = runRef.getRunners(RunnerState.INIT);
		
		for(int i = 0; i < runners.length; i++) {
			runners[i].setRunArguments(new ArrayList<Object>());
			try {
				RunnerHelper.startRunner(runners[i]);
			} catch (ApplicationException e) {
				logger.severe(e.toString());
			}
		}
	}

	private void populateConfigurator() throws ApplicationException {
		ConfigurationFetcher fetcher = (ConfigurationFetcher) context.newComponent("ConfigurationFetcher");
		Configuration c = fetcher.fetchConfiguration(run.getConfigFilePath());
		config.loadConfiguration(c);
	}

	protected LogSettings getLogSettings() {
		return new BasicLogSettings();
	}

	protected Configurator getConfigurator() {
		return InternalSettings.getEmptyConfigurator();
	}

	protected Context getContext() {
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
