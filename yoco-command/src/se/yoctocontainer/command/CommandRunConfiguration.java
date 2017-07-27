package se.yoctocontainer.command;

import java.util.Map;

import se.yoctocontainer.command.impl.CommandExecutorImpl;
import se.yoctocontainer.command.impl.CommandFactoryImpl;
import se.yoctocontainer.core.AbstractRunConfiguration;
import se.yoctocontainer.core.Component;
import se.yoctocontainer.core.Instance;
import se.yoctocontainer.core.RunConfiguration;
import se.yoctocontainer.core.Version;
import se.yoctocontainer.core.impl.YoctoVersion;

/**
 * Components needed to run yoco-command
 * @author Joen
 *
 */
public class CommandRunConfiguration extends AbstractRunConfiguration {

	@Override
	public Map<String, Class<? extends Component>> components(Map<String, Class<? extends Component>> components) {

		return components;
	}

	@Override
	public Map<String, Class<? extends Instance>> instances(Map<String, Class<? extends Instance>> instances) {
		
		instances.put("CommandExecutor", CommandExecutorImpl.class);
		instances.put("CommandFactory", CommandFactoryImpl.class);
		
		return instances;
	}

	@Override
	public Map<String, String> settings(Map<String, String> settings) {
		settings.put("programName", "Yocto Container Command Framework");
		settings.put("configFilePath", "command.properties");
		settings.put("configFileType", "Properties");
		
		return settings;
	}

	@Override
	public Version version() {
		Version v = new YoctoVersion();
		v.setVersion(1, 0, 0, 0);
		return v;
	}

	@Override
	public Map<String, Class<? extends RunConfiguration>> dependencies(
			Map<String, Class<? extends RunConfiguration>> dependencies) {

		
		return dependencies;
	}

}
