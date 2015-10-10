/**
 * 
 */
package se.winquman.yocto.tester;

import java.util.Map;

import se.winquman.yocto.core.AbstractRunConfiguration;
import se.winquman.yocto.core.Version;
import se.winquman.yocto.core.impl.YoctoVersion;
import se.winquman.yocto.tester.impl.MyNameInputerImpl;
import se.winquman.yocto.tester.impl.MyNameRunnerImpl;

/**
 * @author Joen
 *
 */
public class TesterRunConfiguration extends AbstractRunConfiguration {

	/* (non-Javadoc)
	 * @see se.winquman.yocto.RuntimeEnvironment#defaultComponents(java.util.Map)
	 */
	@Override
	public Map<String, Class> defaultComponents(
			Map<String, Class> components) {

		// use components.put() to add stuff
		
		
		return components;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.RuntimeEnvironment#instances(java.util.Map)
	 */
	@Override
	public Map<String, Class> instances(
			Map<String, Class> instances) {
		
		instances.put("MyNameInputer", MyNameInputerImpl.class);
		instances.put("MyNameRunner", MyNameRunnerImpl.class);
		// Use instances.put() to add stuff
		
		
		return instances;
	}


	/* (non-Javadoc)
	 * @see se.winquman.yocto.RuntimeEnvironment#componentFactories(java.util.Map)
	 */
	@Override
	public Map<String, Class> componentFactories(
			Map<String, Class> factories) {
		
		// Use factores.put() to add additional special factories with associated components
		
		
		return factories;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.RuntimeEnvironment#settings(java.util.Map)
	 */
	@Override
	public Map<String, String> settings(Map<String, String> settings) {
		
		
		settings.put("programName", "Yocto Container Tester");
		settings.put("configFilePath", "C:/work/config.properties");
		settings.put("configFileType", "Properties");
		// Use settings.put() to add additional settings
		
		
		return settings;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.RuntimeEnvironment#version()
	 */
	@Override
	public Version version() {
		// Change this to correct version.
		
		Version version = new YoctoVersion();
		version.setVersion(1, 0, 0, 0);
		
		return version;
	}

}
