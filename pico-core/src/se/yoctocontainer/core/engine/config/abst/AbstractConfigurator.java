/**
 * 
 */
package se.yoctocontainer.core.engine.config.abst;

import se.yoctocontainer.core.AbstractInstance;
import se.yoctocontainer.core.engine.config.Configuration;
import se.yoctocontainer.core.engine.config.ConfigurationFinder;
import se.yoctocontainer.core.engine.config.ConfigurationPath;
import se.yoctocontainer.core.engine.config.Configurator;
import se.yoctocontainer.error.ConfigurationException;

/**
 * @author Joen
 *
 */
public abstract class AbstractConfigurator extends AbstractInstance implements
		Configurator {
	
	protected Configuration mainConfig;


	@Override
	public Object getConfiguration(String configPath) 
			throws ConfigurationException {

		ConfigurationPath path = (ConfigurationPath) context.newComponent("ConfigurationPath");
		ConfigurationFinder finder = (ConfigurationFinder) context.newComponent("ConfigurationFinder");
		path.setPath(configPath);
		finder.setRoot(mainConfig.getRootItem());
		return finder.findConfiguration(path);
	}


	@Override
	public void loadConfiguration(Configuration config) {
		info("Adding configuration: " + config.getRootItem().treeToText());
		mainConfig.addConfig(config);
	}

	@Override
	protected void init() {
		mainConfig = (Configuration) context.newComponent("Configuration");
	}

}
