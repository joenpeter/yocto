package se.yoctocontainer.ui;

import java.util.Map;

import se.yoctocontainer.core.AbstractRunConfiguration;
import se.yoctocontainer.core.Component;
import se.yoctocontainer.core.Instance;
import se.yoctocontainer.core.Version;
import se.yoctocontainer.core.impl.YoctoVersion;

/**
 * Components needed to run yoco-ui
 * @author Joen
 *
 */
public class UIRunConfiguration extends AbstractRunConfiguration {

	@Override
	public Map<String, Class<? extends Component>> components(Map<String, Class<? extends Component>> components) {

		return components;
	}

	@Override
	public Map<String, Class<? extends Instance>> instances(Map<String, Class<? extends Instance>> instances) {
		
		
		
		return instances;
	}

	@Override
	public Map<String, String> settings(Map<String, String> settings) {
		settings.put("programName", "Yocto Container User Interface Framework");
		settings.put("configFilePath", "ui.properties");
		settings.put("configFileType", "Properties");
		
		return settings;
	}

	@Override
	public Version version() {
		Version v = new YoctoVersion();
		v.setVersion(1, 0, 0, 0);
		return v;
	}

}
