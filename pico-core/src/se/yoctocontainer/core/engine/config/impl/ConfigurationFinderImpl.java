package se.yoctocontainer.core.engine.config.impl;

import se.yoctocontainer.core.AbstractComponent;
import se.yoctocontainer.core.engine.config.ConfigurationFinder;
import se.yoctocontainer.core.engine.config.ConfigurationItem;
import se.yoctocontainer.core.engine.config.ConfigurationPath;
import se.yoctocontainer.core.engine.config.ConfigurationPoint;

public class ConfigurationFinderImpl extends AbstractComponent implements
		ConfigurationFinder {

	ConfigurationItem root;
	ConfigurationItem current;
	
	@Override
	public void setRoot(ConfigurationItem root) {
		this.root = root;
	}

	@Override
	public Object findConfiguration(ConfigurationPath configurationPath) {
		current = root;
		while(configurationPath.hasNext() && current != null) {
			debug("Traversing: " + current);
			current = current.getChild(configurationPath.next());
		}
		
		debug("Ended traverse of find, current=" + current);
		
		if(current instanceof ConfigurationPoint) {
			ConfigurationPoint point = (ConfigurationPoint) current;
			return point.getValue();
		}
		
		return null;
	}

	@Override
	protected void init() {

	}

}
