/**
 * 
 */
package se.winquman.yocto.core.engine;

import se.winquman.yocto.core.Component;
import se.winquman.yocto.error.InitializationException;
import se.winquman.yocto.error.NotFoundException;

/**
 * @author Joen
 *
 */
public class BasicComponentFactory extends AbstractComponentFactory {

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.ComponentFactory#newComponent(java.lang.String)
	 */
	@Override
	public Component newComponent(String type) throws NotFoundException, InitializationException{
		check();
		Class c = components.get(type);
		if(c == null) {
			throw new NotFoundException("Unable to create component: " + type + " - not found.");
		}
		
		try {
			return (Component) c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			logger.severe(e.toString());
			throw new InitializationException("Unable to create component: " + type, e);
		}
	}

}
