/**
 * 
 */
package se.winquman.yocto.core.engine.config;

import java.util.Map;

import se.winquman.yocto.core.AbstractInstance;
import se.winquman.yocto.core.Configuration;
import se.winquman.yocto.core.Configurator;

/**
 * @author Joen
 *
 */
public abstract class AbstractConfigurator extends AbstractInstance implements
		Configurator {
	
	protected Configuration mainConfig;

	/**
	 * 
	 */
	public AbstractConfigurator() {
		super();
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Configurator#getConfiguration(java.lang.String)
	 */
	@Override
	public Object getConfiguration(String configPath) {
		check();
		ConfigurationPath path = (ConfigurationPath) context.newComponent("ConfigurationPath");
		ConfigurationFinder finder = (ConfigurationFinder) context.newComponent("ConfigurationFinder");
		path.setPath(configPath);
		finder.setPath(path);
		finder.setRoot(mainConfig.getRootItem());
		return finder.findConfiguration();
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Configurator#loadConfiguration(se.winquman.yocto.core.Configuration)
	 */
	@Override
	public void loadConfiguration(Configuration config) {
		check();
		logger.fine("Adding configuration: " + config);
		mainConfig.addConfig(config);
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.AbstractYoctoObject#init()
	 */
	@Override
	protected void init() {
		mainConfig = (Configuration) context.newComponent("Configuration");
	}

}
