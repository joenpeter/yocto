package se.yoctocontainer.core.engine.config;

import se.yoctocontainer.core.Instance;
import se.yoctocontainer.error.ConfigurationException;

/**
 * Maintains the configuration of the active environment
 * 
 * @author Joen
 * 
 */
public interface Configurator extends Instance {
	
	public Object getConfiguration(String configPath) 
			throws ConfigurationException;
	
	public boolean getBooleanConfiguration(String configPath)
			throws ConfigurationException;
	
	public String getStringConfiguration(String configPath)
			throws ConfigurationException;
	
	public int getIntConfiguration(String configPath)
			throws ConfigurationException;
		
	public void loadConfiguration(Configuration config);

}
