/**
 * 
 */
package se.yoctocontainer.core.engine.config;

import java.util.List;

/**
 * @author Joen
 *
 */
public interface ConfigurationFolder extends ConfigurationItem {
	
	public ConfigurationItem getFirstChild();
	
	public List<ConfigurationItem> getAllChildren();

}
