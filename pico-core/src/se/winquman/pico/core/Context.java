/**
 * 
 */
package se.winquman.pico.core;

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

}
