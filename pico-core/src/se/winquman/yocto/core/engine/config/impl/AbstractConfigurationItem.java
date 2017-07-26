/**
 * 
 */
package se.winquman.yocto.core.engine.config.impl;

import se.winquman.yocto.TreeNode;
import se.winquman.yocto.core.TreeNodeImpl;
import se.winquman.yocto.core.engine.config.ConfigurationItem;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author jpeter
 *
 */
public abstract class AbstractConfigurationItem extends TreeNodeImpl implements
		ConfigurationItem {

	protected String name;

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.engine.config.ConfigurationItem#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.engine.config.ConfigurationItem#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.engine.config.ConfigurationItem#getChild(java.lang.String)
	 */
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

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.engine.config.ConfigurationItem#getOrCreateChild(java.lang.String)
	 */
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

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.engine.config.ConfigurationItem#getParent()
	 */
	@Override
	public ConfigurationItem getParent() {
		throw new NotImplementedException();
	}

}
