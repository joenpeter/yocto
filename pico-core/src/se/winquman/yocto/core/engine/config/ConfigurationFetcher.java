/**
 * 
 */
package se.winquman.yocto.core.engine.config;

import se.winquman.yocto.core.Component;
import se.winquman.yocto.core.Configuration;

/**
 * @author Joen
 *
 */
public interface ConfigurationFetcher extends Component {

	public Configuration fetchConfiguration(String filePath);
	
}
