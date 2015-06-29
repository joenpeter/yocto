/**
 * 
 */
package se.winquman.yocto.core;

import java.util.Map;

/**
 * This is where all context configuration goes - can be done in layers
 * @author Joen
 *
 */
public interface RunConfiguration {
	
	public Map<String,Class> getInstances();
	
	public Map<String,Class> getComponentFactories();
	
	public Map<String,Class> getRunners();
	
	public String getName();
	
	public Version getVersion();
	
	public String getConfigFilePath();
	
	public Map<String, String> getSettings();
	
	public Map<String,Class> getComponents();

}
