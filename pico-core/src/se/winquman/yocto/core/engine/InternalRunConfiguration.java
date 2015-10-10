/**
 * 
 */
package se.winquman.yocto.core.engine;

import java.util.Map;

import se.winquman.yocto.core.AbstractRunConfiguration;
import se.winquman.yocto.core.Version;
import se.winquman.yocto.core.engine.config.impl.ConfigurationFetcherImpl;
import se.winquman.yocto.core.engine.config.impl.ConfigurationFinderImpl;
import se.winquman.yocto.core.engine.config.impl.ConfigurationFolderImpl;
import se.winquman.yocto.core.engine.config.impl.ConfigurationImpl;
import se.winquman.yocto.core.engine.config.impl.ConfigurationPathImpl;
import se.winquman.yocto.core.engine.config.impl.ConfigurationPointImpl;
import se.winquman.yocto.core.impl.YoctoVersion;
import se.winquman.yocto.xcoder.decode.PlainFileSettingsDecoder;
import se.winquman.yocto.xcoder.factory.DecoderTaskFactory;

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
		components.put("ConfigurationFetcher", ConfigurationFetcherImpl.class);
		components.put("Configuration", ConfigurationImpl.class);
		components.put("ConfigurationFinder", ConfigurationFinderImpl.class);
		components.put("ConfigurationPath", ConfigurationPathImpl.class);
		components.put("SettingsDecoder", PlainFileSettingsDecoder.class);
		components.put("ConfigurationPoint", ConfigurationPointImpl.class);
		components.put("ConfigurationFolder", ConfigurationFolderImpl.class);
		
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
	 * @see se.winquman.yocto.RuntimeEnvironment#componentFactories(java.util.Map)
	 */
	@Override
	public Map<String, Class> componentFactories(
			Map<String, Class> factories) {
		
		// Use factores.put() to add additional special factories with associated components
		factories.put("DecoderTask", DecoderTaskFactory.class);
		
		return factories;
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.RuntimeEnvironment#settings(java.util.Map)
	 */
	@Override
	public Map<String, String> settings(Map<String, String> settings) {
		
		
		settings.put("programName", "Yocto Container Intrnal");
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
		
		Version version = new YoctoVersion();
		version.setVersion(0, 1, 0, 0);
		
		return version;
	}

}
