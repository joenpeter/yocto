/**
 * 
 */
package se.winquman.yocto.tester;

import java.util.Map;

import se.winquman.yocto.tester.impl.MyNameInputerImpl;
import se.winquman.yocto.tester.impl.MyNameRunnerImpl;
import se.yoctocontainer.core.AbstractRunConfiguration;
import se.yoctocontainer.core.Component;
import se.yoctocontainer.core.Instance;
import se.yoctocontainer.core.Version;
import se.yoctocontainer.core.impl.YoctoVersion;

/**
 * @author Joen
 *
 */
public class TesterRunConfiguration extends AbstractRunConfiguration {

	/* (non-Javadoc)
	 * @see se.winquman.yocto.RuntimeEnvironment#defaultComponents(java.util.Map)
	 */
	@Override
	public Map<String, Class<? extends Component>> components(
			Map<String, Class<? extends Component>> components) {

		// use components.put() to add stuff
		
		
		return components;
	}

	@Override
	public Map<String, Class<? extends Instance>> instances(
			Map<String, Class<? extends Instance>> instances) {
		
		instances.put("MyNameInputer", MyNameInputerImpl.class);
		instances.put("MyNameRunner", MyNameRunnerImpl.class);
		// Use instances.put() to add stuff
		
		
		return instances;
	}

	@Override
	public Map<String, String> settings(Map<String, String> settings) {
		
		
		settings.put("programName", "Yocto Container Tester");
		settings.put("configFilePath", "D:/work/runtime/name-tester.properties");
		settings.put("configFileType", "Properties");
		// Use settings.put() to add additional settings
		
		
		return settings;
	}

	@Override
	public Version version() {
		// Change this to correct version.
		
		Version version = new YoctoVersion();
		version.setVersion(1, 0, 0, 0);
		
		return version;
	}

}
