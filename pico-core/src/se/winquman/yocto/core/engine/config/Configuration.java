/**
 * 
 */
package se.winquman.yocto.core.engine.config;

import java.util.List;
import java.util.Map;

/**
 * @author Joen
 *
 */
public interface Configuration extends Map<String, Object> {
	
	public ConfigurationItem getRootItem();
	
	public void addConfig(Configuration config);
}
