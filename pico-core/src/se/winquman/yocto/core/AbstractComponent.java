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
	
	/* (non-Javadoc)
	 * @see se.winquman.yocto.core.YoctoObject#create()
	 */
	@Override
	public void create(Context cont, Configurator conf) {
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
