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


	protected abstract Map<String,Class> creatables(Map<String,Class> map);
	
	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.ComponentFactory#newComponent()
	 */
	@Override
	public Component newComponent() throws NotFoundException, InitializationException {
		return newComponent(null);
	}
	
	public Component newComponent(String name) throws NotFoundException, InitializationException {
		try {
			Component c = (Component) components.get(name).newInstance();
			c.create(context, config);
			return c;
		} catch (InstantiationException | IllegalAccessException e) {
			error("Factory could not create the requested component " + name, e);
			throw new InitializationException("Unable to create component with requirements "
					+ name, e);
		} catch (NullPointerException e) {
			error("Factory could not find a way to create the requested object - it is now known: "
					+ name, e);
			throw new NotFoundException("Unable to create component with requirements "
					+ name, e);
		}
		
		
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.AbstractYoctoObject#init()
	 */
	@Override
	protected void init() {
		components = creatables(new HashMap<String,Class>());
	}
	
}