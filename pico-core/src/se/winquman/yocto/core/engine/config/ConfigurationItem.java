/**
 * 
 */
package se.winquman.yocto.core.engine.config;

import se.winquman.yocto.TreeNode;
import se.winquman.yocto.core.Component;
import se.winquman.yocto.xcoder.Encodable;

/**
 * @author Joen
 *
 */
public interface ConfigurationItem extends Component, Encodable, TreeNode {

	public String getName();
	
	public void setName(String name);
	
	public ConfigurationItem getChild(String name);
	
	
	/**
	 * Gets the child if it exists. If not, create a
	 * folder item with that name.
	 * @param name
	 * @return
	 */
	public ConfigurationItem getOrCreateChild(String name);
	
	public ConfigurationItem getParent();
	
}
