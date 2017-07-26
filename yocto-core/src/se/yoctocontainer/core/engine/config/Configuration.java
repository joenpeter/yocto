/**
 * 
 */
package se.yoctocontainer.core.engine.config;

import se.yoctocontainer.core.YoctoObject;

/**
 * Business configuration for the application
 * 
 * @author jpeter
 *
 */
public interface Configuration extends YoctoObject {
	
	/**
	 * Get the root of the configuration tree
	 * @return
	 */
	public ConfigurationItem getRootItem();
	
	/**
	 * Add another configuration to this, merging the trees
	 * @param config
	 */
	public void addConfig(Configuration config);
	
	/**
	 * Add a configuration point to a specific place on this configuration
	 * @param item the configuration item to add
	 * @param path the path where to add it on the tree
	 */
	public void addItem(ConfigurationItem item, String path);
	
}
