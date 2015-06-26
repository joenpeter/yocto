/**
 * 
 */
package se.winquman.yocto.core;

/**
 * @author Joen
 *
 */
public interface ComponentFactory extends Instance {

	public Component newComponent();
	
	public Component newComponent(String type);
}
