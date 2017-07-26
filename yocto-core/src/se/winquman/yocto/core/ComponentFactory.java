/**
 * 
 */
package se.winquman.yocto.core;

import java.util.Map;

import se.winquman.yocto.error.InitializationException;
import se.winquman.yocto.error.NotFoundException;

/**
 * @author Joen
 *
 */
public interface ComponentFactory extends Instance {

	public Component newComponent() throws NotFoundException, InitializationException;
	
	public Component newComponent(String type) throws NotFoundException, InitializationException;
	
}
