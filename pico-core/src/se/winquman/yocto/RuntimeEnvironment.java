/**
 * 
 */
package se.winquman.yocto;

import java.util.List;
import java.util.Map;

import se.winquman.yocto.core.Component;
import se.winquman.yocto.core.ComponentFactory;
import se.winquman.yocto.core.Instance;
import se.winquman.yocto.core.Version;

/**
 * @author Joen
 *
 */
public interface RuntimeEnvironment {
	
	/**
	 * 
	 * @param components
	 * @return list of all components in this runtime added to the provided map
	 */
	public Map<String, Class> defaultComponents(Map<String, Class> components);
	
	/**
	 * 
	 * @param instances
	 * @return list of all instances in this runtime added to the provided map
	 */
	public Map<String,Class> instances(Map<String,Class> instances);
	
	/**
	 * 
	 * @param factories
	 * @return list of all component factories added to the provided map
	 */
	public Map<String,Class> componentFactories(Map<String,Class> factories);
	
	/**
	 * 
	 * @param settings
	 * @return list of all settings added to the provided map
	 */
	public Map<String,String> settings(Map<String,String> settings);
	
	/**
	 * 
	 * @return the version of this runtime
	 */
	public Version version();

}
