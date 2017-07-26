/**
 * 
 */
package se.yoctocontainer.core;

import java.util.HashMap;
import java.util.Map;

import se.yoctocontainer.RuntimeEnvironment;

/**
 * @author Joen
 *
 */
public abstract class AbstractRunConfiguration implements RunConfiguration, RuntimeEnvironment {

	private Map<String,String> settings;
	
	@Override
	public Map<String, Class<? extends Instance>> getInstances() {
		return instances(new HashMap<String,Class<? extends Instance>>());
	}

	@Override
	public Map<String, Class<? extends Component>> getComponents() {
		return components(new HashMap<String,Class<? extends Component>>());
	}


	@Override
	public String getName() {
		checkSettings();
		return settings.get("programName");
	}


	@Override
	public Version getVersion() {
		return version();
	}


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


	@Override
	public Map<String,String> getSettings() {
		checkSettings();
		return settings;
	}

}
