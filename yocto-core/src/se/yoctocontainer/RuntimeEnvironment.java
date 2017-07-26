/**
 * 
 */
package se.yoctocontainer;

import java.util.Map;

import se.yoctocontainer.core.Component;
import se.yoctocontainer.core.Instance;
import se.yoctocontainer.core.Version;

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
	public Map<String, Class<? extends Component>> components(Map<String, Class<? extends Component>> components);
	
	/**
	 * 
	 * @param instances
	 * @return list of all instances in this runtime added to the provided map
	 */
	public Map<String,Class<? extends Instance>> instances(Map<String,Class<? extends Instance>> instances);
	
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
