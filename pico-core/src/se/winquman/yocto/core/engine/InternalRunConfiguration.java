/**
 * 
 */
package se.winquman.yocto.core.engine;

import java.util.Map;

import se.winquman.yocto.core.AbstractRunConfiguration;
import se.winquman.yocto.core.Component;
import se.winquman.yocto.core.ComponentFactory;
import se.winquman.yocto.core.Instance;
import se.winquman.yocto.core.Runner;
import se.winquman.yocto.core.Version;
import se.winquman.yocto.core.engine.config.ConfigurationFetcher;
import se.winquman.yocto.core.helpers.RunnerHelper;

/**
 * @author Joen
 *
 */
public class InternalRunConfiguration extends AbstractRunConfiguration {

	/* (non-Javadoc)
	 * @see se.winquman.yocto.RuntimeEnvironment#defaultComponents(java.util.Map)
	 */
	@Override
	public Map<String, Class> defaultComponents(
			Map<String, Class> components) {

		// use components.put() to add stuff
		components.put("ConfigurationFetcher", null);
		components.put("Configuration", null);
		components.put("ConfigurationFinder", null);
		components.put("ConfigurationPath", null);
		
		return components;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.RuntimeEnvironment#instances(java.util.Map)
	 */
	@Override
	public Map<String, Class> instances(
			Map<String, Class> instances) {
		
		// Use instances.put() to add stuff
		
		
		return instances;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.RuntimeEnvironment#runners(java.util.Map)
	 */
	@Override
	public Map<String, Class> runners(Map<String, Class> runners) {
		
		// Use runners.put() to add runners
		
		
		return runners;
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
		settings.put("configFilePath", "./config/config.xml");
		settings.put("configFileType", "XML");
		// Use settings.put() to add additional settings
		
		
		return settings;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.RuntimeEnvironment#version()
	 */
	@Override
	public Version version() {
		// Change this to correct version.
		
		Version version = new Version(0,1,0,0);
		
		return version;
	}

}
