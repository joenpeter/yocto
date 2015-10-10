/**
 * 
 */
package se.winquman.yocto.core.engine.config.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import se.winquman.yocto.TreeNode;
import se.winquman.yocto.core.AbstractComponent;
import se.winquman.yocto.core.engine.config.Configuration;
import se.winquman.yocto.core.engine.config.ConfigurationFetcher;
import se.winquman.yocto.core.engine.config.ConfigurationFolder;
import se.winquman.yocto.core.engine.config.ConfigurationItem;
import se.winquman.yocto.error.ApplicationRuntimeException;
import se.winquman.yocto.error.InitializationException;
import se.winquman.yocto.xcoder.decode.Decoder;

/**
 * @author jpeter
 *
 */
public class ConfigurationFetcherImpl extends AbstractComponent implements
		ConfigurationFetcher {

	Decoder<ConfigurationItem> decoder;
	
	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.engine.config.ConfigurationFetcher#fetchConfiguration(java.lang.String)
	 */
	@Override
	public Configuration fetchConfiguration(String filePath) {
		
		Reader configReader = null;
		try {
			configReader = new FileReader(filePath);
		} catch (FileNotFoundException e) {
			error("Error when opening config (" + filePath + ")", e);
		}
		decoder.setReader(configReader);
		decoder.setResultClass(ConfigurationItem.class);
		
		Configuration config = (Configuration) context.newComponent("Configuration");
		
		ConfigurationItem root = config.getRootItem();
		root.setName("root");
		ConfigurationItem current = root;
		ConfigurationItem item = null;
		
		
		info("Loading configuration");
		boolean proceed = true;
		while(proceed) {
			try {
				item = decoder.decodeNext();
				info("Loading: " + item);
			} catch (IOException e) {
				error("Could not decode configuration line", e);
				break;
			}
			
			if(item == null) {
				break;
			}
			
			if(item instanceof ConfigurationFolder) {
				if(item.getName().equals("..")) {
					// Up one step
					debug("Folder, upping one step...");
					current = current.getParent();
				} else {
					debug("Folder, adding " + item + " to " + current);
					current = current.getOrCreateChild(item.getName());
				}
			} else if (current != null) {
				debug("Config point, adding " + item + " to " + current);
				current.addChild(item);
			}
			
			debug("Config tree now looking like: " + root.treeToText());
		}

		return config;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.AbstractYoctoObject#init()
	 */
	@Override
	protected void init() {
		try {
		
			decoder = (Decoder<ConfigurationItem>) 
					context.newComponent("SettingsDecoder");
		
		} catch (ApplicationRuntimeException e) {
			error("Caught exception when initiating ConfigurationFetcher.", e);
		}
	}

}
