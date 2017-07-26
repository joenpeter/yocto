/**
 * 
 */
package se.yoctocontainer.core.engine.config.impl;

import java.util.ArrayList;
import java.util.List;

import se.yoctocontainer.core.TreeNode;
import se.yoctocontainer.core.engine.config.ConfigurationFolder;
import se.yoctocontainer.core.engine.config.ConfigurationItem;

/**
 * @author jpeter
 *
 */
@SuppressWarnings("serial")
public class ConfigurationFolderImpl extends AbstractConfigurationItem implements ConfigurationFolder {

	@Override
	public ConfigurationItem getFirstChild() {
		return (ConfigurationItem) super.getChildFirst();
	}

	@Override
	public List<ConfigurationItem> getAllChildren() {
		List<ConfigurationItem> list = new ArrayList<ConfigurationItem>();
		for(TreeNode child: children) {
			list.add((ConfigurationItem) child);
		}
		return list;
	}
	
	public String toString() {
		return "[" + name + "]";
	}

	
}
