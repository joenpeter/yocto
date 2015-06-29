/**
 * 
 */
package se.winquman.yocto.core;

import java.util.List;
import java.util.Map;

import se.winquman.yocto.core.engine.config.ConfigurationItem;

/**
 * @author Joen
 *
 */
public interface Configuration extends Map<String, Object> {
	
	public ConfigurationItem getRootItem();
	
	public void addConfig(Configuration config);
}
