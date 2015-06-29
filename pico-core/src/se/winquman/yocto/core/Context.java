/**
 * 
 */
package se.winquman.yocto.core;

import se.winquman.yocto.core.engine.RuntimeReference;
import se.winquman.yocto.core.logging.LogSettings;
import se.winquman.yocto.error.ApplicationException;
import se.winquman.yocto.error.ApplicationRuntimeException;

/**
 * This is the context currently in operation
 * 
 * @author Joen
 *
 */
public interface Context {
	
	public Configurator getConfigurator();
	
	public Session getSession();
	
	public Instance getInstance(String name) throws ApplicationRuntimeException;
	
	public ComponentFactory getComponentFactory(String type) throws ApplicationRuntimeException;
	
	public Component newComponent(String name) throws ApplicationRuntimeException;
	
	public LogSettings getLogSettings();
	
	public RuntimeReference addRuntime(RunConfiguration run);
	
}
