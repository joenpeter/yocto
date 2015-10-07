/**
 * 
 */
package se.winquman.yocto.core.engine.config;

import se.winquman.yocto.core.Instance;

/**
 * Maintains the configuration of the active environment
 * 
 * @author Joen
 * 
 */
public interface Configurator extends Instance {
	
	public Object getConfiguration(String configPath);
	
	public void loadConfiguration(Configuration config);

}
