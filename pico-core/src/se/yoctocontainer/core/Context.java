/**
 * 
 */
package se.yoctocontainer.core;

import se.yoctocontainer.core.engine.config.Configurator;
import se.yoctocontainer.core.logging.LogSettings;
import se.yoctocontainer.error.ApplicationRuntimeException;

/**
 * This is the context currently in operation
 * 
 * @author Joen
 *
 */
public interface Context {
	
	/**
	 * 
	 * @return the configurator for this context
	 */
	public Configurator getConfigurator();
	
	/**
	 * 
	 * @return the session for this context
	 */
	public Session getSession();
	
	/**
	 * 
	 * @param name configured name of the instance to get
	 * @return The instance corresponding to the name
	 * @throws ApplicationRuntimeException if it cannot be found
	 */
	public <T extends Instance> T getInstance(String name) throws ApplicationRuntimeException;
	
	/**
	 * 
	 * @param name name of the component
	 * @return a newly created object of this component type
	 * @throws ApplicationRuntimeException if the component with that name cannot be created
	 */
	public <T extends Component> T newComponent(String name) throws ApplicationRuntimeException;
	
	/**
	 * 
	 * @return the LogSettings of this context
	 */
	public LogSettings getLogSettings();
}
