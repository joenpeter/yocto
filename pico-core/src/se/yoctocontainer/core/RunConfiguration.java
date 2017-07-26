/**
 * 
 */
package se.yoctocontainer.core;

import java.util.Map;

/**
 * This is where all context configuration goes - can be done in layers
 * @author Joen
 *
 */
public interface RunConfiguration {
	
	/**
	 *  
	 * @return map of all instances in this runtime
	 */
	public Map<String,Class<? extends Instance>> getInstances();
	
	
	/**
	 * 
	 * @return Name of this runtime
	 */
	public String getName();
	
	/**
	 * 
	 * @return version of this runtime
	 */
	public Version getVersion();
	
	/**
	 * 
	 * @return file path to config file
	 */
	public String getConfigFilePath();
	
	/**
	 * 
	 * @return map of all settings (parameters) that are
	 * declared here rather then config files
	 */
	public Map<String, String> getSettings();
	
	/**
	 * 
	 * @return map of all component classes avilable
	 */
	public Map<String,Class<? extends Component>> getComponents();

}
