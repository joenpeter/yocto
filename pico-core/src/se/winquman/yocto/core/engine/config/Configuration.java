/**
 * 
 */
package se.winquman.yocto.core.engine.config;

import java.util.List;
import java.util.Map;

import se.winquman.yocto.core.YoctoObject;

/**
 * @author Joen
 *
 */
public interface Configuration extends YoctoObject {
	
	public ConfigurationItem getRootItem();
	
	public void addConfig(Configuration config);
	
	public void addItem(ConfigurationItem item, String path);
	
}
