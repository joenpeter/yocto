/**
 * 
 */
package se.winquman.yocto.core;

import se.winquman.yocto.core.engine.config.Configurator;
import se.winquman.yocto.core.logging.LogSettings;
import se.winquman.yocto.error.ApplicationRuntimeException;

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
	public Instance getInstance(String name) throws ApplicationRuntimeException;
	
	/**
	 * 
	 * @param type configured name of the component type (= factory name)
	 * @return the special factory for this component, if it exists
	 * @throws ApplicationRuntimeException if no factory can be found
	 */
	public ComponentFactory getComponentFactory(String type) throws ApplicationRuntimeException;
	
	/**
	 * 
	 * @param name name of the component
	 * @return a newly created object of this component type
	 * @throws ApplicationRuntimeException if the component with that name cannot be created
	 */
	public Component newComponent(String name) throws ApplicationRuntimeException;
	
	/**
	 * 
	 * @return the LogSettings of this context
	 */
	public LogSettings getLogSettings();
}
