/**
 * 
 */
package se.winquman.yocto.core.engine.config.impl;

import java.util.ArrayList;
import java.util.List;

import se.winquman.yocto.TreeNode;
import se.winquman.yocto.core.engine.config.ConfigurationFolder;
import se.winquman.yocto.core.engine.config.ConfigurationItem;

/**
 * @author jpeter
 *
 */
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
