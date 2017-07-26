/**
 * 
 */
package se.winquman.yocto.core.engine.config.impl;

import se.winquman.yocto.core.engine.config.ConfigurationItem;
import se.winquman.yocto.core.engine.config.abst.AbstractConfigurator;
import se.winquman.yocto.error.ConfigurationException;

/**
 * @author Joen
 *
 */
public class BasicConfigurator extends AbstractConfigurator {

	@Override
	public boolean getBooleanConfiguration(String configPath) 
			throws ConfigurationException {

		if(this.getConfiguration(configPath) instanceof Boolean) {
			return (Boolean) getConfiguration(configPath);
		}
		throw new ConfigurationException("Config point " + configPath
				+ " is not a boolean configuration point.");
	}

	@Override
	public String getStringConfiguration(String configPath)
			throws ConfigurationException {

		Object item = getConfiguration(configPath);
		if(item instanceof String) {
			return (String) getConfiguration(configPath);
		}
		throw new ConfigurationException("Config point " + configPath
				+ " is not a String configuration point. (" + item + ")");
	}

	@Override
	public int getIntConfiguration(String configPath) 
			throws ConfigurationException {

		if(getConfiguration(configPath) instanceof Integer) {
			return (Integer) getConfiguration(configPath);
		}
		throw new ConfigurationException("Config point " + configPath
				+ " is not an integer configuration point.");
	}


}
