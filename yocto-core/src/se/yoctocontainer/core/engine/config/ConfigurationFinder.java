/**
 * 
 */
package se.yoctocontainer.core.engine.config;

import se.yoctocontainer.core.Component;

/**
 * Can find a specific config item in the context configuration
 * @author Joen
 *
 */
public interface ConfigurationFinder extends Component {
	
	/**
	 * 
	 * @param root the root item of the configuration
	 */
	public void setRoot(ConfigurationItem root);
	
	/**
	 * 
	 * @param configurationPath the logical path to the config
	 * @return the object representing
	 */
	public Object findConfiguration(ConfigurationPath configurationPath);

}
