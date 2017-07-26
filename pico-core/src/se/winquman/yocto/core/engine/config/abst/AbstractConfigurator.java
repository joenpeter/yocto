/**
 * 
 */
package se.winquman.yocto.core.engine.config.abst;

import se.winquman.yocto.core.AbstractInstance;
import se.winquman.yocto.core.engine.config.Configuration;
import se.winquman.yocto.core.engine.config.ConfigurationFinder;
import se.winquman.yocto.core.engine.config.ConfigurationPath;
import se.winquman.yocto.core.engine.config.Configurator;
import se.winquman.yocto.error.ConfigurationException;

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
	public Object getConfiguration(String configPath) 
			throws ConfigurationException {
		check();
		ConfigurationPath path = (ConfigurationPath) context.newComponent("ConfigurationPath");
		ConfigurationFinder finder = (ConfigurationFinder) context.newComponent("ConfigurationFinder");
		path.setPath(configPath);
		finder.setRoot(mainConfig.getRootItem());
		return finder.findConfiguration(path);
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Configurator#loadConfiguration(se.winquman.yocto.core.Configuration)
	 */
	@Override
	public void loadConfiguration(Configuration config) {
		check();
		info("Adding configuration: " + config.getRootItem().treeToText());
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
