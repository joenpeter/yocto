/**
 * 
 */
package se.winquman.yocto.core.engine.config;

import se.winquman.yocto.core.Component;

/**
 * @author Joen
 *
 */
public interface ConfigurationFinder extends Component {
	
	public void setPath(ConfigurationPath path);
	
	public void setRoot(ConfigurationItem root);
	
	public Object findConfiguration();

}
