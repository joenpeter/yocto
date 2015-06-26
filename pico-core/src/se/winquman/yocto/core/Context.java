/**
 * 
 */
package se.winquman.yocto.core;

import se.winquman.yocto.core.logging.LogSettings;

/**
 * This is the context currently in operation
 * 
 * @author Joen
 *
 */
public interface Context {
	
	public Configurator getConfigurator();
	
	public Session getSession();
	
	public Instance getInstance(String name);
	
	public ComponentFactory getComponentFactory(String type);
	
	public ComponentFactory getComponentFactory(Class<Component> type);
	
	public Component newComponent(String name);
	
	public LogSettings getLogSettings();
	
	
}
