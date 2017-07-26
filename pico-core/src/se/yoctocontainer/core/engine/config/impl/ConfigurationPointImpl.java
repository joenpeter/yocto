/**
 * 
 */
package se.yoctocontainer.core.engine.config.impl;

import se.yoctocontainer.core.engine.config.ConfigurationPoint;

/**
 * @author jpeter
 *
 */
@SuppressWarnings("serial")
public class ConfigurationPointImpl extends AbstractConfigurationItem implements
		ConfigurationPoint {

	protected Object value; 

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void setValue(Object o) {
		value = o;
	}
	
	public String toString() {
		return name + "=" + value + " (" + value.getClass().toString() + ")";
	}

}
