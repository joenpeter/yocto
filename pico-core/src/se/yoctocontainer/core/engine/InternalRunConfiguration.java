/**
 * 
 */
package se.yoctocontainer.core.engine;

import java.util.Map;

import se.yoctocontainer.core.AbstractRunConfiguration;
import se.yoctocontainer.core.Component;
import se.yoctocontainer.core.Instance;
import se.yoctocontainer.core.Version;
import se.yoctocontainer.core.engine.config.impl.ConfigurationFetcherImpl;
import se.yoctocontainer.core.engine.config.impl.ConfigurationFinderImpl;
import se.yoctocontainer.core.engine.config.impl.ConfigurationFolderImpl;
import se.yoctocontainer.core.engine.config.impl.ConfigurationImpl;
import se.yoctocontainer.core.engine.config.impl.ConfigurationPathImpl;
import se.yoctocontainer.core.engine.config.impl.ConfigurationPointImpl;
import se.yoctocontainer.core.engine.config.impl.ConfigurationTreeDecoderTask;
import se.yoctocontainer.core.impl.YoctoVersion;
import se.yoctocontainer.xcoder.decode.PlainFileSettingsDecoder;

/**
 * @author Joen
 *
 */
public class InternalRunConfiguration extends AbstractRunConfiguration {


	@Override
	public Map<String, Class<? extends Component>> components(
			Map<String, Class<? extends Component>> components) {

		// use components.put() to add stuff
		components.put("ConfigurationFetcher", ConfigurationFetcherImpl.class);
		components.put("Configuration", ConfigurationImpl.class);
		components.put("ConfigurationFinder", ConfigurationFinderImpl.class);
		components.put("ConfigurationPath", ConfigurationPathImpl.class);
		components.put("SettingsDecoder", PlainFileSettingsDecoder.class);
		components.put("ConfigurationPoint", ConfigurationPointImpl.class);
		components.put("ConfigurationFolder", ConfigurationFolderImpl.class);
		components.put("ConfigurationDecoderTask", ConfigurationTreeDecoderTask.class);
		
		return components;
	}

	@Override
	public Map<String, Class<? extends Instance>> instances(
			Map<String, Class<? extends Instance>> instances) {
		
		// Use instances.put() to add stuff
		
		
		return instances;
	}


	@Override
	public Map<String, String> settings(Map<String, String> settings) {
		
		
		settings.put("programName", "Yocto Container Intrnal");
		settings.put("configFilePath", "./config/config.xml");
		settings.put("configFileType", "XML");
		// Use settings.put() to add additional settings
		
		
		return settings;
	}

	@Override
	public Version version() {
		// Change this to correct version.
		
		Version version = new YoctoVersion();
		version.setVersion(0, 1, 0, 0);
		
		return version;
	}

}
