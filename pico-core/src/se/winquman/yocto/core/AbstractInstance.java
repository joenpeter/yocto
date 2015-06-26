/**
 * 
 */
package se.winquman.yocto.core;

import se.winquman.yocto.error.ApplicationException;
import se.winquman.yocto.error.ApplicationRuntimeException;
import se.winquman.yocto.error.InitializationException;
import se.winquman.yocto.error.NotInitiatedException;

/**
 * @author Joen
 *
 */
public abstract class AbstractInstance extends AbstractYoctoObject implements Instance {
	
	private boolean isInitiated = false;
	
	@Override
	public void create(Context cont, Configurator conf) throws ApplicationException {
		super.create(cont, conf);
	}

	public void init() throws InitializationException {
		super.check();
		isInitiated = true;
	}
	
	public void empty() {
		isInitiated = false;
	}
	
	@Override
	protected void check() throws ApplicationRuntimeException {
		super.check();
		if(!isInitiated) {
			throw new NotInitiatedException("Instance called before it was initiated: " + this.getClass());
		}
	}
}
