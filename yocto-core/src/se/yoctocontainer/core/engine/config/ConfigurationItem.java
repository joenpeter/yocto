/**
 * 
 */
package se.yoctocontainer.core.engine.config;

import se.yoctocontainer.core.Component;
import se.yoctocontainer.core.TreeNode;
import se.yoctocontainer.xcoder.Encodable;

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
