/**
 * 
 */
package se.winquman.yocto.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import se.winquman.yocto.RuntimeEnvironment;
import se.winquman.yocto.core.helpers.InternalSettings;

/**
 * @author Joen
 *
 */
public abstract class AbstractRunConfiguration implements RunConfiguration, RuntimeEnvironment {

	private Map<String,String> settings;
	
	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.RunConfiguration#getInstances()
	 */
	@Override
	public Map<String, Class> getInstances() {
		return instances(new HashMap<String,Class>());
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.RunConfiguration#getComponentFactories()
	 */
	@Override
	public Map<String, Class> getComponentFactories() {
		return componentFactories(new HashMap<String,Class>());
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.RunConfiguration#getRunners()
	 */
	@Override
	public Map<String, Class> getRunners() {
		return runners(new HashMap<String,Class>());
	}
	
	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.RunConfiguration#getRunners()
	 */
	@Override
	public Map<String, Class> getComponents() {
		return defaultComponents(new HashMap<String,Class>());
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.RunConfiguration#getName()
	 */
	@Override
	public String getName() {
		checkSettings();
		return settings.get("programName");
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.RunConfiguration#getVersion()
	 */
	@Override
	public Version getVersion() {
		return version();
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.RunConfiguration#getConfigFilePath()
	 */
	@Override
	public String getConfigFilePath() {
		checkSettings();
		return settings.get("configFilePath");
	}
	
	private void checkSettings() {
		if(settings == null) {
			settings = settings(new HashMap<String,String>());
		}
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.RunConfiguration#getConfigFilePath()
	 */
	@Override
	public Map<String,String> getSettings() {
		checkSettings();
		return settings;
	}

}
