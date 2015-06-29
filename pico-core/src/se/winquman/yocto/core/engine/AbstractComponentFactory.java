/**
 * 
 */
package se.winquman.yocto.core.engine;

import java.util.HashMap;
import java.util.Map;

import se.winquman.yocto.core.AbstractInstance;
import se.winquman.yocto.core.Component;
import se.winquman.yocto.core.ComponentFactory;
import se.winquman.yocto.error.InitializationException;
import se.winquman.yocto.error.NotFoundException;

/**
 * @author Joen
 *
 */
public abstract class AbstractComponentFactory extends AbstractInstance implements
		ComponentFactory {
	
	protected Map<String,Class> components;

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.ComponentFactory#newComponent()
	 */
	@Override
	public Component newComponent() throws NotFoundException, InitializationException {
		return newComponent(null);
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.ComponentFactory#addCreatable(java.util.Map)
	 */
	@Override
	public void addCreatable(Map<String, Class> map) {
		components.putAll(map);
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.AbstractYoctoObject#init()
	 */
	@Override
	protected void init() {
		components = new HashMap<String,Class>();
	}

}
