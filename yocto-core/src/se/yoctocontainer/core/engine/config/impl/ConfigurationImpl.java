/**
 * 
 */
package se.yoctocontainer.core.engine.config.impl;

import se.yoctocontainer.core.AbstractComponent;
import se.yoctocontainer.core.TreeNode;
import se.yoctocontainer.core.engine.config.Configuration;
import se.yoctocontainer.core.engine.config.ConfigurationItem;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author jpeter
 *
 */
public class ConfigurationImpl extends AbstractComponent implements
		Configuration {

	ConfigurationItem rootItem;
	
	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.engine.config.Configuration#getRootItem()
	 */
	@Override
	public ConfigurationItem getRootItem() {
		return rootItem;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.engine.config.Configuration#addConfig(se.winquman.yocto.core.engine.config.Configuration)
	 */
	@Override
	public void addConfig(Configuration config) {
		if(rootItem == null) {
			rootItem = config.getRootItem();
			
		} else {
			for(TreeNode node: config.getRootItem().getChildren()) {
				rootItem.addChild(node);
			}
			debug("Configuration merged: " + rootItem.treeToText());
		}
		
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.engine.config.Configuration#addItem(se.winquman.yocto.core.engine.config.ConfigurationItem)
	 */
	@Override
	public void addItem(ConfigurationItem item, String path) {
		throw new NotImplementedException();
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.AbstractYoctoObject#init()
	 */
	@Override
	protected void init() {
		rootItem = (ConfigurationItem) context.newComponent("ConfigurationFolder");
		rootItem.setName("root");
	}


}
