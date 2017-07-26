/**
 * 
 */
package se.yoctocontainer.core;

import se.yoctocontainer.core.engine.config.Configurator;
import se.yoctocontainer.error.ApplicationException;

/**
 * @author jpeter
 *
 */
public interface YoctoObject {

	/**
	 * Called when this object is initiated, to allow for internal initialization
	 * @param cont current global context
	 * @param conf current global configuration
	 * @throws ApplicationException if component cannot be initialized
	 */
	public void create(Context cont, Configurator conf) throws ApplicationException;

	/**
	 * Get the name of this object
	 * @return the name of this object, as defined in the run configuration
	 */
	public String getObjectName();
	
	/**
	 * Sets the name of this object - should typically only be called by the core engine of yocto
	 * @param name the name of this object
	 */
	public void setObjectName(String name);
}
