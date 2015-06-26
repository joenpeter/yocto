/**
 * 
 */
package se.winquman.yocto.core;

import se.winquman.yocto.error.ApplicationException;

/**
 * @author Joen
 *
 */
public abstract class AbstractComponent extends AbstractYoctoObject implements Component {

	@Override
	public Component clone() {
		return replicate();
	}
	
	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.YoctoObject#create()
	 */
	@Override
	public void create(Context cont, Configurator conf) throws ApplicationException {
		super.create(cont, conf);
	}

	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.Component#destroy()
	 */
	@Override
	public void destroy() {
		// do nothing
	}

}
