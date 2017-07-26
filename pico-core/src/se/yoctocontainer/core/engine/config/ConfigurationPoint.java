/**
 * 
 */
package se.yoctocontainer.core.engine.config;

/**
 * @author Joen
 *
 */
public interface ConfigurationPoint extends ConfigurationItem {

	public Object getValue();
	
	public void setValue(Object o);
	
}
