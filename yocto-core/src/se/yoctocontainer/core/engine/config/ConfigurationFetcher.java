/**
 * 
 */
package se.yoctocontainer.core.engine.config;

import se.yoctocontainer.core.Component;

/**
 * 
 * Fetches the configuration tree from the config file specified
 * @author Joen
 *
 */
public interface ConfigurationFetcher extends Component {

	/**
	 * 
	 * @param filePath the path to the config file
	 * @return the configuration object created from that file
	 */
	public Configuration fetchConfiguration(String filePath);
	
}
