/**
 * 
 */
package se.yoctocontainer.core.engine.config.impl;

import se.yoctocontainer.core.TreeNode;
import se.yoctocontainer.core.TreeNodeImpl;
import se.yoctocontainer.core.engine.config.ConfigurationItem;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author jpeter
 *
 */
@SuppressWarnings("serial")
public abstract class AbstractConfigurationItem extends TreeNodeImpl implements
		ConfigurationItem {

	protected String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public ConfigurationItem getChild(String name) {
		for(TreeNode child: children) {
			ConfigurationItem item = (ConfigurationItem) child;
			if(item.getName().equals(name)) {
				return item;
			}
		}
		
		return null;
	}

	@Override
	public ConfigurationItem getOrCreateChild(String name) {
		ConfigurationItem child = getChild(name);
		if(child == null) {
			debug("Created new configuration folder: " + name);
			child = (ConfigurationItem) context.newComponent("ConfigurationFolder");
			child.setName(name);
			addChild(child);
		}
		
		return child;
	}

	@Override
	public ConfigurationItem getParent() {
		throw new NotImplementedException();
	}

}
