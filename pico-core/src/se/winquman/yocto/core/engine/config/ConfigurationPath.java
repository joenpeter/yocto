/**
 * 
 */
package se.winquman.yocto.core.engine.config;

import se.winquman.yocto.core.Component;

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
