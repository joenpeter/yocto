/**
 * 
 */
package se.yoctocontainer.core.engine.config;

import se.yoctocontainer.core.Component;

/**
 * @author Joen
 *
 */
public interface ConfigurationPath extends Component {
	
	public void setPath(String path);
	
	/**
	 * 
	 * @return the next step in the path
	 */
	public String next();
	
	public boolean hasNext();

}
